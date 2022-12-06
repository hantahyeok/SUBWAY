package com.hde.subway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import android.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import com.hde.subway.databinding.ActivitySubwayComeBinding
import retrofit2.http.Url
import java.io.InputStreamReader
import java.net.URL

class SubwayComeActivity : AppCompatActivity() {

    val binding: ActivitySubwayComeBinding by lazy { ActivitySubwayComeBinding.inflate(layoutInflater) }

    lateinit var stationLineNum : StationLineNum
    var list:MutableList<String> = mutableListOf()
    var station: String? = ""
    lateinit var adapter: MyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tb.setNavigationOnClickListener { finish() }

        adapter= MyPagerAdapter(this, list)
        binding.pager.adapter=adapter

        var intent = getIntent()
        station = intent.getStringExtra("station")

        binding.tv.text = station

        stationNum() //지하철 호선 알아내는

    }

    fun stationNum() {
        var apiKey = "50794a697674616839374849626e77"
        var serverUrl = "http://openapi.seoul.go.kr:8088/" +
                apiKey + "/json/" + "SearchSTNBySubwayLineInfo/1/5/%20/" + station

        Thread {
            kotlin.run {
                var url = URL(serverUrl)
                var inputStream = url.openStream()
                var inputStreamReader = InputStreamReader(inputStream)

                var gson = Gson()
                stationLineNum= gson.fromJson(inputStreamReader, StationLineNum::class.java)

                stationLineNum.SearchSTNBySubwayLineInfo.row.forEach {
                    if( station.equals(it.STATION_NM) ) {
                        list.add(it.LINE_NUM)
                    }
                }


                runOnUiThread {
                    binding.pager.adapter= MyPagerAdapter(this, list)
                    var mediator:TabLayoutMediator= TabLayoutMediator(binding.tabbar,binding.pager,TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                        tab.text = list[position]
                    })

                    mediator.attach()
                }

            }
        }.start()

    }
}
