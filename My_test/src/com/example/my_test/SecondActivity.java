package com.example.my_test;

import com.example.my_test.R;

import android.app.Activity;
import android.content.Intent;
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
	private Button cancelBtn;
	private Button registerBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		account = (EditText)findViewById(R.id.editText1);
		password = (EditText)findViewById(R.id.editText2);
		loginBtn = (Button)findViewById(R.id.button1);
		cancelBtn = (Button)findViewById(R.id.button2);
		registerBtn = (Button)findViewById(R.id.register);
		
		loginBtn.setOnClickListener(login);
		cancelBtn.setOnClickListener(cancel);
		registerBtn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	

//	
//	private void ShowErrorAlertDialog()
//	{
//	Builder MyAlertDialog = new AlertDialog.Builder(this);
//	MyAlertDialog.setTitle("錯誤");
//	MyAlertDialog.setMessage("請輸入登入帳號");
//	MyAlertDialog.show();
//	}

	private Button.OnClickListener login=new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
//			if(account.getText().length()==0){
//				ShowErrorAlertDialog();
//			}else{
//			ShowAlertDialog();
//			}
			
			
			Intent i=new Intent();
			Bundle bundle = new Bundle();
			bundle.putString("account", account.getText().toString());
			i.putExtras(bundle);
			setResult(RESULT_OK, i);
			finish();
		}
		
	};
	
	private Button.OnClickListener cancel=new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent();
			Bundle bundle = new Bundle();
			bundle.putString("account","尚未登入");
			i.putExtras(bundle);
			setResult(RESULT_OK, i);
			finish();
			
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
