package com.demianvelasco.meetingcost;

import android.os.Bundle;
import android.os.Handler;
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
	public int seconds;
	public int minutes;

	TextView timerTextView;
	long startTime = 0;

	//runs without a timer by reposting this handler at the end of the runnable
	Handler timerHandler = new Handler();
	Runnable timerRunnable = new Runnable() {

		@Override
		public void run() {
			long millis = System.currentTimeMillis() - startTime;
			seconds = (int) (millis / 1000);
			minutes = seconds / 60;
			seconds = seconds % 60;

			timerTextView.setText(String.format("%d:%02d", minutes, seconds));

			timerHandler.postDelayed(this, 500);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);

		// Timer Timer Timer
		timerTextView = (TextView) findViewById(R.id.timer_text_view);

		Button timerButton = (Button) findViewById(R.id.start_button);
		timerButton.setText("start");
		timerButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Button b = (Button) v;
				if (b.getText().equals("stop")) {
					timerHandler.removeCallbacks(timerRunnable);	         
					b.setText("start");
				} else {
					startTime = System.currentTimeMillis();
					timerHandler.postDelayed(timerRunnable, 0);
					b.setText("stop");
				}
			}
		});

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

		// Set meeting name on meeting_name TextView
		final TextView meetingNameTextView = (TextView) findViewById(R.id.meeting_name);
		meetingNameTextView.setText("Meeting name: " + meetingName);


		// Test button to check variables
		Button test = (Button) findViewById(R.id.button1);
		test.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplication(), ("Employees:" + numberOfEmployees + averageSalary + meetingName) , Toast.LENGTH_LONG).show();
			}
		});

	}






	@Override
	public void onPause() {
		super.onPause();
		timerHandler.removeCallbacks(timerRunnable);
		Button b = (Button)findViewById(R.id.start_button);
		b.setText("start");
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timer, menu);
		return true;
	}





}

