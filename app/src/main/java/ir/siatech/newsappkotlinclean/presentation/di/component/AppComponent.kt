package ir.siatech.newsappkotlinclean.presentation.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ir.siatech.newsappkotlinclean.presentation.core.NewsApp
import ir.siatech.newsappkotlinclean.presentation.di.builder.ActivityBuilder
import ir.siatech.newsappkotlinclean.presentation.di.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        UseCaseModule::class,
        DataModule::class,
        ActivityBuilder::class,
        ContextModule::class,
        NetworkModule::class]
)
interface AppComponent : AndroidInjector<NewsApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}