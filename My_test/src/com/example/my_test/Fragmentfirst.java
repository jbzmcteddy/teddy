package com.example.my_test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragmentfirst extends Fragment {
	
	private EditText account;
	private EditText password;
	private Button loginBtn;
	private Button cancelBtn;
	private Button registerBtn;
	private Mysqlite myDB;
	
	private Editor editor;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.activity_second,container,false);
		
		account = (EditText)v.findViewById(R.id.editText1);
		password = (EditText)v.findViewById(R.id.editText2);
		loginBtn = (Button)v.findViewById(R.id.button1);
		loginBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();  // 取得FragmentManager（如果不向下相容，就不用加Support）
	             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	             Fragmentsecond f = new Fragmentsecond();  // 把上面的FragmentA new出來！
	             fragmentTransaction.add(R.id.Main_Activity, f);  // 丟入到llParent之中
	             fragmentTransaction.commit(); // 必須commit以後才會真正add
			}
			});
		cancelBtn = (Button)v.findViewById(R.id.button2);
		cancelBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();  // 取得FragmentManager（如果不向下相容，就不用加Support）
	             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	             Fragmentsecond ff = new Fragmentsecond(); 
	             fragmentTransaction.replace(R.id.Main_Activity, ff);
	             fragmentTransaction.commit();
			}
			});
		
		registerBtn = (Button)v.findViewById(R.id.register);
		registerBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sqladd();
				sharedpreferencesadd();
			}
			
		});
		return v;
	}
	private void sqladd(){
		String acc = account.getText().toString();
		String pass = password.getText().toString();
		myDB = new Mysqlite(getActivity());
		myDB.add(acc,pass);
	}
	
	
	private void sharedpreferencesadd(){
		SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE); 
		editor = sharedPref.edit (); 
		editor.putString("acc", account.getText().toString());
	    editor.putString("pass", password.getText().toString());
	    editor.commit();
	}
	
//	private Button.OnClickListener login=new Button.OnClickListener(){
//
//		@Override
//		public void onClick(View arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//
//};
	
}