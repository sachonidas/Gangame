package xyz.sachonidas.gangame.deals

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import xyz.sachonidas.commons.BaseListFragment
import xyz.sachonidas.commons.DataBindingRecyclerAdapter
import xyz.sachonidas.gangame.BR
import xyz.sachonidas.gangame.Deal
import xyz.sachonidas.gangame.R

/**
 * Created by sachonidas on 20/9/17.
 */

class DealsFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal,
                R.layout.item_deal)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<Deal>)
                .items.addAll(getDummyDeals())
    }

    fun getDummyDeals():ArrayList<Deal>{
        return arrayListOf(Deal("Counter Strike",
                0.99F,
                9.99F,
                80,
                80,
                "http://cdn.akami.steamstatic.com/steam/apps/10/capsule_184x69.jpg "))
    }


}
