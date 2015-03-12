package com.bsu.reporting_tool;

import com.bsu.reporting_tool.db_helper.BuildDB;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListCases extends Activity implements OnItemClickListener,OnClickListener{
	MyDatabase dbManager=null;
    ListView casesList;
    SimpleCursorAdapter adapter;
	 Cursor  dbcursor;
	 BuildDB mydb;
	 long rowId = -1;
	  int postion = -1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_cases);
		dbManager = new MyDatabase(this);
		dbManager.open();
		dbManager.opeReadblenDb();
		casesList = (ListView) findViewById(R.id.case_list);
		String columns[] = {"_id", "serialNumber","crime","incidenceOccurred" };
		int to[]= new int[]{ R.id.serial_number,R.id.crime ,R.id.incidenceOccurred, R.id.area};
		dbcursor = dbManager.fetchAllRecords("crime_reporting",BuildDB.crimeColumnsFecth);
		 startManagingCursor(dbcursor);
		 adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.case_list_details,   dbcursor, columns, to);
		 casesList.setAdapter(adapter);
		 casesList.setOnItemClickListener(this);
	}
	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		rowId = id;
		postion=position;
//		dialog =mdclass.createDialog(this, this);
//		dialog.show();
		// createDialog();
		// alert_editlist(id);	
}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
