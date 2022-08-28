package com.example.frenny

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.onboarding_screen_layout.*

class MainActivity4 : AppCompatActivity() {

    var OnBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
    var tabLayout: TabLayout?=null
    var onBoardingViewPager: ViewPager?=null
    var next: TextView?=null
    var position=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        tabLayout= findViewById(R.id.tab_indicator)
        next= findViewById(R.id.next)


        val onBoardingData:MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData(title = "Talk to a frenny...", desc = "Feeling lonely and want to speak your heart out to someone who'd listen to you? Boom! You have Frenny. A trained companion who will listen to you for on and on and on... you only need to speak to your Frenny whose area of expertise aligns with your problem and we promise you that your problems will be taken care of.", text = "Sounds Interesting. What's Next?", ImageUrl = R.drawable.talk))
        onBoardingData.add(OnBoardingData(title = "Consult with an Expert...", desc = "Still have problems? Maybe you're looking for an expert solution. To help you we have professional experts onboard from all the different areas of specializations. Choose from a pool of 1000+ experts, who will guide you to find a solution to your problems, in no time. And it's easy so easy to connect to them - just a few clicks away!", text = "Okay! What else?", ImageUrl = R.drawable.expert))
        onBoardingData.add(OnBoardingData(title = "Frenny's Corner...", desc = "Bored? Do you believe you are yet to figure out your problems? Or want to deplete your stress levels? Check the Frenny kits - music, podcasts, videos, and much more to bring you back to the person you truly are. Listen, watch and stand up! Are you ready to explore all of it? Become globally connected by joining our community as a member. ", text = "Gotcha! Now take me in", ImageUrl = R.drawable.frenny))

        setOnBoardingViewPagerAdapter(onBoardingData)

        position = onBoardingViewPager!!.currentItem

        next?.setOnClickListener {
            if(position<onBoardingData.size){
                position++
                onBoardingViewPager!!.currentItem=position
            }
        }
        tabLayout!!.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if (tab.position == onBoardingData.size - 1) {
                    next!!.text = "<< Back"
                } else {
                    next!!.text = "Next >>"
                }
            }

        })

    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>){

        onBoardingViewPager= findViewById(R.id.screenPager);
        OnBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingData)
        onBoardingViewPager!!.adapter= OnBoardingViewPagerAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)
    }
}