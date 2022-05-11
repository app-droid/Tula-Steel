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
data class All(
    override val id: Int = 0,
    override val title: Int = R.string.our_prodaction,
    override val path: Int = R.string.title_body_text,
    val products: List<Product> = listOf(
        Product(
            itemLayoutId = R.layout.kvadratnaia_zagotovka_include_layout,
            title = R.string.Tovarnaia_zagotovka_title,
            description = R.string.Tovarnaia_zagotovka_description,
            picture = R.drawable.tovarnaia_zagotovka,
            marochnyiAssortiment = R.string.Tovarnaia_zagotovka_marochnyi_assortiment,
            upakovka = R.string.Tovarnaia_zagotovka_upakovki),
        Product(
            itemLayoutId =R.layout.katanka_include_layout,
            picture = R.drawable.katanka_pic,
            title = R.string.Katanka_title,
            description = R.string.Katanka_description,
            upakovka = R.string.Katanka_upakovki),
        Product(
            picture = R.drawable.krug_picture,
            title = R.string.Krug_title,
            description = R.string.Krug_description,
            upakovka = R.string.Krug_upakovki,
            marochnyiAssortiment = R.string.Krug_marochnyi_assortiment,
            itemLayoutId = R.layout.krug_include_layout),
        Product(
            picture = R.drawable.polosa_picture,
            title = R.string.Polosa_title,
            description = R.string.Polosa_description,
            upakovka = R.string.Polosa_upakovki,
            marochnyiAssortiment = R.string.Polosa_marochnyi_assortiment,
            itemLayoutId = R.layout.polosa_include_layout),
        Product(
            picture = R.drawable.shestigrannik,
            title = R.string.Shestigrannik_title,
            description = R.string.Shestigrannik_description,
            marochnyiAssortiment = R.string.Shestigrannik_marochnyi_assortiment,
            upakovka = R.string.Shestigrannik_upakovki,
            itemLayoutId = R.layout.shestigrannik_include_layout
        ),
        Product(
            picture = R.drawable.kvadrat,
            title = R.string.Kvadrat_title,
            marochnyiAssortiment = R.string.Kvadrat_marochnyi_assortiment,
            upakovka = R.string.Kvadrat_upakovki,
            itemLayoutId = R.layout.kvadrat_include_layout,
            description = null),
        Product(
            itemLayoutId = R.layout.armatura_prutki_include_layout,
            title = R.string.Armatura_prutki_title,
            description = R.string.Armatura_prutki_description,
            upakovka = R.string.Armatura_prutki_upakovki,
            picture = R.drawable.armatura_prutki_picture),
        Product(
            itemLayoutId = R.layout.armatura_motki_include_layout,
            picture = R.drawable.armatura_motki_picture,
            title = R.string.Armatura_motki_title,
            description = R.string.Armatura_motki_description,
            upakovka = R.string.Armatura_motki_upakovki),
        Product(
            itemLayoutId = R.layout.shveller_include_layout,
            picture = R.drawable.product_shveller,
            title = R.string.shveller_title,
            description = R.string.shveller_description,
            upakovka = R.string.shveller_upakovki,
            marochnyiAssortiment = R.string.shveller_marki),
        Product(
            itemLayoutId = R.layout.ugolok_ravnopolochnyi_include_layout,
            picture = R.drawable.ugolok_ravnopolochnyi_pic,
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

data class TovarnaiaZagotovka(
    override val id: Int = 1,
    override val title: Int = R.string.category_tovarnaia_zagotovka,
    override val path: Int = R.drawable.tovarnaia_zagotovka_main_picture,
    val products: List<Product> = listOf(
        Product(
            itemLayoutId = R.layout.kvadratnaia_zagotovka_include_layout,
            title = R.string.Tovarnaia_zagotovka_title,
            description = R.string.Tovarnaia_zagotovka_description,
            picture = R.drawable.tovarnaia_zagotovka,
            marochnyiAssortiment = R.string.Tovarnaia_zagotovka_marochnyi_assortiment,
            upakovka = R.string.Tovarnaia_zagotovka_upakovki)
    )
) : AppEntity

@Parcelize
data class Katanka(
    override val id: Int = 2,
    override val title: Int = R.string.category_katanka,
    override val path: Int = R.drawable.katanka_main_category,
    val products: List<Product> = listOf(
        Product(
            itemLayoutId =R.layout.katanka_include_layout,
            picture = R.drawable.katanka_pic,
            title = R.string.Katanka_title,
            description = R.string.Katanka_description,
            upakovka = R.string.Katanka_upakovki)
    )
) : AppEntity, Parcelable

@Parcelize
data class SortovoiProkat(
    override val id: Int = 3,
    override val title: Int = R.string.category_sortovoi_prokat,
    override val path: Int = R.drawable.sortovoi_prokat_main_category,
    val products: List<Product> = listOf(
        Product(
            picture = R.drawable.krug_picture,
            title = R.string.Krug_title,
            description = R.string.Krug_description,
            upakovka = R.string.Krug_upakovki,
            marochnyiAssortiment = R.string.Krug_marochnyi_assortiment,
            itemLayoutId = R.layout.krug_include_layout),
        Product(
            picture = R.drawable.polosa_picture,
            title = R.string.Polosa_title,
            description = R.string.Polosa_description,
            upakovka = R.string.Polosa_upakovki,
            marochnyiAssortiment = R.string.Polosa_marochnyi_assortiment,
            itemLayoutId = R.layout.polosa_include_layout),
        Product(
            picture = R.drawable.shestigrannik,
            title = R.string.Shestigrannik_title,
            description = R.string.Shestigrannik_description,
            marochnyiAssortiment = R.string.Shestigrannik_marochnyi_assortiment,
            upakovka = R.string.Shestigrannik_upakovki,
            itemLayoutId = R.layout.shestigrannik_include_layout
        ),
        Product(
            picture = R.drawable.kvadrat,
            title = R.string.Kvadrat_title,
            marochnyiAssortiment = R.string.Kvadrat_marochnyi_assortiment,
            upakovka = R.string.Kvadrat_upakovki,
            itemLayoutId = R.layout.kvadrat_include_layout,
            description = null
        )
    )
) : AppEntity, Parcelable

@Parcelize
data class ArmaturnyiProkat(
    override val id: Int = 4,
    override val title: Int = R.string.category_armaturnyi_prokat,
    override val path: Int = R.drawable.armaturnyi_prokat_main_category,
    val products: List<Product> = listOf(
        Product(
            itemLayoutId = R.layout.armatura_prutki_include_layout,
            title = R.string.Armatura_prutki_title,
            description = R.string.Armatura_prutki_description,
            upakovka = R.string.Armatura_prutki_upakovki,
            picture = R.drawable.armatura_prutki_picture),
        Product(
            itemLayoutId = R.layout.armatura_motki_include_layout,
            picture = R.drawable.armatura_motki_picture,
            title = R.string.Armatura_motki_title,
            description = R.string.Armatura_motki_description,
            upakovka = R.string.Armatura_motki_upakovki)
    )
) : AppEntity, Parcelable

@Parcelize
data class FasonnyiProkat(
    override val id: Int = 5,
    override val title: Int = R.string.category_fasonnyi_prokat,
    override val path: Int = R.drawable.fasonnyi_prokat_main_category,
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
            picture = R.drawable.ugolok_ravnopolochnyi_pic,
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
