package com.example.my_test;

import com.example.my_test.MainActivity;
import com.example.my_test.R;
import com.example.my_test.SecondActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.FragmentTransaction;
import android.app.FragmentManager;



public class MainActivity extends FragmentActivity {

	private ImageButton imageButton;
	private TextView accountShow;
	private Button fragmentBtn;

	private static final int EDIT=1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        imageButton = (ImageButton)findViewById(R.id.imageButton1);
        accountShow = (TextView)findViewById(R.id.textView3);
        imageButton.setOnClickListener(btnclick);
		fragmentBtn = (Button)findViewById(R.id.newPageBtn);
		fragmentBtn.setOnClickListener(fragmentBtnClick);
    }

    private ImageButton.OnClickListener btnclick=new ImageButton.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//將值傳到第二頁之後再傳回來
//			Intent intent = new Intent();
//	        intent.setClass(MainActivity.this, SecondActivity.class);
////	        startActivity(intent);
//	        Bundle bundle = new Bundle();
//	        bundle.putString("account", "");
//	        intent.putExtras(bundle); 
//	        startActivityForResult(intent, EDIT);
		}

	 
    	
    };
    
    private Button.OnClickListener fragmentBtnClick=new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 accountShow.setText("下一頁");
			
			 FragmentManager fragmentManager = getFragmentManager();  // 取得FragmentManager（如果不向下相容，就不用加Support）
             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             Fragmentfirst f = new Fragmentfirst();  // 把上面的FragmentA new出來！
             fragmentTransaction.add(R.id.Main_Activity, f);  // 丟入到llParent之中
             fragmentTransaction.commit(); // 必須commit以後才會真正add

		}
    	
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
               super.onActivityResult(requestCode, resultCode, data);

               switch(requestCode){
               case EDIT:
            	   accountShow.setText("您的帳號"+data.getExtras().getString("account"));
              }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
