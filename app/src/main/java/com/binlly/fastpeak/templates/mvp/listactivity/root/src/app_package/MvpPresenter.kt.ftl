package ${packageName}

import android.content.Context
import android.content.Intent

class ${moduleName}Presenter(context: Context, mView: ${moduleName}Contract.View):
        BaseActivityPresenterImpl<${moduleName}Contract.View>(context, mView),
        ${moduleName}Contract.Presenter {

    private val PAGE_SIZE = 20
    private var page = 0

    private val datas = makeFakeDatas(30)

    override fun handleIntent(intent: Intent): Boolean {
        return true
    }

    override fun request(observer: RxObserver<${moduleName}Model>) {
        page = 0
        V().onRefresh()
        page++
    }

    override fun loadMore(observer: RxObserver<${moduleName}Model.Model>) {
        val from = page * PAGE_SIZE
        if (from >= datas.size) {
            V().hideLoading()
            V().loadEnd()
            return
        }
        val to = if (datas.size > from + PAGE_SIZE) from + PAGE_SIZE else datas.size
        V().onLoadMore(getSlice(from until to))
        V().loadComplete()
        page++
    }

    private fun getSlice(range: IntRange): List<${moduleName}Model.Model> {
        return datas.slice(range)
    }

    private fun makeFakeDatas(size: Int): List<${moduleName}Model.Model> {
        val list = arrayListOf<${moduleName}Model.Model>()
        val random = Random()
        (0 until size).map {
            ${moduleName}Model.Model(random.nextBoolean())
        }.forEach {
            list.add(it)
        }
        return list
    }
}
