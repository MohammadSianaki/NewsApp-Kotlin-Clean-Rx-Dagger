package ir.siatech.newsappkotlinclean.data.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface WebService {

    @GET("everything")
    fun getTopHeadlinesByNewsSource(
        @Query("domains")
        sourceName: String
    ): Observable<NewsResult>

    @GET("")
    fun searchNews(@Query("") query: String, from: Date, to: Date): Observable<NewsResult>

}
