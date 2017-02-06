package mydemo.kotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.example.hp0331.mydemo.R

import mydemo.GestureEditActivity
import mydemo.GestureVerifyActivity

class LockActivity : Activity(), OnClickListener {
    private var mBtnSetLock: Button? = null
    private var mBtnVerifyLock: Button? = null
    private var mTvpassword: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock)
        setUpView()
        setUpListener()
    }

    private fun setUpView() {
        mBtnSetLock = findViewById(R.id.btn_set_lockpattern) as Button
        mBtnVerifyLock = findViewById(R.id.btn_verify_lockpattern) as Button
        mTvpassword = findViewById(R.id.tv_password) as TextView
        mTvpassword!!.text = "ÕÒ»ØÃÜÂë"
    }

    private fun setUpListener() {
        mBtnSetLock!!.setOnClickListener(this)
        mBtnVerifyLock!!.setOnClickListener(this)
        mTvpassword!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_set_lockpattern -> startSetLockPattern()
            R.id.btn_verify_lockpattern -> startVerifyLockPattern()
            R.id.tv_password -> {
                val preferences = getSharedPreferences("message", Context.MODE_PRIVATE)
                val password = preferences.getString("password", "")
                if (password === "") {
                    Toast.makeText(this@LockActivity, "Î´ÉèÖÃÃÜÂë", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LockActivity, "ÃÜÂëÊÇ:" + password!!, Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
            }
        }
    }

    private fun startSetLockPattern() {
        val intent = Intent(this@LockActivity, GestureEditActivity::class.java)
        startActivity(intent)
    }

    private fun startVerifyLockPattern() {
        val intent = Intent(this@LockActivity, GestureVerifyActivity::class.java)
        startActivity(intent)
    }
}
