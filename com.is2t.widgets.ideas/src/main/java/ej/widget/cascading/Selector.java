package ej.widget.cascading;

import java.util.List;

import ej.widget.State;

interface Selector {
	boolean fit(List<String> classSelectors, List<State> states);
}
