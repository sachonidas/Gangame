package xyz.sachonidas.commons

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by sachonidas on 18/10/17.
 */
class DataBindingViewHolder<MODEL>(val itemVariableId : Int, val binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item : MODEL){
        binding.setVariable(itemVariableId, item)
        binding.executePendingBindings()
    }
}