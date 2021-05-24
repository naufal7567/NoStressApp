package org.nostress.behappy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.trace
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import org.nostress.behappy.fragment.AccountFragment
import org.nostress.behappy.fragment.DashboardFragment
import org.nostress.behappy.fragment.TestFragment

class MainActivity : AppCompatActivity() {
    private val dashboardFragment = DashboardFragment()
    private val testFragment = TestFragment()
    private val accountFragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(dashboardFragment)
        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_dashboard -> replaceFragment(dashboardFragment)
                R.id.ic_test -> replaceFragment(testFragment)
                R.id.ic_account_box -> replaceFragment(accountFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}