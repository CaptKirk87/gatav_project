package de.fhkl.gatav_project;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
			}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	public void Button1(View v) {
		Uri adress = Uri.parse("http://www.fh-kl.de/");
		Intent intent = new Intent(Intent.ACTION_VIEW, adress);
		startActivity(intent);
	}

	
	
}
