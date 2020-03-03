package com.prueba.sqlkotlin.Actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.prueba.sqlkotlin.*
import com.prueba.sqlkotlin.Adaptador.AdapterRecycler

class MainActivity : AppCompatActivity() {

    var lista:RecyclerView?=null
    var adaptador:AdapterRecycler?=null
    var layoutManager:RecyclerView.LayoutManager?=null

    var alumnos:ArrayList<Alumno>?=null

    var crud:AlumnoCrud?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab=findViewById<FloatingActionButton>(R.id.fab)
        lista=findViewById(R.id.lista)
        lista?.setHasFixedSize(true)

        layoutManager=LinearLayoutManager(this)
        lista?.layoutManager=layoutManager


        fab.setOnClickListener{

            startActivity(Intent(this,NuevoAlumno::class.java))

        }


        crud = AlumnoCrud(this)

        alumnos=crud?.getAlumnos()



        adaptador= AdapterRecycler(alumnos!!,object:ClickListener{

            override fun onClick(vista: View, index: Int) {

                val intent = Intent(applicationContext,DetalleAlumno::class.java)
                intent.putExtra("ID",alumnos!!.get(index).id)
                startActivity(intent)

            }

        },object:LongClickListener{
            override fun longClick(vista: View, index: Int) {

            }

        })

        lista?.adapter=adaptador
    }
}
