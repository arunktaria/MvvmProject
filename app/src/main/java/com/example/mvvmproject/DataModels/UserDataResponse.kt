package com.example.mvvmproject.DataModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_userdata")
class UserDataResponse {

    var data: Data?=null


class Data{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id=0
@ColumnInfo(name = "doctor_name")
     var doctor_name:String?=null
    var first_name:String?=null
    var code:String?=null
    var mobile:String?=null
    var dob:String?=null
    var zip_code:String?=null
    var country:String?=null
    var state_id:String?=null
    var state:String?=null
    var status:String?=null
    var last_name:String?=null
    var email:String?=null

}


}