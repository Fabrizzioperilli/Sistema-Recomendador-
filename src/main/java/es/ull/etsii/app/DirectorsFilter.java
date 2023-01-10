package es.ull.etsii.app;

/**
 * DirectorsFilters implements Filter interface to create a String[] structure of directors.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

public class DirectorsFilter implements Filter {
	private String[] dirList;

	public DirectorsFilter(String directors) {
		dirList = directors.split(",");
	}

	public boolean satisfies(String id) {
		String movieDirector = MovieDatabase.getDirector(id);
		for (String dir : dirList) {
			if (movieDirector.indexOf(dir) != -1) {
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return "DirectorFilter " + dirList;
	}

}
