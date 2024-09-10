package com.seymagunduz.cities

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seymagunduz.cities.databinding.RecyclerRowBinding

class CityAdapter (val cityList : ArrayList<Cities>): RecyclerView.Adapter<CityAdapter.CityViewHolder> () {

    class CityViewHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CityViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.binding.textViewRecyclerView.text =" ${cityList[position].name}, ${cityList[position].country}"

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, PromotionalActivity::class.java)
            intent.putExtra("cities",cityList[position])
            holder.itemView.context.startActivity(intent)

        }
    }
}