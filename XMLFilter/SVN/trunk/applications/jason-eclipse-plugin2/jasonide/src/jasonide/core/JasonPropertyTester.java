package jasonide.core;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;

public class JasonPropertyTester extends PropertyTester {

	public JasonPropertyTester() {
	}
 
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!(receiver instanceof IAdaptable)){
			return false;
		}
		
		if (property.equals("checkFullPath")){
			IResource res = null;
			
			if (receiver instanceof IResource){
				res = (IResource)receiver;
			} else if (receiver instanceof IPackageFragmentRoot){
				res = ((IPackageFragmentRoot)receiver).getResource();
			} else if (receiver instanceof IPackageFragment){
				res = ((IPackageFragment)receiver).getResource();
			} else if (receiver instanceof ICompilationUnit){
				res = ((ICompilationUnit)receiver).getResource();
			}
			
			String path = res.getFullPath().toString();
			
			if (path.contains((CharSequence)expectedValue)){
				return true;
			} else {
				return false;
			}
		} else if (property.equals("checkCartagoArtifact")) {
			IResource res = null;
			
			if (receiver instanceof IResource){
				res = (IResource)receiver;
			} else if (receiver instanceof IPackageFragmentRoot){
				res = ((IPackageFragmentRoot)receiver).getResource();
			} else if (receiver instanceof IPackageFragment){
				res = ((IPackageFragment)receiver).getResource();
			} else if (receiver instanceof ICompilationUnit){
				res = ((ICompilationUnit)receiver).getResource();
			}
			
			String path = res.getFullPath().toString();
			
			if (path.contains((CharSequence)expectedValue)){
				IProject project = res.getProject();
		        IResource mainFile = null;
				try {
					for (IResource resMain : project.members()) {
						if (resMain.getFileExtension() != null && resMain.getFileExtension().equals("mas2j")) {
							mainFile = resMain;
							break;
						}
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
				
				if (mainFile != null) {
					try {
						String sourceMainFile = Utils.loadFile(mainFile.getLocation().toString());
						
						if (sourceMainFile.indexOf("c4jason.CartagoEnvironment") > -1 || sourceMainFile.indexOf("JaCaMo") > -1) {
							return true;
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return false;
	}
}