package com.binlly.gankee.business.photo

import android.os.Bundle
import com.binlly.gankee.R
import com.binlly.gankee.base.mvp.BaseActivity
import kotlinx.android.synthetic.main.activity_photo_view.*

/**
 * Created by yy on 2017/11/17.
 */
class PhotoViewActivity: BaseActivity() {

    override fun getContentView(): Int = R.layout.activity_photo_view

    private var pos: Int = 0

    private lateinit var adapter: PhotoPagerAdapter

    override fun initView(savedInstanceState: Bundle?) {
        pos = intent.getIntExtra("position", 0)
        val photos = intent.getStringArrayListExtra("photo_list")
        photos ?: return
        if (photos.isEmpty()) return

        adapter = PhotoPagerAdapter(this, photos)
        photo_pager.transitionName = "photo"
        photo_pager.offscreenPageLimit = 2
        photo_pager.adapter = adapter
        photo_pager.currentItem = pos
    }

    //    override fun onBackPressed() {
    //        super.onBackPressed()
    //        overridePendingTransition(R.anim.stay, R.anim.fade_scale_large_small)
    //    }
}