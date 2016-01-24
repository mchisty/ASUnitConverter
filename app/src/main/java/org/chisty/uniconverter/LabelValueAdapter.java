package org.chisty.uniconverter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LabelValueAdapter extends ArrayAdapter<LabelValue> {
	private Context context;
	private int resourceId;
	private LabelValue labelValue;
	private LayoutInflater inflater;

	public LabelValueAdapter(Context context, int resourceId) {
		super(context, resourceId);
		this.context = context;
		this.resourceId = resourceId;
		inflater = ((Activity) context).getLayoutInflater();
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	private View getCustomView(int position, View convertView, ViewGroup parent) {
		LVHolder holder = null;
		// ----------------------------------------
		// Get the holder
		// ----------------------------------------
		if (convertView == null) {
			convertView = inflater.inflate(resourceId, parent, false);
			holder = new LVHolder();
			holder.labelTxtView = (TextView) convertView.findViewById(R.id.cs_txt);
			convertView.setTag(holder);
		} else {
			holder = (LVHolder) convertView.getTag();
		}
		// ----------------------------------------
		// Assign the values from VO
		// ----------------------------------------
		labelValue = this.getItem(position);
		holder.labelTxtView.setText(labelValue.getLabel());
		// ----------------------------------------
		return convertView;
	}

	public static class LVHolder {
		TextView labelTxtView;
	}
}
