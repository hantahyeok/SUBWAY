package com.hde.subway


import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hde.subway.databinding.ActivityExitBinding
import com.kakao.util.maps.helper.Utility
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class ExitActivity : AppCompatActivity() {

    val binding:ActivityExitBinding by lazy { ActivityExitBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 키 해시값을 얻어오는 기능을 가진 클래스에게 디버그용 키해시값 얻어오기
        val keyHash = Utility.getKeyHash(this)
        Log.d("cccc", keyHash)

        binding.tb.setNavigationOnClickListener { finish() }

        var mapView = MapView(this)
        val mapViewContainer = binding.mapView
        mapViewContainer.addView(mapView)

        // 중심점 변경

        // 중심점 변경
        //mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true)

        mapView.setZoomLevel(1, true)
        mapView.zoomIn(true)
        mapView.zoomOut(true)

    }


}