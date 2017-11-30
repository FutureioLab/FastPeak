package ${packageName}


interface ${moduleName}Contract {
    interface View: BaseView {
        fun onRefresh(list: List<${moduleName}Model.Model>)

        fun onLoadMore(list: List<${moduleName}Model.Model>)

        fun loadComplete()

        fun loadEnd()

        fun loadFail()
    }

    interface Presenter: BaseActivityPresenter {
        fun request(observer: RxObserver<${moduleName}Model>)

        fun loadMore(observer: RxObserver<${moduleName}Model>)
    }
}
