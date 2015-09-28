/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.test;

import ej.microui.MicroUI;

/**
 *
 */
public class TestAll {

	public static void main(String[] args) {
		MicroUI.start();

		new GeneralSelectorsTest().start();
		new InheritanceTest().start();
		new SelectorsTest().start();
		new SimpleTest().start();
		new WeakTest().start();

		MicroUI.stop();
	}

}
