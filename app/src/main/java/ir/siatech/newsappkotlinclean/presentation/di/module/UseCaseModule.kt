package ir.siatech.newsappkotlinclean.presentation.di.module

import dagger.Module
import dagger.Provides
import ir.siatech.newsappkotlinclean.domain.NewsRepository
import ir.siatech.newsappkotlinclean.domain.usecases.GetTopHeadlinesByNewsSource
import ir.siatech.newsappkotlinclean.domain.usecases.SearchAllArticlesByTopicAndDate
import ir.siatech.newsappkotlinclean.presentation.core.ASyncTransformer
import ir.siatech.newsappkotlinclean.presentation.core.ArticleEntityArticleMapper
import ir.siatech.newsappkotlinclean.presentation.ui.headlines.TopHeadlinesVMFactory

@Module(includes = [DataModule::class])
class UseCaseModule {

    @Provides
    fun provideGetTopHeadlinesUseCase(newsRepository: NewsRepository): GetTopHeadlinesByNewsSource {
        return GetTopHeadlinesByNewsSource(ASyncTransformer(), newsRepository)
    }

    @Provides
    fun provideTopHeadlinesVMFactory(
        useCase: GetTopHeadlinesByNewsSource, mapper: ArticleEntityArticleMapper
    ): TopHeadlinesVMFactory {
        return TopHeadlinesVMFactory(useCase, mapper)
    }

    @Provides
    fun provideSearchAllArticlesUseCase(newsRepository: NewsRepository): SearchAllArticlesByTopicAndDate {
        return SearchAllArticlesByTopicAndDate(ASyncTransformer(), newsRepository)
    }


}