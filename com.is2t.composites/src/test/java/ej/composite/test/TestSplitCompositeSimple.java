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
import ej.mwt.Widget;

/**
 *
 */
public class TestSplitCompositeSimple {

	public static void main(String[] args) {
		CheckHelper.startCheck(TestSplitCompositeSimple.class);

		testHorizontalPackedUniformSplit();
		testVerticalPackedUniformSplit();
		testHorizontalFillUniformSplit();
		testVerticalFillUniformSplit();
		testHorizontalPackedVariableSplit();
		testVerticalPackedVariableSplit();

		CheckHelper.endCheck(TestSplitCompositeSimple.class);
	}

	private static void testHorizontalPackedUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item leftLabel = new Item(baseWidth, baseHeight);
		Item rightLabel = new Item(baseWidth, baseHeight);
		SplitComposite splitComposite = createSplitComposite(leftLabel, rightLabel, ratio, true);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeSimple.class, "hpus left width", leftLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpus left height", leftLabel.getHeight(), baseHeight);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpus right width", rightLabel.getWidth(), baseWidth * 2);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpus right height", rightLabel.getHeight(), baseHeight);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpus composite width", splitComposite.getWidth(),
				baseWidth * 3);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpus composite height", splitComposite.getHeight(),
				baseHeight);
	}

	private static void testHorizontalPackedVariableSplit() {
		final int baseWidth = 30;
		final int biggestHeight = 40;
		final int smallestHeight = 20;
		float ratio = (float) 1 / 3;

		// test biggest first
		Item leftLabel = new Item(baseWidth, biggestHeight);
		Item rightLabel = new Item(baseWidth, smallestHeight);
		SplitComposite splitComposite = createSplitComposite(leftLabel, rightLabel, ratio, true);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs left width", leftLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs left height", leftLabel.getHeight(), biggestHeight);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs right width", rightLabel.getWidth(), baseWidth * 2);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs right height", rightLabel.getHeight(), biggestHeight);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs composite width", splitComposite.getWidth(),
				baseWidth * 3);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs composite height", splitComposite.getHeight(),
				biggestHeight);

		// test smallest first
		leftLabel = new Item(baseWidth, smallestHeight);
		rightLabel = new Item(baseWidth, biggestHeight);
		splitComposite = createSplitComposite(leftLabel, rightLabel, ratio, true);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs left width", leftLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs left height", leftLabel.getHeight(),
				Math.max(biggestHeight, smallestHeight));
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs right width", rightLabel.getWidth(), baseWidth * 2);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs right height", rightLabel.getHeight(),
				Math.max(biggestHeight, smallestHeight));
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs composite width", splitComposite.getWidth(),
				baseWidth * 3);
		CheckHelper.check(TestSplitCompositeSimple.class, "hpvs composite height", splitComposite.getHeight(),
				biggestHeight);
	}

	private static void testHorizontalFillUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item leftLabel = new Item(baseWidth, baseHeight);
		Item rightLabel = new Item(baseWidth, baseHeight);
		SplitComposite splitComposite = createSplitComposite(leftLabel, rightLabel, ratio, true);
		TestHelper.showAndWait(splitComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper
		.check(TestSplitCompositeSimple.class, "hfus left width", leftLabel.getWidth(), displayWidth * ratio);
		CheckHelper.check(TestSplitCompositeSimple.class, "hfus left height", leftLabel.getHeight(), displayHeight);
		CheckHelper.check(TestSplitCompositeSimple.class, "hfus right width", rightLabel.getWidth(), displayWidth
				- leftLabel.getWidth());
		CheckHelper.check(TestSplitCompositeSimple.class, "hfus right height", rightLabel.getHeight(), displayHeight);
		CheckHelper.check(TestSplitCompositeSimple.class, "hfus composite width", splitComposite.getWidth(),
				displayWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "hfus composite height", splitComposite.getHeight(),
				displayHeight);
	}

	private static void testVerticalPackedUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item topLabel = new Item(baseWidth, baseHeight);
		Item bottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite splitComposite = createSplitComposite(topLabel, bottomLabel, ratio, false);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeSimple.class, "vpus top width", topLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpus top height", topLabel.getHeight(), baseHeight);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpus bottom width", bottomLabel.getWidth(), baseWidth);
		CheckHelper
		.check(TestSplitCompositeSimple.class, "vpus bottom height", bottomLabel.getHeight(), baseHeight * 2);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpus composite width", splitComposite.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpus composite height", splitComposite.getHeight(),
				baseHeight * 3);
	}

	private static void testVerticalPackedVariableSplit() {
		final int biggestWidth = 30;
		final int smallestWidth = 15;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		// test biggest width first
		Item topLabel = new Item(biggestWidth, baseHeight);
		Item bottomLabel = new Item(smallestWidth, baseHeight);
		SplitComposite splitComposite = createSplitComposite(topLabel, bottomLabel, ratio, false);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs top width", topLabel.getWidth(), biggestWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs top height", topLabel.getHeight(), baseHeight);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs bottom width", bottomLabel.getWidth(), biggestWidth);
		CheckHelper
				.check(TestSplitCompositeSimple.class, "vpvs bottom height", bottomLabel.getHeight(), baseHeight * 2);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs composite width", splitComposite.getWidth(),
				biggestWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs composite height", splitComposite.getHeight(),
				baseHeight * 3);

		// test smallest width first
		topLabel = new Item(smallestWidth, baseHeight);
		bottomLabel = new Item(biggestWidth, baseHeight);
		splitComposite = createSplitComposite(topLabel, bottomLabel, ratio, false);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs top width", topLabel.getWidth(), biggestWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs top height", topLabel.getHeight(), baseHeight);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs bottom width", bottomLabel.getWidth(), biggestWidth);
		CheckHelper
				.check(TestSplitCompositeSimple.class, "vpvs bottom height", bottomLabel.getHeight(), baseHeight * 2);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs composite width", splitComposite.getWidth(),
				biggestWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "vpvs composite height", splitComposite.getHeight(),
				baseHeight * 3);
	}

	private static void testVerticalFillUniformSplit() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item topLabel = new Item(baseWidth, baseHeight);
		Item bottomLabel = new Item(baseWidth, baseHeight);
		SplitComposite splitComposite = createSplitComposite(topLabel, bottomLabel, ratio, false);
		TestHelper.showAndWait(splitComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper.check(TestSplitCompositeSimple.class, "vfus top width", topLabel.getWidth(), displayWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "vfus top height", topLabel.getHeight(),
				(int) (displayHeight * ratio));
		CheckHelper.check(TestSplitCompositeSimple.class, "vfus bottom width", bottomLabel.getWidth(), displayWidth);
		CheckHelper.check(TestSplitCompositeSimple.class, "vfus bottom height", bottomLabel.getHeight(), displayHeight
				- topLabel.getHeight());
		CheckHelper.check(TestSplitCompositeAlone.class, "vfus composite width", splitComposite.getWidth(),
				displayWidth);
		CheckHelper.check(TestSplitCompositeAlone.class, "vfus composite height", splitComposite.getHeight(),
				displayHeight);
	}

	public static SplitComposite createSplitComposite(Widget firstLabel, Widget secondLabel, float ratio,
			boolean horizontal) {
		SplitComposite splitComposite = new SplitComposite();
		splitComposite.setHorizontal(horizontal);
		splitComposite.setRatio(ratio);
		splitComposite.add(firstLabel);
		splitComposite.add(secondLabel);
		return splitComposite;
	}

}
