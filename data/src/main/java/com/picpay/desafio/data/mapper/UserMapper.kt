package com.picpay.desafio.data.mapper

import com.picpay.desafio.data.model.UserDTO
import com.picpay.desafio.domain.model.User

fun UserDTO.toDomainModel() = User(id, name, username, img)