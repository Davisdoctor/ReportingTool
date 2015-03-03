package com.bsu.reporting_tool;

import com.bsu.reporting_tool.db_helper.BuildDB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReportingCases extends Activity implements View.OnClickListener{
	EditText serialNumber,crime,incidence,occurance,evidence,date,victim,reporting_person;
	Button saveBtn;
	public static final String crimeColumns[]={"serialNumber","crime","incidenceOccurred","areaOccurred","evidence","date","victimRelationship","personReporting"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.report_crime);
		initializeVariables();
	}
public void initializeVariables()
{
	serialNumber=(EditText) findViewById(R.id.serialNumberInput);
	crime=(EditText) findViewById(R.id.crimeInput);
	incidence=(EditText) findViewById(R.id.iNameInput);
	occurance=(EditText) findViewById(R.id.occuranceInput);
	evidence=(EditText) findViewById(R.id.evidenceInput);
	date=(EditText) findViewById(R.id.dateInput);
	victim=(EditText) findViewById(R.id.vRelationInput);
	reporting_person=(EditText) findViewById(R.id.personInput);
	saveBtn=(Button) findViewById(R.id.saveCaseBtn);
	saveBtn.setOnClickListener(this);
	
}
public void onClick(View view)
{
	switch (view.getId()) {
	case R.id.saveCaseBtn:
		String receivedInputs[]={serialNumber.getText().toString(),
								crime.getText().toString(),
								incidence.getText().toString(),
								occurance.getText().toString(),
								evidence.getText().toString(),
								date.getText().toString(),
								victim.getText().toString(),
								reporting_person.getText().toString()};
		
		String tableName="crime_reporting";
		try{
			MyDatabase entry=new MyDatabase(ReportingCases.this);
			entry.open();
			entry.createEntry(receivedInputs, BuildDB.crimeColumns, tableName);
			entry.close();
			Toast.makeText(ReportingCases.this, "Crime Record Successfully Saved", Toast.LENGTH_LONG).show();
			Intent thisClass=new Intent(getApplicationContext(),ReportingCases.class);
			startActivity(thisClass);
		}
		catch(Exception e)
		{
			Toast.makeText(ReportingCases.this, "Record Not Saved", Toast.LENGTH_LONG).show();
		}
	
		break;
	}
}
	
}
