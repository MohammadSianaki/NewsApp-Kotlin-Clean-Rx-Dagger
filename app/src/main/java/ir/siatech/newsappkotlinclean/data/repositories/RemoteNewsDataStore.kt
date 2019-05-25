package ir.siatech.newsappkotlinclean.data.repositories

import io.reactivex.Observable
import ir.siatech.newsappkotlinclean.data.api.WebService
import ir.siatech.newsappkotlinclean.data.entities.ArticleData
import ir.siatech.newsappkotlinclean.data.mappers.ArticleDataEntityMapper
import ir.siatech.newsappkotlinclean.data.mappers.SourceDataEntityMapper
import ir.siatech.newsappkotlinclean.domain.NewsDataStore
import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.ArticleEntity
import ir.siatech.newsappkotlinclean.domain.entities.SourceEnum
import java.util.*

class RemoteNewsDataStore(private val webService: WebService) : NewsDataStore {

    private val articleDataMapper: Mapper<ArticleData, ArticleEntity> by lazy {
        ArticleDataEntityMapper(SourceDataEntityMapper())
    }

    override fun getNews(): Observable<List<ArticleEntity>> {

        return Observable.mergeArray(
            webService.getTopHeadlinesByNewsSource(SourceEnum.Bloomberg.sourceName),
            webService.getTopHeadlinesByNewsSource(SourceEnum.CNN.sourceName),
            webService.getTopHeadlinesByNewsSource(SourceEnum.Independent.sourceName),
            webService.getTopHeadlinesByNewsSource(SourceEnum.WSJ.sourceName),
            webService.getTopHeadlinesByNewsSource(SourceEnum.TechCrunch.sourceName),
            webService.getTopHeadlinesByNewsSource(SourceEnum.Economist.sourceName)
        ).map { results ->
            results.articles.map { articleDataMapper.mapFrom(it) }
        }
    }

    override fun search(query: String, from: Date, to: Date): Observable<List<ArticleEntity>> {
        return webService.searchNews(query, from, to).map { results ->
            results.articles.map { articleDataMapper.mapFrom(it) }
        }
    }
}