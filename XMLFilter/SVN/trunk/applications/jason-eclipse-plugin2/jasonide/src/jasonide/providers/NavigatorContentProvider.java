package jasonide.providers;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class NavigatorContentProvider implements ITreeContentProvider, IResourceChangeListener, IResourceDeltaVisitor {

	/*
	public NavigatorContentProvider() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
	}*/
	
	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		
		/*
		System.out.println("sssss");
		
		if (delta.getKind() == IResourceDelta.CHANGED) {
			System.out.println("a " + delta.getKind() + " " + delta.getFlags() + " " + delta.getResource().toString());
		}
		*/
		return false;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		
		
		/*
        IResource res = event.getResource();
        
        switch (event.getType()) {
        	case IResourceChangeEvent.POST_CHANGE:
				try {
					event.getDelta().accept(this);
				} catch (CoreException e) {
					e.printStackTrace();
				}
        		if (event.getDelta().getKind() == IResourceDelta.CHANGED && event.getDelta().getFlags() == (IResourceDelta.ADDED | IResourceDelta.REMOVED)) {
        			System.out.println("Resources have RENAMED.");
        		} else {
        			System.out.println("Resources have RENAMED." + event.getDelta().getKind() + " = " + event.getDelta().getFlags());
        		}
        	default:
        }*/
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}
}
