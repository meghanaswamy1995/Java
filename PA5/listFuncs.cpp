// Name:Meghana Putta Swamy
// USC NetID:mswamy
// CSCI 455 PA5 
// Spring 2022 


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue; 
   next = NULL; 
}

Node::Node(const string &theKey, int theValue, Node *n) { 
   key = theKey;
   value = theValue;
   next = n;   
}

void insertFront(ListType &list,const string & key, int value){  
   list = new Node(key,value,list); 
   //cout<<"new created list: "<<list<<endl; 
}

int* lookupKey(ListType list, const string &key){ 
   ListType p = list;
   if (p==NULL){
      return NULL; 
   }
   while(p!=NULL){
      //cout<<"searching list"<<endl;
      if(p->key==key){
         return &p->value; 
      }
      p=p->next; 
   }
   return NULL;
}

bool removeKey(ListType &list, const string &key){ 
   ListType p_prev = list;
   ListType p = list;
    
   if(list==NULL){ 
      return false;
   }
   //checking if it is only one entry list
   if (p->next == NULL) {  
      if(p->key == key){
         delete p; 
         p=NULL;
         list = NULL; 
         return true;  
       } 
   }
   //checking if first element is the key 
   if(p->key == key){  
      Node *save = p->next; 
      //cout<<"save: "<<save<<" list: "<<p<<" list-> next: "<<p->next<<endl;
         delete p;
         p = save; 
         list=p;
         //cout<<"after deleting the list/save is: "<<p<<"list: "<<list<<endl;  
         return true; 
   }
   
   while(p != NULL){ 
      if(p->key == key){ 
         p_prev->next= p->next;
         //cout<<"list in the middle, list: "<<list<<" list-next: "<<list->next<<" p_prev: "<<p_prev<<" prev-next: "<<p_prev->next<<endl;
         delete p;
         //cout<<"after deleting list is pointing to: "<<list<<endl;  
         return true;    
      }
      p_prev=p;   
      p=p->next;
      
   }
   return false;
}

void printList(ListType list ){
   if(list==NULL){
      cout<<"empty"<<endl;
   }  
   while(list!=NULL){
      cout<<list->key<<" "<<list->value<<endl;  
      list=list->next; 
   }
}

int getListSize(ListType list){ 
   int count=0;
   if(list==NULL){
      return 0;
   }
   while(list!=NULL){
      count++;
      list=list->next;
   }
   return count; 
}

