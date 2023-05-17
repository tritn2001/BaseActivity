package com.lutech.baseproject


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_test.view.*


class TestViewPagerAdapter : PagerAdapter {

    var mResources :ArrayList<Integer> = ArrayList()
    var mContext: Context? = null

    var mLayoutInflater: LayoutInflater? = null

    constructor(mContext: Context?,  mResources :ArrayList<Integer>) : super() {
        this.mContext = mContext
        this.mResources = mResources
        mLayoutInflater =
            mContext!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getCount(): Int {
        return mResources.size
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = mLayoutInflater!!.inflate(R.layout.layout_test, container, false)

        Glide.with(mContext!!).load(mResources[position]).into(itemView.image)
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout?)
    }

}