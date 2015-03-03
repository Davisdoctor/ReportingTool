package com.bsu.reporting_tool;

import java.util.List;

import com.bsu.reporting_tool.db_helper.BuildDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Accussed extends Activity implements View.OnClickListener {
EditText pNames,telNumber,age,occupation,tribe;
Spinner sexSpinner,reportSpinner;
Button saveAccussed;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accussed);
		initializeVariables();
	}
	public void initializeVariables()
	{
		pNames=(EditText) findViewById(R.id.accusedPNames);
		telNumber=(EditText) findViewById(R.id.accussedTelNumber);
		age=(EditText) findViewById(R.id.accussedAge);
		sexSpinner=(Spinner) findViewById(R.id.accussedSexSpinnner);
		occupation=(EditText) findViewById(R.id.accussedOccupation);
		tribe=(EditText) findViewById(R.id.accussedTribe);
		reportSpinner=(Spinner) findViewById(R.id.accussedReportSpinner);
		saveAccussed=(Button) findViewById(R.id.saveAccussedBtn);
		saveAccussed.setOnClickListener(this);
		loadSpinnerData();
		
	}
	public void onClick(View v)
	{
		switch (v.getId()) {
		case R.id.saveAccussedBtn:
			String receivedInputs[]={pNames.getText().toString(),
									telNumber.getText().toString(),
									age.getText().toString(),
									sexSpinner.getSelectedItem().toString(),
									occupation.getText().toString(),
									tribe.getText().toString(),
									reportSpinner.getSelectedItem().toString()};
			
			String tableName="accussed";
			try{
				MyDatabase entry=new MyDatabase(Accussed.this);
				entry.open();
				entry.createEntry(receivedInputs, BuildDB.accussedColumns, tableName);
				entry.close();
				Toast.makeText(Accussed.this, "Accussed Record Successfully Saved", Toast.LENGTH_LONG).show();
				Intent thisClass=new Intent(getApplicationContext(),Accussed.class);
				startActivity(thisClass);
			}
			catch(Exception e)
			{
				Toast.makeText(Accussed.this, "Record Not Saved", Toast.LENGTH_LONG).show();
			}
		
			break;
		}
	}
	private void loadSpinnerData() {
		// database handler
		MyDatabase db = new MyDatabase(getApplicationContext());
		//first open the database so that you can read from it to load contents in the spinner
		db.open();
		// Spinner Drop down elements
		List<String> lables = db.getAllLabels();

		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, lables);

		// Drop down layout style - list view with radio button
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		reportSpinner.setAdapter(dataAdapter);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
