package xyz.sachonidas.gangame.owned

import android.support.v7.widget.RecyclerView
import xyz.sachonidas.commons.BaseListFragment
import xyz.sachonidas.commons.DataBindingRecyclerAdapter
import xyz.sachonidas.gangame.BR
import xyz.sachonidas.gangame.R
import xyz.sachonidas.gangame.TopGame
import xyz.sachonidas.gangame.data.GangameDataSource

/**
 * Created by sachonidas on 20/9/17.
 */

class TopOwnedFragment : BaseListFragment(){
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onResume() {
        super.onResume()
        showMostOwned()
    }

    private fun showMostOwned(){
        GangameDataSource
                .getMostOwned()
                .subscribe({ list ->
                    replaceItems(list)
                }, { error ->
                    showError(error)
                })
    }


    private fun replaceItems(list: List<TopGame>){
        with(listAdapter as DataBindingRecyclerAdapter<TopGame>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
    }



}
