package com.example.interviewlist.androidtopics

//Sure, here are a few tricky Android development questions along with their answers that might challenge your skills and knowledge:

//1. **Question:**
//What is the difference between `commit()` and `apply()` in `SharedPreferences`?
//
//**Answer:**
//Both `commit()` and `apply()` are used to save changes to `SharedPreferences`. The difference lies in their approach to writing data:
//- `commit()` writes the data synchronously and returns a boolean value indicating the success or failure of the operation.
//- `apply()` writes the data asynchronously and does not return a result. It schedules the data to be written to disk in the background, making it faster especially when the UI thread is involved.
//
//2. **Question:**
//Explain the Activity lifecycle. What happens if an activity is in the foreground and a new activity starts?
//
//**Answer:**
//The activity lifecycle consists of several states an activity can be in: Created, Started, Resumed, Paused, Stopped, and Destroyed. When an activity is in the foreground (i.e., it is visible and interacting with the user), and a new activity starts, the following happens:
//- The current activity enters the Paused state (onPause() is called), allowing the new activity to become visible.
//- If the new activity completely covers the current activity, the current activity will enter the Stopped state (onStop() is called).
//
//3. **Question:**
//How can you detect memory leaks in an Android application?
//
//**Answer:**
//Detecting memory leaks in Android can be done using tools such as LeakCanary. It is a library that watches for objects that are retained longer than they should be, suggesting potential memory leaks. By integrating LeakCanary into your application, it automatically monitors and reports memory leaks, making it easier to identify and fix them.
//
//4. **Question:**
//What is the role of the manifest file in an Android application?
//
//**Answer:**
//The AndroidManifest.xml file serves several crucial roles:
//- It declares the application's components (activities, services, broadcast receivers, content providers).
//- It is used to define the permissions that the application requires, such as internet access or access to the camera.
//- It specifies the minimum API level required for the application and lists hardware and software features used by the application, which affects compatibility with different devices.
//
//5. **Question:**
//How does the Android operating system handle multiple running applications?
//
//**Answer:**
//Android uses a multitasking environment to manage multiple running applications. This is handled primarily through a component called the Activity Manager and the Linux kernel. Applications run in separate processes, and the system can suspend and resume these processes as needed to manage resources. If resources are low, the system might terminate processes for lower-priority or idle applications to reclaim resources.
//
//Feel free to ask more questions or request explanations on any of these topics!