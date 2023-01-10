package es.ull.etsii.app;

/**
 * TrueFilter implements Filter interface to select every movie from MovieDatabase. It's satisfies method always returns true.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

public class TrueFilter implements Filter {
	public boolean satisfies(String id) {
		return true;
	}

}
