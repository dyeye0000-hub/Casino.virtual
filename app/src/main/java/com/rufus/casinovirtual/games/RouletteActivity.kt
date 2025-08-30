package com.rufus.casinovirtual.games
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rufus.casinovirtual.databinding.ActivityRouletteBinding
import kotlin.random.Random
class RouletteActivity : AppCompatActivity() {
    private lateinit var b: ActivityRouletteBinding
    private var credits = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityRouletteBinding.inflate(layoutInflater)
        setContentView(b.root)
        updateCredits()
        b.btnSpin.setOnClickListener {
            val n = Random.nextInt(0, 37)
            val bet = 10
            credits -= bet
            if (n == 0) credits += 360
            b.tvResult.text = "Número: $n"
            updateCredits()
        }
    }
    private fun updateCredits() { b.tvCredits.text = "Créditos: $credits" }
}
