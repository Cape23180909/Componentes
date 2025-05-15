package edu.ucne.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.ucne.componentes.ui.theme.ComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        MyBox()
                        MyRow()
                        MyColumn()
                        MyButton()
                        MyTextButton()
                        MyOutlinedButton()
                        MyIconButton()
                        MyTextField()
                        MyOutlinedTextField()
                        MyImage()
                        MyIcon()
                        MyProgressBar()
                        MyCheckBox()
                        MySwitch()
                        MyRadioButton()
                        MyDropDownMenu()
                        MyCard()
                        MyDialog()
                    }
                }
            }
        }
    }
}


@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
    }
}

@Preview
@Composable
fun MyBoxPreview() {
    ComponentesTheme {
        MyBox()
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){

    }
}

@Preview
@Composable
fun MyRowPreview() {
    ComponentesTheme {
        MyRow()
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
    }
}

@Preview
@Composable
fun MyColumnPreview() {
    ComponentesTheme {
        MyColumn()
    }
}

// 3.8: Button Components
@Composable
fun MyButton() {
    Button(onClick = { /* Do something */ }) {
        Text("My Button")
    }
}

@Preview
@Composable
fun MyButtonPreview() {
    ComponentesTheme {
        MyButton()
    }
}

@Composable
fun MyTextButton() {
    TextButton(onClick = { /* Do something */ }) {
        Text("Cancelar")
    }
}

@Preview
@Composable
fun MyTextButtonPreview() {
    ComponentesTheme {
        MyTextButton()
    }
}

@Composable
fun MyOutlinedButton() {
    OutlinedButton(onClick = { /* Do something */ }) {
        Text("Outlined Button")
    }
}

@Preview
@Composable
fun MyOutlinedButtonPreview() {
    ComponentesTheme {
        MyOutlinedButton()
    }
}

@Composable
fun MyIconButton() {
    IconButton(onClick = { /* Do something */ }) {
        Icon(Icons.Filled.Share, contentDescription = "Compartir")
    }
}

@Preview
@Composable
fun MyIconButtonPreview() {
    ComponentesTheme {
        MyIconButton()
    }
}

// 3.9: TextField Components
@Composable
fun MyTextField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Standard TextField") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun MyTextFieldPreview() {
    ComponentesTheme {
        MyTextField()
    }
}

@Composable
fun MyOutlinedTextField() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Outlined TextField") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun MyOutlinedTextFieldPreview() {
    ComponentesTheme {
        MyOutlinedTextField()
    }
}

// 3.10: Image
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = android.R.drawable.ic_dialog_info),
        contentDescription = "Info icon",
        modifier = Modifier.size(64.dp)
    )
}

@Preview
@Composable
fun MyImagePreview() {
    ComponentesTheme {
        MyImage()
    }
}

// 3.11: Icon
@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Filled.ThumbUp,
        contentDescription = "MyIcon",
        modifier = Modifier.size(64.dp)
    )
}

@Preview
@Composable
fun MyIconPreview() {
    ComponentesTheme {
        MyIcon()
    }
}

// 3.12: ProgressBar
@Composable
fun MyProgressBar() {
    Column {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator()
    }
}

@Preview
@Composable
fun MyProgressBarPreview() {
    ComponentesTheme {
        MyProgressBar()
    }
}

// 3.13: CheckBox
@Composable
fun MyCheckBox() {
    var acepto by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = acepto,
            onCheckedChange = { acepto = !acepto }
        )
        Text("Acepto el reto jetpack Compose", modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview
@Composable
fun MyCheckBoxPreview() {
    ComponentesTheme {
        MyCheckBox()
    }
}

// 3.14: Switch
@Composable
fun MySwitch() {
    var acepto by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = acepto,
            onCheckedChange = { acepto = !acepto }
        )
        Text("Switch option", modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview
@Composable
fun MySwitchPreview() {
    ComponentesTheme {
        MySwitch()
    }
}

// 3.15: RadioButton
@Composable
fun MyRadioButton() {
    val opciones = listOf("Todos", "Hombres", "Mujeres") // Cambiado ListOf por listOf
    var seleccionado by remember {
        mutableStateOf("")
    }

    Column { // Añadido Column como contenedor principal
        opciones.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp) // Añadido padding
            ) {
                RadioButton(
                    selected = (item == seleccionado),
                    onClick = { seleccionado = item }
                )
                Text(
                    text = item, // Corregido el doble "text ="
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun MyRadioButtonPreview() {
    ComponentesTheme {
        MyRadioButton()
    }
}

// 3.16: DropDownMenu
@Composable
fun MyDropDownMenu() {
    val cities = listOf("Santo Domingo", "Santiago", "La Vega", "Puerto Plata")
    var selectedCity by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selectedCity,
            onValueChange = { selectedCity = it },
            label = { Text("City") },
            trailingIcon = {
                Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
            },
            readOnly = true,
            enabled = false,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            cities.forEach { city ->
                DropdownMenuItem(
                    text = { Text(city) },
                    onClick = {
                        selectedCity = city
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun MyDropDownMenuPreview() {
    ComponentesTheme {
        MyDropDownMenu()
    }
}

// 3.17: Card
@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Card Title", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text("This is the content inside the card component.")
        }
    }
}

@Preview
@Composable
fun MyCardPreview() {
    ComponentesTheme {
        MyCard()
    }
}

// 3.18: Dialog
@Composable
fun MyDialog() {
    var dialogVisible by remember { mutableStateOf(true) }

    if (dialogVisible) {
        AlertDialog(
            onDismissRequest = { dialogVisible = false },
            title = { Text(text = "Title's set Dialog") },
            text = {
                Text("Signed one deses aside de la aplicación")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        dialogVisible = false
                    }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        dialogVisible = false
                    }
                ) {
                    Text("Enseñar")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyDialogPreview() {
    ComponentesTheme {
        MyDialog()
    }
}