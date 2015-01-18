/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.ideas;

public abstract class AbstractDecorator implements Decorator {

	private Alignment alignment;

	@Override
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	@Override
	public Alignment getAlignment() {
		return this.alignment;
	}

}
