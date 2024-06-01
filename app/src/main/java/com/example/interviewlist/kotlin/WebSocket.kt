package com.example.interviewlist.kotlin

//WebSockets provide a way to open a bi-directional communication session between your Android app and a server. This allows for sending messages to a server and receiving event-driven responses without having to poll the server for a reply.
//
//To implement WebSocket communication in an Android app, one popular and easy-to-use library is `OkHttp`. Below is a step-by-step guide on how to set up a simple WebSocket connection using OkHttp:
//
//### Step 1: Add OkHttp Dependency
//
//First, add the OkHttp library to your project. Update your `build.gradle` (Module: app) file to include the following dependency:
//
//```gradle
//dependencies {
//    implementation 'com.squareup.okhttp3:okhttp:4.9.1' // Check for the latest version on the official site
//}
//```
//
//### Step 2: Create a WebSocket Client
//
//You can create a class or directly implement it in your activity where you handle the WebSocket connection. Here’s an example of using OkHttp to connect to a WebSocket server:
//
//```java
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.WebSocket;
//import okhttp3.WebSocketListener;
//import okio.ByteString;
//
//public class WebSocketClient {
//
//    private WebSocket webSocket;
//    private OkHttpClient client;
//
//    public void start() {
//        client = new OkHttpClient();
//        Request request = new Request.Builder().url("wss://echo.websocket.org").build(); // Replace with your WebSocket server URL
//        webSocket = client.newWebSocket(request, new EchoWebSocketListener());
//    }
//
//    private final class EchoWebSocketListener extends WebSocketListener {
//        @Override
//        public void onOpen(WebSocket webSocket, okhttp3.Response response) {
//            webSocket.send("Hello, it's me!"); // Example message sent to server
//            webSocket.send(ByteString.decodeHex("deadbeef")); // Send a binary message
//            webSocket.close(1000, "Goodbye, world!"); // Code 1000 denotes normal closure
//        }
//
//        @Override
//        public void onMessage(WebSocket webSocket, String text) {
//            System.out.println("Receiving : " + text);
//        }
//
//        @Override
//        public void onMessage(WebSocket webSocket, ByteString bytes) {
//            System.out.println("Receiving bytes : " + bytes.hex());
//        }
//
//        @Override
//        public void onClosing(WebSocket webSocket, int code, String reason) {
//            webSocket.close(1000, null);
//            System.out.println("Closing : " + code + " / " + reason);
//        }
//
//        @Override
//        public void onFailure(WebSocket webSocket, Throwable t, okhttp3.Response response) {
//            t.printStackTrace();
//        }
//    }
//
//    public void stop() {
//        if (client != null) {
//            client.dispatcher().executorService().shutdown();
//        }
//    }
//}
//```
//
//### Step 3: Use the WebSocket Client in Your Activity
//
//You can initiate the connection when your activity starts and close it when the activity is destroyed to manage the lifecycle properly:
//
//```java
//public class MainActivity extends AppCompatActivity {
//
//    private WebSocketClient webSocketClient;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        webSocketClient = new WebSocketClient();
//        webSocketClient.start();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (webSocketClient != null) {
//            webSocketClient.stop();
//        }
//    }
//}
//```
//
//This simple example sets up a WebSocket connection that sends a message to the server and listens for messages. It demonstrates sending both text and binary data, handling incoming messages, and properly closing the connection.
//
//Remember to replace `"wss://echo.websocket.org"` with the actual URL of your WebSocket server. The server URL should start with `ws://` for non-secure or `wss://` for secure WebSocket connections.
//
//

// websockets use cases

