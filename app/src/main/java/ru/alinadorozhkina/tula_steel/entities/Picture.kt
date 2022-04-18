package ru.alinadorozhkina.tula_steel.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.alinadorozhkina.tula_steel.R

interface Picture {
    val title: String
    val path: Int
}

@Parcelize
data class ProductionPlan(
    override val title: String = "Схема производства",
    override val path: Int = R.drawable.production_plan
): Picture, Parcelable

@Parcelize
data class PCD32(
    override val title: String = "Свидетельство о признании производителя РСD 32",
    override val path: Int = R.drawable.pcd32
): Picture, Parcelable