package com.demianvelasco.meetingcost;



import android.os.Bundle;
import android.app.Activity;
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
		
		
		final Button startMeeting = (Button) findViewById(R.id.startButton);
		startMeeting.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				final EditText numberOfEmployeesInput = (EditText) findViewById(R.id.numberOfEmployees);
				final int numberOfEmployees;
				
				try {
					numberOfEmployees = Integer.parseInt(numberOfEmployeesInput.getText().toString());
				} catch (final NumberFormatException e) {
					Toast.makeText(getApplicationContext(), getResources().getString(R.string.invalid_number_of_employees), Toast.LENGTH_LONG).show();
					return;
				}
				
				Toast.makeText(getApplicationContext(),"Employees: " + numberOfEmployees, Toast.LENGTH_LONG).show();
				
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
