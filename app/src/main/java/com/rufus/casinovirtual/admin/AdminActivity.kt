package com.rufus.casinovirtual.admin
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.rufus.casinovirtual.databinding.ActivityAdminBinding
class AdminActivity : AppCompatActivity() {
    private lateinit var b: ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(b.root)
        try { FirebaseApp.initializeApp(this); val db = FirebaseFirestore.getInstance(); b.tvInfo.text = "Admin listo. Conecta Firebase para ver usuarios." }
        catch (e: Exception) { b.tvInfo.text = "Admin en modo local (sin Firebase)" }
    }
}
