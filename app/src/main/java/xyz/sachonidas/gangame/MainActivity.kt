package xyz.sachonidas.gangame

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import xyz.sachonidas.gangame.deals.DealsFragment
import xyz.sachonidas.gangame.owned.TopOwnedFragment
import xyz.sachonidas.gangame.rated.TopRatedFragment

class MainActivity : AppCompatActivity() {

    companion object {
        const val DEFAULT_OPTION = R.id.action_deals

    }

    val fragments : HashMap<Int, Fragment> = hashMapOf(
            Pair(R.id.action_deals, DealsFragment()),
            Pair(R.id.action_top_rated, TopRatedFragment()),
            Pair(R.id.action_most_owned, TopOwnedFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        naviagtionView.selectedItemId = DEFAULT_OPTION
        naviagtionView.setOnNavigationItemSelectedListener { item ->
            val fragment : Fragment? = fragments[item.itemId]

            if (fragment != null)
                replaceFragment(fragment)
            true
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    fun initView(){
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (currentFragment == null)
                supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragmentContainer, fragments[DEFAULT_OPTION])
                        .commit()

    }
}
