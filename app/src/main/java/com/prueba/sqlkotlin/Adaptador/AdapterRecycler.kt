package com.prueba.sqlkotlin.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prueba.sqlkotlin.Alumno
import com.prueba.sqlkotlin.ClickListener
import com.prueba.sqlkotlin.LongClickListener
import com.prueba.sqlkotlin.R

class AdapterRecycler(items:ArrayList<Alumno>, var listener: ClickListener, var longClickListener: LongClickListener):
RecyclerView.Adapter<AdapterRecycler.ViewHolder>(){



    var items:ArrayList<Alumno>? = null
    var itemsSeleccionados:ArrayList<Int>?= null

    var viewHolder: ViewHolder?= null

    init {
        this.items=items
        itemsSeleccionados= ArrayList()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val  vista = LayoutInflater.from(parent.context).inflate(R.layout.template,parent,false)
        viewHolder= ViewHolder(vista, listener, longClickListener)


        return viewHolder!!

    }

    override fun getItemCount():Int{

        return items?.count()!!

    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item =items?.get(position)

        holder.nombre?.text=item?.nombre
        holder.id?.text=item?.id



        if (itemsSeleccionados?.contains(position)!!){


        }
        else{


        }

    }


    class ViewHolder(vista:View,listener:ClickListener,lonClickListener:LongClickListener):RecyclerView.ViewHolder(vista){

        var vista = vista

        var nombre:TextView?=null
        var id:TextView?=null

        var listener:ClickListener?=null

        var longClickListener:LongClickListener?=null


        init {

            nombre=vista.findViewById(R.id.txtNombre)
            id=vista.findViewById(R.id.txtId)



        }



    }

}