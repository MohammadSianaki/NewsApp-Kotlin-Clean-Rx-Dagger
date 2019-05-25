package ir.siatech.newsappkotlinclean.domain

import io.reactivex.Observable
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity

interface NewsCache {

    fun clear()
    fun getAll(): Observable<List<ArticleEntity>>
    fun isEmpty(): Observable<Boolean>
    fun search(query: String): Observable<List<ArticleEntity>>
    fun saveAll(articles: List<ArticleEntity>)
}