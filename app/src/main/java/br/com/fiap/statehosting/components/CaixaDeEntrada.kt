package br.com.fiap.statehosting.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CaixaDeEntrada(
    label: String,
    placeholder: String,
    value: String,
    keyboardType: KeyboardType,
    modifier: Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        modifier = modifier,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)

    )
}