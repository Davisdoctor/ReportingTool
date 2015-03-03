package com.bsu.reporting_tool;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;;

public class MainActivity extends Activity implements OnClickListener {
Button caseReport,caseList,responses,settings,accussedList,complaintList;
SQLiteDatabase sqliteManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initializeVariables();
	}
	
	public void initializeVariables()
	{
		caseReport=(Button) findViewById(R.id.caseReportBtn);
		caseList=(Button) findViewById(R.id.caseListBtn);
		responses=(Button) findViewById(R.id.responsesBtn);
		settings=(Button) findViewById(R.id.settingsBtn);
		accussedList=(Button) findViewById(R.id.accusedListBtn);
		complaintList=(Button) findViewById(R.id.complaintListBtn);
		caseReport.setOnClickListener(this);
		caseList.setOnClickListener(this);
		responses.setOnClickListener(this);
		settings.setOnClickListener(this);
		complaintList.setOnClickListener(this);
		accussedList.setOnClickListener(this);
		
	}
	public void onClick(View view)
	{
		switch(view.getId())
		{
		case R.id.caseReportBtn:
			Intent anotherActivty=new Intent(getApplicationContext(),ReportingCases.class);
			startActivity(anotherActivty);
			break;
			
		case R.id.caseListBtn:
			Intent listActivty=new Intent(getApplicationContext(),ListCases.class);
			startActivity(listActivty);
			break;
			
		case R.id.responsesBtn:
			Intent responsesActivty=new Intent(getApplicationContext(),ReportingCases.class);
			startActivity(responsesActivty);
			break;
			
		case R.id.settingsBtn:
			Intent settingActivty=new Intent(getApplicationContext(),Settings.class);
			startActivity(settingActivty);
			break;
			
		case R.id.accusedListBtn:
			Intent accussedListActivty=new Intent(getApplicationContext(),ListCases.class);
			startActivity(accussedListActivty);
			break;
			
		case R.id.complaintListBtn:
			Intent complaintActivty=new Intent(getApplicationContext(),Settings.class);
			startActivity(complaintActivty);
			break;
		}
	}
	

//	@Override
//	protected void onPause() {
//		// TODO Auto-generated method stub
//		finish();
//		super.onPause();
//	}

}
