package android.test.com.swqademo

import android.arch.persistence.room.Room
import android.content.Context
import android.support.annotation.LayoutRes
import android.test.com.swqademo.database.AppDb
import android.test.com.swqademo.utils.DATABASE_NAME
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast

val Context.database: AppDb
    get() = Room.databaseBuilder(applicationContext, AppDb::class.java, DATABASE_NAME)
            .allowMainThreadQueries()
            .build()

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false) =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

fun Context.showMessage(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}