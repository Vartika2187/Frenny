package com.example.frenny

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class OnBoardingViewPagerAdapter(private var context: Context, private var onBoardingDataList: List<OnBoardingData>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view= LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout, null);
        val imageView : ImageView
        val title: TextView
        val desc: TextView
        val text: TextView

        imageView = view.findViewById(R.id.imageView)
        title = view.findViewById(R.id.title)
        desc = view.findViewById(R.id.desc)
        text = view.findViewById(R.id.text)

        imageView.setImageResource(onBoardingDataList[position].ImageUrl)
        title.text = onBoardingDataList[position].title
        desc.text= onBoardingDataList[position].desc
        text.text= onBoardingDataList[position].text

        container.addView(view)
        return view
    }

}