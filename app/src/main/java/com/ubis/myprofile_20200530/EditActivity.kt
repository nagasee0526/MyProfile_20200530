package com.ubis.myprofile_20200530

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val MyTempId = intent.getStringExtra("MySetId")

        if( MyTempId == "본인 닉네임")   EditId.setText("")
        else    EditId.setText(MyTempId)

        EditBtn.setOnClickListener {
            val NickName = EditId.text.toString()
            val resultIntece = Intent()
            resultIntece.putExtra("nick", NickName)
            setResult(Activity.RESULT_OK, resultIntece)

            finish()
        }
    }

}
