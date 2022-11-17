package com.hde.subway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import android.widget.Toolbar
import com.google.gson.Gson
import com.hde.subway.databinding.ActivitySubwayComeBinding
import retrofit2.http.Url
import java.io.InputStreamReader
import java.net.URL

class SubwayComeActivity : AppCompatActivity() {

    val binding: ActivitySubwayComeBinding by lazy {
        ActivitySubwayComeBinding.inflate(
            layoutInflater
        )
    }

    var station: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tb.setNavigationOnClickListener { finish() }

        var intent = getIntent()
        station = intent.getStringExtra("station")

        binding.tv.text = "$station"

        stationNum()

    }

    fun stationNum() {
        var apiKey = "50794a697674616839374849626e77"
        var serverUrl = "http://openapi.seoul.go.kr:8088/" +
                apiKey + "/json/" + "SearchSTNBySubwayLineInfo/1/5//" +
                station

        var thread = Thread() {
            kotlin.run {
                var url = URL(serverUrl)
                var inputStream = url.openStream()
                var inputStreamReader = InputStreamReader(inputStream)

                var gson = Gson()
                var stationLineNum = gson.fromJson(inputStreamReader, StationLineNum::class.java)

                stationLineNum.SearchSTNBySubwayLineInfo.row.let {
                    it.forEach {
                        Log.i("TAG-result", it.LINE_NUM)
                    }
                }
//                    runOnUiThread {
//                        Toast.makeText(this@SubwayComeActivity, "${it.SearchSTNBySubwayLineInfo.row.LINE_NUM}", Toast.LENGTH_SHORT).show() }
//                }.start()

            }
        }.start()

    }
}