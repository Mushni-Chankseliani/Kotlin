package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Adapter.UserAdapter
import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.api.dto.ReqresData
import com.example.myapplication.api.dto.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitClient.reqResApi.getUsers(2)
            .enqueue(object : Callback<ReqresData<List<User>>> {
                override fun onResponse(
                    call: Call<ReqresData<List<User>>>,
                    response: Response<ReqresData<List<User>>>
                ) {
                    Log.d("mmmm", response.body().toString())
                    if (response.isSuccessful && response.body() != null) {
                        response.body()!!.data?.forEach { i -> Log.d("Users", i.toString()) }
                    }

                    recyclerVIew.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerVIew.adapter = response.body()!!.data?.let { UserAdapter(it) }

                }

                override fun onFailure(call: Call<ReqresData<List<User>>>, t: Throwable) {
                    Log.d("failure", t.toString())
                }

            })

    }
}
