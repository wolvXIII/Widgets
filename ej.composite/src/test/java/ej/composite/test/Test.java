/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test;

import com.is2t.testsuite.support.CheckHelper;

/**
 *
 */
public abstract class Test {

	public void start() {
		CheckHelper.startCheck(getClass());
		run();
		CheckHelper.endCheck(getClass());
	}

	protected abstract void run();

}
