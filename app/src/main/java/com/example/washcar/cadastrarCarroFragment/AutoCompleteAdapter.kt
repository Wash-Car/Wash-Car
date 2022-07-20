package com.example.washcar.cadastrarCarroFragment

import android.content.Context
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import com.example.washcar.api.carModel.model.CarModelResponse

class AutoCompleteAdapter(
    context: Context,
    @LayoutRes private val layoutResource: Int,
    private val carModels: List<CarModelResponse>,
    private val carModelName : List<String>
) : ArrayAdapter<CarModelResponse>(context, layoutResource, carModels) {
    override fun getItem(position: Int): CarModelResponse? {
        return super.getItem(position)
    }

    fun getIdItem(position: Int) : Int{
        val currentItem = super.getItem(position)
        return currentItem!!.id
    }

//    override fun getItemId(position: Int): Long {
//        return super.getItemId(position)
//    }


}