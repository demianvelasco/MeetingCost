package com.demianvelasco.meetingcost;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class TimerActivity extends Activity {
	public int var;
	public int numberOfEmployees;
	public int averageSalary = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		
		
//		var = numberOfEmployees * averageSalary;
//		
//	EditText test = (EditText) findViewById(R.id.test);
//	test.setText("Test Test");
////		
//		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timer, menu);
		return true;
	}

}
