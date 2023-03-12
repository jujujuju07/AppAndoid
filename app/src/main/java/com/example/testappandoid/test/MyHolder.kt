package com.example.testappandoid.test

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testappandoid.databinding.Model1Binding
import com.example.testappandoid.databinding.ModelBinding
import com.example.testappandoid.model.Donner
import com.example.testappandoid.model.Structure
import com.example.testappandoid.model_1.MyAdapter1
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle.parent


class MyHolder (private val binding: ModelBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var recyclerViewNews : RecyclerView

        fun bind(DonnerA: Structure) {
        recyclerViewNews = binding.rv1
        val newsAdapter = MyAdapter1(DonnerA)
        recyclerViewNews.adapter = newsAdapter
        val layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewNews.layoutManager = layoutManager



        Log.println(Log.INFO,"Myholder",DonnerA.Donner.size.toString())

    }

}