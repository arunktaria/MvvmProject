package com.example.mvvmproject.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_userdata")
class UserDataEntity  {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id:Int=0
    get() = id
    set(value) {field= value}


    @ColumnInfo(name = "email")
    var email: String =""
        get() = email
        set(value) {field= value}

    @ColumnInfo(name = "password")
    var password: String =""
        get() = password
        set(value) {field= value}

    @ColumnInfo(name = "user_type")
    var user_type: String=""
        get() = user_type
        set(value) {field= value}

    @ColumnInfo(name = "device_token")
    var device_token: String =""
        get() = device_token
        set(value) {field= value}

    @ColumnInfo(name = "device_type")
    var device_type: String = "android"
        get() = device_type
        set(value) {field= value}

    @ColumnInfo(name = "version")
    var version: String = ""
        get() = version
        set(value) {field= value}

    @ColumnInfo(name = "handset")
    var handset: String = "android"
        get() = handset
        set(value) {field= value}


}