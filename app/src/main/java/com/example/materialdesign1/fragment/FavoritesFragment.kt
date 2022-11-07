package com.example.materialdesign1.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.customview.widget.ViewDragHelper
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.materialdesign1.Element
import com.example.materialdesign1.ElementAdapter
import com.example.materialdesign1.R
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.element_items_row.*
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : Fragment() {
    var counterFaf = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvElement.layoutManager = GridLayoutManager(context,1)
        rvElement.setHasFixedSize(true)

        val elementList: ArrayList<Element> = arrayListOf()
        val elementAdapter=ElementAdapter(elementList)


        elementList.add(Element("Strawberries","Winter Products",R.drawable.strawberries,false))
        elementList.add(Element("Pomegranate","Summer Products",R.drawable.pomegranate,false))
        elementList.add(Element("Grape","Summer Products",R.drawable.grape,false))
        elementList.add(Element("Figs","Fall Products",R.drawable.figs,false))
        elementList.add(Element("Peache","Summer Products",R.drawable.peache,false))
        elementList.add(Element("Lemon","Winter Products",R.drawable.lemon,false))
        elementList.add(Element("Watermelon","Summer Products",R.drawable.watermelon,false))

        rvElement.adapter=elementAdapter
//        btnCounter.setOnClickListener {
//            for (i in 0 until elementAdapter.elementList.size) {
//                if (!elementAdapter.elementList[i].isFaf) {
//                    counterFaf++
//                }
//            }
//            Log.d("FragmentSameer", counterFaf.toString())
//        }
    }
}