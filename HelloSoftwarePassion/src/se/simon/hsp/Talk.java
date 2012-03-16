package se.simon.hsp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

public class Talk implements Comparable<Talk> {

	private JSONObject mJSONObject;
	private Date startTime;

	public Talk(JSONObject jsonObject) {
		mJSONObject = jsonObject;
		startTime = getStartTime(mJSONObject.optJSONObject("span").optString("name"));
	}

	@Override
	public String toString() {
		return mJSONObject.optJSONObject("session").optString("abstractTitle");
	}

	public String getTitle() {
		return mJSONObject.optJSONObject("session").optString("abstractTitle");
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public Object getJSONObject() {
		return mJSONObject;
	}

	@Override
	public int compareTo(Talk another) {
		 if (startTime.before(another.getStartTime()))
	            return -1;
	        else if (startTime.equals(another.getStartTime()))
	            return 0;
	        else
	            return 1;
	}
	
	public String getTimeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMMM, HH:mm");
		return sdf.format(startTime);
	}

	private Date getStartTime(String slot) {
		int day = 0;
		int hour = 0;
		int minute = 0;
		if ("DAY1_KEYNOTE".equals(slot)) {
			day	= 19;
			hour = 9;
			minute = 0;
		} else if ("DAY1_AM_1".equals(slot)) {
			day	= 19;
			hour = 10;
			minute = 10;
		} else if ("DAY1_AM_2".equals(slot)) {
			day	= 19;
			hour = 11;
			minute = 20;
		} else if ("DAY1_PM_1".equals(slot)) {
			day	= 19;
			hour = 13;
			minute = 0;
		} else if ("DAY1_PM_2".equals(slot)) {
			day	= 19;
			hour = 14;
			minute = 10;
		} else if ("DAY1_PM_3".equals(slot)) {
			day	= 19;
			hour = 15;
			minute = 30;
		} else if ("DAY1_PM_4".equals(slot)) {
			day	= 19;
			hour = 16;
			minute = 40;
		} else if ("DAY2_KEYNOTE".equals(slot)) {
			day	= 20;
			hour = 9;
			minute = 0;
		} else if ("DAY2_AM_1".equals(slot)) {
			day	= 20;
			hour = 10;
			minute = 10;
		} else if ("DAY2_AM_2".equals(slot)) {
			day	= 20;
			hour = 11;
			minute = 20;
		} else if ("DAY2_PM_1".equals(slot)) {
			day	= 20;
			hour = 13;
			minute = 0;
		} else if ("DAY2_PM_2".equals(slot)) {
			day	= 20;
			hour = 14;
			minute = 10;
		} else if ("DAY2_PM_3".equals(slot)) {
			day	= 20;
			hour = 15;
			minute = 30;
		} else if ("DAY2_PM_4".equals(slot)) {
			day	= 20;
			hour = 16;
			minute = 40;
		}
		return new Date(112, 2, day, hour, minute);
	}





}
