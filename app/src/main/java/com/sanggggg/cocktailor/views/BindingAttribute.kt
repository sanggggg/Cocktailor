package com.sanggggg.cocktailor.views

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanggggg.cocktailor.models.Cocktail
import com.sanggggg.cocktailor.views.main.CocktailListAdapter
import kotlinx.android.synthetic.main.item_cocktail.view.*
import timber.log.Timber

@BindingAdapter("adapter")
fun bindRecyclerViewAdapter(view : RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("bindCocktailList")
fun bindCocktailList(view : RecyclerView, items: List<Cocktail>?) {
    val adapter = view.adapter as? CocktailListAdapter
    adapter?.setItems(items ?: listOf())
}

@BindingAdapter("image_url")
fun bindGlideImage(view : ImageView, image_url: String?) {
    image_url?.let {
        Glide.with(view)
            .load(image_url)
            .thumbnail(0.1f)
            .into(view)
    }
}