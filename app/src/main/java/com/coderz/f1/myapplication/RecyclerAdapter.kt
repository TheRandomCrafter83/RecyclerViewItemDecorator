package com.coderz.f1.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coderz.f1.myapplication.databinding.RecItemBinding

class RecyclerAdapter: ListAdapter<String,RecyclerAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding:RecItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {


            binding.apply {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    val ss = getItem(position)
                    root.setOnClickListener {
                        //do something here on click
                    }
                }
            }
        }
        fun bind(string:String){
            //val s :ShadowDrawable = ShadowDrawable()
            binding.apply {
                textview.text = string
                //root.background = s
            }
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

}