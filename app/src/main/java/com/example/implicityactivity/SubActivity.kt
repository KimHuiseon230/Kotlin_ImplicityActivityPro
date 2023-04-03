package com.example.implicityactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.implicityactivity.databinding.ActivityMainBinding
import com.example.implicityactivity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    val binding: ActivitySubBinding by lazy { ActivitySubBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Toast.makeText(applicationContext, "${intent.getStringExtra("message")}",Toast.LENGTH_SHORT).show()
    }
}