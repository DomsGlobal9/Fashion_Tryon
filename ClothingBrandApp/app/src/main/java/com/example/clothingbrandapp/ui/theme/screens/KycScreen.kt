package com.example.clothingbrandapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KycScreen(onSubmitKYC: () -> Unit) {
    val context = LocalContext.current

    var gstNumber by remember { mutableStateOf("") }
    var panNumber by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var accountNumber by remember { mutableStateOf("") }
    var ifsc by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text("KYC Verification", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4CAF50))

        Spacer(modifier = Modifier.height(12.dp))
        Text("Complete Your KYC", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Text("Verify your business details to start selling.", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(24.dp))
        Text("Business Documents", fontWeight = FontWeight.Bold, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = gstNumber,
            onValueChange = { gstNumber = it },
            label = { Text("GST Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = panNumber,
            onValueChange = { panNumber = it },
            label = { Text("PAN Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Business Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text("Banking Details", fontWeight = FontWeight.Bold, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = accountNumber,
            onValueChange = { accountNumber = it },
            label = { Text("Bank Account Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = ifsc,
            onValueChange = { ifsc = it },
            label = { Text("IFSC Code") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                Toast.makeText(context, "KYC Submitted", Toast.LENGTH_SHORT).show()
                onSubmitKYC()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text("Submit", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}
