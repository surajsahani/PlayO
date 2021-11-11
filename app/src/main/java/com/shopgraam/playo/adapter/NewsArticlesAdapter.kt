package com.shopgraam.playo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.shopgraam.playo.domain.Article
import com.shopgraam.playo.R
import com.shopgraam.playo.inflate
import kotlinx.android.synthetic.main.row_news_article.view.*

class NewsArticlesAdapter(
    private val listener: (Article) -> Unit
)  : RecyclerView.Adapter<NewsArticlesAdapter.NewsHolder>(){


    private var newsArticles: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsHolder(parent.inflate(R.layout.row_news_article))


    override fun onBindViewHolder(newsholder: NewsHolder, position: Int) =
        newsholder.bind(newsArticles[position], listener)


    override fun getItemCount(): Int = newsArticles.size

    class NewsHolder(itemView: View)  : RecyclerView.ViewHolder(itemView) {

        fun bind(newsArticle: Article, listener: (Article) -> Unit) = with(itemView) {


            Glide.with(context)
                .load(newsArticle.urlToImage)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.img_test_one)
                        .error(R.drawable.img_test_one)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(ivNewsImage)
            setOnClickListener { listener(newsArticle) }

        }
    }
    fun replaceItems(items: List<Article>) {
        newsArticles = items
        notifyDataSetChanged()
    }
}