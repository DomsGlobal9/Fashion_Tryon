    package com.example.dvyb.ui.viewmodel

    import androidx.compose.runtime.mutableStateOf
    import androidx.lifecycle.ViewModel
    import com.example.dvyb.data.model.ShopdetailsInfo

    class ShopInfoViewModel : ViewModel() {
        var shopdetailsInfo = mutableStateOf(ShopdetailsInfo())
            private set

        fun updateShopname(value: String) { shopdetailsInfo.value = shopdetailsInfo.value.copy(Shopname = value) }
        fun updateShopGSTINnum(value: String) { shopdetailsInfo.value = shopdetailsInfo.value.copy(GSTINnum = value) }
        fun updateShopPANnum(value: String) { shopdetailsInfo.value = shopdetailsInfo.value.copy(PANnum = value) }
        fun updateShopAddress(value: String) { shopdetailsInfo.value = shopdetailsInfo.value.copy(Address = value) }
        fun updateShopPINcode(value: String) { shopdetailsInfo.value = shopdetailsInfo.value.copy(PINcode = value) }
        fun updateShopBusinessType(value: String) { shopdetailsInfo.value = shopdetailsInfo.value.copy(BusinessType = value) }
    }
