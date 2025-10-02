package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        // Glide is used here to load the images
        CatAdapter(layoutInflater, GlideImageLoader(),
            object : CatAdapter.OnClickListener {
                override fun onItemClick(cat: CatModel) {
                    showSelectionDialog(cat)
                }
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        // Setup the layout manager for the recycler view
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        //Instantiate ItemTouchHelper for the swipe to delete callback and //attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Add data to the model list in the adapter
        // Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Bengal,
                    "Simba",
                    "Playful jungle cat",
                    "https://cdn2.thecatapi.com/images/ybv.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Birman,
                    "Luna",
                    "Loves to nap in the sun",
                    "https://cdn2.thecatapi.com/images/9k1.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.MaineCoon,
                    "Thor",
                    "Big and fluffy guardian",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Persian,
                    "Cleo",
                    "Royal and elegant",
                    "https://cdn2.thecatapi.com/images/7u2.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Siberian,
                    "Max",
                    "Curious and adventurous",
                    "https://cdn2.thecatapi.com/images/3f3.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Sphynx,
                    "Nala",
                    "Sweet but mischievous",
                    "https://cdn2.thecatapi.com/images/MTc5MjA5MQ.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.TurkishVan,
                    "Shadow",
                    "Mysterious wanderer",
                    "https://cdn2.thecatapi.com/images/MTk3MzQ0NQ.jpg"
                )
            )
        )
    }

    // This will create a pop up dialog when one of the items from the recycler view is clicked
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK", null)
            .show()
    }
}
