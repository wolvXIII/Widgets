package ej.widget.cascading;

import java.util.List;

import ej.widget.State;

class ClassSelector implements Selector {
	private final String classSelector;

	public ClassSelector(String classSelector) {
		this.classSelector = classSelector;
	}

	@Override
	public boolean fit(List<String> classSelectors, List<State> states) {
		return classSelectors.contains(this.classSelector);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ClassSelector) {
			ClassSelector other = (ClassSelector) obj;
			return this.classSelector.equals(other.classSelector);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.classSelector.hashCode();
	}
}
