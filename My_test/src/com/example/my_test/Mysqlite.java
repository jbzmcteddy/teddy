package com.example.my_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Mysqlite extends SQLiteOpenHelper {

	private final static int DBVersion = 1; 
	private final static String DBName = "myData.db";
	private final static String tableName = "Data";
	
	
	public Mysqlite(Context context){
		super(context,DBName,null,DBVersion);
	}
	
	
	public Mysqlite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		db.execSQL("CREATE TABLE "+tableName+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,UserName VARCHAR,Password VARCHAR);");

	}
	
//	@Override
//	public void onOpen(SQLiteDatabase db) {
//		// TODO Auto-generated method stub
//		super.onOpen(db);
//		}
//	
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
		// TODO Auto-generated method stub
		
		db.execSQL("DROP TABLE IF EXISTS " + tableName);
		onCreate(db);
	}
	

	void add(String user,String pass){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("UserName", user);
		values.put("Password", pass);
		db.insert(tableName, null, values);
	}

}
