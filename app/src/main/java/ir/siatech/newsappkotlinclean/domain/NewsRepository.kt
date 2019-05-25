package ir.siatech.newsappkotlinclean.domain

import io.reactivex.Observable
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import java.util.*

interface NewsRepository {


    fun getTopHeadlines(): Observable<List<ArticleEntity>>


    fun search(query: String, from: Date, to: Date): Observable<List<ArticleEntity>>


}