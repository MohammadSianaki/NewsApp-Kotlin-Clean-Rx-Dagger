package ir.siatech.newsappkotlinclean.presentation.ui.headlines


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import ir.siatech.newsappkotlinclean.R
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment : DaggerFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: NewsViewModel by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(NewsViewModel::class.java)
    }

    private lateinit var recyclerView: RecyclerView
    private val adapter: TopHeadlinesAdapter by lazy {
        TopHeadlinesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = rv_headlines
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getTopHeadlines()
        with(viewModel) {
            viewState.observe(this@NewsFragment, Observer {
                if (it != null) handleViewState(it)
            })

            errorState.observe(this@NewsFragment, Observer { throwable ->
                throwable?.let {
                    Toast.makeText(activity, throwable.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun handleViewState(viewState: TopHeadlinesViewState) {
        ll_news_progress.visibility = if (viewState.showLoading) View.VISIBLE else View.GONE
        viewState.articles?.let { adapter.addArticles(it) }
    }

    companion object {
        @JvmStatic
        val TAG = NewsFragment::class.java.simpleName

        @JvmStatic
        fun newInstance(): NewsFragment {
            return NewsFragment().apply {
                arguments = Bundle()
            }
        }
    }

}
