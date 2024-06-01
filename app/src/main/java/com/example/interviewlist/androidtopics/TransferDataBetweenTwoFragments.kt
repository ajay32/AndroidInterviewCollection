package com.example.interviewlist.androidtopics

//Sharing data between fragments in an Android application is a common scenario. There are several ways to do this effectively, each with its advantages depending on your app's architecture and the specific needs of your use case. Here are some of the best methods:
//
//### 1. **ViewModel and LiveData (Recommended)**
//Using a `ViewModel` shared between fragments is one of the best and most recommended approaches for sharing data. This method is particularly useful when you have multiple fragments displaying different facets of the same data.
//
//- **Shared ViewModel**: Create a `ViewModel` scoped to the activity that hosts the fragments. This way, all fragments within the activity can access and modify the same instance of the `ViewModel`.
//- **LiveData**: Use LiveData (or StateFlow in Kotlin) inside the ViewModel to observe data and react to changes. LiveData is lifecycle-aware, ensuring that your app does not crash from trying to update fragment views that are not in an active state.
//
//#### Example:
//```kotlin
//class SharedViewModel : ViewModel() {
//    private val selected = MutableLiveData<Item>()
//    fun select(item: Item) {
//        selected.value = item
//    }
//    fun getSelected(): LiveData<Item> = selected
//}
//
//class FragmentA : Fragment() {
//    private val viewModel: SharedViewModel by activityViewModels()
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        someButton.setOnClickListener {
//            viewModel.select(Item("data"))
//        }
//    }
//}
//
//class FragmentB : Fragment() {
//    private val viewModel: SharedViewModel by activityViewModels()
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.getSelected().observe(viewLifecycleOwner, Observer<Item> { item ->
//            // Update UI
//        })
//    }
//}
//```
//
//### 2. **Using a Shared Repository**
//If your data is stored or fetched from a database or network, you can use a repository pattern. Both fragments can access this repository which serves as a single source of truth.
//
//- **Repository**: Implement a repository that handles data logic and is accessed by the ViewModel of each fragment.
//- **Consistency**: This ensures that all fragments are interacting with up-to-date and consistent data.
//
//### 3. **Interface Callbacks**
//You can define an interface in one fragment and implement it in either the activity or the other fragment. This method is a bit more manual but useful for simple or direct interactions.
//
//- **Define an Interface**: One fragment defines an interface that the other fragment or hosting activity implements.
//- **Interaction**: Use this interface to pass data directly.
//
//#### Example:
//```kotlin
//// In FragmentA
//interface OnItemSelectedListener {
//    fun onItemSelected(item: Item)
//}
//
//class FragmentA : Fragment() {
//    var listener: OnItemSelectedListener? = null
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        listener = context as? OnItemSelectedListener
//    }
//
//    fun someMethod() {
//        listener?.onItemSelected(Item("data"))
//    }
//}
//
//// In Activity or FragmentB
//class MainActivity : AppCompatActivity(), FragmentA.OnItemSelectedListener {
//    override fun onItemSelected(item: Item) {
//        // Handle item selection
//    }
//}
//```
//
//### 4. **Event Bus or Pub/Sub Systems**
//Using an event bus (like EventBus) or a Publish/Subscribe system can decouple the fragments from each other while allowing messages or data to be passed between them.
//
//- **Event Bus**: Use a third-party library or implement your own to send and receive data.
//- **Decoupling**: This method reduces dependencies between fragments but can make the data flow harder to follow and debug.
//
//### Best Practice Tips
//- **Avoid direct Fragment-to-Fragment communication**: Always try to communicate through the ViewModel or the hosting Activity to keep fragment independence and modularity.
//- **Use safe arguments**: For passing data during navigation from one fragment to another, consider using the Navigation Component with safe args to pass data safely and effectively.
//
//The choice of method largely depends on the scope of your application, the complexity of the data being shared, and the architecture you are following. The ViewModel approach aligns well with modern Android development practices, offering lifecycle safety and good separation of concerns.
//

//==========================================================================

//Certainly! Implementing a shared repository to manage data between fragments is a common pattern, especially useful when your data layer involves operations like fetching data from a network or database. Below, I will provide a simple example where we use a repository to fetch data, and then share this data between two fragments using a ViewModel.
//
//### Step 1: Define the Repository
//First, let's define the repository that handles data operations. In this example, let's assume we're fetching user details from a network or a mock source.
//
//```kotlin
//class UserRepository {
//    // Simulating a network or database call to fetch user details
//    fun getUserDetails(): LiveData<User> {
//        val liveData = MutableLiveData<User>()
//        liveData.value = User("John Doe", 30)  // Mock data
//        return liveData
//    }
//}
//```
//
//Here, `UserRepository` provides a method to get user details which returns a `LiveData` containing user data.
//
//### Step 2: Define the ViewModel
//The ViewModel will be used by the fragments to interact with the repository. It acts as a bridge between the repository and the UI (fragments).
//
//```kotlin
//class UserViewModel : ViewModel() {
//    private val userRepository = UserRepository()
//
//    val userDetails: LiveData<User> by lazy {
//        userRepository.getUserDetails()
//    }
//}
//```
//
//In the ViewModel, we initialize an instance of `UserRepository` and expose the user details through a LiveData property. This allows the fragments to observe the LiveData for changes.
//
//### Step 3: Define the User Data Class
//Let’s also define the `User` data class which will be used to hold the user information.
//
//```kotlin
//data class User(val name: String, val age: Int)
//```
//
//### Step 4: Implementing Fragments
//Now, we'll create two fragments that will share this data.
//
//#### FragmentA (displays user data)
//
//```kotlin
//class FragmentA : Fragment() {
//    private val userViewModel: UserViewModel by activityViewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding = FragmentABinding.inflate(inflater, container, false)
//
//        userViewModel.userDetails.observe(viewLifecycleOwner, Observer { user ->
//            binding.textView.text = "Name: ${user.name}, Age: ${user.age}"
//        })
//
//        return binding.root
//    }
//}
//```
//
//#### FragmentB (displays user data in a different format or detail)
//
//```kotlin
//class FragmentB : Fragment() {
//    private val userViewModel: UserViewModel by activityViewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding = FragmentBBinding.inflate(inflater, container, false)
//
//        userViewModel.userDetails.observe(viewLifecycleOwner, Observer { user ->
//            binding.detailTextView.text = "User Details - Name: ${user.name}, Age: ${user.age}"
//        })
//
//        return binding.root
//    }
//}
//```
//
//In both FragmentA and FragmentB, we use `activityViewModels()` delegate to obtain an instance of `UserViewModel` scoped to their containing activity. This ensures that both fragments interact with the same instance of the ViewModel, and thus, share the same data.
//
//### Summary
//This setup with a repository pattern ensures that data fetching and handling logic is encapsulated within the repository, keeping the ViewModel and UI layers clean and focused only on presenting data. Both fragments receive updates automatically through LiveData, making the UI consistent and responsive to data changes.
//
