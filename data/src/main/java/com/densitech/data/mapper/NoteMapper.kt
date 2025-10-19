package com.densitech.data.mapper

import com.densitech.data.model.entity.NoteEntity
import com.densitech.domain.model.Note

object NoteMapper {
    fun NoteEntity.toDomainModel() = com.densitech.domain.model.Note(
        id = this.id,
        title = this.title,
        content = this.content,
        timestamp = this.timestamp,
        isSynced = this.isSynced,
        isDeleted = this.isDeleted
    )

    fun Note.toEntity() = NoteEntity(
        id = this.id,
        title = this.title,
        content = this.content,
        timestamp = this.timestamp,
        isSynced = this.isSynced,
        isDeleted = this.isDeleted
    )
}