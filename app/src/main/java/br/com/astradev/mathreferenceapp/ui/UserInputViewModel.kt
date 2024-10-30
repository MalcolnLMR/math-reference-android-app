package br.com.astradev.mathreferenceapp.ui

import androidx.lifecycle.ViewModel

class UserInputViewModel : ViewModel() {

    var uiState = mutableListOf(UserInputScreenState())

}

data class UserInputScreenState(
    var nameEntered: String = "",
    var name2: String = ""
)