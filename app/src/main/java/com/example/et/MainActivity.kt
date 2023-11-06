package com.example.et

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val character = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = Adapter()

        character.layoutManager = LinearLayoutManager(this)
        character.adapter = adapter

        ApiConfig.getService().getCharacter().enqueue(object : Callback<Responses> {
            override fun onResponse(call: Call<Responses>, response: Response<Responses>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val data = responseBody?.results
                    adapter.submitList(data)
                }
            }

            override fun onFailure(call: Call<Responses>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
