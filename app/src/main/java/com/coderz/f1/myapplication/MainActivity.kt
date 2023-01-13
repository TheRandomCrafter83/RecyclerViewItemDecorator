package com.coderz.f1.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coderz.f1.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val s:ShadowDrawable = ShadowDrawable()
        //binding.card.foreground = s
        val adapter = RecyclerAdapter()
        val list:ArrayList<String> = ArrayList()
        for(i:Int in 1..100){
            list.add("Item $i")
        }
        adapter.submitList(list)
        binding.recycler.adapter = adapter
        binding.recycler.setHasFixedSize(true)
        binding.recycler.addItemDecoration(ShadowDividerDecoration(4,16, Color.LTGRAY,12f))
    }
}