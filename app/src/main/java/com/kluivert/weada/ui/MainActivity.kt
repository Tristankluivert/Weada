package com.kluivert.weada.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kluivert.weada.R
import com.kluivert.weada.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

          private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.showProgress.observe(this, Observer {

            if (it)
                progBar.visibility = VISIBLE
            else
                progBar.visibility = GONE

        })

    }

}