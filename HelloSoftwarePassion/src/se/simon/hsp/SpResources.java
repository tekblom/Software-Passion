package se.simon.hsp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SpResources {

	
	private static Context mContext;
	private static SpResources instance;
	private static final String SHARED_PREFERENCE_NAME = "appland.market";

	private SpResources() {	}

	public static SpResources instance() {
		mContext = SPApplication.context;
		if(null == instance) {
			instance = new SpResources();
		}
		return instance;
	}
	
	
	/*
	 * Returns a private instance of APP's default SharedPreferences
	 */
	private SharedPreferences getSharedPreferences() {
		return mContext.getApplicationContext().getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
	}
	
	/*
	 * Returns an editor to manipulate the default Shared Preferences
	 */
	private Editor getEditor() {
		return getSharedPreferences().edit();
	}
	
	
	/**
	 * Method for storing an attribute with key {@link MarketAttribute} on a private 
	 * persistent location with {@link android.content.SharedPreferences}. 
	 * @param key
	 * @param value
	 * @return true if attribute stored
	 */
	public boolean putAttribute(String key, String value) {
		Editor editor = getEditor();
		editor.putString(key, value);
		return editor.commit();
	}
	
	/**
	 * Method for getting an attribute with key {@link MarketAttribute} from private persistent storage location.
	 * @param marketAttributes
	 * @return
	 */
	public String getAttribute(String key) {
		return getSharedPreferences().getString(key, "");
	}
	
	
}
