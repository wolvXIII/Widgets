/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.visual;


import ej.bon.Timer;
import ej.bon.TimerTask;
import ej.microui.MicroUI;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.widget.CircularProgressBar;

/**
 * 
 */
public class TestCircularProgressBar {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();
		panel.setPacked(false);

		final CircularProgressBar progressBar = new CircularProgressBar(0, 100,
				75);
		panel.setWidget(progressBar);
		panel.show(desktop, true);
		desktop.show();

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				int currentValue = progressBar.getValue();
				int maximum = progressBar.getMaximum();

				if (currentValue < maximum) {
					progressBar.setValue(currentValue + maximum / 10);
				} else {
					progressBar.reset();
				}
			}
		}, 100, 500);
	}
}
