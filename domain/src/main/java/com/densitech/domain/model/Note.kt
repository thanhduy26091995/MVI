package com.densitech.domain.model

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val timestamp: Long,
    val isSynced: Boolean,
    val isDeleted: Boolean
)