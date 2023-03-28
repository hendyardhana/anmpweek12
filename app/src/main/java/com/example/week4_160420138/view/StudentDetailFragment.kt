package com.example.week4_160420138.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week4_160420138.R
import com.example.week4_160420138.model.Student
import com.example.week4_160420138.viewmodel.DetailViewModel
import com.example.week4_160420138.viewmodel.ListViewModel
import com.squareup.picasso.Picasso

class StudentDetailFragment : Fragment() {

    private lateinit var viewModel:DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            Picasso.get().load(it.photoUrl).into(view?.findViewById<ImageView>(R.id.imageView2))
            view?.findViewById<EditText>(R.id.txtID)?.setText(it.id)
            view?.findViewById<EditText>(R.id.txtName)?.setText(it.name)
            view?.findViewById<EditText>(R.id.txtBod)?.setText(it.dob.toString())
            view?.findViewById<EditText>(R.id.txtPhone)?.setText(it.phone)
        })
    }
}