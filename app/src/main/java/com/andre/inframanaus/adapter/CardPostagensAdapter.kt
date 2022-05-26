package com.andre.inframanaus.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andre.inframanaus.interfaces.CardOnClickListener
import com.andre.inframanaus.R
import com.andre.inframanaus.body.BodyCardPostagens
import com.andre.inframanaus.body.cardPostagensList
import com.andre.inframanaus.databinding.CardPostagemBinding
import com.andre.inframanaus.databinding.ItemPostagemBinding

class CardPostagensAdapter(
    private val cards: List<BodyCardPostagens>, private val clicklistener:
    CardOnClickListener
) : RecyclerView.Adapter<CardPostagensAdapter.ListItemViewHolder>() {


    class ListItemViewHolder(
        private val binding: ItemPostagemBinding,
        private val clickListener: CardOnClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        var root = binding.root


        fun bindCard(card: BodyCardPostagens) {
//            binding.txtRisco.text = card.risco
//            binding.txtNomeUsuario.text = card.nome
//            val txt_risco = binding.tvRisco
            val nomeUsuario = binding.nomeUsuario
//            val status_img = binding.statusBuracoIndicador
            val tipo_risco = binding.tvRisco

            val tipo_denuncia = binding.tipoDenuncia

            val imgDenuncia = binding.ivPostagem

//            imgDenuncia.setImageResource(card.imgDenuncia)

            tipo_denuncia.text = card.tipo_denuncia

//            txt_risco.text = card.risco
            nomeUsuario.text = card.username


            cardPostagensList.forEach {
                if (card.tipoRisco == "A") {
                    tipo_risco.background = itemView.resources.getDrawable(R.drawable.shape_alto)
                    tipo_risco.text = "Alto"
                } else if (card.tipoRisco == "M") {
                    tipo_risco.background = itemView.resources.getDrawable(R.drawable.shape_medio)
                    tipo_risco.text = "Medio"
                } else if (card.tipoRisco == "B") {
                    tipo_risco.background = itemView.resources.getDrawable(R.drawable.shape_baixo)
                    tipo_risco.text = "Baixo"
                }
            }

            binding.idCardPostagem.setOnClickListener {
                clickListener.onClick(card)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(
            ItemPostagemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), clicklistener
        )
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bindCard(cards[position])
    }

    override fun getItemCount(): Int = cards.size
}


