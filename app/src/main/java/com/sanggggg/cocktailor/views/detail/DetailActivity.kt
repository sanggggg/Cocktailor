package com.sanggggg.cocktailor.views.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sanggggg.cocktailor.R
import com.sanggggg.cocktailor.databinding.ActivityDetailBinding
import com.sanggggg.cocktailor.models.Cocktail
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private val binding: ActivityDetailBinding by lazy {
        DataBindingUtil.setContentView<ActivityDetailBinding>(
            this,
            R.layout.activity_detail
        )
    }

    private val viewModel: DetailActivityViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        intent.getParcelableExtra<Cocktail>(MODEL_KEY)?.let {
            viewModel.setModel(it)
        }

        binding.let {
            it.viewModel = viewModel
            it.adapter = RecipeAdapter()
            it.lifecycleOwner = this
        }
    }

    companion object {
        const val MODEL_KEY: String = "cocktail_key"
        fun startActivityWithModel(context: Context, cocktail: Cocktail) {
            context.let {
                val intent = Intent(it, DetailActivity::class.java)
                intent.putExtra(MODEL_KEY, cocktail)
                it.startActivity(intent)
            }
        }
    }
}
