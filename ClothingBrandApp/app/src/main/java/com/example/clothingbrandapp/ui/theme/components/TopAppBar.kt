package com.example.clothingbrandapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.clothingbrandapp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavbarWithDrawer(
    onCartClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val expandedCategory = remember { mutableStateOf(false) }
    val expandedFilter = remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.fillMaxHeight().verticalScroll(rememberScrollState())) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Main Menu",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                DrawerItem("🏠 Home")
                DrawerItem("👗 Try On with Model")

                // 🔽 Category Expandable
                ExpandableDrawerItem(
                    title = "🧺 Category",
                    expanded = expandedCategory.value,
                    onToggle = { expandedCategory.value = !expandedCategory.value },
                    subItems = listOf("Women", "Men", "Kids", "Infants", "Accessories")
                )

                // 🔽 Filter Expandable
                ExpandableDrawerItem(
                    title = "🧹 Filter",
                    expanded = expandedFilter.value,
                    onToggle = { expandedFilter.value = !expandedFilter.value },
                    subItems = listOf("Price", "Sort: Low to High", "Sort: High to Low")
                )

                DrawerItem("👤 Profile")
                DrawerItem("📸 Album")
                DrawerItem("🎥 Vlogs")
                DrawerItem("⚙️ Settings")
            }
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        navigationIcon = {
                            IconButton(onClick = {
                                onMenuClick()
                                scope.launch { drawerState.open() }
                            }) {
                                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
                            }
                        },
                        title = {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.vy),
                                    contentDescription = "App Logo",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .height(70.dp)
                                        .padding(4.dp)
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = onCartClick) {
                                Icon(
                                    Icons.Default.ShoppingCart,
                                    contentDescription = "Cart",
                                    tint = Color.Black
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.White
                        )
                    )
                },
                content = content
            )
        }
    )
}

@Composable
fun DrawerItem(text: String, onClick: () -> Unit = { println("$text clicked") }) {
    NavigationDrawerItem(
        label = { Text(text) },
        selected = false,
        onClick = onClick,
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
}

@Composable
fun ExpandableDrawerItem(
    title: String,
    expanded: Boolean,
    onToggle: () -> Unit,
    subItems: List<String>
) {
    NavigationDrawerItem(
        label = { Text(title) },
        selected = expanded,
        onClick = onToggle,
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
    if (expanded) {
        subItems.forEach { subItem ->
            NavigationDrawerItem(
                label = { Text(text = "   ↪ $subItem") },
                selected = false,
                onClick = { println("$subItem selected") },
                modifier = Modifier.padding(start = 32.dp)
            )
        }
    }
}




































//package com.example.clothingbrandapp.ui.components
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material.icons.filled.ShoppingCart
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import com.example.clothingbrandapp.R
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TopNavbarWithDrawer(
//    onCartClick: () -> Unit = {},
//    onMenuClick: () -> Unit = {},
//    content: @Composable (PaddingValues) -> Unit
//) {
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//














//    val menuItems = listOf("Women", "Men", "Kids", "Infants", "Accessories")
//    var selectedMenu by remember { mutableStateOf("Home") }
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            ModalDrawerSheet {
//                Spacer(modifier = Modifier.height(16.dp))
//                Text(
//                    text = "Categories",
//                    style = MaterialTheme.typography.titleMedium,
//                    modifier = Modifier.padding(start = 16.dp)
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                menuItems.forEach { item ->
//                    NavigationDrawerItem(
//                        label = { Text(text = item) },
//                        selected = selectedMenu == item,
//                        onClick = {
//                            selectedMenu = item
//                            scope.launch { drawerState.close() }
//                            println("$item selected")
//                        },
//                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
//                    )
//                }
//            }
//        },
//        content = {
//            Scaffold(
//                topBar = {
//                    TopAppBar(
//                        navigationIcon = {
//                            IconButton(onClick = {
//                                onMenuClick()
//                                scope.launch { drawerState.open() }
//                            }) {
//                                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.Black)
//                            }
//                        },
//                        title = {
//                            Box(
//                                modifier = Modifier.fillMaxWidth(),
//                                contentAlignment = Alignment.Center
//                            ) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.logo),
//                                    contentDescription = "App Logo",
//                                    contentScale = ContentScale.Fit,
//                                    modifier = Modifier
//                                        .height(70.dp)
//                                        .padding(4.dp)
//                                )
//                            }
//                        },
//                        actions = {
//                            IconButton(onClick = onCartClick) {
//                                Icon(
//                                    Icons.Default.ShoppingCart,
//                                    contentDescription = "Cart",
//                                    tint = Color.Black
//                                )
//                            }
//                        },
//                        colors = TopAppBarDefaults.topAppBarColors(
//                            containerColor = Color.White
//                        )
//                    )
//                },
//                content = content
//            )
//        }
//    )
//}
