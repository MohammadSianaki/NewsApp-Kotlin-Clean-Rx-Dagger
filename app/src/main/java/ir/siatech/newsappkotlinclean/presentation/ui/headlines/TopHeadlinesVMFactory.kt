package ir.siatech.newsappkotlinclean.presentation.ui.headlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import ir.siatech.newsappkotlinclean.domain.usecases.GetTopHeadlinesByNewsSource
import ir.siatech.newsappkotlinclean.presentation.entities.Article

class TopHeadlinesVMFactory(
    private val useCase: GetTopHeadlinesByNewsSource,
    private val mapper: Mapper<ArticleEntity, Article>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(useCase, mapper) as T
    }
}