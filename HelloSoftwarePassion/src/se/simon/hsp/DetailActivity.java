package se.simon.hsp;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class DetailActivity extends Activity {
	
	private String TAG = DetailActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		
		String jsonDataString = getIntent().getStringExtra("jsonData");
		JSONObject slot = null;
		
		try {
			slot = new JSONObject(jsonDataString);
		} catch (JSONException e) {
			Log.e(TAG , e.getMessage());
		}
		
		if ( null != slot ) {
			JSONObject session = slot.optJSONObject("session");
			((TextView) findViewById(R.id.title)).setText(session.optString("abstractTitle"));
			((WebView) findViewById(R.id.abstract_text)).loadData(session.optString("abstractText"), "text/html", null);
		}
	}
}
