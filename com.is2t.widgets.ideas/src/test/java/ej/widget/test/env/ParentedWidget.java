package ej.widget.test.env;

import java.util.List;

import ej.mwt.Composite;
import ej.widget.State;
import ej.widget.Styled;

public class ParentedWidget extends SimpleWidget implements Styled {

	private final Composite parent;

	public ParentedWidget(Composite parent) {
		this.parent = parent;
	}

	@Override
	public Composite getParent() {
		return this.parent;
	}

	@Override
	public List<String> getClassSelectors() {
		return null;
	}

	@Override
	public List<State> getStates() {
		return null;
	}

	@Override
	public Object getParentElement() {
		return this.parent;
	}

}
