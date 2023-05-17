package com.lutech.baseproject.request_api

import android.util.Log
import com.lutech.baseproject.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HandleAPI {

    private lateinit var retrofitInstance: ApiService


    @Synchronized
    fun init() {
        retrofitInstance = RetroInstance.getRetrofitInstance().create(ApiService::class.java)
    }

    fun getListUser(getListUserCallback: GetUserListCallback) {

        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            val call = retrofitInstance.getListUser()
            call!!.enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (response.isSuccessful) {
                        getListUserCallback.onGetListUserSuccess(response.body() as List<User>)
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    getListUserCallback.onGetListUserFailure(t.message.toString())
                }

            })

        }
    }


    fun getUserByID(userID: String, getUserCallback: GetUserCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofitInstance.getUserByID(userID)

            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        getUserCallback.onGetUserSuccess(response.body() as User)
                    } else {
                        Log.d("==========>333331231231", "onResponse: ")
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    getUserCallback.onGetUserFailure(t.message.toString())
                }

            })
        }
    }

    fun createUser(user: User, getUserCallback: GetUserCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofitInstance.createUser(user)

            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        getUserCallback.onGetUserSuccess(response.body() as User)
                    } else {
                        Log.d("==========>333331231231", "onResponse: ")
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    getUserCallback.onGetUserFailure(t.message.toString())
                }

            })
        }
    }

    fun updateUser(id: String, user: User, getUserCallback: GetUserCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofitInstance.updateUser(id, user)
            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        getUserCallback.onGetUserSuccess(response.body() as User)
                    } else {
                        Log.d("==========>333331231231", "onResponse: ")
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    getUserCallback.onGetUserFailure(t.message.toString())
                }

            })
        }
    }

    fun deleteUser(id: String, getUserCallback: GetUserCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofitInstance.deleteUser(id)
            call.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (!response.isSuccessful) {
                        Log.d("==========>333331231231", "onResponse: ")
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    getUserCallback.onGetUserFailure(t.message.toString())
                }

            })
        }
    }

    fun searchUser(searchText:String,getListUserCallback: GetUserListCallback) {

        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            val call = retrofitInstance.searchUser(searchText)
            call!!.enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    if (response.isSuccessful) {
                        getListUserCallback.onGetListUserSuccess(response.body() as List<User>)
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    getListUserCallback.onGetListUserFailure(t.message.toString())
                }

            })

        }
    }


    interface GetUserListCallback {
        fun onGetListUserSuccess(data: List<User>)
        fun onGetListUserFailure(message: String)
    }

    interface GetUserCallback {
        fun onGetUserSuccess(data: User)
        fun onGetUserFailure(message: String)
    }
}