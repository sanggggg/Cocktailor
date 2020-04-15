package com.sanggggg.cocktailor.views.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanggggg.cocktailor.R
import com.sanggggg.cocktailor.models.Ingredient
import kotlinx.android.synthetic.main.item_cocktail.view.*
import kotlinx.android.synthetic.main.item_recipe_item.view.*
import timber.log.Timber

class RecipeAdapter : RecyclerView.Adapter<RecipeItemViewHolder>() {
    private val items = mutableListOf<Ingredient>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(RecipeItemViewHolder.LAYOUT, parent, false)
        return RecipeItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.count()

    fun setItems(recipe: List<Ingredient>) {
        items.clear()
        items.addAll(recipe)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holderItem: RecipeItemViewHolder, position: Int) {
        holderItem.bindRecipeItem(items[position])
    }
}

class RecipeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var item: Ingredient

    fun bindRecipeItem(ingredient: Ingredient) {
        item = ingredient
        itemView.run {
            item_recipe_item_name.text = item.name
            Glide.with(context)
                .load("https://www.thecocktaildb.com/images/ingredients/${item.name}-Small.png")
                .thumbnail(0.1f)
                .into(item_recipe_item_thumbnail)
        }
    }

    companion object {
        const val LAYOUT = R.layout.item_recipe_item
    }
}