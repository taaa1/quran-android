package io.taaa.alfurqan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import io.taaa.alfurqan.databinding.ActivityReadingBinding

class ReadingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityReadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = Bundle()
        bundle.putInt("index", intent.getIntExtra("index", 0))

        val frag = AyatFragment()
        frag.arguments = bundle

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView2, frag).commit()

        setSupportActionBar(binding.toolbar)

        title = intent.getStringExtra("title")
    }
}