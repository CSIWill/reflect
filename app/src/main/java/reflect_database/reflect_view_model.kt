//package reflect_database
//
//import androidx.lifecycle.*
//import kotlinx.coroutines.launch
//import reflect_database.my_entry
//
//class reflect_view_model(private val repository: reflect_repository) : ViewModel() {
//
//    val entries: LiveData<List<my_entry>> = repository.getEntries().asLiveData()
//
//    fun addEntry(journal_entry: my_entry) = viewModelScope.launch {  //wrapper addEntry method
//        repository.addEntry(journal_entry)
//    }
//}
//class reflect_view_model_factory(private val repository: reflect_repository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
//        if(modelClass.isAssignableFrom(reflect_view_model::class.java)) {
//            @Suppress("unchecked cast")
//            return reflect_view_model(repository) as T
//        }
//        throw IllegalArgumentException("unknown ViewModel class")
//    }
//}