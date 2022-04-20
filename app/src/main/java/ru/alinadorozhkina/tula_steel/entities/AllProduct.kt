package ru.alinadorozhkina.tula_steel.entities

import ru.alinadorozhkina.tula_steel.R

interface AppEntity {
    val title: Int
    val path: Int
}

data class ArmaturaGladkaia(
    override val title: Int = R.string.product_armatura_gladkaia,
    override val path: Int = R.drawable.armatura_gladkaia
) : AppEntity

data class ArmaturaPeriodicheskaia(
    override val title: Int = R.string.product_armatura_periodicheskaia,
    override val path: Int = R.drawable.armatura_periodicheskaia
) : AppEntity

data class UgolokRapnopolochnyi(
    override val title: Int = R.string.product_ugolok_ravnopolochnyi,
    override val path: Int = R.drawable.ugolok_ravnopolochnyi
) : AppEntity

data class UgolokNerapnopolochnyi(
    override val title: Int = R.string.product_ugolok_neravnopolochnyi,
    override val path: Int = R.drawable.ugolok_neravnopolochnyi
) : AppEntity

data class Shveller(
    override val title: Int = R.string.product_shveller,
    override val path: Int = R.drawable.shveller
) : AppEntity

data class Dvutavra(
    override val title: Int = R.string.product_dvutavrovaia_balka,
    override val path: Int = R.drawable.dvutavrovaia_balka
) : AppEntity

data class Krug(
    override val title: Int = R.string.product_krug,
    override val path: Int = R.drawable.krug
) : AppEntity

data class Kvadrat(
    override val title: Int = R.string.product_kvadrat,
    override val path: Int = R.drawable.kvadrat
) : AppEntity

data class Shestigrannik(
    override val title: Int = R.string.product_shestigrannik,
    override val path: Int = R.drawable.shestigrannik
) : AppEntity

data class Polosa(
    override val title: Int = R.string.product_polosa,
    override val path: Int = R.drawable.polosa
) : AppEntity

data class Katanka(
    override val title: Int = R.string.product_katanka,
    override val path: Int = R.drawable.katanka
) : AppEntity

data class KvadratnaiaZagotovka(
    override val title: Int = R.string.product_kvadratnaia_zagotovka,
    override val path: Int = R.drawable.kvadratnaia_zagotovka
) : AppEntity