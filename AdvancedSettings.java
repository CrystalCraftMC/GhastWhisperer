package com.crystalcraftmc.ghastwhisperer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdvancedSettings {
	private MobString globalMs;
	
	private JFrame jf;
	
	public AdvancedSettings(MobString ms) {
		globalMs = ms;
		jf = new JFrame("Advanced Settings");
		jf.setSize(700, 600);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	
	public void display() {
		jf.setVisible(true);
	}
}
