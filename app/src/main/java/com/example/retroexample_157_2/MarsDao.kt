package com.example.retroexample_157_2

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.retroexample_157_2.model.remote.MarsRealState


@Dao
interface MarsDao {

    //Insetar Elemento
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMars(mars:MarsRealState)
    //Insertar lista de tarea
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertAllMars(listMars:List<MarsRealState>)

    //Borrar una tarea

    @Delete
    suspend fun deleteMars(mars: MarsRealState)

    //Borrar Toda
    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

    @Query("SELECT* FROM task_table WHERE id =:id")
    fun getMarsById (id:String):LiveData<MarsRealState>


    //traer todos los elementos
    @Query(" SELECT * FROM task_table")
    fun getAllMars() : LiveData<List<MarsRealState>>





}

