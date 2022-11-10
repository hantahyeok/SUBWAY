package com.hde.subway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hde.subway.databinding.Fragment3Binding

class Fragment3 : Fragment() {

    val binding: Fragment3Binding by lazy { Fragment3Binding.inflate(layoutInflater)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener { clickFab() }
    }

    fun clickFab(){
        activity?.startActivity(Intent(activity, EditActivity::class.java))
    }

}