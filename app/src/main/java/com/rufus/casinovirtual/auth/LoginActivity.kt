package com.rufus.casinovirtual.auth
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.rufus.casinovirtual.databinding.ActivityLoginBinding
class LoginActivity : AppCompatActivity() {
    private lateinit var b: ActivityLoginBinding
    private var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(b.root)
        try { FirebaseApp.initializeApp(this) } catch (_: Exception) { }
        auth = try { FirebaseAuth.getInstance() } catch (_: Exception) { null }
        b.btnGoRegister.setOnClickListener { startActivity(Intent(this, RegisterActivity::class.java)) }
        b.btnLogin.setOnClickListener {
            val email = b.etEmail.text.toString()
            val pass = b.etPass.text.toString()
            if (auth != null) {
                auth!!.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) { Toast.makeText(this, "Bienvenido!", Toast.LENGTH_SHORT).show(); finish() }
                    else { Toast.makeText(this, "Error: ${it.exception?.message}", Toast.LENGTH_LONG).show() }
                }
            } else {
                if (email.isNotEmpty() && pass.isNotEmpty()) { Toast.makeText(this, "Login local OK (sin Firebase)", Toast.LENGTH_SHORT).show(); finish() }
                else { Toast.makeText(this, "Ingresa email y contraseña", Toast.LENGTH_SHORT).show() }
            }
        }
    }
}
