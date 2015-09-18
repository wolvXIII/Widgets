/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test;

import ej.composite.test.border.TestBorderCompositeCenterAlone;
import ej.composite.test.border.TestBorderCompositeConsistency;
import ej.composite.test.border.TestBorderCompositeNorthAlone;
import ej.composite.test.flow.TestFlowCompositeFill;
import ej.composite.test.flow.TestFlowCompositeSimple;
import ej.composite.test.grid.TestGridCompositeNone;
import ej.composite.test.grid.TestGridCompositeSimple;
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
		new TestBorderCompositeNorthAlone().start();

		new TestFlowCompositeFill().start();
		new TestFlowCompositeSimple().start();

		new TestGridCompositeNone().start();
		new TestGridCompositeSimple().start();

		new TestSplitCompositeAlone().start();
		new TestSplitCompositeConsistency().start();
		new TestSplitCompositeHierarchy().start();
		new TestSplitCompositeSimple().start();

		MicroUI.stop();
	}

}
