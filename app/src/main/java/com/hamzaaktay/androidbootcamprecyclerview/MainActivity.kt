package com.hamzaaktay.androidbootcamprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamzaaktay.androidbootcamprecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), KopeklerAdapter.SecilenKopekLister {

    var kopekTur : String? = null
    private var secilenKopek : KopekModel? = null

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


        //Adapter Baglama
        val kopeklerAdapter = KopeklerAdapter(kopeklerList,this)
        binding.kopeklerRecyclerView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        binding.kopeklerRecyclerView.adapter = kopeklerAdapter
        binding.kopeklerRecyclerView.setHasFixedSize(true)

        //OnItemClick

        kopeklerAdapter.onItemClick =::secilenKopekOnClick

        //RecyclerView'a veri eklemek
        binding.addFAB.setOnClickListener {
            kopeklerList.add(KopekModel(R.drawable.pomsky,"Pomsky"))
            kopeklerList.add(KopekModel(R.drawable.pug,"Pug"))
            kopeklerAdapter.kopeklerListGuncelle(kopeklerList)
        }

        binding.deleteFAB.setOnClickListener {
            val silinecekIndex = kopeklerList.indexOf(secilenKopek)
            kopeklerList.removeAt(silinecekIndex)
            kopeklerAdapter.kopeklerListGuncelle(kopeklerList)
        }
    }

    fun secilenKopekOnClick (gelenSecilenKopek : KopekModel) {

        Log.e("Secilen Kopek onClick: ", gelenSecilenKopek.kopekTur)

        secilenKopek = gelenSecilenKopek
    }

    //Interface
    override fun secilenKopek(gelenSecilenKopek: KopekModel) {
        kopekTur = gelenSecilenKopek.kopekTur

        secilenKopek = gelenSecilenKopek
        Log.e("Secilen Kopek Interface:", gelenSecilenKopek.kopekTur)
    }
}