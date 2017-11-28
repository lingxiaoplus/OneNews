package com.lingxiao.onenews

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.lingxiao.onenews.adapter.MainPagerAdapter
import com.lingxiao.onenews.view.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title_bar.*

class MainActivity : BaseActivity() {
    val items = listOf("首页","资讯","本地")
    var adapter: MainPagerAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    private fun initView() {
        initToolBar()
        //初始化底部导航栏
        initBottomBar()
        //初始化viewpager
        initViewPager()
    }

    private fun initViewPager() {
        adapter = MainPagerAdapter(supportFragmentManager,items)
        vp_main.adapter = adapter
        vp_main.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                bottom_navigation.selectTab(position)
            }

        })
    }

    private fun initBottomBar() {
        bottom_navigation
                .setActiveColor(R.color.white)
                .setInActiveColor(R.color.white)
                .setBarBackgroundColor(R.color.white)
        bottom_navigation
                .addItem(BottomNavigationItem(R.drawable.ic_svg_home, items[0])
                        .setActiveColorResource(R.color.colorPrimary))
                .addItem( BottomNavigationItem(R.drawable.ic_svg_news, items[1])
                        .setActiveColorResource(R.color.colorPrimaryDark))
                .addItem(BottomNavigationItem(R.drawable.ic_svg_local, items[2])
                        .setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(0)
                .initialise();//所有的设置需在调用该方法前完成
        bottom_navigation.setTabSelectedListener(object :
                BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {

            }

            override fun onTabSelected(position: Int) {
                vp_main.setCurrentItem(position)
            }

        })
    }

    private fun initToolBar() {
        tb_title.setTitle("一个新闻")
        setSupportActionBar(tb_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //创建返回键，并实现打开关/闭监听
        val mDrawerToggle = object : ActionBarDrawerToggle(this, dl_menu,
                tb_title, R.string.open, R.string.close) {
            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }
        }
        mDrawerToggle.syncState()
        dl_menu.setDrawerListener(mDrawerToggle)
    }
}

