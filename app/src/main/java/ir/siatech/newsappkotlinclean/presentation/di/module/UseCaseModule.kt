package ir.siatech.newsappkotlinclean.presentation.di.module

import dagger.Module
import dagger.Provides
import ir.siatech.newsappkotlinclean.domain.NewsRepository
import ir.siatech.newsappkotlinclean.domain.usecases.GetTopHeadlinesByNewsSource
import ir.siatech.newsappkotlinclean.domain.usecases.SearchAllArticlesByTopicAndDate
import ir.siatech.newsappkotlinclean.presentation.core.ASyncTransformer

@Module(includes = [DataModule::class])
class UseCaseModule {

    @Provides
    fun provideGetTopHeadlinesUseCase(newsRepository: NewsRepository): GetTopHeadlinesByNewsSource {
        return GetTopHeadlinesByNewsSource(ASyncTransformer(), newsRepository)
    }

    @Provides
    fun provideSearchAllArticlesUseCase(newsRepository: NewsRepository): SearchAllArticlesByTopicAndDate {
        return SearchAllArticlesByTopicAndDate(ASyncTransformer(), newsRepository)
    }

}