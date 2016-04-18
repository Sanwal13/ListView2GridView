package blackriders.listview2gridview;


/**
 * Class Component
 * An object Component represents a basic item of the list/grid
 * 
 */


/**
 * Created by Sanwal Singh on 18/4/16.
 */
public class Component{

	private String title;
	private String subtitle;
	
	public Component(String t, String sub) {
		title = t;
		subtitle = sub;	
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String s) {
		
		this.title = s;	
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String s) {
		this.subtitle = s;
	}



}
