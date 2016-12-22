package nl.fzit.MaakBoekingGnuCash;

public class MaakBoeking {

	File dir = new File("put path to classes you want to load here");
	URL loadPath = dir.toURI().toURL();
	URL[] classUrl = new URL[]{loadPath};

	ClassLoader cl = new URLClassLoader(classUrl);

	Class loadedClass = cl.loadClass("classname"); // must be in package.class name format
	
	MyModule modInstance = (MyModule)loadedClass.newInstance();
	
}
