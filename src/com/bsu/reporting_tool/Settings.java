package com.bsu.reporting_tool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends Activity implements View.OnClickListener{
	Button accussedBtn,complaintBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings_menu);
		initializeVariables();
	}
public void initializeVariables()
{
	accussedBtn=(Button) findViewById(R.id.accusedLinkBtn);
	complaintBtn=(Button) findViewById(R.id.complaintLinkBtn);
	accussedBtn.setOnClickListener(this);
	complaintBtn.setOnClickListener(this);
}
public void onClick(View view)
{
	switch(view.getId())
	{
		case R.id.accusedLinkBtn:
			Intent accussed=new Intent(getApplicationContext(),Accussed.class);
			startActivity(accussed);
			break;
			
		case R.id.complaintLinkBtn:
			Intent complaint=new Intent(getApplicationContext(),Complaint.class);
			startActivity(complaint);
			break;
	}
}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
