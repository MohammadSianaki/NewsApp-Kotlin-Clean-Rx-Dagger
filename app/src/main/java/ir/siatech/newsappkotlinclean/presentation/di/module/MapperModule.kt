package ir.siatech.newsappkotlinclean.presentation.di.module

import dagger.Binds
import dagger.Module
import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import ir.siatech.newsappkotlinclean.presentation.core.ArticleEntityArticleMapper
import ir.siatech.newsappkotlinclean.presentation.entities.Article

@Module
abstract class MapperModule {
    @Binds
    abstract fun providesArticleEntityArticleMapper(articleEntityArticleMapper: ArticleEntityArticleMapper)
            : Mapper<ArticleEntity, Article>
}