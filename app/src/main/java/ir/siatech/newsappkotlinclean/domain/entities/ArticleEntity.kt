package ir.siatech.newsappkotlinclean.domain.entities

data class ArticleEntity(
    val id: Long,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceEntity,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)