package com.dev_akash.carousellnews.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev_akash.carousellnews.databinding.NewsItemLayoutBinding
import com.dev_akash.carousellnews.utils.loadImage
import com.dev_akash.carousellnews.model.NewsHomeResponse
import com.dev_akash.carousellnews.utils.DateTimeUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsHomeAdapter : RecyclerView.Adapter<NewsHomeVH>() {

    var newsList: List<NewsHomeResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHomeVH {
        return NewsHomeVH(
            NewsItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsHomeVH, position: Int) {
        holder.setData(newsList[position])
    }

    override fun getItemCount() = newsList.size

}

class NewsHomeVH(private val binding: NewsItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(item: NewsHomeResponse) {
        binding.apply {
            tvTitle.text = item.title
            tvDesc.text = item.description
            ivThumbnail.loadImage(item.bannerUrl)
            tvTimePosted.text = item.timeCreated?.let { DateTimeUtils.getPostedTimeText(it) }
        }
    }
}