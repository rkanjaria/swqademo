package android.test.com.swqademo.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.test.com.swqademo.database.entities.User
import android.test.com.swqademo.utils.USERS
import android.test.com.swqademo.utils.USER_EMAIL
import android.test.com.swqademo.utils.USER_PASSWORD

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User): Long

    @Query("SELECT * FROM ${USERS} WHERE ${USER_EMAIL}= :email AND ${USER_PASSWORD}= :password")
    fun getUser(email: String, password: String): List<User>
}