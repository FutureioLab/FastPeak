<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="@dimen/toolbar_height"
        android:background="@color/colorPrimary"
        app:title="${moduleName}"
        app:titleTextColor="@color/white"/>

    <android.support.v4.widget.SwipeRefreshLayout
        android:id="@+id/swipe"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintEnd_toEndOf="parent">

        <android.support.v7.widget.RecyclerView
            android:id="@+id/recycler"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>

    </android.support.v4.widget.SwipeRefreshLayout>

</LinearLayout>
