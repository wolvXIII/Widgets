/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite;

import ej.microui.display.GraphicsContext;
import ej.mwt.Composite;
import ej.mwt.MWT;
import ej.mwt.Widget;

/**
 * Lays out its children to fit in 3 regions:
 * <ul>
 * <li>horizontal mode: west, east and center (respectively {@link MWT#WEST}, {@link MWT#EAST}, {@link MWT#CENTER}),</li>
 * <li>vertical mode: north, south and center (respectively {@link MWT#NORTH}, {@link MWT#SOUTH}, {@link MWT#CENTER}),</li>
 * </ul>
 * Beware that a widget added on west in vertical mode will be on north (the same goes horizontally and for east and
 * south regions).
 */
public class BorderComposite extends Composite {

	private boolean horizontal;
	private Widget first;
	private Widget center;
	private Widget last;

	/**
	 * Sets the composite orientation: horizontal or vertical.
	 *
	 * @param horizontal
	 *            <code>true</code> to set the composite horizontal, <code>false</code> to set the composite vertical.
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * Adds a widget at the center this grid composite.
	 */
	@Override
	public void add(Widget widget) {
		if (this.center != null) {
			super.remove(widget);
		}
		this.center = widget;
		super.add(widget);
	}

	@Override
	public void remove(Widget widget) {
		if (widget == this.first) {
			this.first = null;
		} else if (widget == this.last) {
			this.last = null;
		} else if (widget == this.center) {
			this.center = null;
		}
		super.remove(widget);
	}

