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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ConfigureData {
	//private WaterGunListener globalWgl;
	private MobString globalMs;
	private JFrame jf;
	private JPanel jp1;
	private JPanel jp2;
	private JComboBox stringNum;
	private JComboBox mobType;
	private JComboBox projectile;
	private JLabel sliderTitle;
	private JSlider numberMobs;
	private JButton apply;
	private JButton getStringData;
	
	public ConfigureData(WaterGunListener wgl, MobString ms) {
		//globalWgl = wgl;
		globalMs = ms;
		
		jf = new JFrame("Customize Your Ride");
		jf.setSize(500, 400);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.setLayout(new GridLayout(1, 2));
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		//jp1.setPreferredSize(new Dimension(250, 200));
		
		jp1.setLayout(new GridLayout(7, 2));
		jp2.setLayout(new GridLayout(4, 1));
		String[] stringNumString = { "Mob String 1", "Mob String 2",
							"Mob String 3", "Mob String 4" };
		String[] mobTypeString = { "Sheep", "Wolf", "Witch", "Ocelot", "Pig",
									"Cow", "Skeleton", "Bat" };
		String[] projectileString = { "Normal", "Fireball", "Arrow", "Snowball", "Egg" };
		
		JLabel[] spaces = new JLabel[20];
		for(int i = 0; i < spaces.length; i++)
			spaces[i] = new JLabel(" ");
		
		stringNum = new JComboBox(stringNumString);
		stringNum.addItemListener(new StringChangeListener());
		mobType = new JComboBox(mobTypeString);
		projectile = new JComboBox(projectileString);
		
		for(int i = 0; i < 14; i++) {
			switch(i) { //basically an if/else if/else statement
			case 2:
				jp1.add(stringNum);
				break;
			case 6:
				jp1.add(mobType);
				break;
			case 10:
				jp1.add(projectile);
				break;
			default:
				jp1.add(spaces[i]);
				break;
			}
		}
		sliderTitle = new JLabel("      Number Of Mobs In MobString 1");
		numberMobs = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
		numberMobs.setMajorTickSpacing(5);
		numberMobs.setMinorTickSpacing(1);
		numberMobs.setPaintLabels(true);
		numberMobs.setPaintTicks(true);
		
		
		apply = new JButton("Apply To MobString 1");
		apply.addActionListener(new ApplyListener());
		getStringData = new JButton("Get MobString 1\'s Data");
		getStringData.addActionListener(new ApplyListener());
		jp2.add(sliderTitle);
		jp2.add(numberMobs);
		jp2.add(apply);
		jp2.add(getStringData);
		jf.add(jp1);
		jf.add(jp2);
		jf.setResizable(false);
		this.colorCode(); //TODO actually make the method
	}
	
	public void display() {
		jf.setVisible(true);
	}
	
	private class StringChangeListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			sliderTitle.setText("              Number Of Mobs In MobString " +
					String.valueOf(stringNum.getSelectedIndex()+1));
			apply.setText("Apply To MobString " +
					String.valueOf(stringNum.getSelectedIndex()+1));
			getStringData.setText("Get MobString " + String.valueOf(stringNum.getSelectedIndex()+1) +
					"\'s Data");
			
		}
	}
	private class ApplyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int whichMobString = stringNum.getSelectedIndex();
			int numMobs = numberMobs.getValue();
			if(e.getSource() == apply) {
				boolean isImproper = false; //equals true if a 'no mob' mobstring comes before a mob string
				
				if(whichMobString == 0 && numMobs == 0 && (globalMs.numberMobs2 != 0 ||
								globalMs.numberMobs3 != 0 || globalMs.numberMobs4 != 0)) {
						isImproper = true;
					}
					else if(whichMobString == 1 && numMobs == 0 && (globalMs.numberMobs3 != 0 ||
								globalMs.numberMobs4 != 0)) {
						isImproper = true;
					}
					else if(whichMobString == 2 && numMobs == 0 && (globalMs.numberMobs4 != 0)) {
						isImproper = true;
					}
					else if(whichMobString == 3 && numMobs != 0 && (globalMs.numberMobs3 == 0 || globalMs.numberMobs2 == 0 ||
								globalMs.numberMobs1 == 0)) {
						isImproper = true;
					}
					else if(whichMobString == 2 && numMobs != 0 && (globalMs.numberMobs2 == 0 || globalMs.numberMobs1 == 0)) {
						isImproper = true;
					}
					else if(whichMobString == 1 && numMobs != 0 && (globalMs.numberMobs1 == 0)) {
						isImproper = true;
					}
				
				if(isImproper) {
					JOptionPane.showMessageDialog(null, "" +
							"Error; you cannot have a Mob String\n" +
							"with a 0 mob count before a Mob String\n" +
							"that has a mob count greater than 0.");
				}
				else {
					String mobType9 = mobType.getSelectedItem().toString().toLowerCase();
					int numMobs9 = numberMobs.getValue();
					if(whichMobString == 0) {
						globalMs.mobOfChoice1 = mobType9;
						globalMs.numberMobs1 = numMobs9;
						if(globalMs.numberMobs1 == 0)
							globalMs.mobOfChoice1 = "no mob";
					}
					else if(whichMobString == 1) {
						globalMs.mobOfChoice2 = mobType9;
						globalMs.numberMobs2 = numMobs9;
						if(globalMs.numberMobs2 == 0)
							globalMs.mobOfChoice2 = "no mob";
					}
					else if(whichMobString == 2) {
						globalMs.mobOfChoice3 = mobType9;
						globalMs.numberMobs3 = numMobs9;
						if(globalMs.numberMobs3 == 0)
							globalMs.mobOfChoice3 = "no mob";
					}
					else if(whichMobString == 3) {
						globalMs.mobOfChoice4 = mobType9;
						globalMs.numberMobs4 = numMobs9;
						if(globalMs.numberMobs4 == 0)
							globalMs.mobOfChoice4 = "no mob";
					}
				}
			}
			else if(e.getSource() == getStringData) {
				String thisMob8 = "Mob String " + String.valueOf(whichMobString+1);
				String mobType8 = "";
				int mobNum8 = 0;
				if(whichMobString == 0) {
					mobType8 = globalMs.mobOfChoice1;
					mobNum8 = globalMs.numberMobs1;
				}
				else if(whichMobString == 1) {
					mobType8 = globalMs.mobOfChoice2;
					mobNum8 = globalMs.numberMobs2;
				}
				else if(whichMobString == 2) {
					mobType8 = globalMs.mobOfChoice3;
					mobNum8 = globalMs.numberMobs3;
				}
				else if(whichMobString == 3) {
					mobType8 = globalMs.mobOfChoice4;
					mobNum8 = globalMs.numberMobs4;
				}
				//below line of code makes mobType8 have an upper-case first letter
				//such syntax is similar to System.out.printf(String str);
				mobType8 = String.format("%C%s", mobType8.charAt(0), mobType8.substring(1));
				JOptionPane.showMessageDialog(null, "" +
						thisMob8 + "'s Data:\n" +
						"-Entity Type: " + mobType8 + "\n" +
						"-Mob Count:   " + mobNum8 + " mobs");
			}
		}
	}
	private void colorCode() {
		
	}
}
