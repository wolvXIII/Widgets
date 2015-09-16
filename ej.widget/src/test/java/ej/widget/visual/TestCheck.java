/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.visual;


import ej.microui.MicroUI;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.widget.Check;

/**
 * 
 */
public class TestCheck {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();
		panel.setPacked(false);

		Check check = new Check();
		panel.setWidget(check);
		panel.show(desktop, true);
		desktop.show();
	}
}
