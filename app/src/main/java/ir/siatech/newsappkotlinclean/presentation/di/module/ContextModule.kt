package ir.siatech.newsappkotlinclean.presentation.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ir.siatech.newsappkotlinclean.presentation.di.builder.ViewModelBuilder
import javax.inject.Singleton

@Module(includes = [ViewModelBuilder::class])
class ContextModule {

    @Provides
    @Singleton
    fun provideAppContext(application: Application): Context {
        return application
    }
}