package br.com.smk.notes.entities

import java.util.*

data class Note(
    var title: String?,
    var subtitle: String,
    var description: String,
    var creationDate: Date,
    var icon: Int
)
