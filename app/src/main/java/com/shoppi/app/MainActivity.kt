package com.shoppi.app

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        // 선택된 아이콘의 그라데이션이 작동이 안되어서 itemIconTintList = null 을 함
        bottomNavigationView.itemIconTintList = null

        // NavHostFragment 에 내부컨트롤러에 대한 참조를 가져와야한다
        // 먼저, NavHostFragment 에 대한 참조가 필요한다
        // NavHostFragment 는 findNavController() 라는 메소드를 지원한다
        // - findNavController() : NavHostFragment 가 소유하고 있는 내부컨트롤러에 대한 참조를 반환해준다
        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            bottomNavigationView.setupWithNavController(it)
            // setupWithNavController : BottomNavigationView 와 FragmentContainerView의 NavHostFragment 를 연결하게 해준다
            // - NavController : NavHostFragment 에서 데스트네이션의 이동을 관리하는 객체
            // 즉, 화면이동을 관리하는 내부컨트롤러 객체를 바텀 내비게이션뷰에 할당할 수 있게 진원함으로서, 바텀내비게인션뷰의 아이템을 클릭했을 때, 화면이동이 이루어질 수 있도록 해줌
        }


    }

}