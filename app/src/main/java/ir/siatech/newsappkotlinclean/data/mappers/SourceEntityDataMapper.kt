package ir.siatech.newsappkotlinclean.data.mappers

import ir.siatech.newsappkotlinclean.data.entities.SourceData
import ir.siatech.newsappkotlinclean.domain.commons.Mapper
import ir.siatech.newsappkotlinclean.domain.entities.SourceEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SourceEntityDataMapper @Inject constructor() : Mapper<SourceEntity, SourceData>() {
    override fun mapFrom(from: SourceEntity): SourceData {
        return SourceData(
            id = from.id,
            name = from.name
        )
    }
}