package com.why.project.collapsingtoolbarlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

	private AppBarLayout appBarLayout;
	private CollapsingToolbarLayout mCollapsingToolbarLayout;
	private LinearLayout mHeadlayout;
	private Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initToolBar();
		setTitleToCollapsingToolbarLayout();
	}

	private void initViews() {
		appBarLayout = findViewById(R.id.appBar);
		mCollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
		mHeadlayout = findViewById(R.id.head_layout);
	}

	private void initToolBar() {
		mToolbar = findViewById(R.id.toolbar_base);
		setSupportActionBar(mToolbar);//由于toolbar只是一个普通控件，我们将ToolBar设置为ActionBar
	}

	/**
	 * 使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，
	 * 设置到Toolbar上则不会显示【备注：其实是可以的】
	 */
	private void setTitleToCollapsingToolbarLayout() {
		appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
			@Override
			public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
				if (verticalOffset <= -mHeadlayout.getHeight() * 4 /5) {
					mCollapsingToolbarLayout.setTitle("我的");//设置标题
					//使用下面两个CollapsingToolbarLayout的方法设置展开透明->折叠时你想要的颜色
					mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
					mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.nav_text_color));

				} else {
					mCollapsingToolbarLayout.setTitle("");
				}
			}
		});
	}
}
