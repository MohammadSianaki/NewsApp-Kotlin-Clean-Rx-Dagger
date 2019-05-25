package ir.siatech.newsappkotlinclean.domain.commons

import io.reactivex.ObservableTransformer

abstract class Transformer<T> : ObservableTransformer<T, T>