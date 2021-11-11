package com.suraj.playo

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.suraj.playo.adapter.NewsArticlesAdapter
import com.suraj.playo.ui.base.BaseActivity
import com.suraj.playo.ui.newslist.Action
import com.suraj.playo.ui.newslist.NewsViewModel
import com.suraj.playo.ui.newslist.State
import com.suraj.playo.ui.newslist.WebViewActivity
import com.suraj.playo.utils.getViewModel
import com.suraj.playo.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*

class NewsActivity : BaseActivity() {

    private val newsViewModel by lazy { getViewModel<NewsViewModel>()}

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


        newsViewModel.observableState.observe(this) {state ->
            renderState(state)
        }

        newsViewModel.dispatch(Action.LoadNews)
    }

    private fun setUpList() {
        newsList.setEmptyView(emptyView)
        newsList.setProgressView(progressView)

        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(this)
    }

    private fun renderState(state: State) {
        when (state) {
            is State.News
            -> adapter.replaceItems(state.news)
            is State.Loading,
            is State.Error
            -> newsList.showState(state)
        }
    }

}