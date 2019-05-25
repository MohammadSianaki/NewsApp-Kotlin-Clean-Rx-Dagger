package ir.siatech.newsappkotlinclean.presentation.ui.headlines

import androidx.lifecycle.MutableLiveData
import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import ir.siatech.newsappkotlinclean.domain.usecases.GetTopHeadlinesByNewsSource
import ir.siatech.newsappkotlinclean.presentation.entities.Article
import ir.siatech.newsappkotlinclean.presentation.ui.common.BaseViewModel
import ir.siatech.newsappkotlinclean.presentation.ui.common.SingleLiveEvent

class NewsViewModel(
    private val getTopHeadlinesByNewsSource: GetTopHeadlinesByNewsSource,
    private val articleEntityArticleMapper: Mapper<ArticleEntity, Article>
) : BaseViewModel() {

    val viewState: MutableLiveData<TopHeadlinesViewState> = MutableLiveData()
    val errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    init {
        viewState.value = TopHeadlinesViewState()
    }

    fun getTopHeadlines() {
        addDisposable(
            getTopHeadlinesByNewsSource.observable()
                .flatMap { articleEntityArticleMapper.observable(it) }
                .subscribe({ articles ->
                    viewState.value?.let {
                        val newSate = this.viewState.value?.copy(showLoading = false, articles = articles)
                        this.viewState.value = newSate

                    }
                }, {
                    viewState.value = viewState.value?.copy(false)
                    errorState.value = it
                })
        )
    }
}