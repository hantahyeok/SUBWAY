package com.hde.subway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toolbar
import com.hde.subway.databinding.ActivitySubwayComeBinding

class SubwayComeActivity : AppCompatActivity() {

    val binding:ActivitySubwayComeBinding by lazy { ActivitySubwayComeBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tb.setNavigationOnClickListener { finish() }

    }
}