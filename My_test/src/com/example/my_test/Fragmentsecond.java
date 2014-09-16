package com.example.my_test;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragmentsecond extends Fragment {
	
	private TextView spAcc;
	private TextView spPass;
	private	TextView sqlAcc;
	private	TextView sqlPass;
	private Mysqlite myDB;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.activity_fragment,container,false);
		spAcc = (TextView)v.findViewById(R.id.sharePrefAcc);
		spPass = (TextView)v.findViewById(R.id.sharePrePass);
		sqlAcc = (TextView)v.findViewById(R.id.sqliteTextAcc);
		sqlPass = (TextView)v.findViewById(R.id.sqliteTextPass);
		
		//使用SharedPreferences
		SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		String spacc = sharedPref.getString("acc", null );
		String sppass = sharedPref.getString("pass", null );
		spAcc.setText(spacc);
		spPass.setText(sppass);
		
		//使用SQLite
		myDB = new Mysqlite(getActivity());
		SQLiteDatabase db = myDB.getWritableDatabase();
        Cursor cursor = db.query("Data", new String[] {"UserName", "Password"}, null, null, null, null, null);
        cursor.moveToLast();
        sqlAcc.setText(cursor.getString(0));
        sqlPass.setText(cursor.getString(1));
		return v;
		
	}

	private SharedPreferences getSharedPreferences() {
		// TODO Auto-generated method stub
		return null;
	}

}
