//
// Created by yuanyou on 14-9-22.
//

#include <string.h>
#include <stddef.h>
#include <stdio.h>
#include <string>
#include <map>
#include <vector>
#include "cocos2d.h"

#ifndef __FunctionFactory_H_
#define __FunctionFactory_H_

using namespace std;

namespace cce{

	typedef std::function<std::string(std::string,std::string)> CallbackFunction;

	class Function {
	    public:
		    virtual std::string invoke(std::string args);

        std::vector<std::string> splitString(const std::string& src, std::string separate_character)
        {
            vector<string> strs;

            int separate_characterLen = separate_character.size();//分割字符串的长度,这样就可以支持如“,,”多字符串的分隔符

            int lastPosition=0;
						int index=0;
						index=-1;
            while (-1 != (index = src.find(separate_character,lastPosition)))
            {
                strs.push_back(src.substr(lastPosition,index - lastPosition));
                lastPosition = index + separate_characterLen;
            }
            string lastString = src.substr(lastPosition);//截取最后一个分隔符后的内容
            if (!lastString.empty())
                strs.push_back(lastString);//如果最后一个分隔符后还有内容就入队
            return strs;
        };
	};

	class FunctionFactory {
	public:
		 static FunctionFactory* getInstance();
		 static FunctionFactory* _defaultFactory;
		 
		 void registerFunction(std::string name,Function* fun){
		    functions[name]=fun;
		 }

		 void registerCallbackFunction(std::string name,CallbackFunction fun){
		    callbackFunctions[name]=fun;
		 }

		 std::string callFunction(std::string name,std::string params);
		 
	private:
		std::map<std::string,Function*> functions;
		std::map<std::string,CallbackFunction> callbackFunctions;
	}
	;
}
#endif //__Function_H_
