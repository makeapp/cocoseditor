#include "JavaStorageClass.h"


using namespace ccj;

static JavaStorageClass *localStorageInst = nullptr;

JavaStorageClass* JavaStorageClass::getInstance()
{
    if (!localStorageInst)
    {
        localStorageInst = new JavaStorageClass();
    }

    return localStorageInst;
}

/** Initializes the database. If path is null, it will create an in-memory DB */
void JavaStorageClass::init( const std::string& fullpath){
   localStorageInit(fullpath);
}


/** Frees the allocated resources */
void JavaStorageClass::free(){
   localStorageFree();
}

/** sets an item in the LS */
void JavaStorageClass::setItem( const std::string& key, const std::string& value){
  localStorageSetItem(key,value);
}

/** gets an item from the LS */
std::string JavaStorageClass::getItem( const std::string& key ){
   return localStorageGetItem(key);
}

/** removes an item from the LS */
void JavaStorageClass::removeItem( const std::string& key ){
     localStorageRemoveItem(key);
}