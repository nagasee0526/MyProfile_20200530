package com.ubis.myprofile_20200530

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        IdChange.setOnClickListener {
            val MyId = NickName.text.toString()
            val myIntent = Intent(this, EditActivity::class.java)
            myIntent.putExtra( "MySetId", MyId)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }

        NumDial.setOnClickListener {

            val inputPhoneNum = PhoneNum.text.toString()
            val MyUri = Uri.parse("tel:${inputPhoneNum.replace("_", "")}")
            val myIntent = Intent(Intent.ACTION_DIAL, MyUri)
            startActivity(myIntent)
        }

        TextSend.setOnClickListener {

            val inputPhoneNum = PhoneNum.text.toString()
            val inputText = EditText.text.toString()
            val MyUri = Uri.parse("smsto:${inputPhoneNum.replace("_", "")}")
            val myIntent = Intent(Intent.ACTION_SENDTO, MyUri)
            myIntent.putExtra("sms_body", "$inputText")
            startActivity(myIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_NICKNAME) {
            if( resultCode == Activity.RESULT_OK) {
                val NewNick = data?.getStringExtra( "nick")
                NickName.text = NewNick
            }
        }

    }

}
