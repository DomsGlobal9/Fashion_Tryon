package com.example.dvyb.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dvyb.data.model.PhotoTip
import com.example.dvyb.ui.viewmodel.PhotoTipsViewModel

@Composable
fun DosAndDontsScreen(viewModel: PhotoTipsViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text("DO’S & DON’TS", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))
        Text("Follow these tips for the best photos!", fontSize = 14.sp)

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // DO's Column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFE6F4EA), RoundedCornerShape(12.dp))
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconBadge("✓", Color(0xFF2ECC71))
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Do’s",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2ECC71)
                )

                Spacer(Modifier.height(12.dp))

                viewModel.dosTips.forEach {
                    TipCard(it)
                    Spacer(Modifier.height(12.dp))
                }
            }

            // DON'Ts Column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFFCE8E6), RoundedCornerShape(12.dp))
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconBadge("✕", Color(0xFFE74C3C))
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Don’ts",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE74C3C)
                )

                Spacer(Modifier.height(12.dp))

                viewModel.dontsTips.forEach {
                    TipCard(it)
                    Spacer(Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun IconBadge(symbol: String, color: Color) {
    Box(
        modifier = Modifier
            .size(30.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            symbol,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Composable
fun TipCard(tip: PhotoTip) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = tip.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(6.dp))
        Text(text = tip.title, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        Spacer(Modifier.height(2.dp))
        Text(
            text = tip.subtitle,
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Start
        )
    }
}
