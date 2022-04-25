package ru.alinadorozhkina.tula_steel.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.alinadorozhkina.tula_steel.R

interface AppEntity {
    val id: Int
    val title: Int
    val path: Int
}

@Parcelize
data class Product (
    val picture: Int,
    val title: Int,
    val description: Int? = null,
    val itemLayoutId: Int,
    val marochnyiAssortiment: Int? = null,
    val upakovka: Int
): Parcelable



@Parcelize
data class Title(
    override val id: Int = 0,
    override val title: Int = R.string.our_prodaction,
    override val path: Int = R.string.title_body_text,
) : AppEntity, Parcelable


data class TovarnaiaZagotovka(
    override val id: Int = 1,
    override val title: Int = R.string.category_tovarnaia_zagotovka,
    override val path: Int = R.drawable.category_tovarnaia_zagotovka,

) : AppEntity

@Parcelize
data class Katanka_(
    override val id: Int = 2,
    override val title: Int = R.string.category_katanka,
    override val path: Int = R.drawable.category_katanka,
) : AppEntity, Parcelable

@Parcelize
data class SortovoiProkat(
    override val id: Int = 3,
    override val title: Int = R.string.category_sortovoi_prokat,
    override val path: Int = R.drawable.category_sortovoi_prokat,
) : AppEntity, Parcelable

@Parcelize
data class ArmaturnyiProkat(
    override val id: Int = 4,
    override val title: Int = R.string.category_armaturnyi_prokat,
    override val path: Int = R.drawable.category_armaturnyi_prokat,
) : AppEntity, Parcelable

@Parcelize
data class FasonnyiProkat(
    override val id: Int = 5,
    override val title: Int = R.string.category_fasonnyi_prokat,
    override val path: Int = R.drawable.category_fasonnyi_prokat,
    val products: List<Product> = listOf(
        Product(
            itemLayoutId = R.layout.shveller_include_layout,
            picture = R.drawable.product_shveller,
            title = R.string.shveller_title,
            description = R.string.shveller_description,
            upakovka = R.string.shveller_upakovki,
            marochnyiAssortiment = R.string.shveller_marki),
        Product(
            itemLayoutId = R.layout.ugolok_ravnopolochnyi_include_layout,
            picture = R.drawable.ugolok_ravnopolochnyi,
            title = R.string.Ugolok_ravnopolochnyi_title,
            description = R.string.Ugolok_ravnopolochnyi_description,
            upakovka = R.string.Ugolok_ravnopolochnyi_upakovki,
            marochnyiAssortiment = R.string.Ugolok_ravnopolochnyi_marochnyi_assortiment),
        Product(
            itemLayoutId = R.layout.ugolok_neravnopolochnyi_include_layout,
            picture = R.drawable.ugolok_neravnopolochnyi,
            title = R.string.Ugolok_neravnopolochnyi_title,
            description = R.string.Ugolok_neravnopolochnyi_description,
            upakovka = R.string.Ugolok_neravnopolochnyi_upakovki,
            marochnyiAssortiment = R.string.Ugolok_neravnopolochnyi_marochnyi_assortiment),
        Product(
            itemLayoutId = R.layout.dvutavrovaia_balka_include_layout,
            picture = R.drawable.dvutavrovaia_balka,
            title = R.string.Dvutavrovaia_balka_title,
            description = R.string.Dvutavrovaia_balka_description,
            upakovka = R.string.Dvutavrovaia_balka_upakovki,
            marochnyiAssortiment = R.string.Dvutavrovaia_balka_marochnyi_assortiment
        )
    )
) : AppEntity, Parcelable


//data class ArmaturaGladkaia(
//    override val title: Int = R.string.product_armatura_gladkaia,
//    override val path: Int = R.drawable.armatura_gladkaia
//) : AppEntity
//
//data class ArmaturaPeriodicheskaia(
//    override val title: Int = R.string.product_armatura_periodicheskaia,
//    override val path: Int = R.drawable.armatura_periodicheskaia
//) : AppEntity
//
//data class UgolokRapnopolochnyi(
//    override val title: Int = R.string.product_ugolok_ravnopolochnyi,
//    override val path: Int = R.drawable.ugolok_ravnopolochnyi
//) : AppEntity
//
//data class UgolokNerapnopolochnyi(
//    override val title: Int = R.string.product_ugolok_neravnopolochnyi,
//    override val path: Int = R.drawable.ugolok_neravnopolochnyi
//) : AppEntity
//
//data class Shveller(
//    override val title: Int = R.string.product_shveller,
//    override val path: Int = R.drawable.shveller
//) : AppEntity
//
//data class Dvutavra(
//    override val title: Int = R.string.product_dvutavrovaia_balka,
//    override val path: Int = R.drawable.dvutavrovaia_balka
//) : AppEntity
//
//data class Krug(
//    override val title: Int = R.string.product_krug,
//    override val path: Int = R.drawable.krug
//) : AppEntity
//
//data class Kvadrat(
//    override val title: Int = R.string.product_kvadrat,
//    override val path: Int = R.drawable.kvadrat
//) : AppEntity
//
//data class Shestigrannik(
//    override val title: Int = R.string.product_shestigrannik,
//    override val path: Int = R.drawable.shestigrannik
//) : AppEntity
//
//data class Polosa(
//    override val title: Int = R.string.product_polosa,
//    override val path: Int = R.drawable.polosa
//) : AppEntity
//
//data class Katanka(
//    override val title: Int = R.string.product_katanka,
//    override val path: Int = R.drawable.katanka
//) : AppEntity
//
//data class KvadratnaiaZagotovka(
//    override val title: Int = R.string.product_kvadratnaia_zagotovka,
//    override val path: Int = R.drawable.kvadratnaia_zagotovka
//) : AppEntity