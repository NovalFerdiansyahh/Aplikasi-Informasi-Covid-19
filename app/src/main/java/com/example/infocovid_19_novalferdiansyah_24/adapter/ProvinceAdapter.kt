package com.example.infocovid_19_novalferdiansyah_24.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.infocovid_19_novalferdiansyah_24.R
import com.example.infocovid_19_novalferdiansyah_24.model.ProvinceResponse

class ProvinceAdapter(private var list: ArrayList<ProvinceResponse>):
    RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {
    inner class ProvinceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(province: ProvinceResponse){
            with(itemView){
                val name :TextView = findViewById(R.id.tvName)
                name.text = province.attributes.province
                val positif :TextView = findViewById(R.id.tvPositive)
                positif.text = province.attributes.positive.toString()
                val sembuh :TextView = findViewById(R.id.tvRecover)
                sembuh.text = province.attributes.recover.toString()
                val meninggal :TextView = findViewById(R.id.tvDeath)
                meninggal.text = province.attributes.death.toString()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}