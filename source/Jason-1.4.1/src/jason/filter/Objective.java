/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jason.filter;

/**
 *
 * @author Márcio F. Stabile Jr.
 */
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
