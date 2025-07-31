package com.example.dvyb.ui.screens.profile


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Help
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

// Data classes for better structure
data class BankDetailsState(
    val selectedBank: String = "",
    val branchName: String = "",
    val accountHolderName: String = "",
    val accountNumber: String = "",
    val confirmAccountNumber: String = "",
    val ifscCode: String = ""
)

data class ValidationErrors(
    val bankError: String? = null,
    val branchError: String? = null,
    val accountHolderError: String? = null,
    val accountNumberError: String? = null,
    val confirmAccountNumberError: String? = null,
    val ifscError: String? = null
) {
    val hasErrors: Boolean
        get() = listOfNotNull(bankError, branchError, accountHolderError,
            accountNumberError, confirmAccountNumberError, ifscError).isNotEmpty()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterBankDetailsScreen(
    onNext: (BankDetailsState) -> Unit,
    onHelp: () -> Unit
) {
    var bankDetailsState by remember { mutableStateOf(BankDetailsState()) }
    var validationErrors by remember { mutableStateOf(ValidationErrors()) }
    var isBankDropdownExpanded by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = com.example.dvyb.R.drawable.loginbg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            BankDetailsCard(
                bankDetailsState = bankDetailsState,
                validationErrors = validationErrors,
                isBankDropdownExpanded = isBankDropdownExpanded,
                isLoading = isLoading,
                onStateChange = { bankDetailsState = it },
                onValidationChange = { validationErrors = it },
                onBankDropdownExpandedChange = { isBankDropdownExpanded = it },
                onNext = { state ->
                    val errors = validateBankDetails(state)
                    validationErrors = errors

                    if (!errors.hasErrors) {
                        isLoading = true
                        // Simulate API call
                        coroutineScope.launch {
                            try {
                                kotlinx.coroutines.delay(2000) // Simulate network delay
                                onNext(state)
                            } catch (e: Exception) {
                                snackbarHostState.showSnackbar(
                                    message = "Failed to save bank details. Please try again.",
                                    actionLabel = "Retry"
                                )
                            } finally {
                                isLoading = false
                            }
                        }
                    }
                },
                onHelp = onHelp
            )
        }

        // Snackbar
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun BankDetailsCard(
    bankDetailsState: BankDetailsState,
    validationErrors: ValidationErrors,
    isBankDropdownExpanded: Boolean,
    isLoading: Boolean,
    onStateChange: (BankDetailsState) -> Unit,
    onValidationChange: (ValidationErrors) -> Unit,
    onBankDropdownExpandedChange: (Boolean) -> Unit,
    onNext: (BankDetailsState) -> Unit,
    onHelp: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(650.dp)
            .padding(1.dp),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoSection()
            Spacer(modifier = Modifier.height(8.dp))
            ProgressIndicator(currentStep = 3)
            Spacer(modifier = Modifier.height(24.dp))
            StepIndicator(stepNumber = "3", stepTitle = "Bank details")
            Spacer(modifier = Modifier.height(20.dp))

            BankDetailsFields(
                bankDetailsState = bankDetailsState,
                validationErrors = validationErrors,
                isBankDropdownExpanded = isBankDropdownExpanded,
                onStateChange = onStateChange,
                onValidationChange = onValidationChange,
                onBankDropdownExpandedChange = onBankDropdownExpandedChange
            )

            Spacer(modifier = Modifier.height(24.dp))
            NextButton(
                isEnabled = !validationErrors.hasErrors && bankDetailsState.selectedBank.isNotEmpty(),
                isLoading = isLoading,
                onClick = { onNext(bankDetailsState) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            HelpSection(onClick = onHelp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BankDetailsFields(
    bankDetailsState: BankDetailsState,
    validationErrors: ValidationErrors,
    isBankDropdownExpanded: Boolean,
    onStateChange: (BankDetailsState) -> Unit,
    onValidationChange: (ValidationErrors) -> Unit,
    onBankDropdownExpandedChange: (Boolean) -> Unit
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Bank Selection Dropdown
        ExposedDropdownMenuBox(
            expanded = isBankDropdownExpanded,
            onExpandedChange = onBankDropdownExpandedChange
        ) {
            OutlinedTextField(
                value = bankDetailsState.selectedBank,
                onValueChange = {},
                readOnly = true,
                label = { Text("Bank Name") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isBankDropdownExpanded)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF5DADE2),
                    focusedLabelColor = Color(0xFF5DADE2)
                ),
                isError = validationErrors.bankError != null,
                supportingText = validationErrors.bankError?.let {
                    { ErrorText(text = it) }
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )

            ExposedDropdownMenu(
                expanded = isBankDropdownExpanded,
                onDismissRequest = { onBankDropdownExpandedChange(false) }
            ) {
                getBankList().forEach { bank ->
                    DropdownMenuItem(
                        text = { Text(bank) },
                        onClick = {
                            onStateChange(bankDetailsState.copy(selectedBank = bank))
                            onBankDropdownExpandedChange(false)
                            // Clear bank error when selection is made
                            onValidationChange(validationErrors.copy(bankError = null))
                        }
                    )
                }
            }
        }

        // Branch Name
        OutlinedTextField(
            value = bankDetailsState.branchName,
            onValueChange = {
                onStateChange(bankDetailsState.copy(branchName = it))
                // Clear error on input
                if (validationErrors.branchError != null) {
                    onValidationChange(validationErrors.copy(branchError = null))
                }
            },
            label = { Text("Branch Name") },
            placeholder = { Text("Enter branch name") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF0BA4E0),
                focusedLabelColor = Color(0xFF5DADE2)
            ),
            isError = validationErrors.branchError != null,
            supportingText = validationErrors.branchError?.let {
                { ErrorText(text = it) }
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // Account Holder Name
        OutlinedTextField(
            value = bankDetailsState.accountHolderName,
            onValueChange = {
                onStateChange(bankDetailsState.copy(accountHolderName = it))
                if (validationErrors.accountHolderError != null) {
                    onValidationChange(validationErrors.copy(accountHolderError = null))
                }
            },
            label = { Text("Account Holder Name") },
            placeholder = { Text("Enter full name as per bank records") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF5DADE2),
                focusedLabelColor = Color(0xFF5DADE2)
            ),
            isError = validationErrors.accountHolderError != null,
            supportingText = validationErrors.accountHolderError?.let {
                { ErrorText(text = it) }
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // Account Number
        OutlinedTextField(
            value = bankDetailsState.accountNumber,
            onValueChange = { input ->
                // Only allow digits and limit length
                val filtered = input.filter { it.isDigit() }.take(20)
                onStateChange(bankDetailsState.copy(accountNumber = filtered))
                if (validationErrors.accountNumberError != null) {
                    onValidationChange(validationErrors.copy(accountNumberError = null))
                }
            },
            label = { Text("Account Number") },
            placeholder = { Text("Enter account number") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF5DADE2),
                focusedLabelColor = Color(0xFF5DADE2)
            ),
            isError = validationErrors.accountNumberError != null,
            supportingText = validationErrors.accountNumberError?.let {
                { ErrorText(text = it) }
            } ?: { Text("Enter your bank account number", color = Color.Gray) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // Confirm Account Number
        OutlinedTextField(
            value = bankDetailsState.confirmAccountNumber,
            onValueChange = { input ->
                val filtered = input.filter { it.isDigit() }.take(20)
                onStateChange(bankDetailsState.copy(confirmAccountNumber = filtered))
                if (validationErrors.confirmAccountNumberError != null) {
                    onValidationChange(validationErrors.copy(confirmAccountNumberError = null))
                }
            },
            label = { Text("Confirm Account Number") },
            placeholder = { Text("Re-enter account number") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (bankDetailsState.accountNumber == bankDetailsState.confirmAccountNumber &&
                    bankDetailsState.confirmAccountNumber.isNotEmpty()) Color(0xFF4CAF50) else Color(0xFF5DADE2),
                focusedLabelColor = Color(0xFF5DADE2)
            ),
            isError = validationErrors.confirmAccountNumberError != null,
            supportingText = validationErrors.confirmAccountNumberError?.let {
                { ErrorText(text = it) }
            } ?: if (bankDetailsState.confirmAccountNumber.isNotEmpty()) {
                if (bankDetailsState.accountNumber == bankDetailsState.confirmAccountNumber) {
                    { Text("✓ Account numbers match", color = Color(0xFF4CAF50)) }
                } else {
                    { Text("Account numbers don't match", color = Color(0xFFFF5722)) }
                }
            } else null,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // IFSC Code
        OutlinedTextField(
            value = bankDetailsState.ifscCode,
            onValueChange = { input ->
                // IFSC format: 4 letters + 7 digits
                val filtered = input.uppercase().take(11)
                onStateChange(bankDetailsState.copy(ifscCode = filtered))
                if (validationErrors.ifscError != null) {
                    onValidationChange(validationErrors.copy(ifscError = null))
                }
            },
            label = { Text("IFSC Code") },
            placeholder = { Text("e.g., SBIN0001234") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF5DADE2),
                focusedLabelColor = Color(0xFF5DADE2)
            ),
            isError = validationErrors.ifscError != null,
            supportingText = validationErrors.ifscError?.let {
                { ErrorText(text = it) }
            } ?: { Text("11-character bank code", color = Color.Gray) },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun ErrorText(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Error,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun LogoSection() {
    Box(
        modifier = Modifier.size(48.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = com.example.dvyb.R.drawable.logo),
            contentDescription = "App Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Register",
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF2C3E50)
    )
}

@Composable
private fun ProgressIndicator(currentStep: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(4) { index ->
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(4.dp)
                    .background(
                        if (index < currentStep) Color(0xFF5DADE2) else Color(0xFFE0E0E0),
                        RoundedCornerShape(2.dp)
                    )
            )
            if (index < 3) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
private fun StepIndicator(stepNumber: String, stepTitle: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(Color(0xFF5DADE2), RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stepNumber,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = stepTitle,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF2C3E50)
        )
    }
}

@Composable
private fun NextButton(
    isEnabled: Boolean,
    isLoading: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = isEnabled && !isLoading,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF5DADE2),
            disabledContainerColor = Color(0xFFE0E0E0)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = Color.White,
                strokeWidth = 2.dp
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Next",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
private fun HelpSection(onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Need help",
                fontSize = 14.sp,
                color = Color(0xFF666666)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.Help,
                contentDescription = "Help",
                tint = Color(0xFF666666),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

// Utility Functions
private fun getBankList(): List<String> = listOf(
    "State Bank of India",
    "HDFC Bank",
    "ICICI Bank",
    "Punjab National Bank",
    "Bank of Baroda",
    "Canara Bank",
    "Union Bank of India",
    "Axis Bank",
    "Bank of India",
    "Indian Bank",
    "Central Bank of India",
    "Indian Overseas Bank",
    "UCO Bank",
    "Punjab & Sind Bank",
    "Bank of Maharashtra"
)

private fun validateBankDetails(state: BankDetailsState): ValidationErrors {
    return ValidationErrors(
        bankError = if (state.selectedBank.isEmpty()) "Please select a bank" else null,
        branchError = when {
            state.branchName.isEmpty() -> "Branch name is required"
            state.branchName.length < 2 -> "Branch name must be at least 2 characters"
            else -> null
        },
        accountHolderError = when {
            state.accountHolderName.isEmpty() -> "Account holder name is required"
            state.accountHolderName.length < 2 -> "Name must be at least 2 characters"
            !state.accountHolderName.matches(Regex("^[a-zA-Z\\s.]+$")) -> "Name can only contain letters, spaces, and dots"
            else -> null
        },
        accountNumberError = when {
            state.accountNumber.isEmpty() -> "Account number is required"
            state.accountNumber.length < 9 -> "Account number must be at least 9 digits"
            state.accountNumber.length > 18 -> "Account number cannot exceed 18 digits"
            else -> null
        },
        confirmAccountNumberError = when {
            state.confirmAccountNumber.isEmpty() -> "Please confirm your account number"
            state.accountNumber != state.confirmAccountNumber -> "Account numbers don't match"
            else -> null
        },
        ifscError = when {
            state.ifscCode.isEmpty() -> "IFSC code is required"
            !state.ifscCode.matches(Regex("^[A-Z]{4}0[A-Z0-9]{6}$")) -> "Invalid IFSC format (e.g., SBIN0001234)"
            else -> null
        }
    )
}