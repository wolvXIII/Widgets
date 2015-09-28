/*
 * Copyright 2014-2015 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.widget;

import java.util.ListIterator;

import ej.bon.Timer;
import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.microui.event.generator.Pointer;
import ej.motion.Motion;
import ej.motion.MotionManager;
import ej.motion.ease.EaseMotionManager;
import ej.motion.util.MotionAnimator;
import ej.motion.util.MotionListener;
import ej.style.Style;
import ej.style.util.Rectangle;
import ej.style.util.Size;
import ej.widget.util.Styles;
import ej.widget.util.TouchConfiguration;

public class Wheel extends StyledWidget implements Controller {

	private static final int STATE_BY_STEP = 5;
	private static final int ANIMATION_PERIOD = 50;
	private static final int STEP_TIME = STATE_BY_STEP * ANIMATION_PERIOD;

	private final int itemOnSideCount;
	private SpinnerModel model;
	private int spinOffset;
	private int currentIndexDiff;
	private boolean dragged;
	private int pressPointerCoordinate;
	private int lastPointerCoordinate;
	private long pressTime;
	private long lastPointerTime;

	private final MotionManager motionManager;
	private MotionAnimator motionAnimator;

	public Wheel(int itemOnSideCount) {
		this.motionManager = new EaseMotionManager();
		this.itemOnSideCount = itemOnSideCount;
	}

	public void setModel(SpinnerModel model) {
		this.model = model;
	}

	@Override
	protected void renderContent(GraphicsContext g, Style style, Rectangle remainingSize) {
		int remainingWidth = remainingSize.getWidth();
		int remainingHeight = remainingSize.getHeight();

		int lineHeight = getLineHeight();
		int itemOnSideCount = this.itemOnSideCount;
		int maxItemOnSideCount = itemOnSideCount + 1;
		int currentValueY = remainingHeight / 2 + this.spinOffset;
		int currentVisibleIndex = this.model.getCurrentIndex() + this.currentIndexDiff;
		int windowHeight = lineHeight * (itemOnSideCount * 2 + 1);
		g.clipRect(0, (remainingHeight - windowHeight) / 2, remainingWidth, windowHeight);

		// Draws the current value.
		int x = remainingWidth / 2;
		int y = currentValueY;
		g.setColor(style.getForegroundColor());
		DisplayFont font = Styles.getFont(style);
		g.setFont(font);
		g.drawString(this.model.getValueAsString(currentVisibleIndex), x, y, GraphicsContext.HCENTER
				| GraphicsContext.VCENTER);

		// Draws the previous values.
		ListIterator<String> valueIterator = this.model.listIterator(currentVisibleIndex);
		int previousValueCount = maxItemOnSideCount;
		while (previousValueCount-- > 0 && valueIterator.hasPrevious()) {
			y -= lineHeight;
			float fontRatio = computeFontRatio(y, windowHeight);
			font.setRatios(fontRatio, fontRatio);
			g.drawString(valueIterator.previous(), x, y, GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		}

		// Draws the next values.
		valueIterator = this.model.listIterator(currentVisibleIndex);
		int nextValueCount = maxItemOnSideCount;
		y = currentValueY;
		while (nextValueCount-- > 0 && valueIterator.hasNext()) {
			y += lineHeight;
			float fontRatio = computeFontRatio(y, windowHeight);
			font.setRatios(fontRatio, fontRatio);
			g.drawString(valueIterator.next(), x, y, GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		}

		font.resetRatios();
	}

	private float computeFontRatio(int y, int height) {
		// int distance = Math.abs(y - height / 2);
		// return 1.0f - (float) distance / height;
		return 1.0f;
	}

	private int getLineHeight() {
		return 30;
	}

	@Override
	protected Size getContentSize(Style style) {
		// TODO Auto-generated method stub
		return null;
	}

	private void stopAnimation() {
		if (this.motionAnimator != null) {
			this.motionAnimator.stop();
		}
	}

	@Override
	public boolean onPointerPressed(Pointer pointer, int pointerX, int pointerY, int event) {
		stopAnimation();
		this.dragged = false;
		this.pressPointerCoordinate = pointerY;
		this.lastPointerCoordinate = pointerY;
		this.pressTime = System.currentTimeMillis();
		this.lastPointerTime = this.pressTime;
		return false;
	}

	@Override
	public boolean onPointerDragged(Pointer pointer, int pointerX, int pointerY, int event) {
		this.dragged = true;
		int pointerCoordinate = pointerY;
		int distanceDragged = pointerCoordinate - this.lastPointerCoordinate;

		if (distanceDragged != 0) {
			this.lastPointerTime = System.currentTimeMillis();
			this.spinOffset = computeSpinOffset(distanceDragged, this.spinOffset);
			this.currentIndexDiff = computeIndexDiff(this.pressPointerCoordinate - pointerCoordinate);
			this.lastPointerCoordinate = pointerCoordinate;
			repaint();
		}
		return true;
	}

	private int computeIndexDiff(int distance) {
		int n = (int) Math.floor(distance / (float) (getLineHeight() / 2));
		return (n & 1) == 0 ? n / 2 : (n + 1) / 2;
	}

	private int computeSpinOffset(int distance, int spinOffset) {
		int halfLineHeight = getLineHeight() / 2;
		int max = halfLineHeight;
		int min = -halfLineHeight + 1;
		int range = max - min + 1;
		int newSpinOffset = spinOffset + distance % range;

		// Overflow case.
		if (newSpinOffset > max) {
			newSpinOffset = newSpinOffset - range;
		}

		// Underflow case.
		if (newSpinOffset < min) {
			newSpinOffset = range + newSpinOffset;
		}

		return newSpinOffset;
	}

	@Override
	public boolean onPointerReleased(Pointer pointer, int pointerX, int pointerY, int event) {
		int pointerCoordinate = pointerY;
		int start;
		int stop;
		int currentIndexDiffToBe = 0;
		if (!this.dragged) {
			currentIndexDiffToBe = computeIndexDiff(pointerCoordinate - getHeight() / 2);
			start = 0;
			stop = -currentIndexDiffToBe * getLineHeight();
		} else {
			long now = System.currentTimeMillis();
			int currentIndexDiff = this.currentIndexDiff;
			if (now - this.lastPointerTime > TouchConfiguration.TOUCH_SENSIBILITY) {
				// The closer step will be the current value.
				stop = -currentIndexDiff * getLineHeight();
				start = stop + this.spinOffset;
				currentIndexDiffToBe = currentIndexDiff;
			} else {
				int deltaDistance = pointerCoordinate - this.pressPointerCoordinate;
				long deltaTime = now - this.pressTime;
				int indexDiffWithThrow = computeThrow(deltaDistance, deltaTime);
				currentIndexDiffToBe = this.currentIndexDiff + indexDiffWithThrow;
				stop = -currentIndexDiffToBe * getLineHeight();
				start = -currentIndexDiff * getLineHeight() + this.spinOffset;
			}
		}
		spin(start, stop, currentIndexDiffToBe);
		return false;
	}

	/**
	 * @param deltaDistance
	 * @param deltaTime
	 * @return
	 */
	protected int computeThrow(int deltaDistance, long deltaTime) {
		return -deltaDistance / 10;
	}

	private void spin(int start, int stop, final int currentIndexDiffToBe) {
		int motionTime = (int) ((Math.abs(start - stop) / (float) getLineHeight()) * STEP_TIME);
		Motion spinMotion = this.motionManager.easeOut(start, stop, motionTime);
		this.motionAnimator = new MotionAnimator(spinMotion, new MotionListener() {

			@Override
			public void stop(int value) {
				Wheel.this.spinOffset = 0;
				Wheel.this.currentIndexDiff = 0;
				int newCurrentIndex = Wheel.this.model.getCurrentIndex() + currentIndexDiffToBe;
				Wheel.this.model.setCurrentIndex(newCurrentIndex);
				repaint();
			}

			@Override
			public void step(int value) {
				Wheel.this.spinOffset = computeSpinOffset(value, 0);
				Wheel.this.currentIndexDiff = computeIndexDiff(-value);
				repaint();
			}

			@Override
			public void start(int value) {
				// Nothing to do.
			}
		});
		Timer timer = ServiceLoaderFactory.getServiceLoader().getService(Timer.class);
		this.motionAnimator.start(timer, ANIMATION_PERIOD);
	}
}
