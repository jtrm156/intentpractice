package com.example.testproject2

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework2.CustomAdapter
import com.example.testproject2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    var account_array = arrayListOf<DataVo>(
        DataVo("12-123456-1234", "입금:50000원", "2021-07-10", "icon_user"),
        DataVo("12-123456-1234", "출금:35200원", "2021-07-02", "icon_user"),
        DataVo("12-123456-1234", "입금:880000원", "2021-07-01", "icon_user"),
        DataVo("12-123456-1234", "출금:39000원", "2021-06-30", "icon_user"),
        DataVo("12-123456-1234", "출금:10000원", "2021-06-28", "icon_user"),
        DataVo("12-123456-1234", "출금:70000원", "2021-06-25", "icon_user"),
        DataVo("12-123456-1234", "출금:18000원", "2021-06-20", "icon_user"),
        DataVo("12-123456-1234", "입금:300000원", "2021-06-19", "icon_user"),
        DataVo("12-123456-1234", "출금:7000원", "2021-06-18", "icon_user"),
        DataVo("12-123456-1234", "출금:98000원", "2021-06-17", "icon_user"),
        DataVo("12-123456-1234", "출금:15000원", "2021-06-15", "icon_user"),
    )

    lateinit var binding: ActivitySecondBinding

    var Logoutflag: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val mAdapter = CustomAdapter(this, account_array)
        binding.RCSub.adapter = mAdapter
        val layout = LinearLayoutManager(this)
        binding.RCSub.layoutManager = layout
        binding.RCSub.setHasFixedSize(true)

        if (MysharedPreferences.getUserPW_2(this) == "null")
        {
            MysharedPreferences.setUserPW_2(this, MysharedPreferences.getUserPW_1(this))
        }
        else
        {
            if (MysharedPreferences.getUserPW_1(this) == MysharedPreferences.getUserPW_2(this))
            {
                Toast.makeText(this,"로그인되었습니다", Toast.LENGTH_SHORT).show()
                MysharedPreferences.setUserPW_2(this, MysharedPreferences.getUserPW_1(this))
            }
            else
            {
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this,"로그인오류", Toast.LENGTH_SHORT).show()
            }
        }

            binding.btn1Sub.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            val logout_msg = AlertDialog.Builder(this)

            logout_msg.setTitle("로그아웃 확인 메세지")
            logout_msg.setMessage("로그아웃 하시겠습니까?")

            var listener = DialogInterface.OnClickListener { dialog, which -> startActivity(intent)
                Logoutflag = true }
            logout_msg.setPositiveButton("확인", listener)
            val logout_alertDialog = logout_msg.create()
            logout_alertDialog.show()
        }

        //Toast.makeText(this, "onCrate_Second", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()


    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(this,"OnResume_Second", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()

        MysharedPreferences.setUserPW_2(this, MysharedPreferences.getUserPW_2(this))
        //Toast.makeText(this,"OnPause_Second", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        // MysharedPreferences.setUserPW(this, MysharedPreferences.getUserPW(this))

        if(Logoutflag == true)
        {
            Toast.makeText(this, "로그아웃 되었습니다", Toast.LENGTH_SHORT).show()
        }
       // Toast.makeText(this,"OnStop_Second", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()

        MysharedPreferences.setUserPW_2(this, MysharedPreferences.getUserPW_2(this))

        Toast.makeText(this, "자동 로그인 되었습니다", Toast.LENGTH_SHORT).show()
        //Toast.makeText(this,"OnRestart_Second", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()//데이터 제거
        MysharedPreferences.clearUser(this)
        //Toast.makeText(this,"데이터를 삭제", Toast.LENGTH_SHORT).show()
        //actvitiy가 파괴되기 직전에 호출되는 메소드 이 메소드를 실행 후 액티비티는 파괴
    }
}