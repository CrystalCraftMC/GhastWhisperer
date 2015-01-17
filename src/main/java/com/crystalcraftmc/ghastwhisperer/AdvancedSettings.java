/*
 * Copyright 2015 CrystalCraftMC
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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
