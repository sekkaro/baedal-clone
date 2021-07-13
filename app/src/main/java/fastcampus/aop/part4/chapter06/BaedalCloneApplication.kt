package fastcampus.aop.part4.chapter06

import android.app.Application
import android.content.Context
import fastcampus.aop.part4.chapter06.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaedalCloneApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this

        startKoin {
            androidContext(appContext as BaedalCloneApplication)
            modules(appModule)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        appContext = null
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}