package com.example.dvyb.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

// ViewModel and model
import com.example.dvyb.ui.viewmodel.PaymentViewModel
import com.example.dvyb.data.model.PaymentMethod
import com.example.dvyb.R

@Composable
fun PaymentScreen(viewModel: PaymentViewModel = viewModel()) {
    val selectedMethod by viewModel.selectedMethod.collectAsState()
    val cardDetails by viewModel.cardDetails.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Payment", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        Spacer(Modifier.height(8.dp))
        Text("Choose a payment method", color = Color.Gray)

        Spacer(Modifier.height(12.dp))

        PaymentMethodOption(
            icon = painterResource(R.drawable.ic_google_pay),
            label = "Google Pay",
            selected = selectedMethod == PaymentMethod.GOOGLE_PAY
        ) { viewModel.selectMethod(PaymentMethod.GOOGLE_PAY) }

        PaymentMethodOption(
            icon = painterResource(R.drawable.ic_phonepe),
            label = "PhonePe",
            selected = selectedMethod == PaymentMethod.PHONEPE
        ) { viewModel.selectMethod(PaymentMethod.PHONEPE) }

        PaymentMethodOption(
            icon = painterResource(R.drawable.ic_bhim),
            label = "BHIM",
            selected = selectedMethod == PaymentMethod.BHIM
        ) { viewModel.selectMethod(PaymentMethod.BHIM) }

        PaymentMethodOption(
            icon = painterResource(R.drawable.ic_paytm),
            label = "Paytm",
            selected = selectedMethod == PaymentMethod.PAYTM
        ) { viewModel.selectMethod(PaymentMethod.PAYTM) }

        PaymentMethodOption(
            icon = null,
            label = "Cash on delivery",
            selected = selectedMethod == PaymentMethod.COD
        ) { viewModel.selectMethod(PaymentMethod.COD) }

        Spacer(Modifier.height(24.dp))
        Text("Card", fontWeight = FontWeight.SemiBold)

        OutlinedTextField(
            value = cardDetails.cardNumber,
            onValueChange = { viewModel.updateCardNumber(it) },
            label = { Text("Card Number") },
            leadingIcon = { Icon(Icons.Default.CreditCard, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(Modifier.height(12.dp))
        Row {
            OutlinedTextField(
                value = cardDetails.expiry,
                onValueChange = { viewModel.updateExpiry(it) },
                label = { Text("Valid Until") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(Modifier.width(8.dp))
            OutlinedTextField(
                value = cardDetails.cvv,
                onValueChange = { viewModel.updateCVV(it) },
                label = { Text("CVV") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Spacer(Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Total", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            Text("₹506.80", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { /* Payment logic */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1DA1F2)) // light blue
        ) {
            Text("PAY NOW")
            Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.padding(start = 4.dp))
        }
    }
}

@Composable
fun PaymentMethodOption(icon: Painter?, label: String, selected: Boolean, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 8.dp)
    ) {
        RadioButton(selected = selected, onClick = onClick)
        if (icon != null) {
            Icon(
                painter = icon,
                contentDescription = label,
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified // ✅ Prevents Compose from tinting the icon black
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(label)
    }
}
