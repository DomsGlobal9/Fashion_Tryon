package com.example.dvyb.ui.viewmodel.ProductModels


import androidx.lifecycle.ViewModel

import com.example.dvyb.data.model.ProductsModels.CategoryTab
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.dvyb.data.model.ProductsModels.CategoryItem
import kotlinx.coroutines.flow.StateFlow

class CategoryViewModel : ViewModel() {
    private val _selectedTab = MutableStateFlow(CategoryTab.Women)
    val selectedTab: StateFlow<CategoryTab> = _selectedTab

    private val _selectedSubCategory = MutableStateFlow("Top Wear (16)")
    val selectedSubCategory: StateFlow<String> = _selectedSubCategory

    private val categoryMap = mapOf(
        CategoryTab.Women to listOf(
            CategoryItem("Bottom Wear (12)"),
            CategoryItem("Ethnic Wear (18)"),
            CategoryItem("Dresses & Jumpsuits (22)"),
            CategoryItem("Loungewear & Sleepwear (34)"),
            CategoryItem("Winterwear (56)"),
            CategoryItem("Active Wear (56)"),
            CategoryItem("Inner Wear (56)"),
            CategoryItem("Maternity Wear (56)")
        ),
        CategoryTab.Men to listOf(
            CategoryItem("Bottom Wear (12)"),
            CategoryItem("Ethnic Wear (18)"),
            CategoryItem("Loungewear & Innerwear (34)"),
            CategoryItem("Activewear (43)"),
            CategoryItem("Winterwear (56)")
        ),
        CategoryTab.Kids to listOf(
            CategoryItem("Girls (12)"),
            CategoryItem("Infants (18)")
        )
    )

    private val _currentCategories = MutableStateFlow(categoryMap[CategoryTab.Women] ?: emptyList())
    val currentCategories: StateFlow<List<CategoryItem>> = _currentCategories

    fun selectTab(tab: CategoryTab) {
        _selectedTab.value = tab
        _selectedSubCategory.value = when (tab) {
            CategoryTab.Women -> "Top Wear (16)"
            CategoryTab.Men -> "Top Wear (16)"
            CategoryTab.Kids -> "Boys (16)"
        }
        _currentCategories.value = categoryMap[tab] ?: emptyList()
    }
}
