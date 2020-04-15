package com.sanggggg.cocktailor.views

import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TimePicker
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanggggg.cocktailor.models.Cocktail
import com.sanggggg.cocktailor.models.Ingredient
import com.sanggggg.cocktailor.views.detail.RecipeAdapter
import com.sanggggg.cocktailor.views.main.CocktailListAdapter
import com.sanggggg.cocktailor.views.main.MainActivityViewModel
import timber.log.Timber

@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("bindPagenation")
fun bindPagenation(view: RecyclerView, viewModel: MainActivityViewModel) {
    RecyclerViewPaginator(
        recyclerView = view,
        loadMore = { viewModel.postCocktailPage(it) }
    ).run {
        currentPage = 1
    }
}

@BindingAdapter("bindCocktailList")
fun bindCocktailList(view: RecyclerView, items: List<Cocktail>?) {
    val adapter = view.adapter as? CocktailListAdapter
    adapter?.addItems(items ?: listOf())
}

@BindingAdapter("bindRecipeList")
fun bindRecipeList(view: RecyclerView, items: List<Ingredient>?) {
    val adapter = view.adapter as? RecipeAdapter
    adapter?.setItems(items ?: listOf())
}

@BindingAdapter("bindInstructions")
fun bindInstructions(view: ListView, data: List<String>?) {
    val adapter = ArrayAdapter<String>(
        view.context,
        android.R.layout.simple_list_item_1,
        data ?: emptyList<String>()
    )
    view.adapter = adapter
}

@BindingAdapter("image_url")
fun bindGlideImage(view: ImageView, image_url: String?) {
    image_url?.let {
        Glide.with(view)
            .load(image_url)
            .thumbnail(0.1f)
            .into(view)
    }
}