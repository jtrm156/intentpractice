package com.example.testproject2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.testproject2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root

        setContentView(view)

        binding.btn1Main.setOnClickListener {

            if(binding.edtMain.text.toString().length < 6)
            {
                Toast.makeText(this,"비밀번호6자리를 입력하시오", Toast.LENGTH_SHORT).show()
            }
            else
            {
                MysharedPreferences.setUserPW_1(this, binding.edtMain.text.toString())

                var intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("data", binding.edtMain.text.toString())
                startActivity(intent)
            }
        }

        binding.btn2Main.setOnClickListener{
            binding.edtMain.setText("")
        }

        binding.txt1Main.setOnClickListener{
            val find_pw = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.custom_dialog,null)
            val dialogText = dialogView.findViewById<EditText>(R.id.edt_dig)

            find_pw.setTitle("비밀번호 재설정")
            find_pw.setView(dialogView)
            find_pw.setPositiveButton("확인"){ dialogInterface, i->
                binding.edtMain.text = dialogText.text
            }
            find_pw.setNegativeButton("취소"){
                    dialogInterface, i->
            }
            find_pw.show()
            MysharedPreferences.clearUser(this)
        }

        //MysharedPreferences.setUserPW(this, binding.edtMain.text.toString())
        //binding.txt3Main.setText(MysharedPreferences.getUserPW(this))
        //Toast.makeText(this,"OnCreate_Main", Toast.LENGTH_SHORT).show()
    }   //액티비티가 만들어질때 생성되는 메소드
        //메인 액티비티에 edittext에 값을 입력한 후 버튼을 클릭하면 입력한 값을 인텐트에 담아서 Second Actvitiy로 화면 전환을 해주고
        //Second Activity에 있는 textview에 받아온 값을 세팅

    override fun onStart() {
        super.onStart()
        //Toast.makeText(this,"OnStart_Main", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        //Toast.makeText(this,"OnResume_Main", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        //Toast.makeText(this,"OnPause_Main", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        //Toast.makeText(this,"OnStop_Main", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        binding.edtMain.setText("")
        //Toast.makeText(this,"OnRestart_Main", Toast.LENGTH_SHORT).show()
        //저장된 데이터 초기화
    }

    override fun onDestroy() {
        super.onDestroy()
        MysharedPreferences.clearUser(this)
        //Toast.makeText(this,"데이터를 삭제", Toast.LENGTH_SHORT).show()
        //actvitiy가 파괴되기 직전에 호출되는 메소드 이 메소드를 실행 후 액티비티는 파괴
    }
}
