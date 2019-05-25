package ir.siatech.newsappkotlinclean.data.repositories

import io.reactivex.Observable
import ir.siatech.newsappkotlinclean.domain.NewsCache
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity

class NewsMemoryCache : NewsCache {
    private val news: LinkedHashMap<Int, ArticleEntity> = LinkedHashMap()

    override fun clear() {
        news.clear()
    }

    override fun getAll(): Observable<List<ArticleEntity>> {
        return Observable.just(news.values.toList())
    }

    override fun isEmpty(): Observable<Boolean> {
        return Observable.fromCallable { news.isEmpty() }
    }

    override fun search(query: String): Observable<List<ArticleEntity>> {
        return Observable.fromCallable {
            news.values.filter {
                it.title?.contains(query)!! || it.description?.contains(query)!! ||
                        it.description.contains(query)
            }
        }
    }

    override fun saveAll(articles: List<ArticleEntity>) {
        articles.forEach { article -> this.news[article.hashCode()] = article }
    }
}