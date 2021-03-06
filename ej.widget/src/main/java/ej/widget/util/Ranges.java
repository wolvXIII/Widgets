/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.util;

public class Ranges {

	// Prevents initialization.
	private Ranges() {
	}

	public static int keepValueInRange(int current, int min, int max, int offset) {
		int range = max - min + 1;
		int newValue = current + offset % range;

		// Overflow case.
		if (newValue > max) {
			newValue = newValue - range;
		}

		// Underflow case.
		if (newValue < min) {
			newValue = range + newValue;
		}

		return newValue;
	}
}
