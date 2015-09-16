/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

/**
 * An implementation of a radio button, an item that can be selected and deselected and which displays its state to the
 * user.
 */
public class RadioButton extends ToggleButton {

	/**
	 * Creates an AbstractRadioButton instance with the specified checked state.
	 * 
	 * @param checked
	 *            if true, the radio button is initially checked; otherwise, the radio button is initially unchecked.
	 */
	public RadioButton(boolean checked) {
		super(checked);
	}

	@Override
	public void toggle() {
		if (!isChecked()) {
			super.toggle();
		}
	}

	@Override
	protected void internalToggle() {
		if (!isChecked()) {
			super.internalToggle();
		}
	}
}
