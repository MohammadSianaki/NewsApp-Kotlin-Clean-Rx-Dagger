package ir.siatech.newsappkotlinclean.data.repositories

import io.reactivex.Observable
import ir.siatech.newsappkotlinclean.domain.NewsRepository
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import java.util.*

class NewsRepositoryImpl(
    private val cachedNewsDataStore: CachedNewsDataStore,
    private val remoteNewsDataStore: RemoteNewsDataStore
) : NewsRepository {

    override fun getTopHeadlines(): Observable<List<ArticleEntity>> {
        return cachedNewsDataStore.isEmpty().flatMap { empty ->
            if (!empty) {
                return@flatMap cachedNewsDataStore.getNews()
            } else {
                return@flatMap remoteNewsDataStore.getNews()
                    .doOnNext { articles -> cachedNewsDataStore.saveAll(articles) }
            }
        }
    }

    override fun search(query: String, from: Date, to: Date): Observable<List<ArticleEntity>> {
        return remoteNewsDataStore.search(query, from, to)
    }
}