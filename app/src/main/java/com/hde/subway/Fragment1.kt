package com.hde.subway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hde.subway.databinding.ActivityFragment1Binding

class Fragment1 : Fragment() {

    lateinit var binding: ActivityFragment1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ActivityFragment1Binding.inflate(inflater, container, false)

        return binding.root
    }
}