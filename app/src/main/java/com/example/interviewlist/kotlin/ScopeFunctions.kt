package com.example.interviewlist.kotlin


fun main()  {
    // let
// it takes a object and return lambda result //null checks
    val result = "Hello World".let { it.length }
    println(result)

    // with - take object as parameter and return lambda result
    val withResult = with("Hello World") { // need to pass object as argument
        length
    }
    println(withResult)

    val runResult = "Hello World".run {// initilize objects
        length
    }
    println(runResult)

    // aa  also apply both return objects
    // apply takes a object add its behavior and return the object
    val list = mutableListOf<Int>(1,2,3,4).apply {//apply is used for configuring objects without breaking the chain of method calls
        add(5)
    }
    println(list.toString())

    val list2 = mutableListOf<Int>(1,2,3,4).also {//useful when you need a reference to the object itself for logging, additional method chaining,
        it.add(5)
    }
    println(list2)


//
}

//=====================

//button.setOnClickListener {
//    // Use `run` to update multiple properties of textView and imageView together
//    textView.run {
//        text = "Button Clicked"
//        setTextColor(Color.RED)
//        textSize = 20f
//    }
//}

//************ apply

//recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView).apply {
//    layoutManager = LinearLayoutManager(this@MyActivity) // Set the layout manager
//    adapter = MyAdapter(listOf("Item 1", "Item 2", "Item 3")) // Set the adapter
//    addItemDecoration(DividerItemDecoration(this@MyActivity, DividerItemDecoration.VERTICAL)) // Add decoration
//    setHasFixedSize(true) // Improve performance if you know changes in content do not change the layout size of the RecyclerView
//}
//

//====================================================================================================

//********** apply and also

//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_my)
//
//    textView = findViewById<TextView>(R.id.myTextView).apply {
//        text = "Hello, Kotlin!"
//        textSize = 20f
//        setTextColor(Color.BLUE)
//    }.also {
//        Log.d("MyActivity", "Configured TextView with text: ${it.text}")
//    }
//
//    // Assume more setup here...
//}

//===================================================================================================

//*********** let & run example

//class UserDetailActivity : AppCompatActivity() {
//    private lateinit var userNameTextView: TextView
//    private lateinit var userEmailTextView: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_detail)
//
//        userNameTextView = findViewById(R.id.userNameTextView)
//        userEmailTextView = findViewById(R.id.userEmailTextView)
//
//        // Assume getUserDetails() fetches user data which might be null
//        getUserDetails()?.let { userDetails ->
//            // 'let' ensures userDetails is not null within this block
//            userNameTextView.run {
//                text = userDetails.name  // Set the name to TextView
//                setTextColor(Color.BLACK) // Setting text color
//                visibility = View.VISIBLE // Make TextView visible
//            }
//            userEmailTextView.run {
//                text = userDetails.email  // Set the email to TextView
//                setTextColor(Color.GRAY) // Setting text color
//                visibility = View.VISIBLE // Make TextView visible
//            }
//        } ?: run {
//            // Run this block if getUserDetails() returns null
//            Toast.makeText(this, "User details not available.", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun getUserDetails(): UserDetails? {
//        // Mock fetching user data that might return null
//        return UserDetails("John Doe", "john.doe@example.com")  // Replace with actual data fetching logic
//    }
//}
//
//data class UserDetails(val name: String, val email: String)
