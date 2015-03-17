
package jasonide.xtext.mas2j;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Mas2jStandaloneSetup extends Mas2jStandaloneSetupGenerated{

	public static void doSetup() {
		new Mas2jStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

