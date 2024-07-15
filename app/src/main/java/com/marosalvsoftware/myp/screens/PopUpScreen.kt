package com.marosalvsoftware.myp.screens

import android.util.Size
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import androidx.compose.runtime.Composable
import com.marosalvsoftware.myp.R
@Composable
fun PopUpScreen(anchor: View, content: @Composable () -> Unit = {}){
    PopupWindow(anchor.context).apply {
        isOutsideTouchable = true
        val inflater = LayoutInflater.from(anchor.context)
        contentView = inflater.inflate(R.layout.popup_layout, null).apply {
            measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            )
        }
    }.also { popupWindow ->
        // Absolute location of the anchor view
        val location = IntArray(2).apply {
            anchor.getLocationOnScreen(this)
        }
        val size = Size(
            popupWindow.contentView.measuredWidth,
            popupWindow.contentView.measuredHeight
        )
        popupWindow.showAtLocation(
            anchor,
            Gravity.TOP or Gravity.START,
            location[0] - (size.width - anchor.width) / 2,
            location[1] - size.height
        )
    }
    content()
}