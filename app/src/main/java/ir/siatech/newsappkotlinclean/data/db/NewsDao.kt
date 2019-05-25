package ir.siatech.newsappkotlinclean.data.db

import androidx.room.*
import ir.siatech.newsappkotlinclean.data.entities.ArticleData

@Dao
interface NewsDao {

    @Query("SELECT * FROM articles")
    fun getFavorites(): List<ArticleData>

    @Query("SELECT * FROM articles WHERE title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%'")
    fun search(query: String): List<ArticleData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveArticle(articleData: ArticleData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllArticles(articles: List<ArticleData>)

    @Delete
    fun removeMovie(articleData: ArticleData)

    @Query("DELETE FROM articles")
    fun clear()

}
