package com.hde.subway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hde.subway.databinding.Fragment1Binding
import com.hde.subway.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    var mBinding: Fragment2Binding? = null
    val binding get() = mBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = Fragment2Binding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}