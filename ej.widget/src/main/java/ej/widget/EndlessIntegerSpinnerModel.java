/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import java.util.ListIterator;

/**
 * 
 */
public class EndlessIntegerSpinnerModel implements SpinnerModel {

	private final int min;
	private final int max;
	private int currentIndex;

	/**
	 * 
	 */
	public EndlessIntegerSpinnerModel(int min, int max, int current) {
		if (min > max || current < min || current > max) {
			throw new IllegalArgumentException("Order constraint not respected");
		}
		this.min = min;
		this.max = max;
		setCurrentIndex(current);
	}

	@Override
	public void setCurrentIndex(int index) {
		this.currentIndex = getCheckedIndex(index);
	}

	public int getCurrentValue() {
		return this.min + this.currentIndex;
	}

	@Override
	public int getCurrentIndex() {
		return this.currentIndex;
	}

	@Override
	public String getValueAsString(int index) {
		index = getCheckedIndex(index);
		return String.valueOf(this.min + index);
	}

	private int getCheckedIndex(int index) {
		int range = this.max - this.min + 1;
		index = index % range;

		// Overflow case.
		if (index > this.max) {
			index = index - range;
		}

		// Underflow case.
		if (index < this.min) {
			index = range + index;
		}

		return index;
	}

	@Override
	public ListIterator<String> listIterator(int index) {
		index = getCheckedIndex(index);
		return new InternalListIterator(index);
	}

	private class InternalListIterator implements ListIterator<String> {

		private int currentIndexIter;

		public InternalListIterator(int index) {
			this.currentIndexIter = index;
		}

		@Override
		public void add(String e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public boolean hasPrevious() {
			return true;
		}

		@Override
		public String next() {
			this.currentIndexIter = nextIndex();
			return String.valueOf(EndlessIntegerSpinnerModel.this.min + this.currentIndexIter);
		}

		@Override
		public int nextIndex() {
			int nextIndex = this.currentIndexIter + 1;
			if (nextIndex > EndlessIntegerSpinnerModel.this.max - EndlessIntegerSpinnerModel.this.min) {
				nextIndex = 0;
			}

			return nextIndex;
		}

		@Override
		public String previous() {
			this.currentIndexIter = previousIndex();
			return String.valueOf(EndlessIntegerSpinnerModel.this.min + this.currentIndexIter);
		}

		@Override
		public int previousIndex() {
			int previousIndex = this.currentIndexIter - 1;
			if (previousIndex < 0) {
				previousIndex = EndlessIntegerSpinnerModel.this.max - EndlessIntegerSpinnerModel.this.min;
			}

			return previousIndex;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(String e) {
			throw new UnsupportedOperationException();
		}

	}
}
