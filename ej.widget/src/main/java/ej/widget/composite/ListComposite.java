/*
 * Java
 *
 * Copyright 2013-2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package ej.widget.composite;

import java.util.ArrayList;
import java.util.List;

import ej.microui.display.GraphicsContext;
import ej.mwt.Composite;
import ej.mwt.MWT;
import ej.mwt.Widget;

/**
 * A list composite is a {@link Composite} that lays out its children in a list.
 */
public class ListComposite extends Composite implements ScrollContent {

	private final boolean horizontal;
	private final List<Widget> childrenList;
	private int lastFirstVisible;

	public ListComposite(boolean horizontal) {
		this.horizontal = horizontal;
		this.childrenList = new ArrayList<>();
	}

	@Override
	public void add(Widget widget) {
		this.childrenList.add(widget);
	}

	@Override
	public void remove(Widget widget) {
		this.childrenList.remove(widget);
		super.remove(widget);
	}

	@Override
	public void removeAllWidgets() {
		this.childrenList.clear();
		super.removeAllWidgets();
	}

	private Widget[] getChildren() {
		return this.childrenList.toArray(new Widget[this.childrenList.size()]);
	}

	@Override
	public int getWidgetsCount() {
		return this.childrenList.size();
	}

	/**
	 * <p>
	 * Lays out children in a grid.
	 * </p>
	 * <p>
	 * The size of each child is set to the size of a grid cell.<br>
	 * </p>
	 * <p>
	 * The parameters defines the maximum size available for this composite, or {@link MWT#NONE} if there is no
	 * constraint. <br>
	 * After this call the preferred size will have been established.
	 * </p>
	 * 
	 * @param widthHint
	 *            the width available for this widget or {@link MWT#NONE}
	 * @param heightHint
	 *            the height available for this widget or {@link MWT#NONE}
	 */
	@Override
	public void validate(int widthHint, int heightHint) {
		if (!isVisible()) {
			// optim: do not validate its hierarchy
			setPreferredSize(0, 0);
			return;
		}

		Widget[] contents = getChildren();
		int length = contents.length;
		if (length == 0) {
			// nothing to do
			return;
		}

		boolean horizontal = this.horizontal;

		// get composite renderer and padding
		int cPadding = 0;
		int doubleCPadding = cPadding << 1;

		// if size is not yet defined -> compute it !
		boolean computeWidth = widthHint == MWT.NONE;
		boolean computeHeight = heightHint == MWT.NONE;

		int maxCellWidth = widthHint;// computeWidth ? 0 : (widthHint -
										// doubleCPadding) / columns;
		int maxCellHeight = heightHint;// computeHeight ? 0 : (heightHint -
										// doubleCPadding) / rows;
		// int cellWidth = 0;
		// int cellHeight = 0;
		int totalCellWidth = 0;
		int totalCellHeight = 0;

		int widgetWidthHint = computeWidth ? 0 : maxCellWidth;
		int widgetHeightHint = computeHeight ? 0 : maxCellHeight;

		// keep an array of margins for the second pass
		int[] margins = new int[length];
		int marginsTotal = 0;

		for (int i = length; --i >= 0;) {
			// long sa = System.currentTimeMillis();
			Widget widget = contents[i];

			// get widget renderer and margin
			// Renderer renderer = null;
			int margin = 0;
			// if (renderer == null) {
			// margin = 0;
			// } else {
			// margins[i] = margin = renderer.getMargin();
			// marginsTotal += margin;
			// }

			widget.validate(Math.max(0, widgetWidthHint - margin), Math.max(0, widgetHeightHint - margin));

			int ww = widget.getPreferredWidth() + margin;
			int wh = widget.getPreferredHeight() + margin;

			totalCellWidth += ww;
			totalCellHeight += wh;
		}

		float xRatio = 1.0f;
		float yRatio = 1.0f;

		int marginMedian = marginsTotal / length;
		int halfMarginMedian = marginMedian >> 1;
		if (computeWidth) {
			widthHint = totalCellWidth + doubleCPadding;
			xRatio = 1.0f;
		} else if (horizontal) {
			xRatio = (float) (widthHint - doubleCPadding) / totalCellWidth;
			// System.out.println("width: " + totalCellWidth + " " + (widthHint
			// - doubleCPadding));
		}

		if (computeHeight) {
			heightHint = totalCellHeight + doubleCPadding;
			yRatio = 1.0f;
		} else if (!horizontal) {
			yRatio = (float) (heightHint - doubleCPadding) / totalCellHeight;
			// System.out.println("height: " + totalCellHeight + " " +
			// (heightHint - doubleCPadding));
		}

		// System.out.println("ratios: " + xRatio + " " + yRatio);

		int currentX = cPadding + halfMarginMedian;
		int currentY = cPadding + halfMarginMedian;
		if (horizontal) {
			for (int i = -1; ++i < length;) {
				Widget widget = contents[i];
				int margin = margins[i];
				int halfMargin = margin >> 1;

				int ww = (int) (widget.getPreferredWidth() * xRatio);

				widget.setBounds(currentX + halfMargin, currentY + halfMargin, ww, heightHint);

				currentX += ww + margin;
			}
		} else {
			for (int i = -1; ++i < length;) {
				Widget widget = contents[i];
				int margin = margins[i];
				int halfMargin = margin >> 1;

				int wh = (int) (widget.getPreferredHeight() * yRatio);
				widget.setBounds(currentX + halfMargin, currentY + halfMargin, widthHint, wh);

				currentY += wh + margin;
			}
		}

		setPreferredSize(widthHint, heightHint);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		int availableWidth = getParent().getWidth();
		int availableHeight = getParent().getHeight();
		if (availableWidth == 0) {
			availableWidth = width;
		}
		if (availableHeight == 0) {
			availableHeight = height;
		}
		updateViewport(x, y, availableWidth, availableHeight);
	}

