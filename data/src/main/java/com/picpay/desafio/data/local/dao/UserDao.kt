package com.picpay.desafio.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.data.local.model.UserEntity


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: List<UserEntity>)

    @Query("DELETE FROM user")
    suspend fun deleteAllUser()

    @Query("SELECT * FROM user")
    suspend fun getAllUser(): List<UserEntity>?
}