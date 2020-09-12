package com.example.stringapp.UI.MobileFeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.stringapp.Model.MobileFeed.Data
import com.example.stringapp.Model.MobileFeed.MobileFeed
import com.example.stringapp.R
import com.example.stringapp.Utils.StaticVariable
import com.example.stringapp.Utils.onItemFeedClickListener
import kotlinx.android.synthetic.main.feed_itinerary.view.*
import kotlinx.android.synthetic.main.feed_poi.view.*
import kotlinx.android.synthetic.main.feed_post.view.*

class MobileFeedAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mobileFeed: MobileFeed = MobileFeed()
    private var data: MutableList<Data> = arrayListOf()
    var isLiked: Boolean = false
    var isSaved: Boolean = false
    var postId: Int? = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                MyPostViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.feed_post,
                parent,
                false
            )
        )
            }
            1 -> {
                MyPoiViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.feed_poi,
                        parent,
                        false))
            }
            2 -> {
                MyItineraryViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.feed_itinerary,
                        parent,
                        false))
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MyPostViewHolder -> {
                val myData = data[position]
                holder.bind(myData)
            }
            is MyPoiViewHolder -> {
                val myData = data[position]
                holder.bind(myData)
            }
            is MyItineraryViewHolder -> {
                val myData = data[position]
                holder.bind(myData)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    var itemLikeClick: onItemFeedClickListener?= null

    fun setItemLikeClickListener(clickListener: onItemFeedClickListener) {
        itemLikeClick = clickListener
    }

    var itemSaveClick: onItemFeedClickListener?= null

    fun setItemSaveClickListener(clickListener: onItemFeedClickListener) {
        itemSaveClick = clickListener
    }

    inner class MyPostViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val feedPostAvatar: ImageView = view.feed_post_user_avatar
        private val feedPostImage: ImageView = view.feed_post_image

        private val feedPostSaveCounter: Button = view.feed_post_save_counter

        private val feedPostUsername: TextView = view.feed_post_username
        private val feedPostDescription: TextView = view.feed_post_description
        private val feedPostLocationName: TextView = view.feed_post_location_name
        private val feedPostFavoriteCount: TextView = view.feed_post_favorite_count
        private val feedPostCommentCount: TextView = view.feed_post_comment_count

        fun bind(feedData: Data){
            feedPostUsername.text = feedData.user?.username ?: ""
            feedPostDescription.text = feedData.description
            feedPostLocationName.text = feedData.place?.title
            feedPostFavoriteCount.text = feedData.likeCounter.toString()
            feedPostCommentCount.text = feedData.commentCounter.toString()

            isSaved = feedData.isSaved ?: false
            postId = feedData.id

            val postAvatar = feedData.user?.profilePhoto
            if (postAvatar != null) {
                val obj1 = RoundedCorners(8)
                val options1 = RequestOptions().transform(obj1)
                Glide.with(view.context.applicationContext ?: return)
                    .load(postAvatar)
                    .apply(options1)
                    .into(feedPostAvatar)
            }

            val postImage = feedData.photos?.get(0)?.url?.thumb
            if (postImage != null) {
                val obj2 = RoundedCorners(8)
                val options2 = RequestOptions().transform(obj2)
                Glide.with(view.context.applicationContext ?: return)
                    .load(postImage)
                    .apply(options2)
                    .into(feedPostImage)
            }

            feedPostSaveCounter.setOnClickListener{
                itemSaveClick?.onItemFeedClick(feedPostSaveCounter)
            }

        }
    }

    inner class MyPoiViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val feedPoiTitle: TextView = view.feed_poi_title
        private val feedPoiAddress: TextView = view.feed_poi_address
        private val feedPoiUsername: TextView = view.feed_poi_username
        private val feedPoiFavoriteCount: TextView = view.feed_poi_favorite_count
        private val feedPoiCommentCount: TextView = view.feed_poi_comment_count

        private val feedPoiImage: ImageView = view.feed_poi_image
        private val feedPoiUserAvatar: ImageView = view.feed_poi_user_avatar

        private val feedPoiLikeCounter: Button = view.feed_poi_like_counter

        fun bind(feedData: Data){
            feedPoiTitle.text = feedData.title
            feedPoiAddress.text = feedData.address
            feedPoiUsername.text = feedData.user?.username
            feedPoiFavoriteCount.text = feedData.likeCounter.toString()
            feedPoiCommentCount.text = feedData.commentCounter.toString()

            isLiked = feedData.isLiked ?: false
            postId = feedData.id

            val poiImage = feedData.photos?.get(0)?.url?.thumb
            if (poiImage != null) {
                val obj2 = RoundedCorners(8)
                val options = RequestOptions().transform(obj2)
                Glide.with(view.context.applicationContext ?: return)
                    .load(poiImage)
                    .apply(options)
                    .into(feedPoiImage)
            }

            val poiUserAvatar = feedData.user?.profilePhoto
            if (poiUserAvatar != null) {
                val obj2 = RoundedCorners(8)
                val options = RequestOptions().transform(obj2)
                Glide.with(view.context.applicationContext ?: return)
                    .load(poiUserAvatar)
                    .apply(options)
                    .into(feedPoiUserAvatar)
            }

            feedPoiLikeCounter.setOnClickListener{
                itemLikeClick?.onItemFeedClick(feedPoiLikeCounter)
            }

        }
    }

    inner class MyItineraryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val feedItineraryTitle: TextView = view.feed_itinerary_title
        private val feedItineraryUsername: TextView = view.feed_itinerary_username
        private val feedItineraryStrungFrom: TextView = view.feed_itinerary_strungFrom
        private val feedItineraryUserBio: TextView = view.feed_itinerary_user_bio
        private val feedItineraryFavoriteCount: TextView = view.feed_itinerary_favorite_count
        private val feedItineraryCommentCount: TextView = view.feed_itinerary_comment_count

        private val feedItineraryImage: ImageView = view.feed_itinerary_image

        fun bind(feedData: Data){
            feedItineraryTitle.text = feedData.title
            feedItineraryUsername.text = feedData.user?.username ?: ""
            feedItineraryStrungFrom.text = feedData.strungFrom
            feedItineraryUserBio.text = feedData.description
            feedItineraryFavoriteCount.text = feedData.likeCounter.toString()
            feedItineraryCommentCount.text = feedData.commentCounter.toString()

            val itineraryImage = feedData.itineraries?.get(0)?.photos
            if (itineraryImage != null) {
                val obj2 = RoundedCorners(8)
                val options = RequestOptions().transform(obj2)
                Glide.with(view.context.applicationContext ?: return)
                    .load(itineraryImage)
                    .apply(options)
                    .into(feedItineraryImage)
            }
        }
    }

    fun setMobileFeed(mobileFeedData: MobileFeed) {
        mobileFeed.apply { mobileFeed = mobileFeedData }

        data.apply {
            mobileFeedData.mobileFeedData?.let { data.addAll(it) }
        }

        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        val item = data[position]
        return when (item.type) {
            StaticVariable.POST -> 0
            StaticVariable.POI -> 1
            StaticVariable.ITINERARY -> 2
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }
}