	@Override
	public void updateViewport(int x, int y, int width, int height) {
		Widget[] oldVisibleChildren = getWidgets();
		int length = oldVisibleChildren.length;
		// remove no more visible items
		for (int i = -1; ++i < length;) {
			Widget child = oldVisibleChildren[i];
			int childX = child.getX();
			int childY = child.getY();
			if (this.horizontal ? (childX + x > width || childX + child.getWidth() < -x)
					: (childY + y > height || childY + child.getHeight() < -y)) {
				super.remove(child);
			}
		}
		// add newly visible items
		int size = this.childrenList.size();
		if (size > 0) {
			// System.out.print("ListComposite.updateViewport()");
			// System.out.print(" x=" + x);
			// System.out.print(", y=" + y);
			// System.out.print(", width=" + width);
			// System.out.println(", height=" + height);
			// System.out.println("lastFirstVisible=" + lastFirstVisible);
			int firstVisible = getFirstVisible(x, y, width, height);
			// System.out.println("firstVisible=" + firstVisible);
			for (int i = firstVisible - 1; ++i < size;) {
				Widget child = this.childrenList.get(i);
				int childX = child.getX();
				int childY = child.getY();
				if (this.horizontal ? (childX + x > width) : (childY + y > height)) {
					break;
				} else if (this.horizontal ? (childX + child.getWidth() > -x) : (childY + child.getHeight() > -y)) {
					if (!contains(oldVisibleChildren, child)) {
						super.add(child);
					}
				}
			}
		}
	}

	private int getFirstVisible(int x, int y, int width, int height) {
		int index = this.lastFirstVisible;
		Widget lastFirstVisibleChild = this.childrenList.get(index);
		if (this.horizontal) {
			int childX = lastFirstVisibleChild.getX();
			int childWidth = lastFirstVisibleChild.getWidth();
			boolean stillFirst = childX <= -x && childX + childWidth >= -x;
			if (!stillFirst) {
				boolean searchForward = childX + childWidth < -x;
				int size = this.childrenList.size();
				for (int i = this.lastFirstVisible; searchForward ? ++i < size : --i >= 0;) {
					Widget child = this.childrenList.get(i);
					int candidateX = child.getX();
					int candidateWidth = child.getWidth();
					if (searchForward ? candidateX <= -x : candidateX + candidateWidth >= -x) {
						this.lastFirstVisible = i;
						break;
					}
				}
			}
		} else {
			int childY = lastFirstVisibleChild.getY();
			int childHeight = lastFirstVisibleChild.getHeight();
			// System.out.println("childY=" + childY);
			// System.out.println("childHeight=" + childHeight);
			boolean stillFirst = childY <= -y && childY + childHeight >= -y;
			// System.out.println("childY <= -y=" + (childY <= -y));
			// System.out.println("childY + childHeight >= -y=" + (childY +
			// childHeight >= -y));
			// System.out.println("stillFirst=" + stillFirst);
			if (!stillFirst) {
				boolean searchForward = childY + childHeight < -y;
				// System.out.println("searchForward=" + searchForward);
				int size = this.childrenList.size();
				int firstCandidate = searchForward ? size - 1 : 0;
				for (int i = this.lastFirstVisible; searchForward ? ++i < size : --i >= 0;) {
					Widget child = this.childrenList.get(i);
					int candidateY = child.getY();
					int candidateHeight = child.getHeight();
					// System.out.println("i=" + i);
					// System.out.println("candidateY=" + candidateY);
					// System.out.println("candidateHeight=" + candidateHeight);
					if (candidateY <= -y && candidateY + candidateHeight > -y) {
						firstCandidate = i;
						break;
					}
				}
				this.lastFirstVisible = firstCandidate;
			}
		}

		return this.lastFirstVisible;
	}

	private boolean contains(Widget[] widgets, Widget widget) {
		for (Widget candidate : widgets) {
			if (candidate == widget) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void revalidate() {
		// DO NOT REVALIDATE
		repaint();
	}

	@Override
	public void render(GraphicsContext arg0) {
	}
}
