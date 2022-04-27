// Name: Meghana Putta Swamy
// USC NetID: mswamy
// CSCI 455 PA5
// Spring 2022

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>
#include <functional>

using namespace std;

// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h" 

Table::Table() {
   hashSize = HASH_SIZE;
   hashArray = new ListType[HASH_SIZE]();
}


Table::Table(unsigned int hSize) {
   hashSize = hSize;
   hashArray = new ListType[hSize](); 
}


int * Table::lookup(const string &key) { 
   unsigned int hashIdx = hashCode(key);
    if(hashArray[hashIdx]==NULL){ 
      return NULL; 
   }
    return lookupKey(hashArray[hashIdx],key);
    
}


bool Table::remove(const string &key) {
   unsigned int hashIdx = hashCode(key);
   if( lookup(key) != NULL ){ 
      if(hashArray[hashIdx]==NULL){ 
         return false; 
      }
      //cout<<"hashArray["<<hashIdx<<"] for remove: "<<hashArray[hashIdx]<<endl;
      bool stat= removeKey(hashArray[hashIdx],key); 
      // cout<<"Finally after removal hashArray poiting to: "<<hashArray[hashIdx]<<endl;
      return stat;  
   }
   else{ 
      return false;
   }
}


bool Table::insert(const string &key, int value) { 
   unsigned int hashIdx = hashCode(key); 
   ListType list = NULL;
    if( lookup(key) == NULL ){
      if(hashArray[hashIdx]==NULL){
         //cout<<"list not found, so creating a new list"<<endl;
         insertFront(list, key, value);   
         hashArray[hashIdx]=list;
         //cout<<"list address after adding: "<<hashArray[hashIdx]<<endl;  
         return true;
      }
      else{ 
         list = hashArray[hashIdx];
         //cout<<"list found, appending, table address: "<<list<<endl; 
         insertFront(list,key,value);
         hashArray[hashIdx]=list;    
         //cout<<"list address after adding: "<<list<<" hash table addr: "<< hashArray[hashIdx]<<endl;
         return true; 
      }
    } 
    else{
      return false;  
    } 
}


int Table::numEntries() const {
   int numberOfEntries=0;
   for(int i=0;i<hashSize;i++){
      if(hashArray[i]!=NULL){
         int chainLength=getListSize(hashArray[i]);
         numberOfEntries+=chainLength;
      }
   }  
   return numberOfEntries;
}

void Table::printAll() const {
   if(numEntries()==0){
      cout<<"Empty"<<endl;
      return;
   }
   for(int i=0;i<hashSize;i++){
      if(hashArray[i]!=NULL){
         printList(hashArray[i]); 
      }
   } 
}

void Table::hashStats(ostream &out) const { 
   int nonEmptyBuckets=0;
   int longestChain=0;
   int numOfEntries=0;

   for(int i=0;i<hashSize;i++){
      if(hashArray[i]!=NULL){
         int chainLength=getListSize(hashArray[i]);
         nonEmptyBuckets++;
         numOfEntries+=chainLength;
         
         if(chainLength>longestChain){
            longestChain=chainLength;  
         }
      }
   } 
 
   out<<"number of buckets: "<<hashSize<<endl; 
   out<<"number of entries: "<<numOfEntries<<endl;
   out<<"number of non-empty buckets: "<<nonEmptyBuckets<<endl;
   out<<"longest chain: "<<longestChain<<endl;
}


// hash function for a string
// (we defined it for you)
// returns a value in the range [0, hashSize)
unsigned int Table::hashCode(const string &word) const { 

   // Note: calls a std library hash function for string (it uses the good hash
   //   algorithm for strings that we discussed in lecture).
   return hash<string>()(word) % hashSize;

}