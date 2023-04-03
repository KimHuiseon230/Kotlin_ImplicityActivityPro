package com.example.implicityactivity

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import com.example.implicityactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // +++ 함수
        binding.btnWeb.setOnClickListener(this)
        binding.btnCamera.setOnClickListener(this)
        binding.btnGoogle.setOnClickListener(this)
        binding.btnSearch.setOnClickListener(this)
        binding.btnText.setOnClickListener(this)
        binding.btnImlicity.setOnClickListener(this)
        // +++ 함수

    }

    override fun onClick(v: View?) {
        try {
            when (v?.id) {
                //1. 웹뷰를 암시적 인텐트로 불러옴
                R.id.btnWeb -> {
                    val intent = Intent()
                    intent.action = Intent.ACTION_VIEW
                    intent.data = Uri.parse("http://www.naver.com")
                    startActivity(intent)
                }
                //2. 카메라를 암시적 인텐트로 불러옴
                R.id.btnCamera -> {
                    val intent = Intent()
                    intent.action = MediaStore.ACTION_IMAGE_CAPTURE
                    startActivity(intent)
                }

                //3. 구글을 암시적 인텐트로 불러옴
                R.id.btnGoogle -> {
                    val iatitude = 38.111111
                    val logitude = 127.111111
                    val intent = Intent()
                    intent.action = Intent.ACTION_VIEW
                    intent.data = Uri.parse("http://google.com/maps?q=${iatitude},${logitude}")
                    startActivity(intent)
                }
                //3. 검색을 암시적 인텐트로 불러옴
                R.id.btnSearch -> {
                    val intent = Intent()
                    intent.action = Intent.ACTION_WEB_SEARCH
                    intent.putExtra(SearchManager.QUERY, binding.edtSerach.text.toString())
                    startActivity(intent)

                }
                //4. 문자를 암시적 인텐트 방법으로 활용하기
                R.id.btnText -> {
                    val intent = Intent()
                    intent.action = Intent.ACTION_SENDTO
                    intent.putExtra("sms_body", "${binding.edtSerach.text.toString()}")
                    intent.data = Uri.parse("smsto:" + Uri.encode("010-3657-1894"))
                    startActivity(intent)
                }
                //5. 우리가 만든 것을 암시적 인텐트로 불러옴
                R.id.btnImlicity -> {
                    val intent = Intent()
                    intent.action = "ACTION_EDIT"
                    intent.putExtra("message", "${binding.edtSerach.text.toString()}")
                    //subactivity으로 띄워짐
                    startActivity(intent)
                }
            }
        } catch (e: java.lang.Exception) {
            // 모든 스택의 정보를 가져와라
            Log.e("MainActivity", "${e.stackTrace.toString()}")
        }

    }
}