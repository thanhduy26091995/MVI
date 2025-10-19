package com.densitech.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.densitech.domain.model.Note
import com.densitech.domain.usecase.note.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase
) : ViewModel() {
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    init {
        getAllNotes()
    }

    fun getAllNotes() {
        viewModelScope.launch {
            getAllNotesUseCase.invoke(Unit).collect { result ->
                result.onSuccess {
                    _notes.value = it
                }

                result.onFailure {
                    // Handle error case, e.g., log the error or update UI state
                }
            }
        }
    }
}