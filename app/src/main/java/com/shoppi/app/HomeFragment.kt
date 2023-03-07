package com.shoppi.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btn_enter_product_detail)
        button.setOnClickListener {

            // FragmentManager : Fragment 를 추가, 삭제, 교체를 담당한다
            // 종류 : parentFragmentManager, childFragmentManager
            // 여기서 HomeFragment 는 host 의 역할을 하므로 parentFragmentManager 를 참조해야한다
            // Transaction 이라함은 Fragment 를 추가, 삭제, 교체를 요청하는 걸 의미
            //  - beginTransaction() : Transaction 객체를 반환
            //  - commit() : Transaction 이 실행하기 위해서는 반드시 선언해줘야한다

            /*val transaction = parentFragmentManager.beginTransaction()
            transaction.add(R.id.container_main, ProductDetailFragment())
            transaction.commit()*/
            findNavController().navigate(R.id.action_home_to_product_detail)

        }
    }

}