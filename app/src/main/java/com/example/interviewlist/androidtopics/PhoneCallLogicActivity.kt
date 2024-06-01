package com.example.interviewlist.androidtopics

//When I am in my activity onResume() & get a phone call what will be the lifecycle of the fragment inside my activity

//When your Android activity receives a phone call, the activity lifecycle is impacted, which in turn affects the fragments hosted by that activity. The specific lifecycle methods called in your activity and its fragments depend on how the phone call is handled and the version of Android, but a typical scenario would look like this:
//
//### Activity and Fragment Lifecycle During a Phone Call
//
//1. **Activity is in `onResume()`**:
//- Your activity is currently running and is in the foreground. The `onResume()` method is where your activity is actively interacting with the user.
//
//2. **Phone Call Received**:
//- As the phone call comes in and if the phone call application takes focus, your activity will lose focus.
//
//3. **Activity's `onPause()` is Called**:
//- The first lifecycle method called when your activity starts to lose focus due to the incoming call is `onPause()`. At this point, the activity is still visible but not active.
//
//4. **Activity's `onStop()` May Be Called**:
//- If the phone call UI covers the entire screen or if the system decides to further background your app (which can depend on system conditions and how the phone app is implemented), your activity's `onStop()` method will be called, indicating that your activity is no longer visible.
//
//5. **Fragment Lifecycle**:
//- **Fragments follow the activity's lifecycle**, so when the activity's `onPause()` is called, all fragments within that activity also receive their `onPause()` callbacks.
//- Similarly, if the activity's `onStop()` is called, all its fragments also get `onStop()` callbacks. This means that fragments will not be interactable and are not visible to the user, similar to the activity.
//
//6. **End of Phone Call**:
//- Once the phone call is finished or declined, and your activity comes back to the foreground:
//- **Activity's `onRestart()`** (if `onStop()` was called) followed by,
//- **Activity's `onStart()`** and then,
//- **Activity's `onResume()`**.
//
//7. **Fragment's Lifecycle Post-Call**:
//- Correspondingly, the fragments will go through their lifecycle methods:
//- **`onStart()`** (if they were stopped) followed by,
//- **`onResume()`**, which means the fragments are now active and interacting with the user again.
//
//### Considerations
//
//- **Handling State**: It's crucial to handle state properly in both your activity and fragments. For example, if you're performing network operations or have unsaved changes in a form within a fragment, you should handle the potential interruption of a phone call properly.
//- **Testing**: Always test these scenarios to ensure that your application behaves correctly under such conditions. Use tools like the Android Emulator, which allows you to simulate phone calls during your app's execution.
//
//In summary, when a phone call is received, the activity and its contained fragments will typically pause (and possibly stop, depending on the visibility of the activity post-call). They will then resume once the call is finished, following the normal lifecycle pattern of activity and fragment resume operations.
//
//
