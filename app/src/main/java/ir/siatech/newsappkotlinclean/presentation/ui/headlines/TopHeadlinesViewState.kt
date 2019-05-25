package ir.siatech.newsappkotlinclean.presentation.ui.headlines

import ir.siatech.newsappkotlinclean.presentation.entities.Article

data class TopHeadlinesViewState(
    val showLoading: Boolean = true,
    val articles: List<Article>? = null
)