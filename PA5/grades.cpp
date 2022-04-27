// Name: Meghana Putta Swamy
// USC NetID: mswamy
// CSCI 455 PA5
// Spring 2022 

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize] 
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h" 
// cstdlib needed for call to atoi
#include <cstdlib>
#include <vector> 
#include <regex>

using namespace std;

//PRECONDITION:
//The input command given by the user should contain-
// 1. 2 arguments incase of insert, change oeprations. e.g. [insert/change] [student name] [student score]
// 2. 1 arguments incase of remove, lookup operations. e.g. [remove/lookup] [student name]
// 3. 0 arguments incase of print, size, stats, help. e.g. [print/size/stats/help] 
// the [student Name] argument should always be string and [student score] argument should be an int


// Function to do the insert operation, 
//it takes the command arguments in the form of strWords array, and Table type object
// It inserts key into the table if the pair is not already added, else prints "already present " message
void doInsertOperation(string strWords[],Table * grades){
      string key = strWords[1]; 
      int value = stoi(strWords[2]); 
      bool operationStat=grades->insert(key,value); 
      if( operationStat != true ){ 
       cout<<key<<" already present in the table. See 'help' command"<<endl; 
      }
 }  

// Function to do the change value operation, 
//it takes the command arguments in the form of strWords array, and Table type object
// It changes the value of the key if present else prints "not present " message
void doChangeOperation(string strWords[],Table * grades){
      string key = strWords[1]; 
      int value = stoi(strWords[2]); 
      int *valuePtr=grades->lookup(key);
      if( valuePtr != NULL ){
         *valuePtr = value;  
      }
      else{ 
         cout<<key<<" not present in the table. Try inserting it. See 'help' for commands"<<endl;
      } 
 }

// Function to do the lookup operation for the given key.
//it takes the command's arguments in the form of strWords array, and Table type object
// if the value is found print the value for the given key, 
// or prints "not present" message if not found.
void doLookupOperation(string strWords[],Table * grades){
      string key = strWords[1];
      int *value=grades->lookup(key);
      if( value == NULL ){
         cout<<key<<" not present in the table. Try inserting it. See 'help' for commands"<<endl;
      }
      else{
         cout<<key<<"'s score is "<<*value<<endl; 
      }
 }

// Function to do the remove operation based on the key
//it takes the command's arguments in the form of strWords array, and Table type object
// if the value is found removes the key value for the given key, 
// else prints "not present" message if not found. 
void doRemoveOperation(string strWords[],Table * grades){  
      string key = strWords[1];
      bool operationStat=grades->remove(key); 
      if( operationStat == false ){
      cout<<key<<" not present in the table. See 'help' for commands"<<endl; 
      }
     
 }

 // Function to print brief command summary for help oepration
void printCommandSummary(){
      cout<< "Valid commands: "<<endl 
      <<"insert [student name] [student score] (To insert new student score),"<<endl
      <<"change [student name] [student score] (To change already entered student score),"<<endl
      <<"lookup [student name] (To lookup given student's score),"<<endl
      <<"remove [student name] (To remove student's details),"<<endl 
      <<"print (To print all students scores),"<<endl
      <<"size (To get the count of all students added so far),"<<endl
      <<"stats (To print the statistics of the hashtable at this point),"<<endl
      <<"help (To get brief command summary),"<<endl
      <<"quit (To the program)"<<endl;  
 }

//Helper function which analizes the operation that is entered from the user,
// and calls respective operation functions to do the operation
void executeOperation(string strWords[],Table * grades){
      string operation = strWords[0];  
        if(operation == "insert"){ 
           doInsertOperation(strWords,grades);
         }  
        else if(operation == "change"){    
            doChangeOperation(strWords,grades); 
         } 
        else if(operation == "lookup"){
            doLookupOperation(strWords,grades);
         }    
        else if(operation == "remove"){
            doRemoveOperation(strWords,grades);
         } 
         else if(operation == "print"){ 
            grades->printAll();
         }
         else if(operation == "size"){
           cout<<grades->numEntries()<<endl;  
         }
         else if(operation ==  "stats"){ 
            grades->hashStats(cout);
         }
         else if(operation ==  "help"){
           printCommandSummary(); 
         } 
         else{
            cout<<"ERROR: invalid command, see 'help'"<<endl; 
            printCommandSummary();  
         }
}


int main(int argc, char * argv[]) {

   int hashSize = Table::HASH_SIZE;
   Table * grades;  
   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int
      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }
      grades = new Table(hashSize);  
   }
   else {
      grades = new Table();
   }
   grades->hashStats(cout);

   string command;
   string s;
   cout<<"cmd> ";  
   getline(cin,command);

   while(command != "quit"){
      string strWords[5];
      short counter = 0;

      //getting arguments from the user input command
      for(short i=0;i<command.length();i++){
         if(command[i] == ' '){ 
            if(command[i+1]!=' '){ 
               counter++;
               i++;
            }  
         }
         strWords[counter] += command[i];
      } 
      for(int i=0;i<sizeof(strWords)/sizeof(strWords[0]);i++){  
      regex r("\\s+");
      strWords[i] = std::regex_replace(strWords[i], r, "");  
      }

      //checks whihc operation needs to be performed and calls respective functions
      executeOperation(strWords,grades);

      cout<<"cmd> "; 
      getline(cin,command);  
   }

   return 0; 
}
