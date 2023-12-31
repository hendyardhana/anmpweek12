package com.example.week4_160420138.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.week4_160420138.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel(application: Application): AndroidViewModel(application)  {
    val studentLD = MutableLiveData<Student>()
    private var queue: RequestQueue? = null
    val TAG = "detailTag"

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
    fun fetch(people_id: String) {

//        val student1 = Student("16055","Nonie","1998/03/28","5718444778",
//            "https://img.okezone.com/content/2017/02/21/298/1623840/selain-roti-tawar-ini-loh-4-jenis-roti-yang-paling-sering-dikonsumsi-masyarakat-indonesia-u3Mihn3ZBk.jpg")

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://jitusolution.com/student.php?id=$people_id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Student>() {}.type
                val result = Gson().fromJson<Student>(it, sType)
                studentLD.value = result

                Log.d("showdetail", result.toString())

            },
            {
                Log.d("showdetail", it.toString())

            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

}