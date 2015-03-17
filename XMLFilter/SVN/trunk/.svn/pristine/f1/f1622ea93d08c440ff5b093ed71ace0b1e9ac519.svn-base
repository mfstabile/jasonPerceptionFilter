package jasonide.nature;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class JasonBuilder extends IncrementalProjectBuilder implements IResourceDeltaVisitor {
	public static final String BUILDER_ID = "jasonide.jasonBuilder";
	
	public JasonBuilder() {
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		return false;
	}

	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {
		return null;
	}
 
	
}
