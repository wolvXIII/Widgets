/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

/**
 * A SimpleButton is a Button containing a label.
 */
public class SimpleButton extends Button {

	private final Label label;

	public SimpleButton() {
		this.label = new Label();
		setWidget(this.label);
	}

	public String getText() {
		return this.label.getText();
	}

	public void setText(String text) {
		this.label.setText(text);
	}

}
