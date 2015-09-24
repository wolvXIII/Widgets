/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test.nonauto.visual;


import ej.microui.MicroUI;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.widget.ToggleButton;

/**
 * 
 */
public class TestToggleButton {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();
		panel.setPacked(false);

		ToggleButton toggleButton = new ToggleButton(true);
		panel.setWidget(toggleButton);
		panel.show(desktop, true);
		desktop.show();
	}
}
