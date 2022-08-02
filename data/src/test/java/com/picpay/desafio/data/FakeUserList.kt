package com.picpay.desafio.data

import com.picpay.desafio.domain.model.User

class FakeUserList {

    companion object {
        fun getFakeList(): List<User> {
            return listOf(
                User(1,"Sandrine Spinka","Tod86","https://randomuser.me/api/portraits/men/1.jpg"),
                User(2,"Carli Carroll","Constantin_Sawayn","https://randomuser.me/api/portraits/men/2.jpg"),
                User(3,"Annabelle Reilly","Lawrence_Nader62","https://randomuser.me/api/portraits/men/3.jpg"),
                User(4,"Mrs. Hilton Welch","Tatyana_Ullrich","https://randomuser.me/api/portraits/men/4.jpg")
            )
        }

        fun getFakeListLocal(): List<User> {
            return listOf(
                User(10,"Sandrine Spinka","Tod86","https://randomuser.me/api/portraits/men/1.jpg"),
                User(30,"Annabelle Reilly","Lawrence_Nader62","https://randomuser.me/api/portraits/men/3.jpg"),
                User(40,"Mrs. Hilton Welch","Tatyana_Ullrich","https://randomuser.me/api/portraits/men/4.jpg")
            )
        }
    }
}