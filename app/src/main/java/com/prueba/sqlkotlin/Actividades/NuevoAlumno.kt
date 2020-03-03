package com.prueba.sqlkotlin.Actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.prueba.sqlkotlin.Alumno
import com.prueba.sqlkotlin.AlumnoCrud
import com.prueba.sqlkotlin.R

class NuevoAlumno : AppCompatActivity() {


    var id:EditText?=null
    var name:EditText?=null
    var btnNuevo:Button?=null


    var crud:AlumnoCrud?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_alumno)


        id=findViewById(R.id.EdtId)
        name=findViewById(R.id.EdtNombre)
        btnNuevo=findViewById(R.id.button)


        crud= AlumnoCrud(this)

        btnNuevo?.setOnClickListener{

            crud?.newAlumno(Alumno(id?.text.toString(),name?.text.toString()))
            startActivity(Intent(this,MainActivity::class.java))

        }

    }
}
