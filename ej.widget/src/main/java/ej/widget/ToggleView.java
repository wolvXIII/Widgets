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
public abstract class ToggleView extends StyledWidget implements OnStateChangeListener {

	protected boolean checked;

	@Override
	public void onStateChange(Object source, boolean before, boolean after) {
		this.checked = after;
		repaint();
	}
}
