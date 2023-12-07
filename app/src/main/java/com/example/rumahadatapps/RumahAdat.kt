package com.example.rumahadatapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RumahAdat(
    val name: String,
    val origin: String,
    val description: String,
    val photo: Int,
    val source: String,
    val image1: String,
    val image2: String,
    val image3: String,
    val philosophy: String
): Parcelable
