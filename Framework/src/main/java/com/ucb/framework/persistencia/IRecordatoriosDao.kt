package com.ucb.framework.persistencia

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IRecordatoriosDao {

    @Query("SELECT * FROM recordatorios")
    fun getRecordatorios(): List<Recordatorios>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(gitAccount: Recordatorios)
}