package xyz.sachonidas.commons

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 * Created by sachonidas on 4/10/17.
 */

abstract class BaseListFragment : BaseFragment(){

    lateinit var listAdapter : RecyclerView.Adapter<*>

    override fun getLayoutResId(): Int {
        return R.layout.fragment_list
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter = getAdapter()

        //Evitar codigo repetitivo y evitar null en el view list
        view?.list?.let {
            with(view.list) {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }

    }


    abstract fun getAdapter() : RecyclerView.Adapter<*>
}