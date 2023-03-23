package com.example.week4_160420138.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week4_160420138.model.Student

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch() {
        val student1 = Student("16055","Nonie","1998/03/28","5718444778",
            "https://img.okezone.com/content/2017/02/21/298/1623840/selain-roti-tawar-ini-loh-4-jenis-roti-yang-paling-sering-dikonsumsi-masyarakat-indonesia-u3Mihn3ZBk.jpg")
        studentLD.value = student1
    }

}