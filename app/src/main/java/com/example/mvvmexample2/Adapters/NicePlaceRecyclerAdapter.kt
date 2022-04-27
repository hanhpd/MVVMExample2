package com.example.mvvmexample2.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmexample2.Models.NicePlace
import com.example.mvvmexample2.ViewModels.NicePlaceViewModel
import com.example.mvvmexample2.R
import de.hdodenhof.circleimageview.CircleImageView

class NicePlaceRecyclerAdapter(val viewModel: NicePlaceViewModel, val arrayList: ArrayList<NicePlace>, val context: Context) :
    RecyclerView.Adapter<NicePlaceRecyclerAdapter.NicePlaceViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NicePlaceRecyclerAdapter.NicePlaceViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return NicePlaceViewHolder(root)
    }

    override fun onBindViewHolder(holder: NicePlaceViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
    inner class NicePlaceViewHolder(private  val binding: View):RecyclerView.ViewHolder(binding){
        fun bind(nicePlace: NicePlace){
            binding.findViewById<TextView>(R.id.image_name).text = nicePlace.title
            val defaultOptions = RequestOptions().error(R.drawable.ic_launcher_background)
            Glide.with(context).setDefaultRequestOptions(defaultOptions).load(nicePlace.imageUrl).into(binding.findViewById<CircleImageView>(R.id.image))
        }
    }
}