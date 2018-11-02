package android.test.com.swqademo.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.test.com.swqademo.utils.*

@Entity(tableName = USERS)
data class User(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = USER_ID)
        val id: Int = 0,
        @ColumnInfo(name = USER_NAME)
        val fullName: String,
        @ColumnInfo(name = USER_EMAIL)
        val email: String,
        @ColumnInfo(name = USER_PASSWORD)
        val password: String
)