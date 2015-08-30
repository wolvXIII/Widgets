/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.composite.SplitComposite;
import ej.composite.widget.Item;
import ej.microui.io.Display;

/**
 *
 */
public class TestSplitCompositeHierarchy {

	public static void main(String[] args) {
		CheckHelper.startCheck(TestSplitCompositeHierarchy.class);

		testHorizontalHorizontalFillUniformSplit();
		testVerticalHorizontalFillUniformSplit();
		testVerticalVerticalFillUniformSplit();
		testHorizontalVerticalFillUniformSplit();
		testHorizontalHorizontalPackedUniformSplit();
		testVerticalHorizontalPackedUniformSplit();
		testVerticalVerticalPackedUniformSplit();
		testHorizontalVerticalPackedUniformSplit();

		CheckHelper.endCheck(TestSplitCompositeHierarchy.class);
	}

	private static void testHorizontalHorizontalPackedUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item leftLeftLabel = new Item(baseWidth, baseHeight);
		Item leftRightLabel = new Item(baseWidth, baseHeight);
		SplitComposite leftSplitComposite = TestSplitCompositeSimple.createSplitComposite(leftLeftLabel,
				leftRightLabel, ratio, true);
		Item rightLeftLabel = new Item(baseWidth, baseHeight);
		Item rightRightLabel = new Item(baseWidth, baseHeight);
		SplitComposite rightSplitComposite = TestSplitCompositeSimple.createSplitComposite(rightLeftLabel,
				rightRightLabel, ratio, true);
		SplitComposite splitComposite = TestSplitCompositeSimple.createSplitComposite(leftSplitComposite,
				rightSplitComposite, ratio, true);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhpus left left width", leftLeftLabel.getWidth(),
				baseWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhpus left left height", leftLeftLabel.getHeight(),
				baseHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhpus left right width", leftRightLabel.getWidth(),
				baseWidth * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhpus left right height", leftRightLabel.getHeight(),
				baseHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhpus right left width", rightLeftLabel.getWidth(),
				baseWidth * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhpus right left height", rightLeftLabel.getHeight(),
				baseHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhpus right right width", rightRightLabel.getWidth(),
				baseWidth * 4);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhpus right right height", rightRightLabel.getHeight(),
				baseHeight);
	}

	private static void testVerticalHorizontalPackedUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item topLeftLabel = new Item(baseWidth, baseHeight);
		Item topRightLabel = new Item(baseWidth, baseHeight);
		SplitComposite topSplitComposite = TestSplitCompositeSimple.createSplitComposite(topLeftLabel, topRightLabel,
				ratio, true);
		Item bottomLeftLabel = new Item(baseWidth, baseHeight);
		Item bottomRightLabel = new Item(baseWidth, baseHeight);
		SplitComposite bottomSplitComposite = TestSplitCompositeSimple.createSplitComposite(bottomLeftLabel,
				bottomRightLabel, ratio, true);
		SplitComposite splitComposite = TestSplitCompositeSimple.createSplitComposite(topSplitComposite,
				bottomSplitComposite, ratio, false);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper
				.check(TestSplitCompositeHierarchy.class, "vhpus top left width", topLeftLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhpus top left height", topLeftLabel.getHeight(),
				baseHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhpus top right width", topRightLabel.getWidth(),
				baseWidth * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhpus top right height", topRightLabel.getHeight(),
				baseHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhpus bottom left width", bottomLeftLabel.getWidth(),
				baseWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhpus bottom left height", bottomLeftLabel.getHeight(),
				baseHeight * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhpus bottom right width", bottomRightLabel.getWidth(),
				baseWidth * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhpus bottom right height", bottomRightLabel.getHeight(),
				baseHeight * 2);
	}

	private static void testVerticalVerticalPackedUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item topTopLabel = new Item(baseWidth, baseHeight);
		Item topBottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite topSplitComposite = TestSplitCompositeSimple.createSplitComposite(topTopLabel, topBottomLabel,
				ratio, false);
		Item bottomTopLabel = new Item(baseWidth, baseHeight);
		Item bottomBottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite bottomSplitComposite = TestSplitCompositeSimple.createSplitComposite(bottomTopLabel,
				bottomBottomLabel, ratio, false);
		SplitComposite splitComposite = TestSplitCompositeSimple.createSplitComposite(topSplitComposite,
				bottomSplitComposite, ratio, false);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvpus top top width", topTopLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvpus top top height", topTopLabel.getHeight(),
				baseHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvpus top bottom width", topBottomLabel.getWidth(),
				baseWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvpus top bottom height", topBottomLabel.getHeight(),
				baseHeight * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvpus bottom top width", bottomTopLabel.getWidth(),
				baseWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvpus bottom top height", bottomTopLabel.getHeight(),
				baseHeight * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvpus bottom bottom width", bottomBottomLabel.getWidth(),
				baseWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvpus bottom bottom height",
				bottomBottomLabel.getHeight(), baseHeight * 4);
	}

	private static void testHorizontalVerticalPackedUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item leftTopLabel = new Item(baseWidth, baseHeight);
		Item leftBottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite leftSplitComposite = TestSplitCompositeSimple.createSplitComposite(leftTopLabel,
				leftBottomLabel, ratio, false);
		Item rightTopLabel = new Item(baseWidth, baseHeight);
		Item rightBottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite rightSplitComposite = TestSplitCompositeSimple.createSplitComposite(rightTopLabel,
				rightBottomLabel, ratio, false);
		SplitComposite splitComposite = TestSplitCompositeSimple.createSplitComposite(leftSplitComposite,
				rightSplitComposite, ratio, true);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper
				.check(TestSplitCompositeHierarchy.class, "hvpus left top width", leftTopLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvpus left topheight", leftTopLabel.getHeight(),
				baseHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvpus left bottom width", leftBottomLabel.getWidth(),
				baseWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvpus left bottom height", leftBottomLabel.getHeight(),
				baseHeight * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvpus right top width", rightTopLabel.getWidth(),
				baseWidth * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvpus right top height", rightTopLabel.getHeight(),
				baseHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvpus right bottom width", rightBottomLabel.getWidth(),
				baseWidth * 2);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvpus right bottom height", rightBottomLabel.getHeight(),
				baseHeight * 2);
	}

	private static void testHorizontalHorizontalFillUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item leftLeftLabel = new Item(baseWidth, baseHeight);
		Item leftRightLabel = new Item(baseWidth, baseHeight);
		SplitComposite leftSplitComposite = TestSplitCompositeSimple.createSplitComposite(leftLeftLabel,
				leftRightLabel, ratio, true);
		Item rightLeftLabel = new Item(baseWidth, baseHeight);
		Item rightRightLabel = new Item(baseWidth, baseHeight);
		SplitComposite rightSplitComposite = TestSplitCompositeSimple.createSplitComposite(rightLeftLabel,
				rightRightLabel, ratio, true);
		SplitComposite splitComposite = TestSplitCompositeSimple.createSplitComposite(leftSplitComposite,
				rightSplitComposite, ratio, true);
		TestHelper.showAndWait(splitComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhfus left left width", leftLeftLabel.getWidth(),
				(int) (displayWidth * ratio * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhfus left left height", leftLeftLabel.getHeight(),
				displayHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhfus left right width", leftRightLabel.getWidth(),
				(int) (displayWidth * ratio) - leftLeftLabel.getWidth());
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhfus left right height", leftRightLabel.getHeight(),
				displayHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhfus right left width", rightLeftLabel.getWidth(),
				(int) ((displayWidth - leftSplitComposite.getWidth()) * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhfus right left height", rightLeftLabel.getHeight(),
				displayHeight);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhfus right right width", rightRightLabel.getWidth(),
				displayWidth - leftSplitComposite.getWidth() - rightLeftLabel.getWidth());
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hhfus right right height", rightRightLabel.getHeight(),
				displayHeight);
	}

	private static void testVerticalHorizontalFillUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item topLeftLabel = new Item(baseWidth, baseHeight);
		Item topRightLabel = new Item(baseWidth, baseHeight);
		SplitComposite topSplitComposite = TestSplitCompositeSimple.createSplitComposite(topLeftLabel, topRightLabel,
				ratio, true);
		Item bottomLeftLabel = new Item(baseWidth, baseHeight);
		Item bottomRightLabel = new Item(baseWidth, baseHeight);
		SplitComposite bottomSplitComposite = TestSplitCompositeSimple.createSplitComposite(bottomLeftLabel,
				bottomRightLabel, ratio, true);
		SplitComposite splitComposite = TestSplitCompositeSimple.createSplitComposite(topSplitComposite,
				bottomSplitComposite, ratio, false);
		TestHelper.showAndWait(splitComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhfus top left width", topLeftLabel.getWidth(),
				(int) (displayWidth * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhfus top left height", topLeftLabel.getHeight(),
				(int) (displayHeight * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhfus top right width", topRightLabel.getWidth(),
				displayWidth - topLeftLabel.getWidth());
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhfus top right height", topRightLabel.getHeight(),
				(int) (displayHeight * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhfus bottom left width", bottomLeftLabel.getWidth(),
				(int) (displayWidth * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhfus bottom left height", bottomLeftLabel.getHeight(),
				displayHeight - topLeftLabel.getHeight());
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhfus bottom right width", bottomRightLabel.getWidth(),
				displayWidth - bottomLeftLabel.getWidth());
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vhfus bottom right height", bottomRightLabel.getHeight(),
				displayHeight - topRightLabel.getHeight());
	}

	private static void testVerticalVerticalFillUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item topTopLabel = new Item(baseWidth, baseHeight);
		Item topBottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite topSplitComposite = TestSplitCompositeSimple.createSplitComposite(topTopLabel, topBottomLabel,
				ratio, false);
		Item bottomTopLabel = new Item(baseWidth, baseHeight);
		Item bottomBottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite bottomSplitComposite = TestSplitCompositeSimple.createSplitComposite(bottomTopLabel,
				bottomBottomLabel, ratio, false);
		SplitComposite splitComposite = TestSplitCompositeSimple.createSplitComposite(topSplitComposite,
				bottomSplitComposite, ratio, false);
		TestHelper.showAndWait(splitComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvfus top top width", topTopLabel.getWidth(),
				displayWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvfus top top height", topTopLabel.getHeight(),
				(int) (displayHeight * ratio * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvfus top bottom width", topBottomLabel.getWidth(),
				displayWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvfus top bottom height", topBottomLabel.getHeight(),
				(int) (displayHeight * ratio) - topTopLabel.getHeight());
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvfus bottom top width", bottomTopLabel.getWidth(),
				displayWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvfus bottom top height", bottomTopLabel.getHeight(),
				(int) ((displayHeight - topSplitComposite.getHeight()) * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvfus bottom bottom width", bottomBottomLabel.getWidth(),
				displayWidth);
		CheckHelper.check(TestSplitCompositeHierarchy.class, "vvfus bottom bottom height",
				bottomBottomLabel.getHeight(),
				displayHeight - topSplitComposite.getHeight() - bottomTopLabel.getHeight());
	}

	private static void testHorizontalVerticalFillUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item leftTopLabel = new Item(baseWidth, baseHeight);
		Item leftBottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite leftSplitComposite = TestSplitCompositeSimple.createSplitComposite(leftTopLabel,
				leftBottomLabel, ratio, false);
		Item rightTopLabel = new Item(baseWidth, baseHeight);
		Item rightBottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite rightSplitComposite = TestSplitCompositeSimple.createSplitComposite(rightTopLabel,
				rightBottomLabel, ratio, false);
		SplitComposite splitComposite = TestSplitCompositeSimple.createSplitComposite(leftSplitComposite,
				rightSplitComposite, ratio, true);
		TestHelper.showAndWait(splitComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvfus left top width", leftTopLabel.getWidth(),
				(int) (displayWidth * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvfus left topheight", leftTopLabel.getHeight(),
				(int) (displayHeight * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvfus left bottom width", leftBottomLabel.getWidth(),
				(int) (displayWidth * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvfus left bottom height", leftBottomLabel.getHeight(),
				displayHeight - leftTopLabel.getHeight());
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvfus right top width", rightTopLabel.getWidth(),
				displayWidth - leftTopLabel.getWidth());
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvfus right top height", rightTopLabel.getHeight(),
				(int) (displayHeight * ratio));
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvfus right bottom width", rightBottomLabel.getWidth(),
				displayWidth - leftBottomLabel.getWidth());
		CheckHelper.check(TestSplitCompositeHierarchy.class, "hvfus right bottom height", rightBottomLabel.getHeight(),
				displayHeight - rightTopLabel.getHeight());
	}

}
