/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import java.util.ArrayList;
import java.util.List;

/**
 * The ToggleButtonGroup provides a container to organize groups of toggle button widgets.
 * 
 * ToggleButtonGroup provides an abstract container into which button widgets can be placed. It does not provide a
 * visual representation of this container, but instead manages the states of each of the buttons in the group.
 * 
 * It switches off all toggle buttons except the one that has been clicked.
 * 
 * A button can be added to the group with and removed with removeButton(). The currently checked button is available
 * with getChecked().
 */
public class ToggleButtonGroup {

	private final List<ToggleButton> buttons;
	private ToggleButton checked;

	/**
	 * Constructs a new, empty button group.
	 */
	public ToggleButtonGroup() {
		this.buttons = new ArrayList<>();
	}

	/**
	 * Adds the given button to the button group.
	 * 
	 * @param button
	 *            the button to add to the group.
	 */
	public void addButton(ToggleButton button) {
		if (!this.buttons.contains(button)) {
			if (button.isChecked()) {
				if (this.checked != null) {
					throw new IllegalArgumentException("Already one button is selected"); //$NON-NLS-1$
				} else {
					this.checked = button;
				}
			}
			this.buttons.add(button);
			button.setGroup(this);
		}
	}

	/**
	 * Removes the given button from the button group.
	 * 
	 * @param button
	 *            the button to remove from the group.
	 */
	public void removeButton(ToggleButton button) {
		if (this.buttons.contains(button)) {
			this.buttons.remove(button);
			button.setGroup(null);
		}
	}

	/**
	 * Returns the button group's checked button, or 0 if no buttons are checked.
	 * 
	 * @return the current selected button.
	 */
	public ToggleButton getChecked() {
		return this.checked;
	}

	/* package */void select(ToggleButton button) {
		if (this.buttons.contains(button)) {
			if (this.checked != null) {
				this.checked.setChecked(false);
			}

			button.setChecked(true);
			this.checked = button;
		}
	}

	/**
	 * Returns the button group's list of buttons. This may be empty.
	 * 
	 * @return the buttons of the group.
	 */
	public List<ToggleButton> getButtons() {
		return this.buttons;
	}
}
