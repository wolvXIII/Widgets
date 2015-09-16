package ej.widget;

/**
 * A generic implementation of BoundedRangeModel.
 */
public class DefaultBoundedRangeModel implements BoundedRangeModel {

	private int maximum;
	private int minimum;
	private int value;
	private OnValueChangeListener listener;

	/**
	 * Creates a DefaultBoundedRangeModel with the given minimum value, the given maximum value and the given
	 * initialValue.
	 * 
	 * @param minimum
	 *            the minimum value of the model.
	 * @param maximum
	 *            the maximum value of the model.
	 * @param initialValue
	 *            the initial value of the model.
	 * @throws IllegalArgumentException
	 *             if the constraint minimum <= initialValue <= maximum is not satisfied.
	 */
	public DefaultBoundedRangeModel(int minimum, int maximum, int initialValue) {
		if (minimum > initialValue || initialValue > maximum) {
			throw new IllegalArgumentException("Range contraint not respected"); //$NON-NLS-1$
		}

		this.minimum = minimum;
		this.maximum = maximum;
		this.value = initialValue;
	}

	@Override
	public int getMaximum() {
		return this.maximum;
	}

	@Override
	public int getMinimum() {
		return this.minimum;
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void setMaximum(int maximum) {
		if (maximum != this.maximum) {
			int value = this.value;
			if (maximum >= value) {
				this.maximum = maximum;
			} else {
				this.maximum = Math.max(maximum, this.minimum);
				this.value = this.maximum;
			}
			notifyListener(value, value);
		}
	}

	@Override
	public void setMinimum(int minimum) {
		if (minimum != this.minimum) {
			int value = this.value;
			if (minimum <= value) {
				this.minimum = minimum;
			} else {
				this.minimum = Math.min(minimum, this.maximum);
				this.value = this.minimum;
			}
			notifyListener(value, value);
		}
	}

	@Override
	public void setValue(int value) {
		if (value != this.value) {
			int newValue;
			if (value < this.minimum) {
				newValue = this.minimum;
			} else if (value > this.maximum) {
				newValue = this.maximum;
			} else {
				newValue = value;
			}
			int oldValue = this.value;
			this.value = newValue;
			notifyListener(oldValue, newValue);
		}
	}

	private void notifyListener(int before, int after) {
		if (this.listener != null) {
			this.listener.onValueChanged(this, before, after);
		}
	}

	@Override
	public void setOnValueChangeListener(OnValueChangeListener listener) {
		this.listener = listener;
	}

}
