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
import ej.widget.Switch;
import ej.widget.ToggleButton;

/**
 * 
 */
public class TestSwitch {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();
		ToggleButton toggleButton = new ToggleButton(false);
		Switch sswitch = new Switch();
		toggleButton.addOnChangeListener(sswitch);
		toggleButton.setWidget(sswitch);
		panel.setWidget(toggleButton);
		panel.show(desktop, true);
		desktop.show();
	}
}
