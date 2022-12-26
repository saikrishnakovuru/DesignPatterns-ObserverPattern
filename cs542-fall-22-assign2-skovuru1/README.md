# cs542-fall-22-assign2
# CSX42: Assignment 2

## Name: saikrishna kovuru
## slack days used: 0
## slack days remaining: 3


---

---

---

## Instruction to clean:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml clean

Description: cleans up all the .class files that were generated when
compiled.

---

## Instruction to compile:

####Command: ant -buildfile studentRecordsBackupTree/src/build.xml all

Description: Compiles and generates .class files inside the BUILD folder.

---

## Instruction to run:

ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errorLog.txt -Darg3=2 -Darg4=1


---

## Description:

Initially in the driver class we will be having a condition to check no. of parameters were being passed, if the no. of cimmands passes are more than or less than 5 then the error will be thrown.

Followed by an if condition to check if the input file is present or not, if also the file os empty then also the user will be prompted by a message in the consode and also the error will be registered in the errorLog file.

Initially a check has been passed to find if the arg[3] or arg[4] is either int or not, if not user will be prompted with a message in the errorLog.

-----------------------FileProcessor:-------------------
The whole data present in the inputFile will be sent to to fileProcessr and all the numbers will be stored into "arraylist" one by one. The reason I used array list instead of linked list is because we have limited input data at the moment and in case if the data is increased since we are retriving the data one by one in the BST builder ArrayList is the best data structure to use in my openion.

-----------------------BSTreeImpl:-------------------
The setting up of the BST tree will be handled here in this class and later creating the main BST and backup-1 and backup-2 we will store those trees here in this class to send them back to the Results class to display.
Also we add the roots in this class.
We find the root node based on the index.

-----------------------Node:-------------------
In the node class is a tyoe where eah branch in the BST is a node where they are differentiated with left node and right node.
SInce when we update a single node we alse have to update the respective observer nodes, so subject is the node and observer is also the Node in our case.
We also add all the observers and notify all the observers here itself.

-----------------------BSTBuilderImpl:-------------------
The main logic here in the entire program is been handled in this class.
This class is like a barrier for the Node class and the subject and the observer as we just update, set and send instructions to notify from here in this class.
build--> we get the input from fileProcessor one by one and set to BSTreeImpl to create a BST.
        we make inorder traversel to iterate through the nodes, later setting values one by one.
        Incrementing the node value is also handeled here and later the inorder will be called to set the values again into the BST tree.

Enum values are used to differnetiate which BST is being passed, so made use of ENUMS.

setValuesToBinarySearchTree--> cloning the trees is don in this method.
                                and registering the observers is also done here.

-----------------------MyLogger:-------------------
no System.out.println() statemtn has been used, but used the MyLogger to display the statemnts.
Made use of logger level as well.

-----------------------Results:-------------------
Later the whole process is done we use Results class to display the results.
   
-----------------------writeResultsToOutputFile:-------------------
We have the hold of all the results of addition and BST's those will be passed to results class
to display those in the files

-----------------------displayResultsInConsole:-------------------
We have the hold of all the results of addition and BST's those will be passed to results class
to print those files on console.

-----------------------Errors Handeling:-------------------
If any alphabet is passed as an input an error message will be displayed on the console as well as in the errorLog file.
If a debug level is passed as an alphabet an error message will be displayed on the console as well as in the errorLog file.

-----------------------Output:-------------------
later runing the command
ant -buildfile studentRecordsBackupTree/src/build.xml run -Darg0=bstInput.txt -Darg1=bstOutput.txt -Darg2=errorLog.txt -Darg3=2 -Darg4=1

the o/p displated would be

// Inorder traversal
BST: 5,7,10,13,14
Backup-1: 5,7,10,13,14
Backup-2: 5,7,10,13,14


// Sum of all the B-Numbers in each tree
BST: 49
Backup-1: 49
Backup-2: 49


// Sum of all the B-Numbers after increment
BST: 54
Backup-1: 54
Backup-2: 54

The above o/p will be same in the bstOutput file.


-----------------------DataStructure used:-------------------
The whole data present in the inputFile will be sent to to fileProcessr and all the numbers will be stored into "arraylist" one by one. The reason I used array list instead of linked list is because we have limited input data at the moment and in case if the data is increased since we are retriving the data one by one in the BST builder ArrayList is the best data structure to use in my openion.

The same arrayList is used in the BSTBuilderImpl as we have to incremetn the nodes one by one again. so, arrayList is used again.


-----------------------"BRIEF DESCRIPTION OF DESIGN"-------------------
Observer pattern is notifying and updating the Observers of a respective thing,
In our situation a node in the main BST is the subject and rest of the nodes in the Backup trees are observers, as soon as we update a value in the subject the values of the observers must also get updated recursively.

In BSTBuilderImpl calss and in the build method we update the Main BST node and in teh incrementGivenValue method we first find the node which has got updated based on the index, and if the node is not null we increment and the BST value and notify the observers by passig which value has to be incremented.
    this leads to notifyObservers in node and by having the list of observers we nofify all those one by one. and there we update the node values of the observers.

Here I conclude that I used the observer pattern succesfully to update the node values when subject node has been modified.


---

## Sources

Findin the specific node using the bNumber in the BSTreeImpl class(GeeksForGeeks).
Concept of BST is also referred in GeeksForGeeks.


### Academic Honesty statement:

---

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: 10/23/2022.
