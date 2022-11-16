package com.hde.subway


import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hde.subway.databinding.ActivityExitBinding
import com.kakao.util.maps.helper.Utility
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import retrofit2.Retrofit
import java.util.*

class ExitActivity : AppCompatActivity() {

    val binding:ActivityExitBinding by lazy { ActivityExitBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var intent= getIntent()
        var station= intent.getStringExtra("station")

        binding.tb.setNavigationOnClickListener { finish() }

        var geocoder= Geocoder(this, Locale.KOREAN)

        var stationName = geocoder.getFromLocationName(station, 1)
        Log.i("tahyeok", stationName.toString())

        //val xcoord= stationName.lati



        var mapView = MapView(this)
        val mapViewContainer = binding.mapView
        mapViewContainer.addView(mapView)

        mapView.setZoomLevel(1, true)
        mapView.zoomIn(true)
        mapView.zoomOut(true)

    }

}