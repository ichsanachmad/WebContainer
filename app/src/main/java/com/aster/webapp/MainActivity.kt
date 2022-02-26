package com.aster.webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.aster.webapp.databinding.ActivityMainBinding
import com.aster.webcontainer.WebContainer
import com.aster.webcontainer.listener.WebContainerListener

class MainActivity : AppCompatActivity(), WebContainerListener {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.openContainer.setOnClickListener {
            WebContainer.launch("https://github.com/", true)
        }
    }

    override fun callback(json: String) {
        Toast.makeText(this, json, Toast.LENGTH_SHORT).show()
    }
}