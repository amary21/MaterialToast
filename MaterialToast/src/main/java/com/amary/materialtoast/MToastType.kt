package com.amary.materialtoast

import androidx.core.content.ContextCompat
import com.amary.materialtoast.databinding.LayoutToastBinding

enum class MToastType {
    ERROR {
        override fun onCreate(binding: LayoutToastBinding) {
            binding.apply {
                mainLayout.setBackgroundColor(ContextCompat.getColor(root.context, R.color.error_dark))
                imgIconLeft.setImageResource(R.drawable.ic_error)
            }
        }
    },
    WARNING {
        override fun onCreate(binding: LayoutToastBinding) {
            binding.apply {
                mainLayout.setBackgroundColor(ContextCompat.getColor(root.context, R.color.warning_dark))
                imgIconLeft.setImageResource(R.drawable.ic_warning)
            }
        }
    },
    INFO {
        override fun onCreate(binding: LayoutToastBinding) {
            binding.apply {
                mainLayout.setBackgroundColor(ContextCompat.getColor(root.context, R.color.info_dark))
                imgIconLeft.setImageResource(R.drawable.ic_info)
            }
        }
    },
    SUCCESS {
        override fun onCreate(binding: LayoutToastBinding) {
            binding.apply {
                mainLayout.setBackgroundColor(ContextCompat.getColor(root.context, R.color.success_dark))
                imgIconLeft.setImageResource(R.drawable.ic_success)
            }
        }
    };

    abstract fun onCreate(binding: LayoutToastBinding)
}