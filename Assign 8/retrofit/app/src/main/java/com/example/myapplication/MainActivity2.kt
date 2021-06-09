package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.Adapter
import com.example.myapplication.Adapter.UserAdapter
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.api.dto.ReqresData
import com.example.myapplication.api.dto.User
import com.example.myapplication.api.dto.UserDetailed
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    private var id = "1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        id = intent.getStringExtra("id").toString()
        getUsersInfo()
    }
    private fun getUsersInfo() {
        RetrofitClient.reqResApi.getUserInfo(id).enqueue(object : Callback<UserDetailed> {

            override fun onResponse(call: Call<UserDetailed>, response: Response<UserDetailed>) {
                    recyclerVIew2.layoutManager = LinearLayoutManager(this@MainActivity2)
                    recyclerVIew2.adapter = response.body()!!.data?.let { Adapter(listOf(it)) }
            }

            override fun onFailure(call: Call<UserDetailed>, t: Throwable) {
                Log.d("mushni", t.toString())
            }

        })
    }
}
