package ru.alinadorozhkina.tula_steel.adapter

import androidx.fragment.app.*

class ViewPagerAdapter (
    private val dataFragments: MutableList<Fragment> = mutableListOf(),
    fragmentManager: FragmentManager
): FragmentStatePagerAdapter(fragmentManager) {

    override fun getCount(): Int  =dataFragments.size
    override fun getItem(position: Int): Fragment = dataFragments[position]

}
