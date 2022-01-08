package com.sophos.myappr

import android.Manifest
import android.content.pm.PackageManager
import android.location.LocationRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.PackageManagerCompat.LOG_TAG
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sophos.myappr.databinding.ActivityMapsBinding
import java.net.URI.create

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private val TAG2 = "MapsActivity"

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val TAG3 = "MapsActivity"
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        var latitud: Double
        var longitud: Double
        var nombre: String
        var punto= LatLng(4.679, -74.044)

        mMap.moveCamera(CameraUpdateFactory.newLatLng(punto))
        mMap.setMinZoomPreference(6.0f)

        viewModel.getPosts()
        viewModel.myResponseList.observe(this, Observer {
            if (it != null) {
                for (city in it) {

                    for (i in 0..7) {
                        Log.d(TAG2, city.Items[i].IdOficina.toString())
                        Log.d(TAG2, city.Items[i].Ciudad.toString())
                        latitud = city.Items[i].Latitud.toDouble()
                        longitud = city.Items[i].Longitud.toDouble()
                        nombre = city.Items[i].Nombre.toString()

                        punto= LatLng(latitud, longitud)
                        mMap.addMarker(MarkerOptions().position(punto).title(nombre))

                    }
                }

            }
        })
    }
}