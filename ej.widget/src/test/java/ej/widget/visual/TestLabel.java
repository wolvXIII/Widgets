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
import ej.widget.Label;

/**
 * 
 */
public class TestLabel {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();
		panel.setPacked(false);

		Label text = new Label("Hello World !!!\nil fait beau et je cours dans les champs");
		panel.setWidget(text);
		panel.show(desktop, true);
		desktop.show();
	}
}
