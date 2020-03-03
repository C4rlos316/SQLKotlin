package com.prueba.sqlkotlin

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.prueba.sqlkotlin.Interace.HttpResponse

class Network(var activity:AppCompatActivity) {

    init {

    }


    fun hayRed():Boolean{


        val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo


        return networkInfo != null && networkInfo.isConnected

    }


    fun httpRequest(context: Context,url:String,httpResponse: HttpResponse){


        if (hayRed()){


            val queue = Volley.newRequestQueue(context)

            val solicitud = StringRequest(Request.Method.GET,url,Response.Listener<String> {

                response ->

                httpResponse.httpResponseSuccess(response)


            },Response.ErrorListener {

                error ->



            })

            queue.add(solicitud)

        }else   {


        }

    }

    fun httpPOSTRequest(context: Context,url: String,httpResponse: HttpResponse){

        if (hayRed()){


            val queue = Volley.newRequestQueue(context)

            val solicitud = StringRequest(Request.Method.POST,url,Response.Listener<String> {

                    response ->

                httpResponse.httpResponseSuccess(response)


            },Response.ErrorListener {

                    error ->



            })

            queue.add(solicitud)

        }else   {


        }


    }


}