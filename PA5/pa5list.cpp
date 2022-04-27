// Name:Meghana Putta Swamy
// USC NetID: mswamy
// CS 455 PA5
// Spring 2022

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"

int main() {

 Node* list = NULL;
 int stat;
  
   cout << "Initial List size: "<<getListSize(list)<<endl;  
   //stat=isListEmpty(list);
   
    cout<<"Is the list empty? ";
    if(stat == 0){
       cout<<"False"<<endl;
    }
    else{
       cout<<"true"<<endl;
    }

   int* p=lookupKey(list,"zero");
   cout<<"Look up zero. value? "; 
   if(p !=NULL){
      cout<< *p<<endl<<endl; 
    }
   else{
      cout<<"NULL"<<endl;
   }
   cout<<"Inserting keys..."<<endl<<endl;   

   insertFront(list, "Two",2);
   insertFront(list, "Three",3);
   insertFront(list, "Four",4);
   insertFront(list, "Five",5);
   insertFront(list, "Six",6); 

   // append (list, "Two",2);
   // append(list,"three",3);
   // append(list,"four",4);
   // append(list,"Five",5);   
   cout<<"---List before removing--- "<<endl; 
   printList(list); 
   cout<<endl;
//testRemove(list); 
   removeKey(list,"-one");   
   //remove(list,"one"); 
   cout<<"---List after removal--- "<<endl; 
   removeKey(list,"Two"); 
   removeKey(list,"three");  
   removeKey(list,"four");  
   removeKey(list,"Five");  
   removeKey(list,"zero");  
   removeKey(list,"-two"); 
     
   
   printList(list);   
   cout<<endl;

   cout<<"---Adding to the list again---"<<endl;
   
   insertFront(list,"zero",0);
   printList(list);  

   // stat=changeKeysValue(list,"five",5);
   // cout<<"chaging value of five.. ";
   //  if(stat == 0){
   //     cout<<"not found"<<endl;
   //  }
   //  else{
   //     cout<<"success"<<endl;
   //  }

   printList(list);   
   cout<<endl;
   
   p=lookupKey(list,"zero");
   cout<<"Look up zero. value? "<< *p<<endl; 

   p=lookupKey(list,"ten");
   cout<<"Look up ten. value? "; 
    if(p !=NULL){ 
      cout<< *p<<endl<<endl; 
    }
   else{
      cout<<"NULL"<<endl; 
   }
   //  stat=changeKeysValue(list,"six",5);
   // cout<<"change the value of key six.. ";
   //  if(stat == 0){
   //     cout<<"not found"<<endl;
   //  }
   //  else{
   //     cout<<"success"<<endl;
   //  }
    
   // stat=isListEmpty(list);
   
   //  cout<<"Is the list empty? ";
   //  if(stat == 0){
   //     cout<<"False"<<endl;
   //  }
   //  else{
   //     cout<<"true"<<endl; 
   //  }   

   return 0;  //intern this summer CS571,CS570, AngelList _

}