package ir.siatech.newsappkotlinclean.presentation.entities

data class Article(
    val id: Long,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)
