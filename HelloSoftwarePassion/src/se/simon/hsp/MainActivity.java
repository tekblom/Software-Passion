package se.simon.hsp;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        new AsyncTask<Object, Object, List<Talk>>() {

			@Override
			protected List<Talk> doInBackground(Object... params) {
				return WebCom.getTalks();
			}
        	
			@Override
			protected void onPostExecute(List<Talk> result) {
				super.onPostExecute(result);
				onDataFetchComplete(result);
			}
        	
		}.execute();
        
    }

	protected void onDataFetchComplete(List<Talk> result) {
		findViewById(R.id.progressBar1).setVisibility(View.GONE);
		TalkAdapter adapter = new TalkAdapter (
        		this, 
        		R.layout.list_item, 
        		result);
        
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> listView, View arg1,
					int position, long arg3) {
				Object o = listView.getAdapter().getItem(position);
				if ( o instanceof Talk ) {
					Intent intent = new Intent(MainActivity.this, DetailActivity.class);
					intent.putExtra("jsonData", ((Talk) o).getJSONObject().toString());
					startActivity(intent);
				}
			}
		});
        listView.setAdapter(adapter);
	}
}