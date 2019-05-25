package ir.siatech.newsappkotlinclean.data.mappers

import ir.siatech.newsappkotlinclean.data.entities.ArticleData
import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleEntityDataMapper @Inject constructor(
    private val sourceEntityDataMapper
    : SourceEntityDataMapper
) :
    Mapper<ArticleEntity, ArticleData>() {

    override fun mapFrom(from: ArticleEntity): ArticleData {
        return ArticleData(
            id = from.id,
            source = sourceEntityDataMapper.mapFrom(from.source),
            author = from.author,
            content = from.content,
            description = from.description,
            publishedAt = from.publishedAt,
            title = from.title,
            url = from.url,
            urlToImage = from.urlToImage
        )
    }
}