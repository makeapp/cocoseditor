#ifndef _LocalStorage_H
#define _LocalStorage_H

#include "storage/local-storage/LocalStorage.h"
#include <string>
#include <ctype.h>
#include <string.h>

	namespace ccj{
class  JavaStorageClass{
    
public:
    JavaStorageClass (){};

     ~JavaStorageClass(){};

      static JavaStorageClass* getInstance();

      /** Initializes the database. If path is null, it will create an in-memory DB */
      void init( const std::string& fullpath = "");

      /** Frees the allocated resources */
      void free();

      /** sets an item in the LS */
      void setItem( const std::string& key, const std::string& value);

      /** gets an item from the LS */
      std::string getItem( const std::string& key );

      /** removes an item from the LS */
      void removeItem( const std::string& key );
  };
	} 

#endif
