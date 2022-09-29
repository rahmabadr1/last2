package com.iittii.last.adapter

import com.iittii.last.model.Result

interface OnClickInterface {
    fun onClick(result: Result)
    fun onFavouriteClicked(isFav: Boolean, result: Result)
}