//WebSockets are particularly useful for applications that require real-time data exchange between the client and the server. Here are some common use cases where WebSockets are typically implemented:
//
//### 1. **Chat Applications**
//WebSockets are ideal for building real-time chat applications where users expect immediate delivery of messages. By maintaining a persistent connection, messages can be sent and received instantly without the need to continually refresh the page or poll the server.
//
//### 2. **Live Notifications and Alerts**
//In applications like social media platforms or trading platforms, users can receive live notifications about new posts, comments, stock movements, or other important alerts without any noticeable delay, enhancing user engagement and providing timely information.
//
//### 3. **Real-Time Data Feeds**
//WebSockets are widely used in applications requiring real-time data feeds, such as live sports scores, stock tickers, or any other type of live data update. This is crucial for applications where data is constantly changing and users rely on the most current information.
//
//### 4. **Collaborative Editing**
//Applications that allow multiple users to edit the same document simultaneously, such as Google Docs or collaborative coding platforms, use WebSockets to synchronize changes between users in real time. This ensures that all participants can see edits as they are being made by others.
//
//### 5. **Gaming**
//Real-time multiplayer online games use WebSockets for fast and real-time communication of the game state to all players. This is crucial for keeping the game fair and reactive, as players' actions need to be immediately reflected on other players’ screens.
//
//### 6. **Financial Trading Platforms**
//In trading platforms, where even a split second’s delay can result in financial loss, WebSockets are used to stream market data, trading volumes, and price changes in real-time. Traders can react immediately to market shifts, making these platforms more effective and responsive.
//
//### 7. **IoT Device Control**
//For IoT applications, WebSockets enable real-time communication and control of devices. This allows users and systems to monitor and control IoT devices from remote locations without any noticeable delay, such as adjusting thermostats, lights, or monitoring sensors.
//
//### 8. **Live Streaming**
//Although not typically used for transferring video or audio streams, WebSockets can be used to control and synchronize live streaming media. For example, they can handle playback control messages, chat during a live stream, or updates about the streaming status.
//
//### 9. **Auction Systems**
//Real-time bidding systems for auctions can benefit from WebSockets, as they allow immediate updates of bids to all participants, ensuring that everyone is aware of the current bid without delay.
//
//### 10. **Transport and Logistics Tracking**
//WebSockets enable real-time tracking of logistics movements, such as the locations of vehicles, estimated times of arrival, and status updates. This is crucial for logistics platforms needing real-time updates for planning and operational efficiency.
//
//### 11. **Health Monitoring Systems**
//In healthcare, WebSockets facilitate real-time monitoring of patient data and vital signs in critical care situations. This allows healthcare providers to make quick decisions based on the most current data available.
//
//These use cases demonstrate the versatility of WebSockets in enabling efficient, real-time interactions and updates across a wide range of applications.
//

// coroutine with websocket

//### Using WebSockets with Retrofit
//Retrofit is a type and safe HTTP client for Android and Java developed by Square. It is primarily designed to turn your HTTP API into a Java interface, and it is best suited for making RESTful requests (GET, POST, PUT, DELETE, etc.). Retrofit does not natively support WebSockets as it is fundamentally designed for request/response style HTTP communications, which are inherently different from the persistent, full-duplex connections established via WebSockets.
//
//For real-time, bidirectional communication with a WebSocket, you would typically use a library that is specifically designed for handling WebSocket connections, such as OkHttp (which is also from Square and integrates well with Retrofit for HTTP calls) or other WebSocket-specific libraries like `Scarlet` which builds on top of OkHttp and Retrofit's principles.
//
//### Using WebSockets with Coroutines
//Kotlin Coroutines are a powerful feature in Kotlin for managing background tasks in a more efficient and simpler way compared to traditional threading methods. You can use coroutines with WebSockets to handle asynchronous streaming of data more effectively. Coroutines can be particularly useful for managing the lifecycle of WebSocket connections, sending messages, and processing received messages without blocking the main thread.
//
//Here’s an example of how you might integrate WebSockets with Kotlin Coroutines using OkHttp:
//
//```kotlin
//import kotlinx.coroutines.*
//import okhttp3.*
//
//fun main() = runBlocking {
//    val client = OkHttpClient()
//    val request = Request.Builder().url("wss://echo.websocket.org").build()
//    val wsListener = EchoWebSocketListener()
//
//    val webSocket = client.newWebSocket(request, wsListener)
//
//    wsListener.send(webSocket, "Hello, WebSocket!")
//    delay(5000) // Wait for some messages to be echoed back
//    wsListener.close(webSocket)
//
//    client.dispatcher.executorService.shutdown()
//}
//
//class EchoWebSocketListener : WebSocketListener() {
//    private val scope = CoroutineScope(Dispatchers.IO)
//
//    override fun onOpen(webSocket: WebSocket, response: Response) {
//        println("WebSocket opened.")
//    }
//
//    override fun onMessage(webSocket: WebSocket, text: String) {
//        println("Receiving : $text")
//    }
//
//    fun send(webSocket: WebSocket, message: String) {
//        scope.launch {
//            webSocket.send(message)
//        }
//    }
//
//    fun close(webSocket: WebSocket) {
//        scope.launch {
//            webSocket.close(1000, "Closing WebSocket.")
//        }
//    }
//
//    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
//        println("Error : ${t.localizedMessage}")
//    }
//}
//```
//
//In this example:
//- **Coroutines** handle the sending and closing actions asynchronously, ensuring that these operations don't block the main thread.
//- **OkHttp’s WebSocket** is used to handle real-time, full-duplex communication.
//
//This setup demonstrates how coroutines can be integrated to manage WebSocket communication effectively, enhancing the responsiveness and scalability of your application.
//
//

