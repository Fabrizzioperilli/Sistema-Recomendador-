package es.ull.etsii.app;

/**
 * AllFilters implements Filter interface to create an ArrayList structure of Filters.
 * 
 * @author Carlos González Mendoza, Fabrizzio Daniell Perilli Martín, Francisco Javier García González
 * @version 1.0
 */

import java.util.ArrayList;

public class AllFilters implements Filter {
	ArrayList<Filter> filters;

	public AllFilters() {
		filters = new ArrayList<>();
	}

	public void addFilter(Filter f) {
		filters.add(f);
	}

	public boolean satisfies(String id) {
		for (Filter f : filters) {
			if (!f.satisfies(id)) {
				return false;
			}
		}

		return true;
	}

}
