package br.com.fiap.statehosting.juros

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.statehosting.calculos.calcularJuros
import br.com.fiap.statehosting.calculos.calcularMontante
import br.com.fiap.statehosting.components.CaixaDeEntrada
import br.com.fiap.statehosting.components.CardResultado

@Composable
fun JurosScreen(jurosScreenViewModel: JurosScreenViewModel) {

    ///var capital by remember { mutableStateOf("") }
    val capital by jurosScreenViewModel.capital.observeAsState(initial = "")

    //var taxa by remember { mutableStateOf("") }
    val taxa by jurosScreenViewModel.taxa.observeAsState(initial = "")

    //var tempo by remember { mutableStateOf("") }
    val tempo by jurosScreenViewModel.tempo.observeAsState(initial = "")

    //var juros by remember { mutableStateOf(0.0) }

    val juros by jurosScreenViewModel.juros.observeAsState(initial = 0.0)

    //var montante by remember { mutableStateOf(0.0) }
    val montante by jurosScreenViewModel.montante.observeAsState(initial = 0.0)

    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(
                text = "Cálculo de Juros Simples",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Formulário para entrada de dados
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Dados do Investimento",
                        fontWeight = FontWeight.Bold
                    )
                    // Caixas de entrada da aplicação
//                    OutlinedTextField(
//                        value = capital,
//                        onValueChange = { capital = it },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 16.dp),
//                        placeholder = {
//                            Text(text = "Quanto deseja investir?")
//                        },
//                        label = {
//                            Text(text = "Valor do investimento")
//                        },
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = KeyboardType.Decimal
//                        )
//                    )
                    CaixaDeEntrada(
                        label = "Valor do investimento",
                        placeholder = "Quanto deseja investir?",
                        value = capital,
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        atualizarValor = {
                            jurosScreenViewModel.onCapitalChanged(it)
                        }
                    )
                    CaixaDeEntrada(
                        label = "Taxa de juros mensal",
                        placeholder = "Qual a taxa de juros mensal?",
                        value = taxa,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        atualizarValor = {
                            jurosScreenViewModel.onTaxaChanged(it)
                        }
                    )
                    CaixaDeEntrada(
                        label = "Período em meses",
                        placeholder = "Qual o tempo em meses?",
                        value = tempo,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        atualizarValor = {
                            jurosScreenViewModel.onTempoChanged(it)
                        }
                    )
//                    OutlinedTextField(
//                        value = taxa,
//                        onValueChange = { taxa = it },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 16.dp),
//                        placeholder = {
//                            Text(text = "Qual a taxa de juros mensal?")
//                        },
//                        label = {
//                            Text(text = "Taxa de juros mensal")
//                        },
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = KeyboardType.Decimal
//                        )
//                    )
//                    OutlinedTextField(
//                        value = tempo,
//                        onValueChange = { tempo = it },
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(top = 16.dp),
//                        placeholder = {
//                            Text(text = "Qual o tempo em meses?")
//                        },
//                        label = {
//                            Text(text = "Período em meses")
//                        },
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = KeyboardType.Decimal
//                        )
//                    )
                    Button(
                        onClick = {
                            jurosScreenViewModel.calcularJurosViewModel()
                            jurosScreenViewModel.calcularMontanteViewModel()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                    ) {
                        Text(text = "CALCULAR")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Resultado da aplicação
            CardResultado(juros = juros, montante = montante)
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                colors = CardDefaults.cardColors(
//                    containerColor = Color(0xFF4CAF50)
//                )
//            ) {
//                Column(
//                    modifier = Modifier
//                        //.fillMaxSize()
//                        .padding(16.dp)
//                ) {
//                    Text(
//                        text = "Resultado",
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Row(modifier = Modifier.fillMaxWidth()) {
//                        Text(
//                            text = "Juros",
//                            modifier = Modifier.padding(end = 8.dp),
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                        Text(
//                            text = juros.toString(),
//                            modifier = Modifier.padding(end = 8.dp),
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = Color.White
//                        )
//                    }
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Row(modifier = Modifier.fillMaxWidth()) {
//                        Text(
//                            text = "Montante",
//                            modifier = Modifier.padding(end = 8.dp),
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                        Text(
//                            text = montante.toString(),
//                            modifier = Modifier.padding(end = 8.dp),
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = Color.White
//                        )
//                    }
//                }
//            }
        }
    }
}
