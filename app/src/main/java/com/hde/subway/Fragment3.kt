package com.hde.subway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hde.subway.databinding.ActivityFragment1Binding
import com.hde.subway.databinding.ActivityFragment3Binding

class Fragment3 : Fragment() {

    var mBinding: ActivityFragment3Binding? = null
    val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = ActivityFragment3Binding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}