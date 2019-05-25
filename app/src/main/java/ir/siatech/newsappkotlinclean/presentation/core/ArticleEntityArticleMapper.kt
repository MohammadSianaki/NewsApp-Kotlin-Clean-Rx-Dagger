package ir.siatech.newsappkotlinclean.presentation.core

import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import ir.siatech.newsappkotlinclean.presentation.entities.Article
import ir.siatech.newsappkotlinclean.presentation.entities.Source
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleEntityArticleMapper @Inject constructor() : Mapper<ArticleEntity, Article>() {
    override fun mapFrom(from: ArticleEntity): Article {
        return Article(
            id = from.id,
            author = from.author,
            description = from.description,
            content = from.content,
            publishedAt = from.publishedAt,
            title = from.title,
            url = from.url,
            urlToImage = from.urlToImage,
            source = Source(
                id = from.source.id,
                name = from.source.name
            )
        )
    }
}