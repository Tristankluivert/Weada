package com.kluivert.weada.ui

import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.kluivert.weada.R
import com.kluivert.weada.utils.GlideApp
import com.kluivert.weada.viewmodel.WeadaViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

import java.text.DecimalFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {


    private lateinit var viewModel : WeadaViewModel
    lateinit var mFusedLocationProviderClient: FusedLocationProviderClient

    val locationRequestId = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(WeadaViewModel::class.java)
     viewModel.currentWeada("ughelli")

        viewModel.showProgress.observe(this, Observer {
            if(it)
                progBar.visibility = VISIBLE
            else
                progBar.visibility = GONE
        })


            getLocation()


    }




    fun getLocation() {

        if (checkForLocationPermission()) {
            updateLocation()
        } else {
            askLocationPermission()
        }
    }

    fun updateLocation() {
        var locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 10000
        locationRequest.fastestInterval = 5000

        mFusedLocationProviderClient = FusedLocationProviderClient(this)

        mFusedLocationProviderClient.requestLocationUpdates(
            locationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }


    var mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(p0: LocationResult) {

            var location: Location = p0.lastLocation

            updateAddressUI(location)

        }
    }

    fun updateAddressUI(location: Location) {

        var geocoder: Geocoder
        var addressList = ArrayList<Address>()

        geocoder = Geocoder(applicationContext, Locale.getDefault())

        addressList = geocoder.getFromLocation(
            location.latitude,
            location.longitude,
            1
        ) as ArrayList<Address>

       welocation.text = addressList.get(0).subAdminArea


    }


    fun checkForLocationPermission(): Boolean {

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        )
            return true

        return false

    }


    fun askLocationPermission() {

        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            locationRequestId
        )

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == locationRequestId) {
            if (grantResults.isNotEmpty() &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED
            )
                getLocation()
            else
                Toast.makeText(this, "Please Allow the location permission", Toast.LENGTH_SHORT)
                    .show()
        }

    }



  }