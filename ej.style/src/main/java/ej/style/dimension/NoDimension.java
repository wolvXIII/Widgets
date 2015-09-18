/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.dimension;

import ej.style.util.Size;

/**
 *
 */
public class NoDimension implements Dimension {

	/**
	 * NoDimension singleton.
	 */
	// assume that it is stateless
	public static final NoDimension NO_DIMENSION = new NoDimension();

	private NoDimension() {
	}

	@Override
	public void apply(Size currentSize, int widthHint, int heightHint) {
		// do not modify the given size
	}

}
