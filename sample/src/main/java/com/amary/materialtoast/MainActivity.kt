package com.amary.materialtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amary.materialtoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        activityMainBinding.apply {
            btnError.setOnClickListener {
                MToast.Builder(this@MainActivity)
                    .setType(MToastType.ERROR)
                    .setMessage("This is an error alert — check it out!")
                    .show()
            }

            btnErrorTitle.setOnClickListener {
                MToast.Builder(this@MainActivity)
                    .setType(MToastType.ERROR)
                    .setTitle("Error")
                    .setMessage("This is an error alert — check it out!")
                    .show()
            }

            btnWarning.setOnClickListener {
                MToast.Builder(this@MainActivity)
                    .setType(MToastType.WARNING)
                    .setMessage("This is an error alert — check it out!")
                    .show()
            }

            btnWarningTitle.setOnClickListener {
                MToast.Builder(this@MainActivity)
                    .setType(MToastType.WARNING)
                    .setTitle("Warning")
                    .setMessage("This is an error alert — check it out!")
                    .show()
            }

            btnInfo.setOnClickListener {
                MToast.Builder(this@MainActivity)
                    .setType(MToastType.INFO)
                    .setMessage("This is an error alert — check it out!")
                    .show()
            }

            btnInfoTitle.setOnClickListener {
                MToast.Builder(this@MainActivity)
                    .setType(MToastType.INFO)
                    .setTitle("Info")
                    .setMessage("This is an error alert — check it out!")
                    .show()
            }

            btnSuccess.setOnClickListener {
                MToast.Builder(this@MainActivity)
                    .setType(MToastType.SUCCESS)
                    .setMessage("This is an error alert — check it out!")
                    .show()
            }

            btnSuccessTitle.setOnClickListener {
                MToast.Builder(this@MainActivity)
                    .setType(MToastType.SUCCESS)
                    .setTitle("Success")
                    .setMessage("This is an error alert — check it out!")
                    .show()
            }
        }
    }
}