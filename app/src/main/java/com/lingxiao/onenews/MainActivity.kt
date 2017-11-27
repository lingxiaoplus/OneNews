package com.lingxiao.onenews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.lingxiao.onenews.view.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title_bar.*

class MainActivity : BaseActivity() {
    val items = listOf("首页","资讯","本地")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }
    private fun initView() {
        tb_title.setTitle("一个新闻")
        setSupportActionBar(tb_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //初始化底部导航栏
        bottom_navigation
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor(R.color.black)
                .setBarBackgroundColor(R.color.white)
        bottom_navigation.setMode(BottomNavigationBar.MODE_FIXED);
        bottom_navigation
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        bottom_navigation
                .addItem(BottomNavigationItem(R.drawable.ic_svg_home, items[0])
                .setInactiveIcon(ContextCompat.getDrawable(this, R.drawable.ic_svg_home)))
                .addItem( BottomNavigationItem(R.drawable.ic_svg_news, items[1])
                .setInactiveIcon(ContextCompat.getDrawable(this, R.drawable.ic_svg_news)))
                .addItem(BottomNavigationItem(R.drawable.ic_svg_local, items[2])
                .setInactiveIcon(ContextCompat.getDrawable(this, R.drawable.ic_svg_local)))
                .setFirstSelectedPosition(0)
                .initialise();//所有的设置需在调用该方法前完成
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
