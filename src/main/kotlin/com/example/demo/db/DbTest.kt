package com.example.demo.db

import UserDB
import model.User

fun main() {
    val db = UserDB()
    println(db.selectAllUsers())
//    db.insertUser(User(-1, "user", "qqq", "qwq"))
//    db.updateUser(User(1, "First", "User", "EN"))
//    println(db.selectAllUsers())

}

class DbTest {

}