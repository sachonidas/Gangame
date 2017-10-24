package xyz.sachonidas.gangame.rated

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import xyz.sachonidas.commons.BaseListFragment
import xyz.sachonidas.commons.DataBindingRecyclerAdapter
import xyz.sachonidas.gangame.BR
import xyz.sachonidas.gangame.R
import xyz.sachonidas.gangame.TopGame

/**
 * Created by sachonidas on 20/9/17.
 */

class TopRatedFragment : BaseListFragment(){
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_top_rated
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (listAdapter as DataBindingRecyclerAdapter<TopGame>)
                .items.addAll(getDummyTopGames())

    }

    fun getDummyTopGames():ArrayList<TopGame>{
        return arrayListOf(TopGame(title = "Counter Strike",
                owners = 13407338,
                publisher = "Valve",
                steamRating = 80,
                price = 9.99F,
                position = 1,
                thumb = "http://cdn.akami.steamstatic.com/steam/apps/10/capsule_184x69.jpg "))
    }

}
