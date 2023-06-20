package com.example.week4_160420138.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.week4_160420138.R
import com.example.week4_160420138.databinding.StudentListLayoutBinding
import com.example.week4_160420138.model.Student
import com.example.week4_160420138.util.loadImage

class StudentListAdapter(private val studentList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener {
    class StudentViewHolder(var view:StudentListLayoutBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<StudentListLayoutBinding>(inflater, R.layout.student_list_layout, parent, false)

        return StudentViewHolder(v)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studentList[position]
        holder.view.listener = this
//        with(holder.view){
//            findViewById<TextView>(R.id.textID).text = studentList[position].id
//            findViewById<TextView>(R.id.textName).text = studentList[position].name
//
//            findViewById<Button>(R.id.btnDetail).setOnClickListener {
//                val action = StudentListFragmentDirections.actionStudentDetail(studentList[position].id.toString())
//                Navigation.findNavController(it).navigate(action)
//            }
//        }
//        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
//        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
//        imageView.loadImage(studentList[position].photoUrl, progressBar)
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}