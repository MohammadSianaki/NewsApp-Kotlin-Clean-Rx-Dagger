package ir.siatech.newsappkotlinclean.presentation.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siatech.newsappkotlinclean.presentation.ui.headlines.NewsFragment

@Module
abstract class MainActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideNewsFragment(): NewsFragment
}