package ru.alinadorozhkina.tula_steel.entities

import ru.alinadorozhkina.tula_steel.R

interface Product {
    val name: String
    val picture: Int
}

data class ArmaturaGladkaia(
    override val name: String = "Арматура гладкая",
    override val picture: Int = R.drawable.armatura_gladkaia
) : Product

data class ArmaturaPeriodicheskaia(
    override val name: String = "Арматура периодическая",
    override val picture: Int = R.drawable.armatura_periodicheskaia
) : Product

data class UgolokRapnopolochnyi(
    override val name: String = "Уголок равнополочный",
    override val picture: Int = R.drawable.ugolok_ravnopolochnyi
) : Product

data class UgolokNerapnopolochnyi(
    override val name: String = "Уголок неравнополочный",
    override val picture: Int = R.drawable.ugolok_neravnopolochnyi
) : Product

data class Shveller(
    override val name: String = "Швеллер",
    override val picture: Int = R.drawable.shveller
) : Product

data class Dvutavra(
    override val name: String = "Двутавровая балка",
    override val picture: Int = R.drawable.dvutavrovaia_balka
) : Product

data class Krug(
    override val name: String = "Круг",
    override val picture: Int = R.drawable.krug
) : Product

data class Kvadrat(
    override val name: String = "Квадрат",
    override val picture: Int = R.drawable.kvadrat
) : Product

data class Shestigrannik(
    override val name: String = "Шестигранник",
    override val picture: Int = R.drawable.shestigrannik
) : Product

data class Polosa(
    override val name: String = "Полоса",
    override val picture: Int = R.drawable.polosa
) : Product

data class Katanka(
    override val name: String = "Катанка",
    override val picture: Int = R.drawable.katanka
) : Product

data class KvadratnaiaZagotovka(
    override val name: String = "Заготовка непрерывнолитая квадратного сечения",
    override val picture: Int = R.drawable.kvadratnaia_zagotovka
) : Product