package com.sophos.myappr.UI

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.provider.SettingsSlicesContract.KEY_LOCATION
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import com.sophos.myappr.MainActivityViewModel
import com.sophos.myappr.Menu
import com.sophos.myappr.R
import com.sophos.myappr.R.layout.activity_maps
import java.util.jar.Manifest

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->

        val TAG2 = "MapsFragment"

        var punto= LatLng(4.679, -74.044)
        //googleMap.addMarker(MarkerOptions().position(punto).title("Bogota"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(punto))
        googleMap.setMinZoomPreference(10.0f)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        // Add a marker in Sydney and move the camera
        var latitud: Double
        var longitud: Double
        var nombre: String
        val count: Int = 7
        //
        var map: GoogleMap? = null
        var cameraPosition: CameraPosition? = null

        // The entry point to the Places API.
        lateinit var placesClient: PlacesClient

        // The entry point to the Fused Location Provider.
        lateinit var fusedLocationProviderClient: FusedLocationProviderClient

        // A default location (Sydney, Australia) and default zoom to use when location permission is
        // not granted.
        //val defaultLocation = LatLng(-33.8523341, 151.2106085)
        var locationPermissionGranted = false

        // The geographical location where the device is currently located. That is, the last-known
        // location retrieved by the Fused Location Provider.
        var lastKnownLocation: Location? = null
        var likelyPlaceNames: Array<String?> = arrayOfNulls(0)
        var likelyPlaceAddresses: Array<String?> = arrayOfNulls(0)
        var likelyPlaceAttributions: Array<List<*>?> = arrayOfNulls(0)
        var likelyPlaceLatLngs: Array<LatLng?> = arrayOfNulls(0)
        //
        // Retrieve location and camera position from saved instance state.
        //Places.initialize(viewModel, google_maps_key)
        //placesClient = Places.createClient(viewModel)
        // Construct a FusedLocationProviderClient.
        //fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)


        //
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(punto))
        googleMap.setMinZoomPreference(12.0f)

        viewModel.getPosts()
        viewModel.myResponseList.observe(this, Observer {
            if (it != null) {
                for (city in it) {
                    for (i in 0..count) {
                        Log.d(TAG2, city.Items[i].IdOficina.toString())
                        Log.d(TAG2, city.Items[i].Nombre.toString())
                        latitud = city.Items[i].Latitud.toDouble()
                        longitud = city.Items[i].Longitud.toDouble()
                        nombre = city.Items[i].Nombre.toString()
                        punto= LatLng(latitud, longitud)
                        googleMap.addMarker(MarkerOptions().position(punto).title(nombre))
                    }
                }

            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        //
        // Construct a PlacesClient



        //
    }


}