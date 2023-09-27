package cstjean.mobile.Carte_fidele.classes

import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toDrawable
import cstjean.mobile.Carte_fidele.R

enum class Type(val vecteurAsset: Int) {
    RESTAURANT(R.drawable.ic_restaurant),
    DIVERTISSEMENT(R.drawable.ic_divertissement),
    EPICERIE(R.drawable.ic_epicerie)
}

