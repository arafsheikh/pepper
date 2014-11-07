package com.entropicapps.pepper;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class List extends ListActivity {
	
	private Context context = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		this.context = context;
		final TextView tvFormula = (TextView) findViewById(R.id.tvFormula); //Display the formula
		final TextView tvAns = (TextView) findViewById(R.id.tvResult); //Display the answer
		final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final ListView lv = (ListView) findViewById(R.id.lvFormulae);
		final String[] formulae = new String[] {"Add", "Sub", "Mul", "Div"};
		
		//Populate list from string
		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < formulae.length; i++) {
			list.add(formulae[i]);
			
		}
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, list);
		    lv.setAdapter(adapter); //adapter
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, android.view.View view,
			    int position, long id) {
				  String selected = (String) getListAdapter().getItem(position);
				  
				  switch (selected) {
				case "Add":
					inflater.inflate(R.layout.two_fields, parent, false);
					tvFormula.setText("Result = First Number + Second Number");
					TextView add_lable1 = (TextView) findViewById(R.id.two_lable1);
					TextView add_lable2 = (TextView) findViewById(R.id.two_lable2);
					Button add_bRes = (Button) findViewById(R.id.bResult);
					
					add_lable1.setText("First Number");
					add_lable2.setText("Second Number");
					
					add_bRes.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							EditText et1 = (EditText) findViewById(R.id.two_editText1);
							EditText et2 = (EditText) findViewById(R.id.two_editText2);
							
							final double d1 = Double.parseDouble(et1.getText().toString());
							final double d2 = Double.parseDouble(et2.getText().toString());
							tvAns.setText("Result = " + (d1+d2));
						}
					});
					break;
				case "Sub":
					inflater.inflate(R.layout.two_fields, parent, false);
					tvFormula.setText("Result = First Number - Second Number");
					
					TextView sub_lable1 = (TextView) findViewById(R.id.two_lable1);
					TextView sub_lable2 = (TextView) findViewById(R.id.two_lable2);
					Button sub_bRes = (Button) findViewById(R.id.bResult);
					
					sub_lable1.setText("First Number");
					sub_lable2.setText("Second Number");
					
					sub_bRes.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							EditText et1 = (EditText) findViewById(R.id.two_editText1);
							EditText et2 = (EditText) findViewById(R.id.two_editText2);
							
							double d1 = Double.parseDouble(et1.getText().toString());
							double d2 = Double.parseDouble(et2.getText().toString());
							tvAns.setText("Result = " + (d1 - d2));
						}
					});
					break;

				case "Mul":
					inflater.inflate(R.layout.two_fields, parent, false);
					tvFormula.setText("Result = First Number * Second Number");
					TextView mul_lable1 = (TextView) findViewById(R.id.two_lable1);
					TextView mul_lable2 = (TextView) findViewById(R.id.two_lable2);
					Button mul_bRes = (Button) findViewById(R.id.bResult);
					
					mul_lable1.setText("First Number");
					mul_lable2.setText("Second Number");
					
					mul_bRes.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							EditText et1 = (EditText) findViewById(R.id.two_editText1);
							EditText et2 = (EditText) findViewById(R.id.two_editText2);
							
							final double d1 = Double.parseDouble(et1.getText().toString());
							final double d2 = Double.parseDouble(et2.getText().toString());
							tvAns.setText("Result = " + (d1*d2));
						}
					});
					break;
					
				case "Div":
					inflater.inflate(R.layout.two_fields, parent, false);
					tvFormula.setText("Result = First Number + Second Number");
					TextView div_lable1 = (TextView) findViewById(R.id.two_lable1);
					TextView div_lable2 = (TextView) findViewById(R.id.two_lable2);
					Button div_bRes = (Button) findViewById(R.id.bResult);
					
					div_lable1.setText("First Number");
					div_lable2.setText("Second Number");
					
					div_bRes.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							EditText et1 = (EditText) findViewById(R.id.two_editText1);
							EditText et2 = (EditText) findViewById(R.id.two_editText2);
							
							final double d1 = Double.parseDouble(et1.getText().toString());
							final double d2 = Double.parseDouble(et2.getText().toString());
							tvAns.setText("Result = " + (d1+d2));
						}
					});
					break;
				}
			  }
			}); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

}
