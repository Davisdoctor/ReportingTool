package com.bsu.reporting_tool.db_helper;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class BuildDB extends Activity {
SQLiteDatabase sqliteManager;
String crimeColumns[]={"serialNumber","crime","incidenceOccurred","areaOccurred","evidence","date","victimRelationship","personReporting"};
String accussedColumns[]={"accussedPerson","accussedTel","accussedAge","accussedSex","accussedOccupation","accussedTribe","reportingId"};
String complaintColumns[]={"complaintName","compalaintAge","complaintSex","complaintOccupation","complaintTribe","complaintReport","reportingId","category"};
//method for creating the tables at run time 
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
													"personReporting text)");
		//table for holding the accussed information 
		sqliteManager.execSQL("create table accussed(" +
				"accussedId integer primary key autoincrement," +
				"accussedPerson text," +
				"accussedTel text," +
				"accussedAge text," +
				"accussedSex text," +
				"accussedOccupation text," +
				"accussedTribe text," +
				"reportingId text)");
		
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
				"category text)");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public long saveRecord(String[]details, String columns[],String tableName){
	 ContentValues values = new ContentValues();
	 for(int i=0; i<details.length; i++){
		 
		 values.put(columns[i],details[i]);
		 System.out.println(columns[i]+"::::::"+details[i]);
		
	 }
 return sqliteManager.insert(tableName, null, values);
// Toast.makeText(this.context, "the data has been submited in the database", Toast.LENGTH_SHORT).show();

}

}
