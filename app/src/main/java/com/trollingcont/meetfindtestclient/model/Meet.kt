package com.trollingcont.meetfindtestclient.model

import java.time.LocalDateTime

data class Meet(
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val time: String,
    val creatorUsername: String,
    val id: Int,
    val timeCreated: String
)