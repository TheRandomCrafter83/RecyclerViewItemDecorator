package com.coderz.f1.myapplication

import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.InsetDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import android.os.Build
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.core.graphics.blue
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

private val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

private val Float.dp:Float
    get() = (this * Resources.getSystem().displayMetrics.density+0.5f).toFloat()

class ShadowDividerDecoration(private val shadowSize:Int, private val itemSpacing:Int = 0, @ColorInt private val shadowColor:Int = Color.RED, private val shadowRadius:Float = 0f): RecyclerView.ItemDecoration() {
    val TAG = "ShadowDividerDecoration"
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount

        for (i:Int in 0 until childCount) {
            val child = parent.getChildAt(i)
            val top = child.top
            val bottom = top + child.height
            val left = child.left
            val right = child.right
            var shadowDrawable = child.background.constantState?.newDrawable()

            if (shadowDrawable == null) {

                shadowDrawable = ShapeDrawable(RoundRectShape(
                floatArrayOf(
                    shadowRadius.dp,shadowRadius.dp,shadowRadius.dp,shadowRadius.dp,shadowRadius.dp,shadowRadius.dp,shadowRadius.dp,shadowRadius.dp),
                null,
                null
                )
                )
            }
            //shadowDrawable?.colorFilter = BlendModeColorFilter(shadowColor,BlendMode.SRC_ATOP)

            DrawableCompat.setTint(shadowDrawable!!.mutate() ,Color.argb(255,shadowColor.red,shadowColor.green,shadowColor.blue))
            for(x:Int in (-1).dp until shadowSize.dp){
                shadowDrawable.alpha = if(x<=0) 100 else 255/x
                shadowDrawable.setBounds(left+x,top+x,right+x,bottom+x)
                shadowDrawable.draw(c)
            }
        }

    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = shadowSize + itemSpacing
    }
}