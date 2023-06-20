package com.example.week4_160420138.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week4_160420138.R
import com.example.week4_160420138.databinding.FragmentStudentDetailBinding
import com.example.week4_160420138.util.loadImage
import com.example.week4_160420138.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment(), ButtonCheck {

    private lateinit var viewModel:DetailViewModel
    private lateinit var dataBinding:FragmentStudentDetailBinding
    private var people_id = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_student_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.listener = this
        if(arguments != null){
            people_id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
        }
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(people_id)
        observeViewModel(view)
    }

    private fun observeViewModel(view:View) {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
            Log.d("check", it.toString())
//            var student = it
//            val progressBar = view.findViewById<ProgressBar>(R.id.progressBar2)
//            view.findViewById<ImageView>(R.id.imageView2).loadImage(it.photoUrl, progressBar)
//            view.findViewById<EditText>(R.id.txtID)?.setText(it.id)
//            view.findViewById<EditText>(R.id.txtName)?.setText(it.name)
//            view.findViewById<EditText>(R.id.txtBod)?.setText(it.dob.toString())
//            view.findViewById<EditText>(R.id.txtPhone)?.setText(it.phone)
//
//            val btnNotif = view.findViewById<Button>(R.id.btnNotif)
//            btnNotif?.setOnClickListener {
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        Log.d("Messages", "five seconds")
//                        MainActivity.showNotification(student.name.toString(),
//                            "A new notification created",
//                            R.drawable.ic_baseline_error_24)
//                    }
//            }

        })
    }

    override fun onButtonCheckClick(v: View) {
        Log.d("check1", dataBinding.student.toString())
    }
}