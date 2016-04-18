package blackriders.listview2gridview;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;




/**
 * Created by Sanwal Singh on 18/4/16.
 */
public class GridViewAdapter extends ArrayAdapter<Component>{
	
	public GridViewAdapter(Context context, int layoutResourceId, List<Component> data) { 
		super(context, layoutResourceId, data); 
	}

	@Override 
	public View getView(int position, View convertView, ViewGroup parent) { 
		View curView = convertView; 
		
		if (curView == null) 
		{ 
			LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			curView = inflater.inflate(R.layout.component_grid, null); 

		} 
		
        Component cp = getItem(position);
        
        //sets the layouts for the item
        TextView title = (TextView) curView.findViewById (R.id.title);
        TextView subtitle = (TextView) curView.findViewById (R.id.subtitle);
        
        //sets the title and the subtitle for the current component
        title.setText(cp.getTitle());
        subtitle.setText(cp.getSubtitle());
		
		return curView;
	} 	
}


