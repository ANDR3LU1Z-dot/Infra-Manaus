package com.andre.inframanaus.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andre.inframanaus.interfaces.CardOnClickListener
import com.andre.inframanaus.R
import com.andre.inframanaus.body.*
import com.andre.inframanaus.databinding.ItemPostagemBinding

class DenunciasAdapter(
    private val cards: List<MockupDenuncias>, private val clicklistener:
    CardOnClickListener
) : RecyclerView.Adapter<DenunciasAdapter.ListItemViewHolder>() {




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

    class ListItemViewHolder(
        private val binding: ItemPostagemBinding,
        private val clickListener: CardOnClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        var root = binding.root


        fun bindCard(card: MockupDenuncias) {

            val nomeUsuario = binding.nomeUsuario
//            val status_img = binding.statusBuracoIndicador
            val tipo_risco = binding.tvRisco

            val tipo_denuncia = binding.tipoDenuncia

            val imgDenuncia = binding.ivPostagem

//            val desc = binding.descricao

//            desc.text =  card.

            imgDenuncia.setImageResource(card.imgDenuncia)

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
//                clickListener.onClick(card)
            }
        }
    }
}


