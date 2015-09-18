/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.util;

/**
 * Simple implementation of style.
 */
public class SimpleStyle extends AbstractStyle implements Cloneable {

	/**
	 * Creates a simple style.
	 */
	public SimpleStyle() {
		// set default values
		this.foregroundColor = -1;
		// others are null: VM DONE
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		SimpleStyle clone = (SimpleStyle) super.clone();
		copyIn(clone);
		return clone;
	}

	/**
	 * Creates a copy of this style.
	 * 
	 * @return a copy of this style.
	 */
	public SimpleStyle copy() {
		SimpleStyle simpleStyle = new SimpleStyle();
		copyIn(simpleStyle);
		return simpleStyle;
	}

	private void copyIn(SimpleStyle simpleStyle) {
		simpleStyle.foregroundColor = this.foregroundColor;
		simpleStyle.background = this.background;
		simpleStyle.fontProfile = this.fontProfile;
		simpleStyle.textManager = this.textManager;
		simpleStyle.dimension = this.dimension;
		simpleStyle.padding = this.padding;
		simpleStyle.border = this.border;
		simpleStyle.margin = this.margin;
	}

}
