package com.example.leaf;
	
import java.util.ArrayList;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.searchdemo.R;
	
public class TreeLeafAdapter extends BaseAdapter {
	
	/** 元素数据源 */
	private ArrayList<LeafDao> elementsData;
	/** 树中元素 */
	private ArrayList<LeafDao> elements;
	/** item的行首缩进基数 */
	private int indentionBase;
	
	public TreeLeafAdapter(ArrayList<LeafDao> elements,
			ArrayList<LeafDao> elementsData) {
		this.elements = elements;
		this.elementsData = elementsData;
		indentionBase = 50;
	}
	
	public ArrayList<LeafDao> getElements() {
		return elements;
	}
	
	public ArrayList<LeafDao> getElementsData() {
		return elementsData;
	}
	
	@Override
	public int getCount() {
		return elements.size();
	}
	
	@Override
	public Object getItem(int position) {
		return elements.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder =null;
		
		if(convertView==null){
			
			holder=new ViewHolder();
			convertView = View.inflate(parent.getContext(), R.layout.list_items, null);
			holder.iv_hot=(ImageView) convertView.findViewById(R.id.iv_hot);
			holder.tv_content_title=(TextView) convertView.findViewById(R.id.tv_content_title);
			convertView.setTag(holder);
			
		}else{
			
			holder = (ViewHolder) convertView.getTag();
			
		}
		
		LeafDao element = elements.get(position);
		holder.tv_content_title.setText(element.getContentText().getKeyword());
		if(element.isHasChildren() && !element.isExpanded()){
			holder.iv_hot.setImageResource(R.drawable.up);
			holder.iv_hot.setVisibility(View.VISIBLE);
		}else if(element.isHasChildren() && element.isExpanded()){
			holder.iv_hot.setImageResource(R.drawable.down);
			holder.iv_hot.setVisibility(View.VISIBLE);
		}else if(!element.isHasChildren()){
			holder.iv_hot.setImageResource(R.drawable.up);
			holder.iv_hot.setVisibility(View.INVISIBLE);
		}
		
		return convertView;
	}
	
	static class ViewHolder {
		
		ImageView iv_hot;
		TextView tv_content_title;
	}
}
