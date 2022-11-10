package com.hde.subway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hde.subway.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    val binding: ActivityEditBinding by lazy { ActivityEditBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



    }
}