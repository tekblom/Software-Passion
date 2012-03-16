package se.simon.hsp;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TalkAdapter extends ArrayAdapter<Talk>{

	private List<Talk> talks;
	private LayoutInflater vi;
	private int textViewResourceId;

	public TalkAdapter(Context context, int textViewResourceId,
			List<Talk> talks) {
		super(context, textViewResourceId, talks);
		this.talks = talks;
		this.textViewResourceId = textViewResourceId;
		vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		ViewHolder holder;
		if (v == null) {
			v = vi.inflate(textViewResourceId, null); 
			holder = new ViewHolder();
			holder.title = (TextView) v.findViewById(R.id.title);
			holder.time = (TextView) v.findViewById(R.id.time);
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}
		
		Talk talk  = talks.get(position);
		
		holder.title.setText(talk.getTitle());
		holder.time.setText(talk.getTimeString());
		
		return v;
	}

	private static class ViewHolder{
		TextView title;
		TextView time;
	}

}
