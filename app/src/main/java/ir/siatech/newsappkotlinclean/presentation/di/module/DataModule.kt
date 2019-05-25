package ir.siatech.newsappkotlinclean.presentation.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ir.siatech.newsappkotlinclean.data.api.WebService
import ir.siatech.newsappkotlinclean.data.db.DatabaseFavoriteNewsCache
import ir.siatech.newsappkotlinclean.data.db.NewsDao
import ir.siatech.newsappkotlinclean.data.db.NewsDatabase
import ir.siatech.newsappkotlinclean.data.mappers.ArticleDataEntityMapper
import ir.siatech.newsappkotlinclean.data.mappers.ArticleEntityDataMapper
import ir.siatech.newsappkotlinclean.data.repositories.CachedNewsDataStore
import ir.siatech.newsappkotlinclean.data.repositories.NewsMemoryCache
import ir.siatech.newsappkotlinclean.data.repositories.NewsRepositoryImpl
import ir.siatech.newsappkotlinclean.data.repositories.RemoteNewsDataStore
import ir.siatech.newsappkotlinclean.domain.NewsCache
import ir.siatech.newsappkotlinclean.domain.NewsRepository
import ir.siatech.newsappkotlinclean.presentation.di.DI
import javax.inject.Named
import javax.inject.Singleton

const val DB_NAME = "news.db"

@Module(includes = [NetworkModule::class])
class DataModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNewsDao(newsDatabase: NewsDatabase): NewsDao {
        return newsDatabase.getNewsDao()
    }


    @Provides
    @Singleton
    fun provideNewsRepository(
        cachedNewsDataStore: CachedNewsDataStore,
        remoteNewsDataStore: RemoteNewsDataStore
    ): NewsRepository {
        return NewsRepositoryImpl(cachedNewsDataStore, remoteNewsDataStore)
    }

    @Provides
    @Singleton
    fun provideCachedNewsDataStore(@Named(DI.MEMORY_CACHE) newsCache: NewsCache): CachedNewsDataStore {
        return CachedNewsDataStore(newsCache)
    }

    @Provides
    @Singleton
    @Named(DI.MEMORY_CACHE)
    fun provideMemoryCache(): NewsCache {
        return NewsMemoryCache()
    }


    @Provides
    @Singleton
    @Named(DI.DATABASE_CACHE)
    fun provideDatabaseCache(
        newsDao: NewsDao,
        newsEntityDataMapper: ArticleEntityDataMapper,
        newsDataEntityMapper: ArticleDataEntityMapper
    ): NewsCache {
        return DatabaseFavoriteNewsCache(newsDao, newsDataEntityMapper, newsEntityDataMapper)
    }

    @Provides
    @Singleton
    fun provideRemoteNewsDataStore(webService: WebService): RemoteNewsDataStore {
        return RemoteNewsDataStore(webService)
    }


}