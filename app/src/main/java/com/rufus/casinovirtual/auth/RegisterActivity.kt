package com.rufus.casinovirtual.auth
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.rufus.casinovirtual.databinding.ActivityRegisterBinding
class RegisterActivity : AppCompatActivity() {
    private lateinit var b: ActivityRegisterBinding
    private var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(b.root)
        try { FirebaseApp.initializeApp(this) } catch (_: Exception) { }
        auth = try { FirebaseAuth.getInstance() } catch (_: Exception) { null }
        b.btnRegister.setOnClickListener {
            val email = b.etEmail.text.toString()
            val pass = b.etPass.text.toString()
            if (auth != null) {
                auth!!.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) { Toast.makeText(this, "Cuenta creada", Toast.LENGTH_SHORT).show(); finish() }
                    else { Toast.makeText(this, "Error: ${it.exception?.message}", Toast.LENGTH_LONG).show() }
                }
            } else {
                if (email.isNotEmpty() && pass.isNotEmpty()) { Toast.makeText(this, "Registro local OK (sin Firebase)", Toast.LENGTH_SHORT).show(); finish() }
                else { Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show() }
            }
        }
    }
}
