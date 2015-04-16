//
//  main.c
//  cocosjvm
//
//  Created by yuanyou on 14-9-29.
//
//

#include <stdio.h>


#include <jni_md.h>
#include <jni.h>
#include <string.h>
#include <iosfwd>
#include <string>

void  string_replace( std::string &strBig, const std::string &strsrc, const std::string &strdst )
{
    std::string::size_type pos = 0;
    std::string::size_type srclen = strsrc.size();
    std::string::size_type dstlen = strdst.size();

    while( (pos=strBig.find(strsrc, pos)) != std::string::npos )
    {
        strBig.replace( pos, srclen, strdst );
        pos += dstlen;
    }
}


int main(int ac, const char * av[])
{
    JavaVMInitArgs vmArgs;
    vmArgs.version = JNI_VERSION_1_6;
    vmArgs.nOptions = 1;
    vmArgs.ignoreUnrecognized = JNI_TRUE;

    const char *class_ = 0;
    const char *jar = 0;
    int argc = 0;
    const char **argv = 0;
    const char *classpath = ".";
    unsigned optionIndex = 0;

    for (int i = 1; i < ac; ++i) {
        if (strcmp(av[i], "-cp") == 0 || strcmp(av[i], "-classpath") == 0) {
            classpath = av[++i];
        } else if (strncmp(av[i], "-X", 2) == 0 || strncmp(av[i], "-D", 2) == 0 || strncmp(av[i], "-agentlib", 2) == 0) {
            ++vmArgs.nOptions;
        } else {
            if (jar == 0) {
                class_ = av[i++];
            }
            if (i < ac) {
                argc = ac - i;
                argv = av + i;
                i = ac;
            }
        }
    }

	const unsigned optionNum = vmArgs.nOptions;
    JavaVMOption *options= new JavaVMOption[optionNum];
    vmArgs.options = options;

    for (int i = 1; i < ac; ++i) {
        if (strncmp(av[i], "-X", 2) == 0 || strncmp(av[i], "-D", 2) == 0 || strncmp(av[i], "-agentlib", 2) == 0) {
            vmArgs.options[optionIndex++].optionString = const_cast<char *>(av[i]);
        }
    }

    std::string cp = "-Djava.class.path=";
    cp.append(classpath);

    vmArgs.options[optionIndex++].optionString=(char *)cp.c_str();

    JavaVM *vm;
    void *env;
    JNI_CreateJavaVM(&vm, &env, &vmArgs);
    JNIEnv *e = (JNIEnv *) env;
    jclass c = 0;

    std::string main(class_);
    string_replace(main,".","/");

    c = e->FindClass(main.c_str());
//    printf("Find  Main Class %p", c);
    if (c && !e->ExceptionCheck()) {
        jmethodID m = e->GetStaticMethodID(c, "main", "([Ljava/lang/String;)V");
        if (!e->ExceptionCheck()) {
            jclass stringClass = e->FindClass("java/lang/String");
            if (!e->ExceptionCheck()) {
                jobjectArray a = e->NewObjectArray(argc, stringClass, 0);
                if (!e->ExceptionCheck()) {
                    for (int i = 0; i < argc; ++i) {
                        e->SetObjectArrayElement(a, i, e->NewStringUTF(argv[i]));
                    }
//                    printf("call main class %s \n", class_);
                    e->CallStaticVoidMethod(c, m, a);
                }
            }
        }
    } else {
        printf("Can't fin main class %s\n", class_);
    }

    if ((e)->ExceptionCheck()) {
        (e)->ExceptionDescribe();
    }

    return 0;
}

