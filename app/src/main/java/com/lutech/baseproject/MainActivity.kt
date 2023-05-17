package com.lutech.baseproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lutech.baseproject.model.User
import com.lutech.baseproject.model.UserResponse
import com.lutech.baseproject.request_api.HandleAPI


class MainActivity : AppCompatActivity() {

    private lateinit var mArrayList: ArrayList<Integer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mArrayList = ArrayList()
//
//        mArrayList.add(Integer(R.drawable.ic_flag_germany))
//        mArrayList.add(Integer(R.drawable.ic_flag_france))
//        mArrayList.add(Integer(R.drawable.ic_flag_india))
//
//        val mCustomPagerAdapter = TestViewPagerAdapter(this,mArrayList)
//
//        viewPager.currentItem = 0
//        viewPager.adapter = mCustomPagerAdapter

        val mHandleAPI = HandleAPI()
        mHandleAPI.init()


//        mHandleAPI.getListUser(object : HandleAPI.GetUserListCallback {
//
//            override fun onGetListUserSuccess(data: List<User>) {
//                Log.d("===========>333333333", "onGetSuccess: " + data[0].id)
//            }
//
//            override fun onGetListUserFailure(message: String) {
//                Log.d("===========>333333333", "onGetFail" + message)
//            }
//        })

//        mHandleAPI.getUserByID("1701984",object : HandleAPI.GetUserCallback{
//            override fun onGetUserSuccess(data: User) {
//                Log.d("===========>333333333", "onGetSuccess2: " + data.name)
//            }
//
//            override fun onGetUserFailure(message: String) {
//                Log.d("===========>333333333", "onGetFail" + message)
//            }
//
//        }

        val user = User("", "Tran Ngoc Tri6", "female", "conmeomeocon11@gmaill.com", "active")

        mHandleAPI.searchUser("N", object : HandleAPI.GetUserListCallback {

            override fun onGetListUserSuccess(data: List<User>) {
                if (data.isEmpty())return
                for (i in data.indices){
                    Log.d("===========>333333333", "onGetSuccess2: "+ data[i].name)
                }
            }

            override fun onGetListUserFailure(message: String) {
                Log.d("===========>333333333", "onGetFail" + message)
            }

        })

    }


}