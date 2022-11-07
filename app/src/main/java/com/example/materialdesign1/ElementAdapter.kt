package com.example.materialdesign1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemLongClickListener
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.element_items_row.*
import kotlinx.android.synthetic.main.element_items_row.view.*

class ElementAdapter( var elementList: List<Element>) :
    RecyclerView.Adapter<ElementAdapter.ElementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.element_items_row, parent, false
        )

        return ElementViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val currentItem: Element = elementList[position]
        holder.bind(currentItem)

    }

    override fun getItemCount(): Int {
        return elementList.size
    }


    class ElementViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(info: Element) {
            itemView.titleCard.text = info.title
            itemView.subtitleCard.text=info.subtitleCard
            itemView.ImgCard.setImageResource(info.ImgCard)
            itemView.card.setOnClickListener {
                info.isFaf=!info.isFaf
                itemView.card.isChecked=info.isFaf
            }
            itemView.btnHideCard.setOnClickListener{
                itemView.ImgCard.alpha=1f
                itemView.ImgCard.animate().setDuration(3000).alpha(0f)

                itemView.dividerLin.alpha=1f
                itemView.dividerLin.animate().setDuration(3000).alpha(0f)

                itemView.lin1.alpha=1f
                itemView.lin1.animate().setDuration(3000).alpha(0f)
            }

            itemView.btnSHOWCard.setOnClickListener{
                itemView.ImgCard.alpha=0f
                itemView.ImgCard.animate().setDuration(5000).alpha(1f)

                itemView.dividerLin.alpha=0f
                itemView.dividerLin.animate().setDuration(5000).alpha(1f)

                itemView.lin1.alpha=0f
                itemView.lin1.animate().setDuration(5000).alpha(1f)

            }

        }

    }
}
