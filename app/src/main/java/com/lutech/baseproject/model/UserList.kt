package com.lutech.baseproject.model

data class User(val id:String? , val name:String?, val gender:String?, val email: String?,val status: String?)
data class UserResponse(val code:String? , val meta:String?, val data:User)

