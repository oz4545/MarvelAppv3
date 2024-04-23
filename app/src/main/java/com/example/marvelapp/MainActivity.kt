package com.example.marvelapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.adapter.RecyclerViewAdapter
import com.example.marvelapp.data.DataSource
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.model.Superheroe

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var verticalRecyclerView: RecyclerView
    private val horizontalAdapter: RecyclerViewAdapter = RecyclerViewAdapter()
    private val verticalAdapter: RecyclerViewAdapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerViews()
        setupClickListeners()
    }

    private fun setupRecyclerViews() {
        horizontalRecyclerView = binding.rvHorizontal
        verticalRecyclerView = binding.rvVertical

        horizontalRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = horizontalAdapter
        }

        verticalRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = verticalAdapter
        }

        val superheroes = DataSource().getSuperHeroes()
        horizontalAdapter.setData(superheroes)
        verticalAdapter.setData(superheroes)
    }

    private fun setupClickListeners() {
        binding.btnHorizontal.setOnClickListener {
            binding.rvHorizontal.visibility = android.view.View.VISIBLE
            binding.rvVertical.visibility = android.view.View.GONE
        }

        binding.btnVertical.setOnClickListener {
            binding.rvVertical.visibility = android.view.View.VISIBLE
            binding.rvHorizontal.visibility = android.view.View.GONE
        }
    }
}