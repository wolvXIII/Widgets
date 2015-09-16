/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.composite;

import ej.microui.MicroUI;

/**
 *
 */
public class TestSplitComposite {

	public static void main(String[] args) {
		TestSplitCompositeConsistency.main(args);
		TestSplitCompositeAlone.main(args);
		TestSplitCompositeSimple.main(args);
		TestSplitCompositeHierarchy.main(args);
		MicroUI.stop();
	}

}
