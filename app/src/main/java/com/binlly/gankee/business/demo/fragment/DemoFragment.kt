package com.binlly.gankee.business.demo.fragment

import android.view.View
import com.binlly.gankee.R
import com.binlly.gankee.base.glide.progress.OnGlideImageViewListener
import com.binlly.gankee.base.mvp.BaseMvpFragment
import com.binlly.gankee.base.rx.RxObserver
import com.binlly.gankee.business.demo.model.DemoModel
import com.binlly.gankee.ext.load
import com.binlly.gankee.ext.loadCircle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import kotlinx.android.synthetic.main.fragment_demo.*
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.toast

/**
 * Created by yy on 2017/8/25.
 */
class DemoFragment: BaseMvpFragment<DemoFragmentPresenter>(), DemoFragmentContract.View {

    private var count = 0

    override fun getContentViewId(): Int {
        return R.layout.fragment_demo
    }

    private lateinit var images: ArrayList<String>

    override fun initView() {
        //        setPageEmpty()
        setPageSuccess()

        images = arrayListOf("http://www.sogoupc.com/uploads/allimg/120309/1-1203091U601.jpg",
                "http://pic4.bbzhi.com/fengjingbizhi/gaoqingkuanpingfengjingbizhixiazai/gaoqingkuanpingfengjingbizhixiazai_404987_10.jpg",
                "http://www.sogoupc.com/uploads/allimg/120309/1-1203091U525.jpg",
                "http://www.1tong.com/uploads/wallpaper/landscapes/404-2-1440x900.jpg",
                "http://pic1.win4000.com/wallpaper/b/51fb21b44fcc6.jpg")

        P.requestImageList(object: RxObserver<DemoFragmentModel>() {
            override fun onNext(result: DemoFragmentModel) {
                super.onNext(result)
                images = result.image_list
            }
        })

        image_1.loadCircle(R.color.colorPrimary)
        image_1.setOnClickListener {
            Glide.get(context).clearMemory()
            bg { Glide.get(context).clearDiskCache() }
            context.toast("清空图片缓存")
        }
        image_2.load(images[0])
        image_2.setOnClickListener {
            image_2.load(images[++count % images.size],
                    listener = object: OnGlideImageViewListener {
                        override fun onProgress(percent: Int, isDone: Boolean,
                                                exception: GlideException?) {
                            println("下载中：$percent")
                            progress.visibility = if (isDone) View.GONE else View.VISIBLE
                            progress.progress = percent
                        }
                    })
        }

        //        refresh()
    }

    private fun refresh() {
        setPageLoading()
        P.requestDemo(object: RxObserver<DemoModel>() {
            override fun onNext(model: DemoModel) {
                setPageSuccess()
                context.toast(model.toString())
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                setPageError()
                e.message ?: return
                context.toast(e.message.toString())
            }

            override fun onComplete() {
                super.onComplete()
                context.toast("onComplete")
            }
        })

        P.requestImageList(object: RxObserver<DemoFragmentModel>() {
            override fun onNext(result: DemoFragmentModel) {
                super.onNext(result)
                images = result.image_list

                image_2.load(images[count % images.size],
                        listener = object: OnGlideImageViewListener {
                            override fun onProgress(percent: Int, isDone: Boolean,
                                                    exception: GlideException?) {
                                println("下载中：$percent")
                                progress.visibility = if (isDone) View.GONE else View.VISIBLE
                                progress.progress = percent
                            }
                        })
            }
        })
    }

    override fun onReload() {
        super.onReload()
        context.toast("reload")
        refresh()
    }
}