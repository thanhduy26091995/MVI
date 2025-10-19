package com.densitech.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "notes")
@Serializable
data class NoteEntity(
    @PrimaryKey
    @SerialName("note_id")
    val id: String,

    @SerialName("note_title")
    val title: String,

    @SerialName("note_content")
    val content: String,

    @SerialName("note_timestamp")
    val timestamp: Long,

    @SerialName("is_deleted")
    val isDeleted: Boolean,

    @SerialName("is_synced")
    val isSynced: Boolean
)
