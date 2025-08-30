package com.rufus.casinovirtual.games
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rufus.casinovirtual.databinding.ActivitySlotsBinding
import kotlin.random.Random
class SlotsActivity : AppCompatActivity() {
    private lateinit var b: ActivitySlotsBinding
    private var credits = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivitySlotsBinding.inflate(layoutInflater)
        setContentView(b.root)
        updateCredits()
        b.btnSpin.setOnClickListener {
            val a = Random.nextInt(1, 6)
            val c = Random.nextInt(1, 6)
            val d = Random.nextInt(1, 6)
            credits -= 5
            var prize = 0
            if (a == c && c == d) prize = 50
            b.tvReels.text = "$a  |  $c  |  $d"
            credits += prize
            updateCredits()
        }
    }
    private fun updateCredits() { b.tvCredits.text = "Créditos: $credits" }
}
