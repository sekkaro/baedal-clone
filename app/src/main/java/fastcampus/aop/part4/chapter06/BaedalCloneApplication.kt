package fastcampus.aop.part4.chapter06

import android.app.Application
import android.content.Context

class BaedalCloneApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
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