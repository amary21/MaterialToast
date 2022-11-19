package com.amary.materialtoast

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.amary.materialtoast.databinding.LayoutToastBinding
import com.google.android.material.snackbar.Snackbar

class MToast(builder: Builder) {
    private val context = builder.context
    private var title = builder.title
    private var message = builder.message
    private var type = builder.type
    private var isShowIcon = builder.isShowIcon
    private var isShowClose = builder.isShowClose
    private val snackBar: Snackbar by lazy {
        val view = (context as Activity).window.decorView.findViewById(android.R.id.content) as View
        Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE)
    }
    private val binding: LayoutToastBinding by lazy {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        LayoutToastBinding.inflate(inflater)
    }

    init {
        snackBar.view.apply {
            val paramsFrame = layoutParams as FrameLayout.LayoutParams
            paramsFrame.gravity = Gravity.TOP

            layoutParams = paramsFrame
            setBackgroundColor(Color.TRANSPARENT)

            val snackBarLayout = this as Snackbar.SnackbarLayout
            snackBarLayout.addView(binding.root)
        }

        binding.apply {
            type?.onCreate(binding)
            snackBar.duration = 5000
            imgIconLeft.isVisible = isShowIcon == true
            btnImgRight.isVisible = isShowClose == true

            lblMessage.text = message ?: ""

            if (title != null){
                lblTitle.isVisible = true
                lblTitle.text = title
            }

            btnImgRight.setOnClickListener { dismiss() }
        }
    }

    fun show(){ snackBar.show() }
    fun dismiss(){ snackBar.dismiss() }



    class Builder(var context: Context){
        var title: String? = null
        var message: String? = null
        var isShowIcon: Boolean? = true
        var isShowClose: Boolean? = true
        var snackBar: Snackbar? = null
        var type: MToastType? = MToastType.INFO

        fun setType(type: MToastType) = apply { this.type = type }
        fun setTitle(title: String) = apply { this.title = title }
        fun setMessage(message: String) = apply { this.message = message }
        fun showIcon(isShowIcon: Boolean) = apply { this.isShowIcon = isShowIcon }
        fun showIconClose(isShowClose: Boolean) = apply { this.isShowClose = isShowClose}

        fun show() = MToast(this).show()
        fun dismiss() = snackBar?.dismiss()
    }
}