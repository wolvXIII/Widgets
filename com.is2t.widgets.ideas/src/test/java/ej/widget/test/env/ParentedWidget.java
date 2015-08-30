package ej.widget.test.env;

import ej.mwt.Composite;

public class ParentedWidget extends SimpleWidget {

	private final Composite parent;

	public ParentedWidget(Composite parent) {
		this.parent = parent;
	}

	@Override
	public Composite getParent() {
		return this.parent;
	}

}
