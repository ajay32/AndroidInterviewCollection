package com.example.interviewlist.androidtopics

// Launch mode concept relates to Task (collection of activites to perform a job) and Backstack management of activites

//4 main launch modes in adnroid


//<activity  //Manifest
//android:name=".YourActivity"
//android:launchMode="singleTop">
//<!-- Other activity configs -->
//</activity>

// 1 Standard (do nothing)
// A B C  -> launching B -> (new stack) A B C B
// A B C -> launching C -> A B C C

// 2 Single Top
// A B C -> launching C again -> A B C ( it will not create C again)
// A B C -> launching B again -> A B C B

// Single Task (one instance in entire system)
// A B  C -> launching B again -> A B  ( b will on the top and will clear anything ahead it)
// A B C -> launching C again -> A B C

// Single instance (activity runs in its own task)
// A B  -> launching C  -> Two stacks A B | C
// A B (main task) C (Single Instance) - > launching C again -> A B (main task) C (single instance)
// A B | C  -> Launch B again -> [A B] stack 1 | [C] Stack 2  -> here A B stack will be at top for use ..no new activites will be created
// A B | C -? Launch A again -> B A | C -> A will be at top of stack 1 for us










