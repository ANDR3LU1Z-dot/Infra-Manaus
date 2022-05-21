package com.andre.inframanaus.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andre.inframanaus.CardOnClickListener
import com.andre.inframanaus.R
import com.andre.inframanaus.body.BodyCardPostagens
import com.andre.inframanaus.body.cardPostagensList
import com.andre.inframanaus.databinding.CardPostagemBinding

class CardPostagensAdapter(private val cards: List<BodyCardPostagens>, private val clicklistener: CardOnClickListener): RecyclerView.Adapter<CardPostagensAdapter.ListItemViewHolder>() {


    class ListItemViewHolder(
        private val binding: CardPostagemBinding,
        private val clickListener: CardOnClickListener
    ): RecyclerView.ViewHolder(binding.root){
        var root = binding.root


        fun bindCard(card: BodyCardPostagens){
//            binding.txtRisco.text = card.risco
//            binding.txtNomeUsuario.text = card.nome
            val txt_risco = binding.txtRisco
            val nomeUsuario = binding.txtNomeUsuario
            val status_img = binding.statusBuracoIndicador

//            txt_risco.text = card.risco
            nomeUsuario.text = card.nome


            cardPostagensList.forEach{
                if(card.tipoRisco == "A"){
                    status_img.background = itemView.resources.getDrawable(R.drawable.shape_alto)
                    txt_risco.text = "Alto"
                } else if(card.tipoRisco == "M"){
                    status_img.background = itemView.resources.getDrawable(R.drawable.shape_medio)
                    txt_risco.text = "Medio"
                } else if(card.tipoRisco == "B"){
                    status_img.background = itemView.resources.getDrawable(R.drawable.shape_baixo)
                    txt_risco.text = "Baixo"
                }
            }

            binding.idCardPostagem.setOnClickListener{
                clickListener.onClick(card)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(CardPostagemBinding.inflate(LayoutInflater.from(parent.context), parent, false), clicklistener)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bindCard(cards[position])
    }

    override fun getItemCount(): Int = cards.size
}


