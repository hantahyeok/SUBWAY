package com.hde.subway

import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.hde.subway.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    val binding: ActivityEditBinding by lazy { ActivityEditBinding.inflate(layoutInflater) }

    var iv : String? = ""
    var text : String? = ""
    //var spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tb.setNavigationOnClickListener { finish() }

        binding.btn.setOnClickListener { clickComplete() }

        binding.iv.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            resultLauncher.launch(intent)
        }
    }

    var resultLauncher =
        registerForActivityResult<Intent, ActivityResult>(ActivityResultContracts.StartActivityForResult()){result ->
            if( result.resultCode != RESULT_CANCELED){
                val intent = result.data
                val uri = intent!!.data
                iv = uri.toString()
                Glide.with(this@EditActivity).load(uri).into(binding.iv)//.error()
            }
        }

    fun clickComplete(){

    }

}