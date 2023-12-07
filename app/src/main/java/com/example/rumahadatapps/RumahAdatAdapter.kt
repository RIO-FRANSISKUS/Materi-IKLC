package com.example.rumahadatapps

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RumahAdatAdapter(private val listRumahAdat: ArrayList<RumahAdat>): RecyclerView.Adapter<RumahAdatAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageRumahAdat: ImageView = itemView.findViewById(R.id.img_item_photo)
        val nameRumahAdat: TextView = itemView.findViewById(R.id.tv_item_name)
        val originRumahAdat: TextView = itemView.findViewById(R.id.tv_item_origin)
        val descriptionRumahAdat: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_rumah_adat, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, origin, description, photo) = listRumahAdat[position]
        holder.imageRumahAdat.setImageResource(photo)
        holder.nameRumahAdat.text = name
        holder.originRumahAdat.text = origin
        holder.descriptionRumahAdat.text = description

        holder.itemView.setOnClickListener {
            val intentRumahAdatDetail = Intent(holder.itemView.context, RumahAdatDetailActivity::class.java)
            intentRumahAdatDetail.putExtra("key_rumah_adat", listRumahAdat[holder.adapterPosition])
            holder.itemView.context.startActivity(intentRumahAdatDetail)
        }
    }

    override fun getItemCount(): Int = listRumahAdat.size
}