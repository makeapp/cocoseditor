#include "Cocos2dFunction.h"
#include "cocos2d.h"
#include "ScriptingCore.h"

using namespace std;

std::string cce::Cocos2dFunction::invoke(std::string args){
	cocos2d::log("Cocos2dFunction::invoke %s",args.c_str());
	vector<std::string> params = splitString(args," ");
	if(params.size()>0){
		if(params[0]=="setSearchPath"){
		  vector<std::string> pathes =  splitString(params[1],"|");
		  cocos2d::log("Cocos2dFunction::invoke pathes %d",pathes.size());
		  std::vector<std::string> searchPaths;
		  auto fileUtils = cocos2d::FileUtils::getInstance();
		  for(int i=0;i<pathes.size();i++){
			searchPaths.push_back(pathes[i]);
			cocos2d::log("add SearchPath  %s",pathes[0].c_str());
		  }
	      fileUtils->setSearchPaths(searchPaths);
		}
	}
	return "";
}


std::string cce::Cocos2dJsFunction::invoke(std::string args){
	vector<std::string> params = splitString(args," ");
	if(params.size()>1){
		if(params[0]=="run"){
			vector<std::string> pathes =  splitString(args,"|");
			for(int i=0;i<pathes.size();i++){
			  cocos2d::log("run script %s",pathes[i].c_str());
			  ScriptingCore::getInstance()->runScript(pathes[i].c_str());
		    }
		}
	}
	return "";
}