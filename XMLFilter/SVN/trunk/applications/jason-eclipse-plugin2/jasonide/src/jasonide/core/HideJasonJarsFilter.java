package jasonide.core;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


public class HideJasonJarsFilter extends ViewerFilter {

	public HideJasonJarsFilter() {
	}
 
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return true;
	}

}