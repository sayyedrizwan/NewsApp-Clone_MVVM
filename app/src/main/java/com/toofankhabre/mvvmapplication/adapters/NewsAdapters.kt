package com.toofankhabre.mvvmapplication.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.toofankhabre.mvvmapplication.R
import com.toofankhabre.mvvmapplication.Response.Article
import com.toofankhabre.mvvmapplication.adapters.NewsAdapters.ViewHolder
import kotlinx.android.synthetic.main.artcle_preview.view.*

class NewsAdapters: RecyclerView.Adapter<ViewHolder>() {



    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    private val diffeCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, diffeCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.artcle_preview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(articleItemImage)

            articleItemTitle.text = article.title
        }
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    private var onItemClickListener: ((Article)-> Unit)? = null


}