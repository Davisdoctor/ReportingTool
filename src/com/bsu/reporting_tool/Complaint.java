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

public class Complaint extends Activity implements View.OnClickListener {
	EditText cNames,cTelNumber,cAge,cOccupation,cTribe;
	Spinner cSexSpinner,cReportSpinner,cCategorySpinner;
	Button saveComplaint;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.complaint);
		initializeVariables();
		
	}
	public void initializeVariables()
	{
		cNames=(EditText) findViewById(R.id.compPNames);
		cTelNumber=(EditText) findViewById(R.id.compTelNumber);
		cAge=(EditText) findViewById(R.id.compAge);
		cSexSpinner=(Spinner) findViewById(R.id.compSexSpinnner);
		cOccupation=(EditText) findViewById(R.id.compOccupation);
		cTribe=(EditText) findViewById(R.id.compTribe);
		cReportSpinner=(Spinner) findViewById(R.id.compReportSpinner);
		cCategorySpinner=(Spinner) findViewById(R.id.compCategorySpinner);
		saveComplaint=(Button) findViewById(R.id.saveComplaintBtn);
		saveComplaint.setOnClickListener(this);
		loadSpinnerData();
	}
	public void onClick(View v)
	{
		switch (v.getId()) {
		case R.id.saveComplaintBtn:
			String receivedInputs[]={cNames.getText().toString(),
									cTelNumber.getText().toString(),
									cAge.getText().toString(),
									cSexSpinner.getSelectedItem().toString(),
									cOccupation.getText().toString(),
									cTribe.getText().toString(),
									cReportSpinner.getSelectedItem().toString(),
									cCategorySpinner.getSelectedItem().toString()};
			
			String tableName="complaints";
			try{
				MyDatabase entry=new MyDatabase(Complaint.this);
				entry.open();
				entry.createEntry(receivedInputs, BuildDB.complaintColumns, tableName);
				entry.close();
				Toast.makeText(Complaint.this, "Complaint Record Successfully Saved", Toast.LENGTH_LONG).show();
				Intent thisClass=new Intent(getApplicationContext(),Complaint.class);
				startActivity(thisClass);
			}
			catch(Exception e)
			{
				Toast.makeText(Complaint.this, "Record Not Saved", Toast.LENGTH_LONG).show();
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
		cReportSpinner.setAdapter(dataAdapter);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
