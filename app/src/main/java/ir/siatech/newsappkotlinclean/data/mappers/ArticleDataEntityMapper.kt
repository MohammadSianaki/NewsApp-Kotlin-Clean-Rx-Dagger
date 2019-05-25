package ir.siatech.newsappkotlinclean.data.mappers

import ir.siatech.newsappkotlinclean.data.entities.ArticleData
import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleDataEntityMapper @Inject constructor(
    private val sourceDataEntityMapper
    : SourceDataEntityMapper
) :
    Mapper<ArticleData, ArticleEntity>() {
    override fun mapFrom(from: ArticleData): ArticleEntity {
        return ArticleEntity(
            id = from.id,
            source = sourceDataEntityMapper.mapFrom(from.source),
            author = from.author,
            content = from.content,
            description = from.description,
            urlToImage = from.urlToImage,
            url = from.urlToImage,
            title = from.title,
            publishedAt = from.publishedAt
        )
    }
}