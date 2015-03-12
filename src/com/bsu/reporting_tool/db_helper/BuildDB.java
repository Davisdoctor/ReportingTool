package com.bsu.reporting_tool.db_helper;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class BuildDB extends Activity {
public SQLiteDatabase sqliteManager;
public static final String crimeColumns[]={"serialNumber","crime","incidenceOccurred","areaOccurred","evidence","date","victimRelationship","personReporting"};
public static final String crimeColumnsFecth[]={"_id,serialNumber","crime","incidenceOccurred","areaOccurred","evidence","date","victimRelationship","personReporting"};
public static final String accussedColumns[]={"accussedPerson","accussedTel","accussedAge","accussedSex","accussedOccupation","accussedTribe","reportingId"};
public static final String complaintColumns[]={"complaintName","compalaintAge","complaintSex","complaintOccupation","complaintTribe","complaintReport","reportingId","category"};
//method for creating the tables at run time 
//this function is not being used---createDatbaseTables
public void createDatabaseTables()
{
	try {
		//creating the database called case_db
		sqliteManager=openOrCreateDatabase("case_db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		//table for holding for all the crime records
		sqliteManager.execSQL("create table crime_reporting(" +
													"crimeId integer primary key autoincrement," +
													"serialNumber text," +
													"crime text," +
													"incidenceOccurred text," +
													"areaOccurred text," +
													"evidence text," +
													"date text," +
													"victimRelationship text," +
													"personReporting text);");
		Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_LONG).show();
		//table for holding the accussed information 
		sqliteManager.execSQL("create table accussed(" +
				"accussedId integer primary key autoincrement," +
				"accussedPerson text," +
				"accussedTel text," +
				"accussedAge text," +
				"accussedSex text," +
				"accussedOccupation text," +
				"accussedTribe text," +
				"reportingId text);");
		
		//table for holding all the complaints
		sqliteManager.execSQL("create table complaints(" +
				"complaintId integer primary key autoincrement," +
				"complaintName text," +
				"compalaintAge text," +
				"complaintSex text," +
				"complaintOccupation text," +
				"complaintTribe text," +
				"complaintReport text," +
				"reportingId text," +
				"category text);");
		
	} catch (Exception e) {
		// TODO: handle exception
		Toast.makeText(getApplicationContext(), "Not Created", Toast.LENGTH_LONG).show();
		e.printStackTrace();
	}
}

public void saveRecord(String[]details, String columns[],String tableName){
	 ContentValues values = new ContentValues();
	 for(int i=0; i<details.length; i++){
		 
		 values.put(columns[i],details[i]);
		
	 }
 sqliteManager.insert(tableName, null, values);

}
public void closeDb(){
sqliteManager.close();
 //this.close();
 
}
}
