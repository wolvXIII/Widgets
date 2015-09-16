/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

/**
 * Defines the data model used by components like Sliders and ProgressBars. Defines three interrelated integer
 * properties: minimum, maximum and value. These three integers define the following range:
 * 
 * minimum <= value <= maximum
 */
public interface BoundedRangeModel {

	/**
	 * Gets the model's maximum.
	 * 
	 * @return the value of the maximum property.
	 */
	int getMaximum();

	/**
	 * Gets the model's minimum.
	 * 
	 * @return the value of the minimum property.
	 */
	int getMinimum();

	/**
	 * Gets the model's current value.
	 * 
	 * @return the model's value.
	 */
	int getValue();

	/**
	 * Sets the model's maximum. The others two properties may be changed as well to ensure that minimum <= value <=
	 * maximum. Notifies the listener if the model changes.
	 * 
	 * @param maximum
	 *            the model's new maximum.
	 */
	void setMaximum(int maximum);

	/**
	 * Sets the model's minimum. The others two properties may be changed as well to ensure that minimum <= value <=
	 * maximum. Notifies the listener if the model changes.
	 * 
	 * @param minimum
	 *            the model's new minimum.
	 */
	void setMinimum(int minimum);

	/**
	 * Sets the model's current value to the given value if it satisfies the model's constraints. Those constraints are:
	 * 
	 * minimum <= value <= maximum
	 * 
	 * 
	 * Otherwise, if the new value is less than minimum it's set to minimum, if its greater than maximum then it's set
	 * to maximum.
	 * 
	 * Notifies the listener if the model changes.
	 * 
	 * @param value
	 */
	void setValue(int value);

	/**
	 * Sets the OnChangeListener of the model.
	 * 
	 * @param listener
	 *            the OnChangeListener to use.
	 */
	void setOnValueChangeListener(OnValueChangeListener listener);
}
