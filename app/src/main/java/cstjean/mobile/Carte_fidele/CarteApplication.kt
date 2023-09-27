package cstjean.mobile.Carte_fidele

import android.app.Application

class CarteApplication  : Application() {
    override fun onCreate() {
        super.onCreate()
        CarteRepository.initialize(this)
    }
}