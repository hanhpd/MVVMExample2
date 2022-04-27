package com.example.mvvmexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample2.Adapters.NicePlaceRecyclerAdapter
import com.example.mvvmexample2.ViewModels.NicePlaceViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.mvvmexample2.Models.NicePlace

class MainActivity : AppCompatActivity() {
    private var TAG:String = "MainActivity"
    private var mViewManager = LinearLayoutManager(this)
    private lateinit var mFab:FloatingActionButton
    private lateinit var mAdapter: NicePlaceRecyclerAdapter
    private lateinit var mProgressBar:ProgressBar
    private lateinit var mNicePlaceViewModel: NicePlaceViewModel
    private lateinit var mRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFab = findViewById(R.id.fab)
        mRecyclerView = findViewById(R.id.recycler_view)
        mProgressBar = findViewById(R.id.progress_bar)
        mNicePlaceViewModel = ViewModelProvider(this).get(NicePlaceViewModel::class.java)
        mFab.setOnClickListener{
            addData()
        }
        initialiseAdapter()
    }

    private fun initialiseAdapter(){
        mRecyclerView.layoutManager = mViewManager
        observeData()
    }
    fun observeData(){
        mNicePlaceViewModel.mNicePlaceList.observe(this,{
            mAdapter = NicePlaceRecyclerAdapter(mNicePlaceViewModel, it, this)
            mRecyclerView.adapter = mAdapter
        })
    }
    fun addData(){
        mNicePlaceViewModel.addNicePlace(NicePlace("Washington","https://i.imgur.com/ZcLLrkY.jpg"))
        mRecyclerView.adapter?.notifyDataSetChanged()
    }
}