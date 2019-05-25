package ir.siatech.newsappkotlinclean.presentation.ui.common

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class DataBindingViewHolder<T>(protected val dataBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(dataBinding.root) {

    abstract fun onBind(t: T)
}