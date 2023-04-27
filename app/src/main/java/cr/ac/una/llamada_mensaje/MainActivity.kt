package cr.ac.una.llamada_mensaje

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun makePhoneCall2(){
        val intent = Intent(Intent.ACTION_CALL)
        val phoneNumber = findViewById<EditText>(R.id.phone_number).text.toString()
        intent.data = Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }



    fun makePhoneCall2(view: View) {

        val permission = android.Manifest.permission.CALL_PHONE
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), 1)
        } else {
            makePhoneCall2()
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (1) {
            requestCode -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    makePhoneCall2()
                } else {
                    // El usuario no concedió el permiso
                }
            }
        }
    }
}