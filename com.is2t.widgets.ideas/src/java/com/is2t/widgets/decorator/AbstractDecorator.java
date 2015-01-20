/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.decorator;


public abstract class AbstractDecorator implements Decorator {

	private int alignment;

	@Override
	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

	@Override
	public int getAlignment() {
		return this.alignment;
	}

}
