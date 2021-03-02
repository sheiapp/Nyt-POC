package com.example.nytpoc.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.nytpoc.R
import com.example.nytpoc.model.Results
import kotlinx.android.synthetic.main.recycler_item_view.view.*

class RecyclerViewAdapter(
    private val requestManager: RequestManager,
    private val clickItem: (Results) -> Unit
) : ListAdapter<Results, RecyclerViewAdapter.ViewHolder>(NytDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_view, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position), requestManager)
        holder.itemView.setOnClickListener {
            clickItem(getItem(position))
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(item: Results?, requestManager: RequestManager) {
            if (item?.title.isNullOrEmpty()) {
                itemView.title.visibility = View.GONE
            }
            if (item?.byline.isNullOrEmpty()) {
                itemView.author.visibility = View.GONE
            }
            if (item?.published_date.isNullOrEmpty()) {
                itemView.date.visibility = View.GONE
            }
            itemView.title.text = item?.title
            itemView.author.text = item?.byline
            itemView.date.text = item?.published_date
            if (item?.media.isNullOrEmpty()) {
                return
            }
            settingThumbnails(item?.media?.get(0)?.media?.get(0)?.url, itemView.img, requestManager)
        }

        private fun settingThumbnails(
            url: String?,
            imageView: ImageView,
            requestManager: RequestManager
        ) {
            requestManager
                .load(url)
                .transition(
                    DrawableTransitionOptions.withCrossFade(
                        DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
                    )
                )
                .into(imageView)
        }
    }

    class NytDiffUtil : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(
            oldItem: Results,
            newItem: Results
        ): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: Results,
            newItem: Results
        ): Boolean {
            return newItem == oldItem
        }

    }
}