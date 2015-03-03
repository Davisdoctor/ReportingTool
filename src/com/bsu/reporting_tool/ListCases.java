package com.bsu.reporting_tool;


import com.bsu.reporting_tool.db_helper.BuildDB;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListCases extends Activity {
	MyDatabase dbManager=null;
    ListView casesList;
    SimpleCursorAdapter adapter;
	 Cursor  dbcursor;
	 BuildDB mydb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_cases);
		dbManager = new MyDatabase(this);
		dbManager.open();
		casesList = (ListView)findViewById(R.id.case_list);
		String columns[] = { "serialNumber","crime","incidenceOccurred","areaOccurred","crimeId" };
		int to[]= new int[]{ R.id.serial_number,R.id.crime ,R.id.incidenceOccurred, R.id.area};
		dbcursor = dbManager.fetchAllRecords("crime_reporting",BuildDB.crimeColumns);
		if(dbcursor.moveToFirst()){
			 startManagingCursor(dbcursor);
			this.setTitle("List of Cases["+ dbcursor.getCount()+"]");
			 adapter = new SimpleCursorAdapter(this, R.layout.case_list_details,   dbcursor, columns, to);
			// dbcursor.deactivate();
			 casesList.setAdapter(adapter);
			 dbManager.close();
	
			// casesList.setOnItemClickListener(this);
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
