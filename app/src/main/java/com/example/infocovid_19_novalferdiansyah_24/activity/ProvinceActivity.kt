package com.example.infocovid_19_novalferdiansyah_24.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infocovid_19_novalferdiansyah_24.R
import com.example.infocovid_19_novalferdiansyah_24.adapter.ProvinceAdapter
import com.example.infocovid_19_novalferdiansyah_24.api.RetrofitClient
import com.example.infocovid_19_novalferdiansyah_24.model.ProvinceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)
        showProvince()

    }

    private fun showProvince() {
        val rvP :RecyclerView = findViewById(R.id.rvProvince)
        rvP.setHasFixedSize(true)
        rvP.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvince().enqueue(object :
            Callback<ArrayList<ProvinceResponse>>{
            override fun onResponse(
                call: Call<ArrayList<ProvinceResponse>>,
                response: Response<ArrayList<ProvinceResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                val rvP :RecyclerView = findViewById(R.id.rvProvince)
                rvP.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}