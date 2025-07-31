package com.example.clothingbrandapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.material3.Text

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clothingbrandapp.R

data class OfferCardData(val imageResId: Int, val title: String)

@Composable
fun OfferCategoryScroll() {
    val offers = listOf(
        OfferCardData(R.drawable.flash_sale, "Flash Sale"),
        OfferCardData(R.drawable.men_offer, "Men Sale"),
        OfferCardData(R.drawable.bag_deal, "Bag Deals"),
        OfferCardData(R.drawable.under_499, "Under ₹499")
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.width(12.dp))
        offers.forEach {
            OfferCard(it)
        }
        Spacer(modifier = Modifier.width(12.dp))
    }
}

@Composable
fun OfferCard(data: OfferCardData) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(120.dp)
            .clickable { println("${data.title} clicked") }
    ) {
        Image(
            painter = painterResource(id = data.imageResId),
            contentDescription = data.title,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = data.title,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
    }
}
