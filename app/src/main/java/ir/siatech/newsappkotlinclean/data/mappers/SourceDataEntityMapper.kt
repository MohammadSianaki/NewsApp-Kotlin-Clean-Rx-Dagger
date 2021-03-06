package ir.siatech.newsappkotlinclean.data.mappers

import ir.siatech.newsappkotlinclean.data.entities.SourceData
import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.SourceEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SourceDataEntityMapper @Inject constructor() : Mapper<SourceData, SourceEntity>() {
    override fun mapFrom(from: SourceData): SourceEntity {
        return SourceEntity(
            id = from.id,
            name = from.name
        )
    }
}