package ir.siatech.newsappkotlinclean.domain.usecases

import io.reactivex.Observable
import ir.siatech.newsappkotlinclean.domain.NewsRepository
import ir.siatech.newsappkotlinclean.domain.commons.Transformer
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity

class GetTopHeadlinesByNewsSource(
    transformer: Transformer<List<ArticleEntity>>,
    private val newsRepository: NewsRepository
) : UseCase<List<ArticleEntity>>(transformer) {
    override fun createObservable(data: Map<String, Any>?): Observable<List<ArticleEntity>> {
        return newsRepository.getTopHeadlines()
    }

}