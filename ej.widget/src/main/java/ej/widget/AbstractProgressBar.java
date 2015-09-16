/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

/**
 * 
 */
public abstract class AbstractProgressBar extends StyledWidget {

	private BoundedRangeModel model;

	public AbstractProgressBar(BoundedRangeModel model) {
		super();
		this.model = model;
	}

	public AbstractProgressBar(int min, int max, int initialValue) {
		this(new DefaultBoundedRangeModel(min, max, initialValue));
	}

	/**
	 * Gets the percent complete for the progress bar. Note that this number is between 0.0 and 1.0.
	 * 
	 * @return the percent complete for this progress bar.
	 */
	public float getPercentComplete() {
		int minimum = getMinimum();
		return (float) this.getValue() / (minimum + getMaximum() - minimum);
	}

	/**
	 * Sets the data model used by the ProgressBar.
	 * 
	 * @param model
	 *            the BoundedRangeModel to use. Cannot be null.
	 * 
	 * @throws IllegalArgumentException
	 *             if the given model is null.
	 */
	public void setModel(BoundedRangeModel model) {
		if (model == null) {
			throw new IllegalArgumentException("Cannot be null"); //$NON-NLS-1$
		}
		this.model = model;
		repaint();
	}

	/**
	 * Facility to set the value of the model to its minimum.
	 */
	public void reset() {
		setValue(this.model.getMinimum());
	}

	/**
	 * Gets the progress bar's maximum value from the BoundedRangeModel.
	 * 
	 * @return the progress bar's maximum value.
	 */
	public int getMaximum() {
		return this.model.getMaximum();
	}

	/**
	 * Gets the progress bar's minimum value from the BoundedRangeModel.
	 * 
	 * @return the progress bar's minimum value.
	 */
	public int getMinimum() {
		return this.model.getMinimum();
	}

	/**
	 * Gets the progress bar's current value from the BoundedRangeModel. The value is always between the minimum and
	 * maximum values, inclusive.
	 * 
	 * @return the current value of the progress bar.
	 */
	public int getValue() {
		return this.model.getValue();
	}

	/**
	 * Sets the progress bar's maximum value to the given value. This method forwards the new maximum to the model.
	 * 
	 * The data model (a BoundedRangeModel instance) handles any mathematical issues arising from assigning faulty
	 * values.
	 * 
	 * If the minimum value is different from the previous maximum, the change listener is notified.
	 * 
	 * @param maximum
	 *            the new maximum
	 */
	public void setMaximum(int maximum) {
		this.model.setMaximum(maximum);
		repaint();
	}

	/**
	 * Sets the progress bar's minimum value to the given value. This method forwards the new minimum to the model.
	 * 
	 * The data model (a BoundedRangeModel instance) handles any mathematical issues arising from assigning faulty
	 * values.
	 * 
	 * If the minimum value is different from the previous minimum, the change listener is notified.
	 * 
	 * @param minimum
	 *            the new minimum
	 */
	public void setMinimum(int minimum) {
		this.model.setMinimum(minimum);
		repaint();
	}

	/**
	 * Sets the progress bar's current value to the given value. This method forwards the new value to the model.
	 * 
	 * The data model (an instance of BoundedRangeModel) handles any mathematical issues arising from assigning faulty
	 * values.
	 * 
	 * If the new value is different from the previous value, the change listener is notified.
	 * 
	 * @param value
	 *            the new value.
	 */
	public void setValue(int value) {
		this.model.setValue(value);
		repaint();
	}

	/**
	 * Sets the OnChangeListener of the progress bar.
	 * 
	 * @param listener
	 *            the OnChangeListener to use.
	 */
	public void setOnValueChangedListener(OnValueChangeListener listener) {
		this.model.setOnValueChangeListener(listener);
	}
}
