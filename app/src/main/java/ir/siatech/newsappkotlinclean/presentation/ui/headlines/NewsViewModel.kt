package ir.siatech.newsappkotlinclean.presentation.ui.headlines

import androidx.lifecycle.MutableLiveData
import ir.siatech.newsappkotlinclean.domain.usecases.GetTopHeadlinesByNewsSource
import ir.siatech.newsappkotlinclean.presentation.core.ArticleEntityArticleMapper
import ir.siatech.newsappkotlinclean.presentation.ui.common.BaseViewModel
import ir.siatech.newsappkotlinclean.presentation.ui.common.SingleLiveEvent
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getTopHeadlinesByNewsSource: GetTopHeadlinesByNewsSource
) : BaseViewModel() {

    private val articleEntityArticleMapper = ArticleEntityArticleMapper()
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