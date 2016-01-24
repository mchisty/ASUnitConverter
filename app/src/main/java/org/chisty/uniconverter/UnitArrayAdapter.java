package org.chisty.uniconverter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class UnitArrayAdapter extends ArrayAdapter<UnitTuple> {
	private Context context;
	private UnitTuple[] unitTuples;

	public UnitArrayAdapter(Context context, int resource, UnitTuple[] objects) {
		super(context, resource, objects);
		this.context = context;
		this.unitTuples = objects;
	}

	public UnitTuple[] getUnitTuples() {
		return unitTuples;
	}

	public void setUnitTuples(UnitTuple[] unitTuples) {
		this.unitTuples = unitTuples;
	}

	public UnitTuple getItem(int position) {
		return unitTuples[position];
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView label = new TextView(getContext());
		label.setText(unitTuples[position].getLabel());
		return label;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		TextView label = new TextView(getContext());
		label.setText(unitTuples[position].getLabel());
		return label;
	}
}
