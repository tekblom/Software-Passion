package se.simon.hsp;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HelloSoftwarePassionActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        new AsyncTask<Object, Object, List<String>>() {

			@Override
			protected List<String> doInBackground(Object... params) {
				return WebCom.getTalks();
			}
        	
			@Override
			protected void onPostExecute(List<String> result) {
				super.onPostExecute(result);
				onDataFetchComplete(result);
			}
        	
		}.execute();
        
    }

	protected void onDataFetchComplete(List<String> result) {
		findViewById(R.id.progressBar1).setVisibility(View.GONE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        		this, 
        		android.R.layout.test_list_item, 
        		result);
        
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
	}
}