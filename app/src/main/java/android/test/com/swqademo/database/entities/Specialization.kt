package android.test.com.swqademo.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.test.com.swqademo.utils.SPECIALIZATION
import android.test.com.swqademo.utils.SPEC_ID
import android.test.com.swqademo.utils.SPEC_NAME
import android.test.com.swqademo.utils.SPEC_PARENT

@Entity(tableName = SPECIALIZATION)
data class Specialization(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = SPEC_ID)
        val specializationId: Int = 0,
        @ColumnInfo(name = SPEC_NAME)
        val specializationName: String,
        @ColumnInfo(name = SPEC_PARENT)
        val specializationParent: String
)