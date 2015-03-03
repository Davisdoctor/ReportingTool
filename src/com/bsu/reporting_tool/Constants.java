package com.bsu.reporting_tool;

/*
 * Holds all the project constansts including table columns, urls, tableName
 * 
 * 
 */

public class Constants {
	// table names
		public static final String accidentsTableName="accidents";
		public static final String robberiesTableName="robberies";

		public static final String casesTableName="cases";
		public static final String officerDetailsTableName="officerDetails";
		
		public static final String offenceDetails="offenceDetails";
		
	// table columns
	
	public static final String accidentsTableColumns[] = {"officerName","officerNumber","placeName","roadName","district","minorInjuries",
		"majorInjuries","numberOfDeaths","numberOfVehicles","numberPlate","cause","date","status"};
	
	public static final String accidentsTableColumnsToFetch[] = {"_id" ,"officerName","officerNumber","placeName","roadName","district","minorInjuries",
		"majorInjuries","numberOfDeaths","numberOfVehicles","numberPlate","cause","date","status"};
	public static String casesColumns[] = {"numberplate","permitNumber","driverName","officerNumber","officerName","caseDescription","penalty","placeName","roadName","district","date","status"};
	public static String casesColumnsToFetch[] = {"_id","numberplate","permitNumber","driverName","officerNumber","officerName","caseDescription","penalty","placeName","roadName","district","date","status"};

	public static final String robberiesTableColumns[]={"placeName","district","roadName","ItemsRobbed","TypeOfVictimes","WeaponsUsed","MeansOfTransport","officerNumber","officerName","date","status"};
	public static final String robberiesTableColumnsTofetch[] ={"_id","placeName","district","roadName","ItemsRobbed","TypeOfVictimes","WeaponsUsed","MeansOfTransport","officerNumber","officerName","date","status"};
	public static final String officerTableColumns[]={"placeName","district","roadName","officerNumber","officerName"};
	public static final String officerTableColumnsTofetch[] ={"_id","placeName","district","roadName","officerNumber","officerName"};
	public static final String usersTableColumns[]={"username","password"};
	public static final String usersTableColumnsTofetch[]={"_id","username","password"};
	
	// tables creation strings
	public static final String createCasesTable = "create table cases(" +
																		"_id integer primary key autoincrement," +
																		"numberplate text," +
																		"permitNumber text," +
																		"driverName text," +
																		"officerNumber text," +
																		"officerName text," +
																		"caseDescription text," +
																		"penalty text," +
																		"placeName text," +
																		"roadName text," +
																		"district text," +
																		"date text,"+
																		 "status text)" ;
	public static final String createrobberiesTabel = "create table robberies(" +
																			  " _id integer primary key autoincrement," +
																			  "placeName text," +
																			  "district text," +
																			  "roadName text," +
																			  "ItemsRobbed text," +
																			  "TypeOfVictimes text,"+
																			  "WeaponsUsed text,"+
																			  "MeansOfTransport text,"+
																			  "officerNumber text," +
																			  "officerName text," +
																			  "date text, "+
																			  "status text)" ;
	public static final String createUsersTable="create table users("+
																	"_id integer primary key autoincrement,"+
																	"username text,"+
																	"password text)";
	public static final String createOfficerDetailsTable="create table officerDetails("+
															" _id integer primary key autoincrement," +
															  "placeName text," +
															  "district text," +
															  "roadName text," +
															  "officerNumber text," +
															  "officerName text)" ;
	
	public static final String createOffencesTable="create table offenceDetails("+
													"_id integer primary key autoincrement,"+
													" section text,offences text, amount int)";
	
															
																	
	
	// urls
	//localhost urls
	public static final String casesUrl = "http://mobi-afande.com/server/server_feedback/insertCases.php";
	public static final String numberPlatefollowupUrl = "http://mobi-afande.com/server/server_feedback/followupNumberPlate.php";
	public static final String permitNumberfollowupUrl = "http://mobi-afande.com/server/server_feedback/followupPermitNumber.php";
	public static final String accidentsUrl ="http://mobi-afande.com/server/server_feedback/insertAccidentDetails.php";
	public static final String robbereisUrl ="http://mobi-afande.com/server/server_feedback/insertRobberies.php";
	public static final String permitUrl = "http://mobi-afande.com/server/server_feedback/getPermitData.php";
	public static final String vehicleCheckerUrl ="http://mobi-afande.com/server/server_feedback/vehicleChecker.php";

	//web urls
	public static final String casesWebUrl ="http://mobi-afande.com/server/server_feedback/insertCases.php";
	public static final String accidentsWebUrl ="http://mobi-afande.com/server/server_feedback/insertAccidentDetails.php";
	public static final String robbereisWebUrl ="http://mobi-afande.com/server/server_feedback/insertRobberies.php";
	public static final String permitNumberfollowupWebUrl ="http://mobi-afande.com/server/server_feedback/followupPermitNumber.php";
	public static final String numberPlatefollowupWebUrl ="http://mobi-afande.com/server/server_feedback/followupNumberPlate.php";
	public static final String permitWebUrl = "http://mobi-afande.com/server/server_feedback/getPermitData.php";
	public static final String vehicleCheckerWebUrl ="http://mobi-afande.com/server/server_feedback/vehicleChecker.php";


	





	


	
	
	

	
}
