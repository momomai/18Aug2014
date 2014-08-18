package com.psu.testlistview;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;

public class MainActivity extends Activity {
	
	private TabHost tbHost;
	private Button btnTab1GoTab2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		//StrictMode.setThreadPolicy(policy);
		
		tbHost = (TabHost) findViewById(android.R.id.tabhost);
		tbHost.setup();
		TabHost.TabSpec spec = tbHost.newTabSpec("TAB1")
				.setIndicator(CreateTabView("SEARCH", android.R.drawable.ic_search_category_default))
				.setContent(R.id.tb1);
		tbHost.addTab(spec);
		
		spec = tbHost.newTabSpec("TAB2")
				.setIndicator(CreateTabView("RESULT", android.R.drawable.ic_menu_view))
				.setContent(R.id.tb2);
		tbHost.addTab(spec);
		
		btnTab1GoTab2 = (Button) findViewById(R.id.btnTap1GoTab2);
		btnTab1GoTab2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub		
				tbHost.setCurrentTab(1);
			}
		});
	}
	
	private View CreateTabView(String title,int img){
		View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_tab_item, null,false);
		ImageView iv = (ImageView) v.findViewById(R.id.ivTitle);
		iv.setImageResource(img);
		return v;
	}
}
