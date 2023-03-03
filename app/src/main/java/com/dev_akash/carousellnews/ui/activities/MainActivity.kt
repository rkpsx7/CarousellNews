package com.dev_akash.carousellnews.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev_akash.carousellnews.NewsApplication
import com.dev_akash.carousellnews.R
import com.dev_akash.carousellnews.databinding.ActivityMainBinding
import com.dev_akash.carousellnews.viewmodel.NewsViewModel
import com.dev_akash.carousellnews.ui.adapter.NewsHomeAdapter
import com.dev_akash.carousellnews.viewmodel.NewsViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: NewsViewModelFactory
    private lateinit var viewModel: NewsViewModel

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: NewsHomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as NewsApplication).daggerAppComponent.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]

        setSupportActionBar(binding.toolbar)
        setRecyclerView()
        setObservers()
    }

    private fun setObservers() {
        viewModel.getNewsForHomePage()
        viewModel.newsList.observe(this) {
            rvAdapter.newsList = it
            rvAdapter.notifyDataSetChanged()
        }
    }

    private fun setRecyclerView() {
        rvAdapter = NewsHomeAdapter()
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvAdapter
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.recent -> {
                viewModel.sortNewsByRecent()
            }
            R.id.popular -> {
                viewModel.sortNewsByPopular()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }
}