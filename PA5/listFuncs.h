// Name:Meghana Putta Swamy
// USC NetID: mswamy
// CSCI 455 PA5
// Spring 2022 

//*************************************************************************

// listFuncs class
//    class with functionalities to store entries of type key value(string, int) inside the list node
//    such that each key (the string) is unique
//    with efficient (O(1)) lookup, insert, and removal of entries functionalities using a key 
// The table class calls this class' methods to add/remove/lookup an entry from the list 

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H

#include <string>
  

struct Node {
   std::string key;
   int value;

   Node *next;

   //Two argument constructor that gets called current nodes next is NULL, 
   // when the very first element is getting added
   // or while the last node is getting adding i.e during append
   Node(const std::string &theKey, int theValue); 

   // Three argument constructor that gets called when the current nodes next is not NULL.
   Node(const std::string &theKey, int theValue, Node *n); 

};
 
typedef Node * ListType;

// PRECONDITION: 
// Param list must be a well-formed list.
// Well-formed list means list can be NULL, or points to a chain
//  of linked nodes such that the last node's next is NULL.

// insert a new student pair into the list
void insertFront(ListType &list,const std::string &key, int value);

 // remove a student pair given its key
 //return true if remove was successful else false
bool removeKey(ListType &list, const std::string &key); 

//returns the address of the value that goes with the given key
// or NULL if key is not present.
int* lookupKey(ListType list,const std::string &key); 

// print out all the entries in the list, one per line.
void printList(Node *list); 

//calculates  and returns the size of the list. 
//i.e. number of students/ entires added into a particular list.
int getListSize(ListType list); 

#endif
