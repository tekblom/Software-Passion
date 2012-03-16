package se.simon.hsp;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class WebCom {
	
	public static List<Talk> getTalks() {
		List<Talk> result = new ArrayList<Talk>();
		try {
			URL url = new URL("http://softwarepassion.se/api/slots");
			URLConnection conn = url.openConnection();
			conn.addRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			conn.connect();
			
			Scanner scanner = new Scanner(conn.getInputStream());
			
			String jsonStr = "";
			while(scanner.hasNext()) {
				jsonStr += scanner.nextLine();
			}
			
			JSONObject jsonObject = new JSONObject(jsonStr);
			JSONArray jsonArray = jsonObject.getJSONArray("slotList");
			
			for(int i = 0; i < jsonArray.length(); i++) {
				result.add(new Talk(jsonArray.getJSONObject(i)));
			}
			
			Collections.sort(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}
