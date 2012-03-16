package se.simon.hsp;

import android.app.Application;
import android.content.Context;

public class SPApplication extends Application {
	public static Context context;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		context = getApplicationContext();
	}
	
}
