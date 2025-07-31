package com.example.clothingbrandapp.ui.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.clothingbrandapp.R
import androidx.compose.ui.text.input.PasswordVisualTransformation // ✅ ADD THIS
import androidx.compose.ui.text.input.VisualTransformation         // ✅ AND THIS

@Composable
fun SignUpScreen(navController: NavController) {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.vy),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("Sign Up", fontSize = 26.sp, color = Color.Black)
        Text("Hello there, sign up to continue.", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        RoundedTextField("Full Name", name) { name = it }
        RoundedTextField("Email", email, KeyboardType.Email) { email = it }
        RoundedTextField("Address", address) { address = it }
        RoundedTextField("Password", password, KeyboardType.Password, isPassword = true) { password = it }
        RoundedTextField("Confirm Password", confirmPassword, KeyboardType.Password, isPassword = true) { confirmPassword = it }

        Button(
            onClick = {
                saveUserLocally(context, name, email, address)
                navController.navigate("kyc")
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("OR", color = Color.Gray)
        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.google), contentDescription = null, modifier = Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.facebook), contentDescription = null, modifier = Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.x), contentDescription = null, modifier = Modifier.size(40.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("By continuing you confirm that you agree\nwith our Terms & Conditions", color = Color.Gray, fontSize = 12.sp)
    }
}

@Composable
fun RoundedTextField(
    label: String,
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        singleLine = true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

fun saveUserLocally(context: Context, name: String, email: String, address: String) {
    val sharedPrefs = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    with(sharedPrefs.edit()) {
        putString("userName", name)
        putString("userEmail", email)
        putString("userAddress", address)
        apply()
    }
}
