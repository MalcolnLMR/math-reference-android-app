package br.com.astradev.mathreferenceapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import br.com.astradev.mathreferenceapp.ui.screens.MathReferenceNavigationGraph
import br.com.astradev.mathreferenceapp.ui.theme.mathreferenceappTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                mathreferenceappTheme {
                    MathReferenceApp()
                }
            }
        }

    @Composable
    fun MathReferenceApp(){
        MathReferenceNavigationGraph()
    }
}

