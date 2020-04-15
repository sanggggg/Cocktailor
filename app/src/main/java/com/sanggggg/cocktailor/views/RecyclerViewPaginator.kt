package com.sanggggg.cocktailor.views

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

class RecyclerViewPaginator(
    private val recyclerView: RecyclerView,
    private val loadMore: (String) -> Unit
) : RecyclerView.OnScrollListener() {

    private var threshold = 2
    var currentPage = 0
    private var prevTotalItem = 0

    private val indexLetterList = listOf(
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
        "u", "v", "w", "x", "y", "z", "0", "1", "2", "3",
        "4", "5", "6", "7", "8", "9"
    )

    init {
        recyclerView.addOnScrollListener(this)
    }

    private fun getIncreasedLetter(): String {
        currentPage++
        Timber.i("Page Request ${indexLetterList[currentPage]}")
        return indexLetterList[currentPage]
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = recyclerView.layoutManager
        layoutManager?.let {
            val visibleItemCount = it.childCount
            val totalItemCount = it.itemCount
            val firstVisibleItemPosition = when (layoutManager) {
                is LinearLayoutManager -> layoutManager.findLastVisibleItemPosition()
                is GridLayoutManager -> layoutManager.findLastVisibleItemPosition()
                else -> return
            }

            if (currentPage >= indexLetterList.size) return

            if (prevTotalItem == totalItemCount) return

            if ((visibleItemCount + firstVisibleItemPosition + threshold) >= totalItemCount) {
                prevTotalItem = totalItemCount
                loadMore(getIncreasedLetter())
            }
        }
    }
}