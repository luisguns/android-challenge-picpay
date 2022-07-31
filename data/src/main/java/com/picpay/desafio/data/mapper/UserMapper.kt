package com.picpay.desafio.data.mapper

import com.picpay.desafio.data.local.model.UserEntity
import com.picpay.desafio.data.network.model.UserDTO
import com.picpay.desafio.domain.model.User

fun UserDTO.toDomainModel() = User(id, name, username, img)

fun UserEntity.toDomainModel() = User(id, name, username, img)

fun User.toLocalDataModel() = UserEntity(id, name, username, img)

fun UserDTO.toLocalDataModel() = UserEntity(id, name, username, img)
