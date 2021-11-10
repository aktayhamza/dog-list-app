package com.hamzaaktay.androidbootcamprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamzaaktay.androidbootcamprecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kopeklerList = arrayListOf(

            KopekModel(R.drawable.avustralyacoban, "Avustralya Coban"),
            KopekModel(R.drawable.danua, "Danua"),
            KopekModel(R.drawable.golden, "Golden"),
            KopekModel(R.drawable.husky, "Husky"),
            KopekModel(R.drawable.jackrussellterrier, "Jackrusselterrier"),
            KopekModel(R.drawable.leonberger, "Leonberger")
        )

        val kopeklerAdapter = KopeklerAdapter(kopeklerList)
        binding.kopeklerRecyclerView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        binding.kopeklerRecyclerView.adapter = kopeklerAdapter
        binding.kopeklerRecyclerView.setHasFixedSize(true)
    }
}