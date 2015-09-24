/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test.nonauto.visual;

import java.util.ListIterator;


import ej.microui.MicroUI;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.widget.SpinnerModel;
import ej.widget.Wheel;

/**
 * 
 */
public class TestWheel {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();
		panel.setPacked(false);

		Wheel wheel = new Wheel(1);
		SpinnerModel model = new SpinnerModel() {

			private final int min = 0;
			private final int max = 10;
			private int currentIndex = 0;

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
				return new MyListIterator(index);
			}

			class MyListIterator implements ListIterator<String> {

				private int currentIndexIter;

				public MyListIterator(int index) {
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
					return String.valueOf(min + this.currentIndexIter);
				}

				@Override
				public int nextIndex() {
					int nextIndex = this.currentIndexIter + 1;
					if (nextIndex > max - min) {
						nextIndex = 0;
					}

					return nextIndex;
				}

				@Override
				public String previous() {
					this.currentIndexIter = previousIndex();
					return String.valueOf(min + this.currentIndexIter);
				}

				@Override
				public int previousIndex() {
					int previousIndex = this.currentIndexIter - 1;
					if (previousIndex < 0) {
						previousIndex = max - min;
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
		};

		wheel.setModel(model);

		panel.setWidget(wheel);
		panel.show(desktop, true);
		desktop.show();
	}
}
