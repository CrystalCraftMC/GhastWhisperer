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

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.awt.*;
import java.awt.event.*;

public class AdvancedSettings implements Listener {
	private MobString globalMs;
	
	private JFrame jf;
	private JPanel jpMove;
	private JPanel jpMove2;
	private JCheckBox toggleMovement;
	private Timer tim;   //will update ghast's velocity every x milliseconds (when toggled)
	private double horizontalSpeed;
	private double verticalSpeed;
	private JTextField horizontal;
	private JTextField vertical;
	private JButton applySpeed;
	private JCheckBox invertY;
	
	public AdvancedSettings(MobString ms, PvpStorm plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		globalMs = ms;
		jf = new JFrame("Advanced Settings");
		jf.setSize(700, 600);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.setLayout(new BorderLayout());
		toggleMovement = new JCheckBox("Enable Ghast Control");
		toggleMovement.addItemListener(new ToggleMovementListener());
		tim = new Timer(100, new UpdateVelocity());
		horizontalSpeed = .2;
		verticalSpeed = .2;
		
		jpMove = new JPanel();
		jpMove.setBackground(Color.BLACK);
		toggleMovement.setBackground(Color.DARK_GRAY);
		toggleMovement.setForeground(Color.GREEN);
		jpMove.add(toggleMovement);
		invertY = new JCheckBox("Invert Y Velocity", false);
		invertY.setBackground(Color.DARK_GRAY);
		invertY.setForeground(Color.GREEN);
		jpMove.add(invertY);
		horizontal = new JTextField(8);
		horizontal.setBackground(Color.YELLOW.brighter());
		horizontal.setText(".2");
		horizontal.setPreferredSize(new Dimension(45, 12));
		vertical = new JTextField(8);
		vertical.setBackground(Color.YELLOW);
		vertical.setText(".2");
		vertical.setPreferredSize(new Dimension(45, 12));
		jpMove2 = new JPanel();
		jpMove2.setBackground(Color.BLACK);
		jpMove2.setLayout(new GridLayout(9, 3));
		JLabel horizontalLab = new JLabel("Horizontal Speed:  ");
		horizontalLab.setForeground(Color.GREEN);
		JLabel verticalLab = new JLabel("Vertical Speed:  ");
		verticalLab.setForeground(Color.GREEN);
		applySpeed = new JButton("Apply Speeds");
		applySpeed.setBackground(Color.ORANGE.darker());
		applySpeed.setForeground(Color.BLACK.brighter());
		applySpeed.addActionListener(new SpeedListener());
		JLabel spaces[] = new JLabel[27];
		for(int i = 0; i < 27; i++) {
			spaces[i] = new JLabel("");
			switch(i) {
			case 3:
				jpMove2.add(horizontalLab);
				break;
			case 4:
				jpMove2.add(horizontal);
				break;
			case 14:
				jpMove2.add(applySpeed);
				break;
			case 21:
				jpMove2.add(verticalLab);
				break;
			case 22:
				jpMove2.add(vertical);
				break;
			default:
				jpMove2.add(spaces[i]);
				break;
			}
		}
		
		jf.add(jpMove, BorderLayout.NORTH);
		jf.add(jpMove2, BorderLayout.WEST);
	}
	
	public void display() {
		jf.setVisible(true);
	}
	
	@EventHandler
	public void carrotToggleMovement(PlayerDropItemEvent e) {
		if(e.getItemDrop().getItemStack().isSimilar(new ItemStack(Material.CARROT_ITEM))) {
			Player p = e.getPlayer();
			p.getInventory().addItem(new ItemStack(Material.CARROT_ITEM, 1));
			toggleMovement.doClick(); //will click the JCheckBox in code
		}
	}
	private class ToggleMovementListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource() == toggleMovement) {
				if(toggleMovement.isSelected()) {
					tim.start();
					globalMs.globalPlayer.sendMessage("tim.start() executed");
				}
				else {
					tim.stop();
					globalMs.globalPlayer.sendMessage("tim.stop() executed");
				}
			}
		}
	}
	public void setGhastVelocity() {
		Player p = globalMs.globalPlayer;
		int pitch = (int)p.getEyeLocation().getPitch();
		int yaw = (int)p.getEyeLocation().getYaw();
		yaw = (int)Math.abs(yaw);
		double xVel = 0;
		double yVel = 0;
		double zVel = 0;
		//the above velocities all hold a value between -1 to 1. 0 means no movement,
		//and 1 or -1 mean full movement.  This value is further multiplied by the speed
		//constant, which can be manipulated by the user
		
		if(yaw >= 0 && yaw < 90) {
			xVel = -(yaw/90.0);
			zVel = 1-(yaw/90.0);
		}
		else if(yaw >= 90 && yaw < 180) {
			xVel = -(1-((yaw-90)/90.0));
			zVel = -((yaw-90)/90.0);
		}
		else if(yaw >= 180 && yaw < 270) {
			xVel = (yaw-180)/90.0;
			zVel = -(1-((yaw-180)/90.0));
		}
		else if(yaw >= 270 && yaw < 361) {
			xVel = 1-((yaw-270)/90.0);
			zVel = (yaw-270)/90.0;
		}
		
		if(pitch > 0) {
			yVel = -(pitch/90.0);
		}
		else {
			yVel = Math.abs(pitch)/90.0;
		}
		xVel *= horizontalSpeed;
		zVel *= horizontalSpeed;
		yVel *= verticalSpeed;
		yVel = invertY.isSelected() ? -yVel : yVel;
		globalMs.globalGhast.setVelocity(new Vector(xVel, yVel, zVel));
		Bukkit.broadcastMessage("Yaw:        " + String.valueOf(yaw));
		Bukkit.broadcastMessage("x velocity: " + String.valueOf(xVel));
		Bukkit.broadcastMessage("y velocity: " + String.valueOf(yVel));
		Bukkit.broadcastMessage("z velocity: " + String.valueOf(zVel));
		Bukkit.broadcastMessage("Horizontal speed: " + String.valueOf(horizontalSpeed));
		Bukkit.broadcastMessage("Vertical speed: " + String.valueOf(verticalSpeed));
	}
	
	private class UpdateVelocity implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!globalMs.globalGhast.equals(null)) { //if ghast exists
				if(!globalMs.globalGhast.isDead()) { //if ghast isn't dead
					if(globalMs.globalPlayer.isInsideVehicle()) {
						setGhastVelocity();
					}
				
					
				}
			}
		}
	}
	private class SpeedListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == applySpeed) {
				double horizTest = 0;
				double vertTest = 0;
				boolean isError = false;
				try{
					horizTest = Double.parseDouble(horizontal.getText());
					vertTest = Double.parseDouble(vertical.getText());
				}catch(NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "Error, numbers not formatted correctly.");
					isError = true;
				}
				if(!isError) {
					if(horizTest < -100 || horizTest > 100 ||
							vertTest < -100 || vertTest > 100) {
						JOptionPane.showMessageDialog(null, "Error, numbers can't be greater than" +
								" 100 or less than -100.");
					}
					else {
						if(horizTest < 0 || vertTest < 0) {
							JOptionPane.showMessageDialog(null, "Error, numbers may not be negative.");
						}
						else {
							if(horizTest > .8 || vertTest > .8) {
								JOptionPane.showMessageDialog(null, "Error, numbers may not surpass .8" +
											"\nIt gets ugly.");
							}
							else {
								horizontalSpeed = horizTest;
								verticalSpeed = vertTest;
							}
						}
					}
				}
			}
		}
	}
}
