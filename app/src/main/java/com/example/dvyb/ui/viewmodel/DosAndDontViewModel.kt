package com.example.dvyb.ui.viewmodel


import androidx.lifecycle.ViewModel
import com.example.dvyb.R
import com.example.dvyb.data.model.PhotoTip

class PhotoTipsViewModel : ViewModel() {
    val dosTips = listOf(
        PhotoTip(R.drawable.clear_well_lit, "Clear and well-lit", "Ensure your photos are sharp and bright."),
        PhotoTip(R.drawable.full_product, "Show the entire item", "Capture the full product without cropping."),
        PhotoTip(R.drawable.neutral_bg, "Use a neutral background", "Keep the background simple and clean.")
    )

    val dontsTips = listOf(
        PhotoTip(R.drawable.blurry, "Avoid blurry photos", "Ensure your photos are sharp and in focus."),
        PhotoTip(R.drawable.cluttered, "Cluttered background", "Keep the background simple and clean."),
        PhotoTip(R.drawable.poor_lighting, "Avoid poor lighting", "Ensure your photos are well-lit and bright.")
    )
}
