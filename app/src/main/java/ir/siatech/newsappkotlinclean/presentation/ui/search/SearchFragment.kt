package ir.siatech.newsappkotlinclean.presentation.ui.search


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.siatech.newsappkotlinclean.R

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    companion object {
        @JvmStatic
        val TAG = SearchFragment::class.java.simpleName

        @JvmStatic
        fun newInstance(): SearchFragment {
            return SearchFragment().apply {
                arguments = Bundle()
            }
        }
    }

}
