/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test;

import ej.composite.test.border.TestBorderCompositeCenterAlone;
import ej.composite.test.border.TestBorderCompositeConsistency;
import ej.composite.test.split.TestSplitCompositeAlone;
import ej.composite.test.split.TestSplitCompositeConsistency;
import ej.composite.test.split.TestSplitCompositeHierarchy;
import ej.composite.test.split.TestSplitCompositeSimple;
import ej.microui.MicroUI;

/**
 *
 */
public class TestAll {

	public static void main(String[] args) {
		MicroUI.start();

		new TestBorderCompositeCenterAlone().start();
		new TestBorderCompositeConsistency().start();

		new TestSplitCompositeAlone().start();
		new TestSplitCompositeConsistency().start();
		new TestSplitCompositeHierarchy().start();
		new TestSplitCompositeSimple().start();

		MicroUI.stop();
	}

}
