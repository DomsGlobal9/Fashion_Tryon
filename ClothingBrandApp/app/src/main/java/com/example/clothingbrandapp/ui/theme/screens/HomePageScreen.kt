package com.example.clothingbrandapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.clothingbrandapp.R
import com.example.clothingbrandapp.ui.components.*

@Composable
fun HomePageScreen() {
    TopNavbarWithDrawer(
        onCartClick = { println("Cart clicked") },
        onMenuClick = { println("Menu clicked") }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.brand_banner),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "SHOP BY CATEGORY",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CategoryCard(R.drawable.men_category, "Men") { println("Men clicked") }
                CategoryCard(R.drawable.women_category, "Women") { println("Women clicked") }
                CategoryCard(R.drawable.kids_category, "Kids") { println("Kids clicked") }
            }

            Spacer(modifier = Modifier.height(40.dp))

            AutoSlidingBannerSection()

            Spacer(modifier = Modifier.height(44.dp))

            Text(
                text = "MEDAL WORTHY BRANDS TO BAG",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 8.dp)
            )

            OfferCategoryScroll()

            Spacer(modifier = Modifier.height(8.dp))

            ProductGridSection()

            Text(
                text = "Trending Ethnic Collections",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 8.dp)
            )

            FashionCategoryScroll()
        }
    }
}
