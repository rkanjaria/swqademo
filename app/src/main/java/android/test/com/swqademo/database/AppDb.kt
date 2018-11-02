package android.test.com.swqademo.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.test.com.swqademo.database.daos.SpecializationDao
import android.test.com.swqademo.database.daos.UserDao
import android.test.com.swqademo.database.entities.Specialization
import android.test.com.swqademo.database.entities.User

@Database(entities = [User::class, Specialization::class], version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun specializationDao(): SpecializationDao
}