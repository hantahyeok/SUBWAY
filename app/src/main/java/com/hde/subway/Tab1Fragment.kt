package com.hde.subway

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Tab1Fragment(list: String) : Fragment() {

    var station : String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        stationCome() //지하철 시간
        var intent = Intent.getIntent(station)

        return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    fun stationCome() {
        var apiKey = ""
    }

}