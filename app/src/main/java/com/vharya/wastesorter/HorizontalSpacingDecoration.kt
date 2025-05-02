package com.vharya.wastesorter

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import kotlin.math.roundToInt

class HorizontalSpacingDecoration(
    size: Int,
    context: Context
) : ItemDecoration() {

    private val sizeInPixel: Int

    init {
        sizeInPixel = dpToPx(size, context)
    }

    private fun dpToPx(dp: Int, context: Context): Int {
        val displayMetrics = context.resources.displayMetrics
        return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.right = sizeInPixel

        if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
            outRect.right = 0
        }
    }
}