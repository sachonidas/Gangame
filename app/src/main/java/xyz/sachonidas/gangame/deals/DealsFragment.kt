package xyz.sachonidas.gangame.deals

import android.support.v7.widget.RecyclerView
import xyz.sachonidas.commons.BaseListFragment
import xyz.sachonidas.commons.DataBindingRecyclerAdapter
import xyz.sachonidas.gangame.BR
import xyz.sachonidas.gangame.Deal
import xyz.sachonidas.gangame.R
import xyz.sachonidas.gangame.data.GangameDataSource

/**
 * Created by sachonidas on 20/9/17.
 */

class DealsFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal,
                R.layout.item_deal)
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals(){
        GangameDataSource
                .getDeals()
                .subscribe({ list ->
                    replaceItems(list)
                }, { error ->
                    showError(error)
                })
    }


    private fun replaceItems(list: List<Deal>){
        with(listAdapter as DataBindingRecyclerAdapter<Deal>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
    }


    /*override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<Deal>)
                .items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()
    }

    fun getDummyDeals():ArrayList<Deal>{
        return arrayListOf(Deal("Counter Strike",
                0.99F,
                9.99F,
                80,
                80,
                "http://cdn.akamai.steamstatic.com/steam/apps/10/capsule_184x69.jpg"))
    }*/


}
