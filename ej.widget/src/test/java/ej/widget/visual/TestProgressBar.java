/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.visual;


import ej.microui.MicroUI;
import ej.mwt.Desktop;
import ej.mwt.MWT;
import ej.mwt.Panel;
import ej.widget.ProgressBar;

/**
 * 
 */
public class TestProgressBar {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();
		panel.setPacked(false);

		final ProgressBar progressBar = new ProgressBar(0, 100, 50);
		progressBar.setOrientation(MWT.HORIZONTAL);
		panel.setWidget(progressBar);
		panel.show(desktop, true);
		desktop.show();

		// Timer timer = new Timer();
		// timer.schedule(new TimerTask() {
		//
		// @Override
		// public void run() {
		// int currentValue = progressBar.getValue();
		// int maximum = progressBar.getMaximum();
		//
		// if (currentValue < maximum) {
		// progressBar.setValue(currentValue + maximum / 10);
		// } else {
		// progressBar.reset();
		// }
		// }
		// }, 100, 100);
	}
}
