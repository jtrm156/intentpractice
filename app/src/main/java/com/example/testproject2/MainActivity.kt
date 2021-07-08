package com.example.testproject2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testproject2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.btnMain.setOnClickListener{

            var intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("data",binding.edtMain.text.toString())
            startActivity(intent)
        }

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    } //액티비티가 만들어질때 생성되는 메소드
      //메인 액티비티에 edittext에 값을 입력한 후 버튼을 클릭하면 입력한 값을 인텐트에 담아서 Second Actvitiy로 화면 전환을 해주고
      //Second Activity에 있는 textview에 받아온 값을 세팅

    override fun onStart() {
        super.onStart()

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
        //actvitiy가 파괴되기 직전에 호출되는 메소드 이 메소드를 실행 후 액티비티는 파괴
    }
}
