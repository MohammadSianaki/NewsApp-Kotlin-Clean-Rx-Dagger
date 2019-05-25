package ir.siatech.newsappkotlinclean.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.siatech.newsappkotlinclean.data.entities.ArticleData

@Database(entities = [ArticleData::class], version = 1)
@TypeConverters(Converters::class)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao
}