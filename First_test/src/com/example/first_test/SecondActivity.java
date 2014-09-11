package com.example.first_test;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {

	private EditText account;
	private EditText password;
	private Button loginBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		account = (EditText)findViewById(R.id.editText1);
		password = (EditText)findViewById(R.id.editText2);
		loginBtn = (Button)findViewById(R.id.button1);
		
		loginBtn.setOnClickListener(login);
	}
	
	private void ShowAlertDialog()
	{
	Builder MyAlertDialog = new AlertDialog.Builder(this);
	MyAlertDialog.setTitle("登入");
	MyAlertDialog.setMessage("登入帳號為"+account.getText());
	MyAlertDialog.show();
	}
	
	private Button.OnClickListener login=new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ShowAlertDialog();
			
		}
		
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
