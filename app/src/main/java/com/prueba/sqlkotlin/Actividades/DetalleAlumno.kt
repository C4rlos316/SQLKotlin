package com.prueba.sqlkotlin.Actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.prueba.sqlkotlin.Alumno
import com.prueba.sqlkotlin.AlumnoCrud
import com.prueba.sqlkotlin.R
import kotlinx.android.synthetic.main.activity_detalle_alumno.*

class DetalleAlumno : AppCompatActivity() {

    var btnActualizar: Button?=null
    var btnEliminar: Button?=null



    var crud: AlumnoCrud?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_alumno)


        val id=findViewById<EditText>(R.id.EdtId)
        val name=findViewById<EditText>(R.id.EdtNombre)
        btnActualizar=findViewById(R.id.btnActualizar)
        btnEliminar=findViewById(R.id.btnEliminar)


        val index = intent.getStringExtra("ID")



        crud= AlumnoCrud(this)


        val alumno = crud?.getAlumno(index)


        id.setText(alumno!!.id,TextView.BufferType.EDITABLE)
        name.setText(alumno!!.nombre,TextView.BufferType.EDITABLE)



        btnActualizar?.setOnClickListener{

            crud?.updateAlumno(Alumno(id.text.toString(),name.text.toString()))
            startActivity(Intent(this,MainActivity::class.java))

        }

        btnEliminar?.setOnClickListener{

            crud?.deleteAlumno(Alumno(id.text.toString(),name.text.toString()))
            startActivity(Intent(this,MainActivity::class.java))

        }

    }
}
