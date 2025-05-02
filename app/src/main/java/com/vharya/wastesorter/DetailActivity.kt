package com.vharya.wastesorter

import android.os.Bundle
import android.widget.GridView
import android.widget.ImageButton
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.vharya.wastesorter.adapters.BasicListAdapter
import com.vharya.wastesorter.adapters.WasteGridAdapter

class DetailActivity : AppCompatActivity() {
    private val features = arrayListOf(
        "Mudah membusuk",
        "Bisa dijadikan kompos",
        "Tidak mencemari lingkungan jika dikelola dengan baik"
    )

    private val benefits = arrayListOf(
        "Dijadikan pupuk kompos",
        "Dimanfaatkan sebagai biogas",
        "Mengurangi volume sampah"
    )

    private val placeholderWasteImages = arrayListOf(
        R.drawable.ic_cherries,
        R.drawable.ic_fish,
    )
    private val placeholderWasteNames = arrayListOf(
        "Sayur & Buah",
        "Daging",
    )
    private val placeholderWasteCategories = arrayListOf(
        "Organik",
        "Organik"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        val buttonBack: ImageButton = findViewById(R.id.button_back)
        val featureList: ListView = findViewById(R.id.list_features)
        val benefitList: ListView = findViewById(R.id.list_benefit)
        val exampleGrid: GridView = findViewById(R.id.waste_example_grid)

        buttonBack.setOnClickListener { finish() }

        featureList.adapter = BasicListAdapter(features)
        benefitList.adapter = BasicListAdapter(benefits)

        exampleGrid.adapter = WasteGridAdapter(
            placeholderWasteImages,
            placeholderWasteNames,
            placeholderWasteCategories
        )
    }
}