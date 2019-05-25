package ir.siatech.newsappkotlinclean.presentation.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import ir.siatech.newsappkotlinclean.R
import ir.siatech.newsappkotlinclean.presentation.ui.headlines.NewsFragment
import ir.siatech.newsappkotlinclean.presentation.ui.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.app_name)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, NewsFragment.newInstance(), NewsFragment.TAG)
                .commitNow()
        }
        bottomNavigation = bottom_navigation
        bottomNavigation.setOnNavigationItemSelectedListener(this)
        onNavigationItemSelected(bottomNavigation.menu.getItem(0))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == bottomNavigation.selectedItemId) {
            return false
        }
        when (item.itemId) {
            R.id.action_headlines -> {
                setUpFragment(NewsFragment.newInstance(), NewsFragment.TAG)
            }
            R.id.action_search -> {
                setUpFragment(SearchFragment.newInstance(), SearchFragment.TAG)
            }
        }

        return true
    }

    private fun setUpFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, tag)
            .commitNow()
    }
}
