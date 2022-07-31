package com.picpay.desafio.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.data.local.dao.UserDao
import com.picpay.desafio.data.local.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class PicPayDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = "PicPayDatabase"
    }
}