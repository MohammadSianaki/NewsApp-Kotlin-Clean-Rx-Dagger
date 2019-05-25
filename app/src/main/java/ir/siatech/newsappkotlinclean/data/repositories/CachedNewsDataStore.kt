package ir.siatech.newsappkotlinclean.data.repositories

import io.reactivex.Observable
import ir.siatech.newsappkotlinclean.domain.NewsCache
import ir.siatech.newsappkotlinclean.domain.NewsDataStore
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import java.util.*

class CachedNewsDataStore(
    private val newsCache: NewsCache
) : NewsDataStore {
    override fun getNews(): Observable<List<ArticleEntity>> {
        return newsCache.getAll()
    }

    override fun search(query: String, from: Date, to: Date): Observable<List<ArticleEntity>> {
        return newsCache.search(query)
    }

    fun isEmpty(): Observable<Boolean> {
        return newsCache.isEmpty()
    }

    fun saveAll(articleEntities: List<ArticleEntity>) {
        newsCache.saveAll(articleEntities)
    }

}