	/**
	 * Adds a widget at a position this grid composite.
	 * <p>
	 * The position can be one of: {@link MWT#CENTER}, {@link MWT#NORTH}, {@link MWT#SOUTH}, {@link MWT#EAST},
	 * {@link MWT#WEST}.
	 *
	 * @param widget
	 *            the widget to add.
	 * @param at
	 *            the position to add the widget to.
	 * @throws NullPointerException
	 *             if the given widget is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if the given position is invalid.
	 * @throws IllegalArgumentException
	 *             if the given widget or one of its children is already connected to a panel.
	 * @see #add(Widget)
	 */
	public void add(Widget widget, int at) {
		switch (at) {
		case MWT.WEST:
			// case MWT.LEFT:
		case MWT.NORTH:
			// case MWT.TOP:
			Widget firstLocal = this.first; // avoid synchronizing
			if (firstLocal != null) {
				remove(firstLocal);
			}
			this.first = widget;
			super.add(widget);
			break;
		case MWT.EAST:
			// case MWT.RIGHT:
		case MWT.SOUTH:
			// case MWT.BOTTOM:
			Widget lastLocal = this.last; // avoid synchronizing
			if (lastLocal != null) {
				remove(lastLocal);
			}
			this.last = widget;
			super.add(widget);
			break;
		case MWT.CENTER:
			Widget centerLocal = this.center; // avoid synchronizing
			if (centerLocal != null) {
				remove(centerLocal);
			}
			this.center = widget;
			add(widget);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Removes the widget at a position this grid composite.
	 * <p>
	 * If no widget is at this position, nothing is done.
	 * <p>
	 * The position can be one of: {@link MWT#CENTER}, {@link MWT#NORTH}, {@link MWT#SOUTH}, {@link MWT#EAST},
	 * {@link MWT#WEST}.
	 *
	 * @param at
	 *            the position to add the widget to.
	 * @throws NullPointerException
	 *             if the given widget is <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if the given position is invalid.
	 * @see #remove(Widget)
	 */
	public void remove(int at) {
		switch (at) {
		case MWT.WEST:
			// case MWT.LEFT:
		case MWT.NORTH:
			// case MWT.TOP:
			Widget firstLocal = this.first; // avoid synchronizing
			if (firstLocal != null) {
				remove(firstLocal);
			}
			this.first = null;
			break;
		case MWT.EAST:
			// case MWT.RIGHT:
		case MWT.SOUTH:
			// case MWT.BOTTOM:
			Widget lastLocal = this.last; // avoid synchronizing
			if (lastLocal != null) {
				remove(lastLocal);
			}
			this.last = null;
			break;
		case MWT.CENTER:
			Widget centerLocal = this.center; // avoid synchronizing
			if (centerLocal != null) {
				remove(centerLocal);
			}
			this.center = null;
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void removeAllWidgets() {
		super.removeAllWidgets();
		this.first = null;
		this.last = null;
		this.center = null;
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		if (!isVisible()) {
			// optim: do not validate its hierarchy
			setPreferredSize(0, 0);
			return;
		}

		boolean computeWidth = widthHint == MWT.NONE;
		boolean computeHeight = heightHint == MWT.NONE;

		// compute widgets expected width
		int firstWidth;
		int centerWidth;
		int lastWidth;
		if (computeWidth) {
			firstWidth = MWT.NONE;
			centerWidth = MWT.NONE;
			lastWidth = MWT.NONE;
		} else {
			if (this.horizontal) {
				firstWidth = MWT.NONE;
				lastWidth = MWT.NONE;
				centerWidth = MWT.NONE; // reset after other layouts later
			} else {
				firstWidth = widthHint;
				centerWidth = widthHint;
				lastWidth = widthHint;
			}
		}
		// compute widgets expected height
		int firstHeight;
		int centerHeight;
		int lastHeight;
		if (computeHeight) {
			firstHeight = MWT.NONE;
			centerHeight = MWT.NONE;
			lastHeight = MWT.NONE;
		} else {
			if (this.horizontal) {
				firstHeight = heightHint;
				centerHeight = heightHint;
				lastHeight = heightHint;
			} else {
				firstHeight = MWT.NONE;
				lastHeight = MWT.NONE;
				centerHeight = MWT.NONE; // reset after other layouts later
			}
		}

		Widget firstLocal = this.first; // avoid synchronizing
		Widget lastLocal = this.last; // avoid synchronizing
		Widget centerLocal = this.center; // avoid synchronizing

		// validate widgets and get their preferred widgets
		int firstPreferredWidth;
		int firstPreferredHeight;
		if (firstLocal != null) {
			firstLocal.validate(firstWidth, firstHeight);
			firstPreferredWidth = firstLocal.getPreferredWidth();
			firstPreferredHeight = firstLocal.getPreferredHeight();
		} else {
			firstPreferredWidth = 0;
			firstPreferredHeight = 0;
		}
		int lastPreferredWidth;
		int lastPreferredHeight;
		if (lastLocal != null) {
			lastLocal.validate(lastWidth, lastHeight);
			lastPreferredWidth = lastLocal.getPreferredWidth();
			lastPreferredHeight = lastLocal.getPreferredHeight();
		} else {
			lastPreferredWidth = 0;
			lastPreferredHeight = 0;
		}

		// center take remaining size
		if (!computeWidth && this.horizontal) {
			centerWidth = Math.max(0, widthHint - firstPreferredWidth - lastPreferredWidth);
		}
		if (!computeHeight && !this.horizontal) {
			centerHeight = Math.max(0, heightHint - firstPreferredHeight - lastPreferredHeight);
		}
		int centerPreferredWidth;
		int centerPreferredHeight;
		if (centerLocal != null) {
			centerLocal.validate(centerWidth, centerHeight);
			centerPreferredWidth = centerLocal.getPreferredWidth();
			centerPreferredHeight = centerLocal.getPreferredHeight();
		} else {
			centerPreferredWidth = 0;
			centerPreferredHeight = 0;
		}

		// compute composite preferred size if necessary
		if (computeWidth) {
			if (this.horizontal) {
				widthHint = firstPreferredWidth + centerPreferredWidth + lastPreferredWidth;
			} else {
				widthHint = Math.max(Math.max(firstPreferredWidth, lastPreferredWidth), centerPreferredWidth);
			}
		}
		if (computeHeight) {
			if (this.horizontal) {
				heightHint = Math.max(Math.max(firstPreferredHeight, lastPreferredHeight), centerPreferredHeight);
			} else {
				heightHint = firstPreferredHeight + centerPreferredHeight + lastPreferredHeight;
			}
		}

		// set composite preferred size
		setPreferredSize(widthHint, heightHint);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);

		Widget firstLocal = this.first; // avoid synchronizing
		Widget lastLocal = this.last; // avoid synchronizing

		// compute widgets bounds
		int firstX = 0;
		int firstY = 0;
		int firstWidth;
		int firstHeight;
		int lastX;
		int lastY;
		int lastWidth;
		int lastHeight;
		int centerX;
		int centerY;
		int centerWidth;
		int centerHeight;
		if (this.horizontal) {
			if (firstLocal != null) {
				firstWidth = firstLocal.getPreferredWidth();
			} else {
				firstWidth = 0;
			}
			firstHeight = height;
			if (lastLocal != null) {
				lastWidth = lastLocal.getPreferredWidth();
			} else {
				lastWidth = 0;
			}
			lastHeight = height;
			lastX = width - lastWidth;
			lastY = 0;
			centerX = firstWidth;
			centerY = 0;
			centerWidth = Math.max(0, width - firstWidth - lastWidth);
			centerHeight = height;
		} else {
			firstWidth = width;
			if (firstLocal != null) {
				firstHeight = firstLocal.getPreferredHeight();
			} else {
				firstHeight = 0;
			}
			lastWidth = width;
			if (lastLocal != null) {
				lastHeight = lastLocal.getPreferredHeight();
			} else {
				lastHeight = 0;
			}
			lastX = 0;
			lastY = width - lastHeight;
			centerX = 0;
			centerY = firstHeight;
			centerWidth = width;
			centerHeight = Math.max(0, height - firstHeight - lastHeight);
		}

		// set widgets bounds
		if (firstLocal != null) {
			firstLocal.setBounds(firstX, firstY, firstWidth, firstHeight);
		}
		if (lastLocal != null) {
			lastLocal.setBounds(lastX, lastY, lastWidth, lastHeight);
		}
		Widget centerLocal = this.center; // avoid synchronizing
		if (centerLocal != null) {
			centerLocal.setBounds(centerX, centerY, centerWidth, centerHeight);
		}
	}

	@Override
	public void render(GraphicsContext g) {
		// TODO
	}

}
