package ir.siatech.newsappkotlinclean.presentation.di.builder

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.siatech.newsappkotlinclean.presentation.di.qualifier.ViewModelKey
import ir.siatech.newsappkotlinclean.presentation.ui.headlines.NewsViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsViewModel(newsViewModel: NewsViewModel): ViewModel
}