//============================================

//How chat app works with Websockets

//A chat application using WebSockets functions by establishing a persistent, full-duplex communication channel between the client (user's device or web browser) and the server. This enables messages to be sent and received in real-time without the need for polling the server for updates. Here’s a breakdown of how a typical chat app works with WebSockets:
//
//### 1. **Client and Server Setup**
//- **Server**: A WebSocket server is set up to handle incoming WebSocket connections, manage connected clients, and facilitate message broadcasting to one or multiple clients. Common technologies for building WebSocket servers include Node.js with the `ws` or `socket.io` library, Python with `websockets`, and Java with frameworks like Spring.
//- **Client**: The client application, which could be a web app or a mobile app, uses a WebSocket library compatible with its platform to open a connection to the WebSocket server. For web clients, the browser's native WebSocket API is often used, while mobile clients might use libraries like OkHttp for Android or Starscream for iOS.
//
//### 2. **Establishing a Connection**
//- When a user opens the chat application, the client establishes a WebSocket connection to the server by sending a WebSocket handshake request to the server's URL (e.g., `ws://example.com/chat`).
//- The server accepts the connection and maintains it open for as long as needed, allowing for two-way data flow without requiring new HTTP connections for each message.
//
//### 3. **User Interaction and Message Flow**
//- **Sending Messages**: When a user types a message and hits send, the message is packaged into a WebSocket frame and sent through the WebSocket connection to the server.
//- **Receiving Messages**: The server receives the message and processes it (e.g., checks for commands, filters for unacceptable words, parses it for data, etc.). It then sends this message to the intended recipients. In a chat room, this might mean broadcasting to all other connected clients.
//- **Notifications**: Users can also be notified in real-time about events like someone joining the conversation or a user typing a message.
//
//### 4. **Handling Connections**
//- **Multiple Clients**: The server keeps track of all active connections, often associating each connection with user session data. When a message needs to be sent to specific users or groups, the server identifies the appropriate connections and sends the message only to those users.
//- **Heartbeats/Pings**: To ensure that connections are alive and well, both the client and server might send periodic "ping" messages that the other party is expected to answer with "pong" messages. This helps in keeping the connection alive, particularly through proxies and firewalls that might otherwise close idle connections.
//
//### 5. **Closing the Connection**
//- Users can explicitly close the chat or disconnect, at which point the client sends a close frame, and the server acknowledges this and closes the connection on its end.
//- The server can also initiate the close if needed, for instance, due to inactivity or server shutdown.
//
//### Example Technologies Used
//- **Frontend**: HTML/CSS/JavaScript with WebSocket API for web, or Swift for iOS and Kotlin for Android using appropriate WebSocket libraries.
//- **Backend**: Node.js, Python, Java, or any other capable of handling WebSocket connections.
//- **Real-Time Data Handling**: Libraries like `socket.io`, `ws` for Node.js, or `websocket` extensions for other backend languages.
//
//### Security Considerations
//- **Encryption**: Use `wss://` (WebSocket Secure) instead of `ws://` to encrypt data transferred via WebSockets.
//- **Authentication**: Implement token-based authentication (like JWT) to ensure that the WebSocket connection is initiated by an authenticated user.
//- **Validation**: Validate all incoming data to avoid injection attacks and ensure that outgoing messages do not contain sensitive data unless necessary.
//
//This architecture allows for efficient real-time communication ideal for a chat app, reducing latency and server load compared to traditional HTTP polling techniques.
//
