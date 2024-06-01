package com.example.interviewlist.androidtopics

//In Android development, both `Serializable` and `Parcelable` are interfaces used for turning objects into a format that can be stored or transmitted (serialization). The key differences between them lie in their usage, performance, and implementation methods.
//
//### Serializable
//`Serializable` is a standard Java interface from the `java.io` package. It is very easy to implement, as it requires no additional methods; you simply mark a class as implementing `Serializable`:
//
//```java
//import java.io.Serializable;
//
//public class ExampleClass implements Serializable {
//    private int data;
//    private String name;
//    // Constructors, getters, setters
//}
//```
//
//**Advantages**:
//- Easy to implement: No boilerplate code is required.
//- Automatically serializes private members: You do not need to manually write the serialization logic.
//
//**Disadvantages**:
//- Performance: It uses reflection to infer the structure of your class, which can be slower than manually specifying the structure. This can lead to significant performance overhead.
//- Overhead: It generates a lot of additional data during serialization, which increases the size of the output.
//
//### Parcelable
//`Parcelable` is an Android-specific interface, found in the `android.os` package. It is designed for high-performance IPC (Inter-Process Communication), and you implement it by fulfilling several methods that manually handle the serialization and deserialization of the object's components.
//
//```java
//import android.os.Parcel;
//import android.os.Parcelable;
//
//public class ExampleClass implements Parcelable {
//    private int data;
//    private String name;
//
//    public int describeContents() {
//        return 0;
//    }
//
//    public void writeToParcel(Parcel out, int flags) {
//        out.writeInt(data);
//        out.writeString(name);
//    }
//
//    public static final Parcelable.Creator<ExampleClass> CREATOR
//    = new Parcelable.Creator<ExampleClass>() {
//        public ExampleClass createFromParcel(Parcel in) {
//            return new ExampleClass(in);
//        }
//
//        public ExampleClass[] newArray(int size) {
//            return new ExampleClass[size];
//        }
//    };
//
//    private ExampleClass(Parcel in) {
//        data = in.readInt();
//        name = in.readString();
//    }
//
//    // Constructors, getters, setters
//}
//```
//
//**Advantages**:
//- Performance: It is much faster than `Serializable` because it is optimized for Android and avoids using reflection.
//- Control: Developers have explicit control over the serialization process.
//
//**Disadvantages**:
//- Boilerplate code: Requires more code to implement.
//- Maintenance: As fields are added or the structure changes, you must update the `Parcelable` implementation manually.
//
//### When to Use Each
//- **Use `Serializable`** when you need a quick serialization method without much performance consideration, or when dealing with a small object where performance is not a concern.
//- **Use `Parcelable`** for high-performance requirements such as passing objects between Android components or storing data in bundles. It's especially preferred for mobile development within Android because it's optimized for the platform.
//
//In summary, `Parcelable` is generally preferred in Android for performance-sensitive applications, despite requiring more effort to implement. `Serializable` might still be suitable for simpler cases or where cross-platform compatibility is needed.
//
//
