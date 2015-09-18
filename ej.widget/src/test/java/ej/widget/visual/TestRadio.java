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
import ej.widget.Radio;
import ej.widget.RadioButton;

/**
 * 
 */
public class TestRadio {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();

		RadioButton radioButton = new RadioButton(false);
		Radio radio = new Radio();
		radioButton.addOnChangeListener(radio);
		radioButton.setWidget(radio);
		panel.setWidget(radioButton);

		panel.setWidget(radioButton);
		panel.show(desktop, true);
		desktop.show();
	}
}
