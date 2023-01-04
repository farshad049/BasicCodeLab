package com.farshad.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farshad.basiccodelab.ui.theme.BasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                // A surface container using the 'background' color from the theme
                    MyApp()
            }
        }
    }
}




@Composable
fun Item(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 24.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello")
                Text(text = name)
            }  
            
            ElevatedButton(
                modifier = Modifier
                    .padding(end = 24.dp),
                onClick = {
                    expanded.value = !expanded.value
                }
            ) {
                Text(text = if (expanded.value) "show more" else "show less")
            }
        }
        
    }
}



@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    name: List<String> = listOf("taghi","naghi") ,
){
    Surface(modifier = modifier) {
        Column(
        ) {
            for (name in name){
                Item(name = name)
            }
        }
    }

}




@Preview(showBackground = true , widthDp = 320)
@Composable
fun DefaultPreview(
) {
    BasicCodelabTheme {
        MyApp(modifier = Modifier.fillMaxSize())
    }
}