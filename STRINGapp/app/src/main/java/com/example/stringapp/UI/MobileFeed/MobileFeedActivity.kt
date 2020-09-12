package com.example.stringapp.UI.MobileFeed

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stringapp.ApiService.ApiService
import com.example.stringapp.Model.MobileFeed.MobileFeed
import com.example.stringapp.R
import com.example.stringapp.StringApi
import com.example.stringapp.Utils.StaticVariable
import com.example.stringapp.Utils.onItemFeedClickListener
import com.example.stringapp.ViewModel.Repository
import com.example.stringapp.ViewModel.StringViewModel
import com.example.stringapp.ViewModel.StringViewModelFactory
import kotlinx.android.synthetic.main.feed.*
import java.lang.Thread.sleep

class MobileFeedActivity: AppCompatActivity(){
    private val sharedPref = StaticVariable.SHARED_PREF
    private val accessToken = StaticVariable.ACCESS_TOKEN

    private lateinit var mobileFeedAdapter: MobileFeedAdapter
    private lateinit var mobileFeedViewModel: StringViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed)

        mobileFeedViewModel = viewModel()
        mobileFeedAdapter = MobileFeedAdapter()
        getFeed()
        bindViewModel()

        mobileFeedAdapter.notifyDataSetChanged()
        feed_view.adapter = mobileFeedAdapter
        feed_view.layoutManager = GridLayoutManager(this, 1)

        val itemSaveClickListener = object: onItemFeedClickListener {
            override fun onItemFeedClick(item: Button) {
                val sharedPreferences: SharedPreferences = getSharedPreferences(
                    sharedPref,
                    MODE_PRIVATE
                )
                val token = "Bearer " + sharedPreferences.getString(accessToken, "")
                mobileFeedAdapter.postId?.let { mobileFeedViewModel.savePost(it, token) }
            }
        }
        mobileFeedAdapter.setItemSaveClickListener(itemSaveClickListener)

        val itemLikeClickListener = object: onItemFeedClickListener {
            override fun onItemFeedClick(item: Button) {
                val sharedPreferences: SharedPreferences = getSharedPreferences(
                    sharedPref,
                    MODE_PRIVATE
                )
                val token = "Bearer " + sharedPreferences.getString(accessToken, "")
                mobileFeedAdapter.postId?.let { mobileFeedViewModel.setLike(it, token) }
            }
        }
        mobileFeedAdapter.setItemLikeClickListener(itemLikeClickListener)

        loadFeed()
    }

    private fun bindViewModel(){
        mobileFeedViewModel.mobileFeed.observe(this, {
            mobileFeedAdapter.setMobileFeed(it)
        })
    }

    private fun viewModel() : StringViewModel{
        val viewModelFactory = StringViewModelFactory(Repository(ApiService(StringApi.create())))
        return ViewModelProvider(this, viewModelFactory)[StringViewModel::class.java]
    }

    private fun getFeed(){
        val sharedPreferences: SharedPreferences = getSharedPreferences(sharedPref, MODE_PRIVATE)
        val token = "Bearer " + sharedPreferences.getString(accessToken, "")
        Log.d("check in feed", token)
        mobileFeedViewModel.getMobileFeed(
            mobileFeedViewModel.feedPage.value ?: 0,
            StaticVariable.CURRENT_PER_PAGE,
            token
        )
    }

    private var loading = true
    private fun loadFeed(){
        feed_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy < 0) {
                    if (loading){
                        loading = false
                        val sharedPreferences: SharedPreferences = getSharedPreferences(
                            sharedPref,
                            MODE_PRIVATE
                        )
                        val token = "Bearer " + sharedPreferences.getString(accessToken, "")
                        mobileFeedViewModel.getMobileFeed(
                            mobileFeedViewModel.feedPage.value?.plus(1) ?: 1,
                            StaticVariable.CURRENT_PER_PAGE,
                            token
                        )
                    }
                }
                if (dy > 0){
                    loading = true
                }
            }
        })
    }

}