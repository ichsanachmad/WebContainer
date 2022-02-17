package com.aster.webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aster.webapp.databinding.ActivityMainBinding
import com.aster.webcontainer.WebContainer

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.openContainer.setOnClickListener {
            WebContainer.launch(this, "https://google.com/")
        }
    }
}