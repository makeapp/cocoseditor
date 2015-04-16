
#include <string.h>
#include <stddef.h>
#include <stdio.h>
#include <string>
#include <map>
#include <vector>

#include "FunctionFactory.h"

#ifndef __CocosFunction_H_
#define __CocosFunction_H_

namespace cce{

	class Cocos2dFunction :
		public cce::Function
	{
		public:
		    virtual std::string invoke(std::string args);
	};

	class Cocos2dJsFunction :
		public cce::Function
	{
		public:
		    virtual std::string invoke(std::string args);
	};
}

#endif