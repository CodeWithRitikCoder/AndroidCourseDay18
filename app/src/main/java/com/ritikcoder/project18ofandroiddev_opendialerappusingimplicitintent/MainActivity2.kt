package com.ritikcoder.project18ofandroiddev_opendialerappusingimplicitintent

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.ritikcoder.project18ofandroiddev_opendialerappusingimplicitintent.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var alertDialog: Dialog

    lateinit var binding: ActivityMain2Binding
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        alertDialog= Dialog(this)
        alertDialog.setContentView(R.layout.alert_dialog_box1)
        alertDialog.window?.setBackgroundDrawable(getDrawable(R.drawable.alert_dialog_box_bg))
        val okayButton: Button= alertDialog.findViewById(R.id.buttonForAlertOkay)

        binding.imageViewForDialNumber.setOnClickListener {
            val phoneNumber= binding.textInputEditTextForPhoneNumber.text
            if(phoneNumber?.isNotEmpty() == true){
                val intentToOpenDialerApplication= Intent(Intent.ACTION_DIAL)
                intentToOpenDialerApplication.data= Uri.parse("tel: $phoneNumber")
                startActivity(intentToOpenDialerApplication)
            }else{
                Toast.makeText(this, "Please Enter Phone No First", Toast.LENGTH_SHORT).show()
                alertDialog.show()
                okayButton.setOnClickListener {
                    alertDialog.dismiss()
                }

            }
        }
    }
}