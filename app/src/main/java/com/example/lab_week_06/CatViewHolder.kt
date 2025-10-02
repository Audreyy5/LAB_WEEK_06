package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

private val FEMALE_SYMBOL = "\u2640"
private val MALE_SYMBOL = "\u2642"
private const val UNKNOWN_SYMBOL = "?"

class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener
) : RecyclerView.ViewHolder(containerView) {

    private val catPhotoView: ImageView = containerView.findViewById(R.id.cat_photo)
    private val catNameView: TextView = containerView.findViewById(R.id.cat_name)
    private val catBreedView: TextView = containerView.findViewById(R.id.cat_breed)
    private val catBiographyView: TextView = containerView.findViewById(R.id.cat_biography)
    private val catGenderView: TextView = containerView.findViewById(R.id.cat_gender)

    fun bindData(cat: CatModel) {
        // load gambar
        imageLoader.loadImage(containerView.context, cat.imageUrl, catPhotoView)

        // set teks
        catNameView.text = cat.name
        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            else -> "Unknown"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }

        // set click listener
        containerView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }
    }
}
