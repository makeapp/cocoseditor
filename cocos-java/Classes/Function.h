//
// Created by yuanyou on 14-9-22.
//

#include <string.h>
#include <stddef.h>
#include <stdio.h>
#include <string>
#include <vector>
#ifndef __Function_H_
#define __Function_H_
using namespace std;
namespace cocos2d{
	class Function {
	    public:
		    virtual std::string invoke(std::string args);

        vector<std::string> splitString(const string& src, string separate_character)
        {
            vector<string> strs;

            int separate_characterLen = separate_character.size();//分割字符串的长度,这样就可以支持如“,,”多字符串的分隔符

            int lastPosition;
						int index;
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
}
#endif //__Function_H_
