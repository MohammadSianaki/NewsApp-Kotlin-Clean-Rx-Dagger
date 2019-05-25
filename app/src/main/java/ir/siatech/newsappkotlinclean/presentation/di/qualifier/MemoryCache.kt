package ir.siatech.newsappkotlinclean.presentation.di.qualifier

import javax.inject.Scope

@Target(
    AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER
)
@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class MemoryCache