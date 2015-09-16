/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import com.is2t.testsuite.support.CheckHelper;

/**
 * 
 */
public class TestDefaultBoundedRangeModel {

	private class OnValueChangeListenerDebug implements OnValueChangeListener {

		private boolean changed;

		@Override
		public void onValueChanged(Object source, int before, int after) {
			this.changed = true;
		}

		boolean hasChanged() {
			return this.changed;
		}

		void reset() {
			this.changed = false;
		}
	}

	private DefaultBoundedRangeModel model;
	private OnValueChangeListenerDebug listener;

	private void testCorrectConstructor() {
		int minimum = 5;
		int maximum = 40;
		int initialValue = 20;
		DefaultBoundedRangeModel model = new DefaultBoundedRangeModel(minimum, maximum, initialValue);
		CheckHelper.check(DefaultBoundedRangeModel.class, "constructor minimum", model.getMinimum(), minimum);
		CheckHelper.check(DefaultBoundedRangeModel.class, "constructor maximum", model.getMaximum(), maximum);
		CheckHelper.check(DefaultBoundedRangeModel.class, "constructor value", model.getValue(), initialValue);
	}

	private void testBadConstructor() {
		try {
			DefaultBoundedRangeModel model = new DefaultBoundedRangeModel(5, 10, 100);
			CheckHelper.check(DefaultBoundedRangeModel.class, "bad constructor", false);
		} catch (IllegalArgumentException e) {
			CheckHelper.check(DefaultBoundedRangeModel.class, "", true);
		}

		try {
			DefaultBoundedRangeModel model = new DefaultBoundedRangeModel(5, 10, 1);
			CheckHelper.check(DefaultBoundedRangeModel.class, "bad constructor", false);
		} catch (IllegalArgumentException e) {
			CheckHelper.check(DefaultBoundedRangeModel.class, "", true);
		}
	}

	private void beforeSetGetTest() {
		this.model = new DefaultBoundedRangeModel(0, 100, 50);
		this.listener = new OnValueChangeListenerDebug();
		this.model.setOnValueChangeListener(this.listener);
	}

	private void testSetGetMaximum() {
		beforeSetGetTest();

		this.model.setMaximum(this.model.getMaximum() + 10);
		checkConstraint(this.model);
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get maximum listener notified",
				this.listener.hasChanged());
		this.listener.reset();

		this.model.setMaximum(this.model.getValue() - 1);
		checkConstraint(this.model);
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get maximum listener notified",
				this.listener.hasChanged());
		this.listener.reset();

		this.model.setMaximum(this.model.getMinimum() - 10);
		checkConstraint(this.model);
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get maximum listener notified",
				this.listener.hasChanged());
		this.listener.reset();

		this.model.setMaximum(this.model.getMaximum());
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get maximum listener not notified",
				!this.listener.hasChanged());
	}

	private void testSetGetMinimum() {
		beforeSetGetTest();

		this.model.setMinimum(this.model.getMinimum() - 10);
		checkConstraint(this.model);
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get minimum listener notified",
				this.listener.hasChanged());
		this.listener.reset();

		this.model.setMinimum(this.model.getValue() + 1);
		checkConstraint(this.model);
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get minimum listener notified",
				this.listener.hasChanged());
		this.listener.reset();

		this.model.setMinimum(this.model.getMaximum() + 10);
		checkConstraint(this.model);
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get minimum listener notified",
				this.listener.hasChanged());
		this.listener.reset();

		this.model.setMinimum(this.model.getMinimum());
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get minimum listener not notified",
				!this.listener.hasChanged());
	}

	private void testSetGetValue() {
		beforeSetGetTest();

		this.model.setValue(this.model.getMinimum() - 10);
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get value", this.model.getValue(),
				this.model.getMinimum());
		CheckHelper
				.check(DefaultBoundedRangeModel.class, "set get value listener notified", this.listener.hasChanged());
		this.listener.reset();

		this.model.setValue(this.model.getMaximum() + 10);
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get value", this.model.getValue(),
				this.model.getMaximum());
		CheckHelper
				.check(DefaultBoundedRangeModel.class, "set get value listener notified", this.listener.hasChanged());
		this.listener.reset();

		this.model.setValue(this.model.getValue());
		CheckHelper.check(DefaultBoundedRangeModel.class, "set get value listener not notified",
				!this.listener.hasChanged());
	}

	private static void checkConstraint(DefaultBoundedRangeModel model) {
		CheckHelper.check(DefaultBoundedRangeModel.class, "check model constraint",
				model.getValue() >= model.getMinimum());
		CheckHelper.check(DefaultBoundedRangeModel.class, "check model constraint",
				model.getValue() <= model.getMaximum());
	}

	public static void main(String[] args) {
		CheckHelper.startCheck(DefaultBoundedRangeModel.class);
		TestDefaultBoundedRangeModel testDefaultBoundedRangeModel = new TestDefaultBoundedRangeModel();
		testDefaultBoundedRangeModel.testCorrectConstructor();
		testDefaultBoundedRangeModel.testBadConstructor();
		testDefaultBoundedRangeModel.testSetGetMaximum();
		testDefaultBoundedRangeModel.testSetGetMinimum();
		testDefaultBoundedRangeModel.testSetGetValue();
		CheckHelper.endCheck(DefaultBoundedRangeModel.class);
	}
}
