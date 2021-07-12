package fastcampus.aop.part4.chapter06.di

import fastcampus.aop.part4.chapter06.screen.main.home.HomeViewModel
import fastcampus.aop.part4.chapter06.screen.main.my.MyViewModel
import fastcampus.aop.part4.chapter06.util.provider.DefaultResourcesProvider
import fastcampus.aop.part4.chapter06.util.provider.ResourcesProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { HomeViewModel() }
    viewModel { MyViewModel() }

    single { provideGsonConvertFactory() }
    single { buildOkHttpClient() }

    single { provideRetrofit(get(), get()) }

    single<ResourcesProvider> { DefaultResourcesProvider(androidApplication()) }

    single { Dispatchers.IO }
    single { Dispatchers.Main }
}