package com.sanggggg.cocktailor.views.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanggggg.cocktailor.R
import com.sanggggg.cocktailor.models.Cocktail
import com.sanggggg.cocktailor.views.detail.DetailActivity
import kotlinx.android.synthetic.main.item_cocktail.view.*
import timber.log.Timber

class CocktailListAdapter : RecyclerView.Adapter<CocktailItemViewHolder>() {
    private val items = mutableListOf<Cocktail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(CocktailItemViewHolder.LAYOUT, parent, false)
        return CocktailItemViewHolder(view)
    }

    override fun getItemCount() = items.count()

    fun setItems(cocktails: List<Cocktail>) {
        items.clear()
        items.addAll(cocktails)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CocktailItemViewHolder, position: Int) {
        holder.bindCocktail(items[position])
    }

}

class CocktailItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {
    private lateinit var item: Cocktail

    fun bindCocktail(cocktail: Cocktail) {
        item = cocktail
        Timber.i("Bind $item")
        itemView.run {
            setOnClickListener(this@CocktailItemViewHolder)
            item_cocktail_name.text = cocktail.name
            Glide.with(context)
                .load(cocktail.thumbnail)
                .thumbnail(0.1f)
                .into(item_cocktail_thumb)
        }
    }

    companion object {
        const val LAYOUT = R.layout.item_cocktail
    }

    override fun onClick(p0: View?) {
        DetailActivity.startActivityWithModel(itemView.context, item)
    }
}