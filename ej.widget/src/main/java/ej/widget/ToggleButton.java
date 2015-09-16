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
 * An AbstractToggleButton allows the user to change a setting between two states.
 */
public class ToggleButton extends Button {

	private boolean checked;
	private ToggleButtonGroup group;
	private final List<OnStateChangeListener> onChangeListeners;

	/**
	 * Creates an AbstractToggleButton instance with the specified checked state.
	 * 
	 * @param checked
	 *            if true, the toggle button is initially checked; otherwise, the toggle button is initially unchecked.
	 */
	public ToggleButton(boolean checked) {
		super();
		this.checked = checked;
		this.onChangeListeners = new ArrayList<>();
	}

	public void addOnChangeListener(OnStateChangeListener listener) {
		listener.onStateChange(listener, this.checked, this.checked);
		this.onChangeListeners.add(listener);
	}

	public void removeOnChangeListener(OnStateChangeListener listener) {
		this.onChangeListeners.remove(listener);
	}

	/**
	 * Sets the state of the toggle button.
	 * 
	 * @param checked
	 *            the new state of the toggle button.
	 */
	public void setChecked(boolean checked) {
		if (isEnabled() && checked != this.checked) {
			internalSetChecked(checked);
		}
	}

	/**
	 * Internal method that sets the state of the toggle button without check.
	 * 
	 * @param checked
	 *            the new state of the toggle button.
	 */
	protected void internalSetChecked(boolean checked) {
		boolean oldChecked = this.checked;
		this.checked = checked;
		repaint();

		notifyOnStateChangeListener(oldChecked, checked);

		if (checked && this.group != null) {
			this.group.select(this);
		}
	}

	protected void notifyOnStateChangeListener(boolean before, boolean after) {
		for (OnStateChangeListener listener : this.onChangeListeners) {
			listener.onStateChange(this, before, after);
		}
	}

	/**
	 * Internal method that toggles the button without check.
	 */
	protected void internalToggle() {
		internalSetChecked(!this.checked);
	}

	/* package */void setGroup(ToggleButtonGroup group) {
		ToggleButtonGroup oldGroup = this.group;

		if (group != oldGroup) {
			if (oldGroup != null) {
				this.group = null;
				oldGroup.removeButton(this);
			} else {
				this.group = group;
			}
		}
	}

	/**
	 * Gets the group which contains the toggle button.
	 * 
	 * @return the group of the toggle button or null if the toggle button has no group.
	 */
	public ToggleButtonGroup getGroup() {
		return this.group;
	}

	/**
	 * Gets whether or not the toggle button is checked.
	 * 
	 * @return true if the toggle button is checked otherwise false.
	 */
	public boolean isChecked() {
		return this.checked;
	}

	/**
	 * Changes the ckecked state of the toggle button to the inverse of the current state.
	 */
	public void toggle() {
		setChecked(!this.checked);
	}

	@Override
	public void performClick() {
		if (isEnabled()) {
			internalToggle();
			notifyOnClickListeners();
		}
	}
}
