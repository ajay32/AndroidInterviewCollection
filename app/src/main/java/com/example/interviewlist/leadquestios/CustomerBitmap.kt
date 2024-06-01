package com.example.interviewlist.leadquestios

//suppose any one customer ask to develop application which is two screen
//first screne has two cards and shows movie poster and poster image has high resolution image 50mb and when we click on image movie should start?

//only for sake of two images which will be best approach ?

//Bitmap factory .. is the best solution here.. becuase we do need to increase the size of apk
//User


//To develop an Android application with two screens, where the first screen displays two high-resolution movie posters on cards, and clicking on these images starts the movie, you need to consider both design and performance. Here's a step-by-step guide on how to approach this:
//
//### 1. Design the Layout
//- **First Screen**: Use a layout manager like `RecyclerView` with a `GridLayoutManager` to display the two cards. Each card should ideally contain an `ImageView` to display the movie poster and possibly a `TextView` for the movie title.
//- **Second Screen**: This screen will play the movie. Use a video player like `ExoPlayer` or `VideoView` to handle video playback.
//
//### 2. Handling High-Resolution Images
//Since the images are high resolution (50 MB each), loading them directly into the app would not be efficient. Here’s how to handle this:
//- **Image Compression**: Before adding images to your app, compress them using tools like Photoshop, or a web service that reduces file size without compromising on visible quality.
//- **Use Thumbnails**: Display a lower resolution thumbnail in the `ImageView`. You can generate thumbnails server-side, or use a service like Imgix, which dynamically resizes images.
//- **Lazy Loading**: Implement lazy loading of images, where the high-resolution image only loads when necessary (e.g., upon user tapping the image, before transitioning to the second screen).
//
//### 3. Image Loading Library
//Use an image loading library like Glide or Picasso. These libraries can handle image resizing, caching, and asynchronous loading, which is essential for performance:
//```kotlin
//Glide.with(context)
//.load(imageUrl)
//.placeholder(R.drawable.loading_spinner)
//.into(imageView)
//```
//
//### 4. Click Listener to Start Movie
//Set a click listener on the card or image. When a user taps on it, the app should navigate to the second screen where the movie starts playing:
//```kotlin
//cardView.setOnClickListener {
//    val intent = Intent(context, MoviePlayerActivity::class.java)
//    intent.putExtra("MOVIE_URL", movieUrl)
//    startActivity(intent)
//}
//```
//
//### 5. Movie Playback Screen
//In the `MoviePlayerActivity`, use `ExoPlayer` to handle video playback. ExoPlayer can handle various formats and sources, and provides tools for buffering and smooth playback:
//```kotlin
//class MoviePlayerActivity : AppCompatActivity() {
//
//    private lateinit var player: SimpleExoPlayer
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_movie_player)
//
//        val movieUrl = intent.getStringExtra("MOVIE_URL")
//        player = SimpleExoPlayer.Builder(this).build()
//        playerView.player = player
//
//        val mediaItem = MediaItem.fromUri(movieUrl)
//        player.setMediaItem(mediaItem)
//        player.prepare()
//        player.play()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        player.release()
//    }
//}
//```
//
//### 6. Optimization and Testing
//- **Memory Management**: Ensure your app handles memory well, given the high-resolution images and video playback.
//- **Testing**: Test on various devices to ensure that images load quickly, the transition between activities is smooth, and video playback does not stutter.
//
//By following these steps, you can create an efficient and user-friendly app that handles high-resolution images and smooth video playback effectively.
//
//
