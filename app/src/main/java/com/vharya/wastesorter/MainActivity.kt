package com.vharya.wastesorter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vharya.wastesorter.adapters.CategoryListAdapter
import com.vharya.wastesorter.adapters.WasteGridAdapter
import com.vharya.wastesorter.models.WasteModel

class MainActivity : AppCompatActivity() {
    private val placeholderCategoryImages = arrayListOf(
        R.drawable.ic_leaf,
        R.drawable.ic_chemical,
        R.drawable.ic_danger,
    )
    private val placeholderCategoryNames = arrayListOf(
        "Organik",
        "Anorganik",
        "B3",
    )

    private val placeholderWasteImages = arrayListOf(
        R.drawable.ic_cherries, R.drawable.ic_alumunium_can,
        R.drawable.ic_drugs, R.drawable.ic_fish,
        R.drawable.ic_plastic_bottle,
    )
    private val placeholderWasteNames = arrayListOf(
        "Sayur & Buah", "Aluminium",
        "Obat", "Daging",
        "Plastik",
    )
    private val placeholderWasteCategories = arrayListOf(
        "Organik", "Anorganik",
        "B3", "Organik",
        "Anorganik",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        val infoButton: ImageButton = findViewById(R.id.button_info)
        val categoryRecycler: RecyclerView = findViewById(R.id.categories)
        val wasteGrid: GridView = findViewById(R.id.gridview)

        infoButton.setOnClickListener {
//            Toast.makeText(this, "About App", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }

        categoryRecycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        );

        val horizontalSpacing = HorizontalSpacingDecoration(16, applicationContext)
        categoryRecycler.addItemDecoration(horizontalSpacing)

        categoryRecycler.adapter = CategoryListAdapter(
            placeholderCategoryImages,
            placeholderCategoryNames,
            object : CategoryListAdapter.OnAdapterListener {
                override fun onItemClicked(categoryName: String) {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    startActivity(intent)
                }
            }
        )

        wasteGrid.adapter = WasteGridAdapter(
            placeholderWasteImages,
            placeholderWasteNames,
            placeholderWasteCategories
        )
    }

//    Light & Dark mode color solution example
//    fun getCategoryColor(category: String, context: Context): Int {
//        return when (category) {
//            "Recyclable" -> ContextCompat.getColor(context, R.color.recyclable_light)
//            "Organic" -> ContextCompat.getColor(context, R.color.organic_light)
//            "Hazardous" -> ContextCompat.getColor(context, R.color.hazardous_light)
//            else -> ContextCompat.getColor(context, android.R.color.darker_gray)
//        }
//    }
}