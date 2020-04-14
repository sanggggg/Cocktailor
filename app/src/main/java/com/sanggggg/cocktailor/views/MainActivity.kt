package com.sanggggg.cocktailor.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sanggggg.cocktailor.R
import com.sanggggg.cocktailor.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }

    private val viewModel: MainActivityViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        viewModel.setCocktailName("Margarita")
        binding.viewModel = viewModel

        viewModel.cocktailListLiveData.observe(this, Observer { Timber.i(it.toString()) })
    }
}
