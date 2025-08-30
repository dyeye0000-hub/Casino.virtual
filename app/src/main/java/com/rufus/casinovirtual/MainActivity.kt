package com.rufus.casinovirtual
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rufus.casinovirtual.databinding.ActivityMainBinding
import com.rufus.casinovirtual.auth.LoginActivity
import com.rufus.casinovirtual.games.RouletteActivity
import com.rufus.casinovirtual.games.SlotsActivity
import com.rufus.casinovirtual.admin.AdminActivity
class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.btnLogin.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }
        b.btnRoulette.setOnClickListener { startActivity(Intent(this, RouletteActivity::class.java)) }
        b.btnSlots.setOnClickListener { startActivity(Intent(this, SlotsActivity::class.java)) }
        b.btnAdmin.setOnClickListener { startActivity(Intent(this, AdminActivity::class.java)) }
    }
}
