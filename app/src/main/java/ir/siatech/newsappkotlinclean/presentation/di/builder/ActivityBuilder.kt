package ir.siatech.newsappkotlinclean.presentation.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.siatech.newsappkotlinclean.presentation.ui.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity
}