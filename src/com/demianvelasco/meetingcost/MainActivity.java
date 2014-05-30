package com.demianvelasco.meetingcost;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button startMeeting = (Button) findViewById(R.id.btn_start_meeting);
		startMeeting.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Intent i = new Intent(MainActivity.this, TimerActivity.class);
				
				
				
				// Get number of employees and check for valid int
				final EditText numberOfEmployeesInput = (EditText) findViewById(R.id.input_number_of_employees);
				final int numberOfEmployees;
				try{
					numberOfEmployees = Integer.parseInt(numberOfEmployeesInput.getText().toString());
				} catch( final NumberFormatException e){
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.invalid_number_of_employees), Toast.LENGTH_LONG).show();
					return;
				}
				
				if (numberOfEmployees < 1) {
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.invalid_number_of_employees), Toast.LENGTH_LONG).show();
					return;
				}
				
				// Get average salary and check for a valid value
				final EditText averageSalaryInput = (EditText) findViewById(R.id.input_average_salary);
				final int averageSalary;
				try {
					averageSalary = Integer.parseInt(averageSalaryInput.getText().toString());
				} catch (final NumberFormatException e) {
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.invalid_number_of_employees), Toast.LENGTH_LONG).show();
					return;
				}
				if ( averageSalary < 1) {
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.invalid_number_of_employees), Toast.LENGTH_LONG).show();
				}
				
				startActivity(i);
			}
			
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
