package ir.siatech.newsappkotlinclean.presentation.ui.headlines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ir.siatech.newsappkotlinclean.BR.articleItem
import ir.siatech.newsappkotlinclean.databinding.NewsRowItemBinding
import ir.siatech.newsappkotlinclean.presentation.entities.Article
import ir.siatech.newsappkotlinclean.presentation.ui.common.DataBindingViewHolder

class TopHeadlinesAdapter : RecyclerView.Adapter<TopHeadlinesAdapter.ViewHolder>() {

    private val articles: MutableList<Article> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsRowItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(articles[position])
    }


    fun addArticles(articles: List<Article>) {
        this.articles.addAll(articles)
    }


    inner class ViewHolder(dataBinding: ViewDataBinding) : DataBindingViewHolder<Article>(dataBinding) {
        override fun onBind(t: Article): Unit = with(t) {
            dataBinding.setVariable(articleItem, t)
        }
    }
}