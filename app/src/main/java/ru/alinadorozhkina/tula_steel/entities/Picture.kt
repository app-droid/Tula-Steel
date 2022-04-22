package ru.alinadorozhkina.tula_steel.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.alinadorozhkina.tula_steel.R

@Parcelize
data class Picture(
    override val id: Int,
    override val title: Int,
    override val path: Int
): AppEntity, Parcelable

@Parcelize
data class ProductionPlan(
    override val id: Int = 0,
    override val title: Int = R.string.about_schema,
    override val path: Int = R.drawable.production_plan
): AppEntity, Parcelable

@Parcelize
data class PCD32(
    override val id: Int = 0,
    override val title: Int = R.string.about_РСD_32,
    override val path: Int = R.drawable.pcd32
): AppEntity, Parcelable