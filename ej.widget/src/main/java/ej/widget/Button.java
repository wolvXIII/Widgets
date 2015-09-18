/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import java.util.ArrayList;
import java.util.List;

import ej.microui.display.GraphicsContext;
import ej.microui.event.generator.Pointer;

/**
 * An Button object can display either text, an image, or both. You can specify where in the label's display area the
 * label's contents are aligned by setting the vertical and horizontal alignment. By default, labels are vertically and
 * horizontally centered in their display area.
 * 
 * You can also specify the position of the icon relative to the text. By default, icon is on the left of the text.
 */
public class Button extends AllSizeComposite {

	private boolean pressed;
	private final List<OnClickListener> onClickListeners;

	public Button() {
		this.onClickListeners = new ArrayList<>();
	}

	/**
	 * Performs the action associated to a click.
	 */
	public void performClick() {
		if (isEnabled()) {
			notifyOnClickListeners();
		}
	}

	public void addOnClickListener(OnClickListener listener) {
		this.onClickListeners.add(listener);
	}

	public void removeOnClickListener(OnClickListener listener) {
		this.onClickListeners.remove(listener);
	}

	protected void notifyOnClickListeners() {
		for (OnClickListener listener : this.onClickListeners) {
			listener.onClick(this);
		}
	}

	private void setPressed(boolean pressed) {
		this.pressed = pressed;
		repaint();
	}

	@Override
	public boolean onPointerPressed(Pointer pointer, int pointerX, int pointerY, int event) {
		setPressed(true);
		return false;
	}

	@Override
	public boolean onPointerReleased(Pointer pointer, int pointerX, int pointerY, int event) {
		setPressed(false);
		performClick();
		return false;
	}

	@Override
	public void render(GraphicsContext g) {
		System.out.println("Button.render() " + this);
		super.render(g);
	}
}
