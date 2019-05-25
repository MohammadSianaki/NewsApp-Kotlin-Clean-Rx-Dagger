package ir.siatech.newsappkotlinclean.data.api

import com.google.gson.annotations.SerializedName
import ir.siatech.newsappkotlinclean.data.entities.ArticleData

data class NewsResult(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<ArticleData>
)