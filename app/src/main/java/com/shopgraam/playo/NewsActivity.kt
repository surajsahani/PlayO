package com.shopgraam.playo

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shopgraam.playo.adapter.NewsArticlesAdapter
import com.shopgraam.playo.di.ViewModelModule
import com.shopgraam.playo.ui.newslist.WebViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class NewsActivity : BaseActivity() {

    private val newsViewModel by lazy { getViewModel<ViewModelModule>()}

    private val adapter by lazy {

        NewsArticlesAdapter {
            val changePage = Intent(this, WebViewActivity::class.java)
            startActivity(changePage)
            toast("Clicked on item")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpList()


    }

    private fun setUpList() {

        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(this)
    }

//    private fun renderState(state: State) {
//        when (state) {
//            is State.News
//            -> adapter.replaceItems(state.news)
//            is State.Loading,
//            is State.Error
//            -> newsList.showState(state)
//        }
//    }

}