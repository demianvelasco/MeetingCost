package com.demianvelasco.meetingcost;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends Activity {
	public int var;
	public int numberOfEmployees;
	public int averageSalary;
	public String meetingName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		
		
		// Get number of employees
		if (null != savedInstanceState && savedInstanceState.containsKey("numberOfEmployees")) {
			numberOfEmployees = savedInstanceState.getInt("numberOfEmployees");
		} else if (null != getIntent().getExtras() && getIntent().getExtras().containsKey("numberOfEmployees")) {
			numberOfEmployees = getIntent().getExtras().getInt("numberOfEmployees");
		} else {
			//Log.w(TAG, "QuizActivity has been started without a specified number of questions. This indicates an error in the way it is being called."); // Dev String
			numberOfEmployees = 1;
		}
		
		
		//Get average salary
		if (null != savedInstanceState && savedInstanceState.containsKey("averageSalary")) {
			averageSalary = savedInstanceState.getInt("averageSalary");
		} else if (null != getIntent().getExtras() && getIntent().getExtras().containsKey("averageSalary")) {
			averageSalary = getIntent().getExtras().getInt("averageSalary");
		} else {
			//Log.w(TAG, "QuizActivity has been started without a specified number of questions. This indicates an error in the way it is being called."); // Dev String
			averageSalary = 1;
		}
		
		// Get meeting string value
		if (null != savedInstanceState && savedInstanceState.containsKey("meetingName")) {
			meetingName = savedInstanceState.getString("meetingName");
		} else if (null != getIntent().getExtras() && getIntent().getExtras().containsKey("meetingName")) {
			meetingName = getIntent().getExtras().getString("meetingName");
		} else {
			//Log.w(TAG, "QuizActivity has been started without a specified number of questions. This indicates an error in the way it is being called."); // Dev String
			meetingName = "No Meeting Name";
		}
		
		final TextView meetingNameTextView = (TextView) findViewById(R.id.meeting_name);
		meetingNameTextView.setText("Meeting name: " + meetingName);
		
		Button test = (Button) findViewById(R.id.button1);
		test.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplication(), ("Employees:" + numberOfEmployees + averageSalary + meetingName) , Toast.LENGTH_LONG).show();
				
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timer, menu);
		return true;
	}

}
