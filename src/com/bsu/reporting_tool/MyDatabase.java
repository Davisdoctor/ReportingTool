package com.bsu.reporting_tool;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase {
	//setting up table rows from here
//creating database name and table
private static final String DATABASE_NAME="cases_db";

//giving the database a version
private static final int DATABASE_VERSION=1;

private DbHelper ourHelper;
private final Context ourContext;
private SQLiteDatabase ourDatabase;


//creating a class helper
private static class DbHelper extends SQLiteOpenHelper
{
	
public DbHelper(Context context)
{
 super(context,DATABASE_NAME,null,DATABASE_VERSION);	
}

@Override
public void onCreate(SQLiteDatabase db) {
	// TODO Auto-generated method stub
	//create table when this method is first run
db.execSQL("create table crime_reporting(" +
			"crimeId integer primary key autoincrement," +
			"serialNumber text," +
			"crime text," +
			"incidenceOccurred text," +
			"areaOccurred text," +
			"evidence text," +
			"date text," +
			"victimRelationship text," +
			"personReporting text);");
//Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_LONG).show();
//table for holding the accussed information 
db.execSQL("create table accussed(" +
"accussedId integer primary key autoincrement," +
"accussedPerson text," +
"accussedTel text," +
"accussedAge text," +
"accussedSex text," +
"accussedOccupation text," +
"accussedTribe text," +
"reportingId text);");

//table for holding all the complaints
db.execSQL("create table complaints(" +
"complaintId integer primary key autoincrement," +
"complaintName text," +
"compalaintAge text," +
"complaintSex text," +
"complaintOccupation text," +
"complaintTribe text," +
"complaintReport text," +
"reportingId text," +
"category text);");
	
	
	
}
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	// TODO Auto-generated method stub
	//if the database has already been created this will executed 
	db.execSQL("DROP TABLE IF EXITS complaints");
	db.execSQL("DROP TABLE IF EXITS accussed");
	db.execSQL("DROP TABLE IF EXITS crime_reporting");
	onCreate(db);
}


}
public Cursor fetchIndividualRecord(long rowId, String columnsToFetch[],String tableName,String key){
	
	Cursor results = ourDatabase.query(tableName, columnsToFetch, key+"="+rowId, null, null, null, null);
	if(results!=null){
		results.moveToFirst();

	}
	return results;
	
}

public Cursor fetchAllRecords(String tableName, String columnsToFetch[]){
	
	
	Cursor results = ourDatabase.query(tableName, columnsToFetch, null, null, null, null, null);
	if(results!=null){
		results.moveToFirst();

	}
	ourDatabase.close();
	return results;
}

public MyDatabase(Context c)
{
ourContext=c;	
}

public MyDatabase open(){
	ourHelper=new DbHelper(ourContext);
	ourDatabase=ourHelper.getWritableDatabase();
	return this;
	}

public void close()
{
ourHelper.close();	
}

public List<String> getAllLabels(){
	List<String> labels = new ArrayList<String>();
	
    // Select All Query
    String selectQuery = "SELECT  * FROM crime_reporting";
 
    SQLiteDatabase db = ourHelper.getReadableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
 
    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
        	labels.add(cursor.getString(1));
        } while (cursor.moveToNext());
    }
    
    // closing connection
    cursor.close();
    db.close();
	
	// returning lables
	return labels;
}

//method for saving in a particular database table
public long createEntry(String [] details, String [] columns,String dbTableName) {
	// TODO Auto-generated method stub
	ContentValues cv=new ContentValues();
	for(int i=0; i<details.length; i++){
		 
		 cv.put(columns[i],details[i]);
	 }
	//data inserted from here.pick all values of cv
	return ourDatabase.insert(dbTableName, null, cv);
}

//public String getData() {
//	// TODO Auto-generated method stub
//	String [] columns=new String []{KEY_ROWID,KEY_NAME,KEY_HOTNESS};
//	Cursor c=ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null); 
//	String result="";
//	int iRow=c.getColumnIndex(KEY_ROWID);
//	int iName=c.getColumnIndex(KEY_NAME);
//	int iHotness=c.getColumnIndex(KEY_HOTNESS);
//	
//	for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
//	{
//		result=result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iHotness) + "\n";	
//	}
//	return result;
//}
/**
 * Getting all labels
 * returns list of labels
 * */
}
