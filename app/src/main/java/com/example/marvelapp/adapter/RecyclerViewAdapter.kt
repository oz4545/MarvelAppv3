package com.example.marvelapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.R
import com.example.marvelapp.model.Superheroe

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var superheroes: MutableList<Superheroe> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_superheroe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superheroe = superheroes[position]
        holder.bind(superheroe)
    }

    override fun getItemCount(): Int = superheroes.size

    fun setData(superheroes: MutableList<Superheroe>) {
        this.superheroes = superheroes
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(superheroe: Superheroe) {
            itemView.findViewById<TextView>(R.id.tvSuperhero).text = superheroe.nombre
            itemView.findViewById<TextView>(R.id.tvRealName).text = superheroe.nombreReal
            itemView.findViewById<TextView>(R.id.tvPublisher).text = superheroe.publisher
            Glide.with(itemView.context)
                .load(superheroe.foto)
                .into(itemView.findViewById<ImageView>(R.id.ivAvatar))
        }
    }
}
