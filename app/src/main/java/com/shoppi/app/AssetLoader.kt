package com.shoppi.app

import android.content.Context
import android.util.Log

class AssetLoader {

    // use 함수의 내부구현을 보면 exception 발생 할 수 있어서, 예외처리를 해야함
    fun getJsonString(context: Context, fileName: String) : String? {

        // kotlin.runCatching : 성공, 실패 캐이스를 나누는 작업
        return kotlin.runCatching {
            loadAsset(context, fileName)
        }.getOrNull()
    }

    private fun loadAsset(context: Context, fileName: String) : String {

        // assets 폴더에 접근하기 위해서는 context 라는 객체에 접근해야함
        // open 함수를 통해서 얻는 객체는 InputStream
        // - InputStream 은 리소스를 사용한 다음에 해제하는 작업(use 함수)을 완료해야한다
        return context.assets.open(fileName).use { inputStream ->
            // available() : inputStream 안에 실제롤 데이터가 존재하는지 확인 가능
            val size = inputStream.available()
            // size 는 ByteArray 를 초기화 하는데 사용됨 (inputStream 에서 전달받는 데이터의 타입이 ByteArray)
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            // bytes 를 String 타입으로 변환시키 -> home.json 파일의 json 데이터를 문자열 형태로 확인이 가능해짐
            // val homeData = String(bytes)
            String(bytes)

        }

    }

}