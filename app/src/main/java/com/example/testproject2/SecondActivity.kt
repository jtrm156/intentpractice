package com.example.testproject2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework2.CustomAdapter
import com.example.testproject2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    var account_array = arrayListOf<DataVo>(
        DataVo("12345678912","입금:50000원","2021-07-10"),
        DataVo("12345678912","출금:35200원","2021-07-02"),
        DataVo("12345678912","입금:880000원","2021-07-01"),
        DataVo("12345678912","출금:39000원","2021-06-30"),
        DataVo("12345678912","출금:10000원","2021-06-28"),
        DataVo("12345678912","출금:70000원","2021-06-25"),
        DataVo("12345678912","출금:18000원","2021-06-20"),
    )

    lateinit var binding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        //binding.txtSecond.text=intent.getStringExtra("data")

        val mAdapter = CustomAdapter(this,account_array)
        binding.RCSub.adapter = mAdapter
        val layout = LinearLayoutManager(this)
        binding.RCSub.layoutManager = layout
        binding.RCSub.setHasFixedSize(true)
    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()

        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show()
        //actvitiy가 파괴되기 직전에 호출되는 메소드 이 메소드를 실행 후 액티비티는 파괴
    }
}