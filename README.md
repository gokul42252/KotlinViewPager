# KotlinViePager

http://thoughtnerds.com/viewpager-using-kotlin-android-tutorial/

<h1><span style="color: #000000;"><a href="http://thoughtnerds.com/viewpager-using-kotlin-android-tutorial/" style="color: #000000;">ViewPager Using Kotlin Android Tutorial</a></span></h1>
<span>ViewPager in Android allows the user to flip left and right through pages of data. In our android ViewPager application we’ll implement a ViewPager that swipes through three views. This tutorial to show how implement </span>ViewPager Using Kotlin Android .

<img src="http://thoughtnerds.com/wp-content/uploads/2018/02/Screenshot-56-160x300.png" alt="" width="255" height="479" class="wp-image-486 alignnone" />

1) Create a Model enum for getting three view Model.kt
<pre><span style="color: #ff6600;">package com.cretlabs.viewpager

/**
 * Created by Gokul on 2/11/2018.
 */

enum class Model private constructor(val titleResId: Int, val layoutResId: Int) {
    RED(R.string.one, R.layout.layout_one),
    BLUE(R.string.two, R.layout.layout_two),
    GREEN(R.string.three, R.layout.layout_three)
}</span></pre>
2) Create a Pager adapter to inflate view CustomPagerAdapter.kt
<pre><span style="color: #ff6600;">package com.cretlabs.viewpager</span>

<span style="color: #ff6600;">/**
 * Created by Gokul on 2/11/2018.
 */
import android.content.Context</span>
<span style="color: #ff6600;">import android.support.v4.view.PagerAdapter</span>
<span style="color: #ff6600;">import android.view.LayoutInflater</span>
<span style="color: #ff6600;">import android.view.View</span>
<span style="color: #ff6600;">import android.view.ViewGroup</span>

<span style="color: #ff6600;">class CustomPagerAdapter(private val mContext: Context) : PagerAdapter() {</span>

<span style="color: #ff6600;">    override fun instantiateItem(collection: ViewGroup, position: Int): Any {</span>
<span style="color: #ff6600;">        val modelObject = Model.values()[position]</span>
<span style="color: #ff6600;">        val inflater = LayoutInflater.from(mContext)</span>
<span style="color: #ff6600;">        val layout = inflater.inflate(modelObject.layoutResId, collection, false) as ViewGroup</span>
<span style="color: #ff6600;">        collection.addView(layout)</span>
<span style="color: #ff6600;">        return layout</span>
<span style="color: #ff6600;">    }</span>

<span style="color: #ff6600;">    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {</span>
<span style="color: #ff6600;">        collection.removeView(view as View)</span>
<span style="color: #ff6600;">    }</span>

<span style="color: #ff6600;">    override fun getCount(): Int {</span>
<span style="color: #ff6600;">        return Model.values().size
    }</span>

<span style="color: #ff6600;">    override fun isViewFromObject(view: View, `object`: Any): Boolean {</span>
<span style="color: #ff6600;">        return view === `object`</span>
<span style="color: #ff6600;">    }</span>

<span style="color: #ff6600;">    override fun getPageTitle(position: Int): CharSequence {</span>
<span style="color: #ff6600;">        val customPagerEnum = Model.values()[position]</span>
<span style="color: #ff6600;">        return mContext.getString(customPagerEnum.titleResId)</span>
<span style="color: #ff6600;">    }</span>

<span style="color: #ff6600;">}
</span></pre>
3) Create layout_one.xml to infalte first view
<pre><span style="color: #ff6600;">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_gravity="center"
    android:layout_height="match_parent"&gt;

    &lt;android.support.v7.widget.AppCompatTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        style="@style/Base.TextAppearance.AppCompat.Subhead"
        android:text="@string/one" /&gt;
&lt;/android.support.constraint.ConstraintLayout&gt;

</span></pre>
4) Create layout_two.xml to inflate second view
<pre><span style="color: #ff6600;">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_gravity="center"
    android:layout_height="match_parent"&gt;
    &lt;android.support.v7.widget.AppCompatTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        style="@style/Base.TextAppearance.AppCompat.Subhead"
        android:text="@string/two" /&gt;
&lt;/android.support.constraint.ConstraintLayout&gt;</span></pre>
5) Create layout_three.xml to inflate third view
<pre><span style="color: #ff6600;">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_gravity="center"
    android:layout_height="match_parent"&gt;

    &lt;android.support.v7.widget.AppCompatTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        style="@style/Base.TextAppearance.AppCompat.Subhead"
        android:text="@string/three" /&gt;
&lt;/android.support.constraint.ConstraintLayout&gt;</span></pre>
6) Create a activity_main.xml contains viewpager
<pre><span style="color: #ff6600;">&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.cretlabs.viewpager.MainActivity"&gt;

    &lt;android.support.v4.view.ViewPager
        android:id="@+id/viewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/&gt;

</span><span><span style="color: #ff6600;">&lt;/android.support.constraint.ConstraintLayout&gt;</span>
</span></pre>
7) Create MainActivity.Kt to initialize and setting adapter to Viewpager
<pre><span style="color: #ff6600;">package com.cretlabs.viewpager</span>

<span style="color: #ff6600;">import android.os.Bundle</span>
<span style="color: #ff6600;">import android.support.v4.view.ViewPager</span>
<span style="color: #ff6600;">import android.support.v7.app.AppCompatActivity</span>
<span style="color: #ff6600;">import android.view.View</span>


<span style="color: #ff6600;">class MainActivity : AppCompatActivity() {</span>
<span style="color: #ff6600;">    override fun onCreate(savedInstanceState: Bundle?) {</span>
<span style="color: #ff6600;">        super.onCreate(savedInstanceState)</span>
<span style="color: #ff6600;">        setContentView(R.layout.activity_main);
        val viewPager = findViewById&lt;View&gt;(R.id.viewpager) as ViewPager</span>
<span style="color: #ff6600;">        viewPager.adapter = CustomPagerAdapter(this)</span>
<span style="color: #ff6600;">    }</span>
<span style="color: #ff6600;">}</span></pre>

