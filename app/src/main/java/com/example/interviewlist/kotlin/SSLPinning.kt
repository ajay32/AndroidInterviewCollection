package com.example.interviewlist.kotlin

//SSL pinning is an essential security technique that can be used to safeguard against man-in-the-middle (MITM) attacks by ensuring that the app communicates directly with the intended server. It involves hardcoding the server's expected SSL certificate or public key directly into the app. When using Retrofit, an HTTP client for Android and Java, implementing SSL pinning typically involves configuring the underlying OkHttpClient (from the OkHttp library) that Retrofit uses.
//
//Here's how to implement SSL pinning in an Android app using Retrofit and OkHttpClient:
//
//### Step 1: Get the Public Key Hash
//
//First, you need the hash of the server's SSL certificate's public key. You can retrieve this by running the following command in your terminal or command prompt, replacing `yourdomain.com` with your server's domain:
//
//bash
//echo | openssl s_client -servername yourdomain.com -connect yourdomain.com:443 | openssl x509 -pubkey -noout | openssl rsa -pubin -outform der | openssl dgst -sha256 -binary | openssl enc -base64
//
//
//### Step 2: Add OkHttp and Retrofit to Your Project
//
//Ensure that you have OkHttp and Retrofit added to your project. Add these dependencies in your `build.gradle` (Module: app):
//
//gradle
//implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//implementation 'com.squareup.okhttp3:okhttp:4.9.0'
//
//
//### Step 3: Configure OkHttpClient with Certificate Pinning
//
//Now, configure OkHttpClient to use SSL pinning with the hash you obtained earlier:
//
//kotlin
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRetrofitService(): Retrofit {
    val hostname = "yourdomain.com"
    val certificatePinner = CertificatePinner.Builder()
        .add(hostname, "sha256/AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=") // Replace A...A= with your actual hash
        .build()

    val client = OkHttpClient.Builder()
        .certificatePinner(certificatePinner)
        .build()

    return Retrofit.Builder()
        .baseUrl("https://$hostname/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}


//### Step 4: Use Retrofit as Usual
//
//Now you can use Retrofit as usual to make network requests. The OkHttpClient configured with certificate pinning will enforce that all connections to the specified domain match the pinned certificate.
//
//kotlin
// Example service interface using Retrofit
interface ApiService {
    // Define your API methods here
}

// Getting a Retrofit instance and creating a service
val retrofit = createRetrofitService()
val apiService = retrofit.create(ApiService::class.java)


//### Error Handling
//
//Be aware that pinning the wrong certificate or not updating the pin when your server's SSL certificate changes can cause your app to fail in establishing a connection with the server. Always handle errors properly and plan for certificate rotation.
//
//### Conclusion
//
//SSL pinning helps to significantly increase the security of your application by preventing MITM attacks. However, managing SSL certificates requires careful planning, especially regarding certificate expiration and renewal. Keep your certificate pins updated and test thoroughly whenever your server's SSL configuration changes. This example provides a basic setup for SSL pinning with Retrofit and should be customized based on specific security requirements and server configurations.
//


//=====================================================================================================

//Besides using OkHttp's `CertificatePinner` for SSL pinning as demonstrated earlier, there are other methods and tools you can use to implement SSL pinning in your Retrofit setup. These methods include using a network security configuration file, or third-party libraries like TrustKit. Here's a look at these alternative methods:
//
//### 1. Using Network Security Configuration
//
//From Android 7.0 (API level 24) onwards, Android provides a built-in way to configure network security settings through an XML configuration file. This method does not require code changes in OkHttpClient and is straightforward to manage.
//
//**Step 1:** Create a network security configuration file.
//
//Add a new XML file under `res/xml/network_security_config.xml`:
//
//```xml
//<?xml version="1.0" encoding="utf-8"?>
//<network-security-config>
//<domain-config>
//<domain includeSubdomains="true">yourdomain.com</domain>
//<pin-set expiration="2023-01-01">
//<pin digest="SHA-256">base64encodedpin=</pin> <!-- Use your actual pin -->
//</pin-set>
//</domain-config>
//</network-security-config>
//```
//
//**Step 2:** Reference the configuration in your app's manifest.
//
//In your `AndroidManifest.xml`, add the `networkSecurityConfig` attribute to the `<application>` tag:
//
//```xml
//<application
//android:networkSecurityConfig="@xml/network_security_config"
//...>
//...
//</application>
//```
//
//This method is less flexible than direct code configurations in terms of dynamic changes but offers a simpler and declarative approach to enforcing SSL pinning.
//
//### 2. Using TrustKit for Android
//
//TrustKit is an open-source library that provides advanced SSL pinning and reporting features. It's especially useful if you need features like report-only mode to monitor pinning failures without blocking connections.
//
//**Step 1:** Add TrustKit to your project.
//
//Add the following dependency in your `build.gradle`:
//
//```gradle
//implementation 'com.datatheorem.android.trustkit:trustkit:1.1.3'
//```
//
//**Step 2:** Configure TrustKit in your application.
//
//You need to initialize TrustKit in your `Application` class with a configuration that specifies your domain and pins.
//
//```kotlin
//import android.app.Application
//import com.datatheorem.android.trustkit.TrustKit
//
//class MyApplication : Application() {
//    override fun onCreate() {
//        super.onCreate()
//        TrustKit.initializeWithNetworkSecurityConfiguration(this)
//    }
//}
//```
//
//Also, update your `network_security_config.xml` as TrustKit uses this file under the hood:
//
//```xml
//<?xml version="1.0" encoding="utf-8"?>
//<network-security-config>
//<domain-config>
//<domain includeSubdomains="true">yourdomain.com</domain>
//<pin-set>
//<pin digest="SHA-256">base64encodedpin=</pin> <!-- Use your actual pin -->
//</pin-set>
//</domain-config>
//</network-security-config>
//```
//
//**Step 3:** Use TrustKit's `OkHttpClient` builder for SSL pinning.
//
//```kotlin
//val client = TrustKit.getInstance().getPinningOkHttpClient(context)
//```
//
//### Conclusion
//
//Choosing the right method for implementing SSL pinning in Retrofit depends on your specific requirements, such as the minimum Android API level supported, whether you need the flexibility to update pins without app updates, and the complexity of your network configurations.
//
//Each method has its advantages and drawbacks:
//- **OkHttp's CertificatePinner** gives you programmable control and is integrated directly with your HTTP client configuration.
//- **Network security configuration** provides a system-level integration that is easy to manage and update.
//- **TrustKit** offers a robust solution with additional features like reporting, which can be crucial for diagnosing pinning issues in production.
//
