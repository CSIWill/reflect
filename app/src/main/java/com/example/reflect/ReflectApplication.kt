package com.example.reflect

import android.app.Application
import reflect_database.my_database

class ReflectApplication: Application() {
    val database by lazy { my_database.getDatabase(this) }
    val repository by lazy {EntryRepository( database.reflect_dao()) }
}