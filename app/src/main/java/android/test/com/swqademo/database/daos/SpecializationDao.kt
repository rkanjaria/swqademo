package android.test.com.swqademo.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.test.com.swqademo.database.entities.Specialization
import android.test.com.swqademo.utils.SPECIALIZATION
import android.test.com.swqademo.utils.SPEC_NAME
import android.test.com.swqademo.utils.SPEC_PARENT

@Dao
interface SpecializationDao {

    @Query("SELECT ${SPEC_NAME} FROM ${SPECIALIZATION} WHERE ${SPEC_PARENT} = :specParent")
    fun getAllSpecializations(specParent: String) : List<String>

    @Query("SELECT count(*) FROM ${SPECIALIZATION}")
    fun isSpecTableEmpty(): Int

    @Insert
    fun insetAllSubSpecializations(subSpecalizationList: List<Specialization>)
}