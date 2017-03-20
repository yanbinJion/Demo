package com.example.searchdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.leaf.Leaf;
import com.example.leaf.LeafDao;
import com.example.leaf.TreeLeafAdapter;
import com.example.leaf.TreeLeafItemClickListener;

public class MainActivity extends Activity {

	/** 树中的元素集合 */
	public ArrayList<LeafDao> leafs;
	/** 数据源元素集合 */
	public ArrayList<LeafDao> leafData;
	private ListView treeview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		treeview = (ListView) findViewById(R.id.lv_list);
		
		leafInit();
		TreeLeafAdapter leafAdapter = new TreeLeafAdapter(leafs, leafData);
		
		
		
		
		TreeLeafItemClickListener leafItemClickListener = new TreeLeafItemClickListener(
				leafAdapter);
		
		treeview.setAdapter(leafAdapter);
		treeview.setOnItemClickListener(leafItemClickListener);
	}
	
	private void leafInit() {

		leafs = new ArrayList<LeafDao>();
		leafData = new ArrayList<LeafDao>();
		LeafDao e1 = new LeafDao(new Leaf("汽车"), LeafDao.TOP_LEVEL, 0,
				LeafDao.NO_PARENT, true, false);
		LeafDao e2 = new LeafDao(new Leaf("电脑"), LeafDao.TOP_LEVEL, 1,
				LeafDao.NO_PARENT, true, false);
		LeafDao e3 = new LeafDao(new Leaf("玛莎拉蒂"),
				LeafDao.TOP_LEVEL + 1, 2, e1.getId(), true, false);
		LeafDao e4 = new LeafDao(new Leaf("玛莎拉蒂总裁"),
				LeafDao.TOP_LEVEL + 2, 3, e3.getId(), false, false);
		LeafDao e5 = new LeafDao(new Leaf("玛莎拉蒂GT"),
				LeafDao.TOP_LEVEL + 2, 4, e3.getId(), false, false);
		LeafDao e6 = new LeafDao(new Leaf("玛莎拉蒂GC"),
						LeafDao.TOP_LEVEL + 2, 5, e3.getId(), false, false);
		LeafDao e7 = new LeafDao(new Leaf("兰博基尼"),
				LeafDao.TOP_LEVEL + 1, 6, e1.getId(), false, false);
		LeafDao e8 = new LeafDao(new Leaf("联想"),
						LeafDao.TOP_LEVEL + 1, 7, e2.getId(), true, false);
		LeafDao e9 = new LeafDao(new Leaf("联想G470"),
						LeafDao.TOP_LEVEL + 2, 8, e8.getId(), false, false);

		
		leafs.add(e1);
		leafs.add(e2);
		leafData.add(e1);
		leafData.add(e2);
		leafData.add(e3);
		leafData.add(e4);
		leafData.add(e5);
		leafData.add(e6);
		leafData.add(e7);
		leafData.add(e8);
		leafData.add(e9);
	}	
	
}
