package jason.filter;

import java.util.HashMap;

public class Objective {
	private String tag;
	public HashMap<String, Filter> hashFilter;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Objective(String tag) {
		this.tag = tag;
		hashFilter = new HashMap<String, Filter>();
	}
}
