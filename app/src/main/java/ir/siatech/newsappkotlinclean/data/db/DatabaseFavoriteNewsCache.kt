package ir.siatech.newsappkotlinclean.data.db

import io.reactivex.Observable
import ir.siatech.newsappkotlinclean.data.entities.ArticleData
import ir.siatech.newsappkotlinclean.domain.NewsCache
import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import javax.inject.Inject

class DatabaseFavoriteNewsCache @Inject constructor(
    private val dao: NewsDao,
    private val dataToEntityMapper: Mapper<ArticleData, ArticleEntity>,
    private val entityToDataMapper: Mapper<ArticleEntity, ArticleData>
) : NewsCache {

    override fun clear() {
        dao.clear()
    }

    override fun getAll(): Observable<List<ArticleEntity>> {
        return Observable.fromCallable { dao.getFavorites().map { dataToEntityMapper.mapFrom(it) } }
    }

    override fun isEmpty(): Observable<Boolean> {
        return Observable.fromCallable { dao.getFavorites().isEmpty() }
    }

    override fun search(query: String): Observable<List<ArticleEntity>> {
        val searchQuery = "%$query%"
        return Observable.fromCallable {
            dao.search(query).map { dataToEntityMapper.mapFrom(it) }
        }
    }

    override fun saveAll(articles: List<ArticleEntity>) {
        return dao.saveAllArticles(articles.map { entityToDataMapper.mapFrom(it) })
    }
}