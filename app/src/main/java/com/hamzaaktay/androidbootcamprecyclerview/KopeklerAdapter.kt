package com.hamzaaktay.androidbootcamprecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamzaaktay.androidbootcamprecyclerview.databinding.KopekCardTasarimBinding

class KopeklerAdapter(private var kopeklerList: ArrayList<KopekModel>, private val secilenKopekLister: SecilenKopekLister): RecyclerView.Adapter<KopeklerAdapter.KopekCardTasarim>() {

    var onItemClick : (KopekModel) -> Unit = {}

    class KopekCardTasarim (val KopekCardTasarimBinding: KopekCardTasarimBinding): RecyclerView.ViewHolder(KopekCardTasarimBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup,  viewType: Int ):KopekCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val KopekCardTasarimBinding = KopekCardTasarimBinding.inflate(layoutInflater,parent,false)
        return KopekCardTasarim(KopekCardTasarimBinding)

    }

    override fun onBindViewHolder(holder:KopekCardTasarim, position: Int) {

        val kopek = kopeklerList[position]

        holder.KopekCardTasarimBinding.kopekImageView.setImageResource(kopek.kopekGorsel)
        holder.KopekCardTasarimBinding.kopekTurTextView.text = kopek.kopekTur

        /*holder.KopekCardTasarimBinding.kopekImageView.setOnClickListener {

            //secilenKopekLister.secilenKopek(kopek)
        }*/

        /*holder.KopekCardTasarimBinding.root.setOnClickListener {
            secilenKopekLister.secilenKopek(kopek)

        }*/

        holder.KopekCardTasarimBinding.root.setOnClickListener {
            onItemClick(kopek)
        }

        /*holder.KopekCardTasarimBinding.kopekImageView.setOnLongClickListener {
            secilenKopekLister.secilenKopek(kopek)
            true
        }*/

    }

    override fun getItemCount(): Int = kopeklerList.size

    fun kopeklerListGuncelle (guncelList: ArrayList<KopekModel>) {
        kopeklerList = guncelList
        notifyDataSetChanged()
    }

    interface SecilenKopekLister {
        fun secilenKopek(kopek: KopekModel)
    }

}

