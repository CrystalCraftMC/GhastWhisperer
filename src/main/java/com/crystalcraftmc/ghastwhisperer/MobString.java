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

import org.bukkit.Location;
import org.bukkit.entity.*;

import java.util.ArrayList;
public class MobString {
	//private WaterGunListener globalWgl;
	
	private ArrayList<Sheep> sheepArray1 = new ArrayList<Sheep>();
	private ArrayList<Wolf> wolfArray1 = new ArrayList<Wolf>();
	private ArrayList<Witch> witchArray1 = new ArrayList<Witch>();
	private ArrayList<Ocelot> ocelotArray1 = new ArrayList<Ocelot>();
	private ArrayList<Pig> pigArray1 = new ArrayList<Pig>();
	private ArrayList<Cow> cowArray1 = new ArrayList<Cow>();
	private ArrayList<Skeleton> skellyArray1 = new ArrayList<Skeleton>();
	private ArrayList<Bat> batArray1 = new ArrayList<Bat>();
	public String mobOfChoice1 = "wolf";
	public int numberMobs1 = 2;
	
	private ArrayList<Sheep> sheepArray2 = new ArrayList<Sheep>();
	private ArrayList<Wolf> wolfArray2 = new ArrayList<Wolf>();
	private ArrayList<Witch> witchArray2 = new ArrayList<Witch>();
	private ArrayList<Ocelot> ocelotArray2 = new ArrayList<Ocelot>();
	private ArrayList<Pig> pigArray2 = new ArrayList<Pig>();
	private ArrayList<Cow> cowArray2 = new ArrayList<Cow>();
	private ArrayList<Skeleton> skellyArray2 = new ArrayList<Skeleton>();
	private ArrayList<Bat> batArray2 = new ArrayList<Bat>();
	public String mobOfChoice2 = "no mob";
	public int numberMobs2 = 0;
	
	private ArrayList<Sheep> sheepArray3 = new ArrayList<Sheep>();
	private ArrayList<Wolf> wolfArray3 = new ArrayList<Wolf>();
	private ArrayList<Witch> witchArray3 = new ArrayList<Witch>();
	private ArrayList<Ocelot> ocelotArray3 = new ArrayList<Ocelot>();
	private ArrayList<Pig> pigArray3 = new ArrayList<Pig>();
	private ArrayList<Cow> cowArray3 = new ArrayList<Cow>();
	private ArrayList<Skeleton> skellyArray3 = new ArrayList<Skeleton>();
	private ArrayList<Bat> batArray3 = new ArrayList<Bat>();
	public String mobOfChoice3 = "no mob";
	public int numberMobs3 = 0;
	
	private ArrayList<Sheep> sheepArray4 = new ArrayList<Sheep>();
	private ArrayList<Wolf> wolfArray4 = new ArrayList<Wolf>();
	private ArrayList<Witch> witchArray4 = new ArrayList<Witch>();
	private ArrayList<Ocelot> ocelotArray4 = new ArrayList<Ocelot>();
	private ArrayList<Pig> pigArray4 = new ArrayList<Pig>();
	private ArrayList<Cow> cowArray4 = new ArrayList<Cow>();
	private ArrayList<Skeleton> skellyArray4 = new ArrayList<Skeleton>();
	private ArrayList<Bat> batArray4 = new ArrayList<Bat>();
	public String mobOfChoice4 = "no mob";
	public int numberMobs4 = 0;
	
	
	public MobString(WaterGunListener wgl) {
		//globalWgl = wgl;
	}
	
	public void cowboy(Player p, Ghast g, Location loc) {
		this.createMobs(p, g, loc);
		/*if(this.mobStringExists(1)) {
			
		}
		if(this.mobStringExists(2)) {
			
		}
		if(this.mobStringExists(3)) {
			
		}
		if(this.mobStringExists(4)) {
			
		}*/
	}
	
	private boolean mobStringExists(int stringNum) {
		
		boolean exists = false;
		if(stringNum == 1) {
			exists = mobOfChoice1.equalsIgnoreCase("no mob") ? false : true;
		}
		else if(stringNum == 2) {
			exists = mobOfChoice2.equalsIgnoreCase("no mob") ? false : true;
		}
		else if(stringNum == 3) {
			exists = mobOfChoice3.equalsIgnoreCase("no mob") ? false : true;
		}
		else if(stringNum == 4) {
			exists = mobOfChoice4.equalsIgnoreCase("no mob") ? false : true;
		}
		return exists;
	}
	private void createMobs(Player p, Ghast g, Location loc) {
		this.emptyAllArrays(); //prevents unnecessary mob objects
		//it is already ensured in ConfigureData class that no 'no mob' mobstring exists before a mob string
		if(this.mobStringExists(1)) {
			if(mobOfChoice1.equalsIgnoreCase("sheep")) {
				for(int i = 0; i < numberMobs1; i++) {
					sheepArray1.add((Sheep)p.getWorld().spawnEntity(loc, EntityType.SHEEP));
					if(i == 0)
						g.setPassenger(sheepArray1.get(i));
					else
						sheepArray1.get(i-1).setPassenger(sheepArray1.get(i));
				}
			}
			else if(mobOfChoice1.equalsIgnoreCase("wolf")) {
				for(int i = 0; i < numberMobs1; i++) {
					wolfArray1.add((Wolf)p.getWorld().spawnEntity(loc, EntityType.WOLF));
					if(i == 0)
						g.setPassenger(wolfArray1.get(i));
					else
						wolfArray1.get(i-1).setPassenger(wolfArray1.get(i));
				}
			}
			else if(mobOfChoice1.equalsIgnoreCase("witch")) {
				for(int i = 0; i < numberMobs1; i++) {
					witchArray1.add((Witch)p.getWorld().spawnEntity(loc, EntityType.WITCH));
					if(i == 0)
						g.setPassenger(witchArray1.get(i));
					else
						witchArray1.get(i-1).setPassenger(witchArray1.get(i));
				}
			}
			else if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
				for(int i = 0; i < numberMobs1; i++) {
					ocelotArray1.add((Ocelot)p.getWorld().spawnEntity(loc, EntityType.OCELOT));
					if(i == 0)
						g.setPassenger(ocelotArray1.get(i));
					else
						ocelotArray1.get(i-1).setPassenger(ocelotArray1.get(i));
				}
			}
			else if(mobOfChoice1.equalsIgnoreCase("pig")) {
				for(int i = 0; i < numberMobs1; i++) {
					pigArray1.add((Pig)p.getWorld().spawnEntity(loc, EntityType.PIG));
					if(i == 0)
						g.setPassenger(pigArray1.get(i));
					else
						pigArray1.get(i-1).setPassenger(pigArray1.get(i));
				}
			}
			else if(mobOfChoice1.equalsIgnoreCase("cow")) {
				for(int i = 0; i < numberMobs1; i++) {
					cowArray1.add((Cow)p.getWorld().spawnEntity(loc, EntityType.COW));
					if(i == 0)
						g.setPassenger(cowArray1.get(i));
					else
						cowArray1.get(i-1).setPassenger(cowArray1.get(i));
				}
			}
			else if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
				for(int i = 0; i < numberMobs1; i++) {
					skellyArray1.add((Skeleton)p.getWorld().spawnEntity(loc, EntityType.SKELETON));
					if(i == 0)
						g.setPassenger(skellyArray1.get(i));
					else
						skellyArray1.get(i-1).setPassenger(skellyArray1.get(i));
				}
			}
			else if(mobOfChoice1.equalsIgnoreCase("bat")) {
				for(int i = 0; i < numberMobs1; i++) {
					batArray1.add((Bat)p.getWorld().spawnEntity(loc, EntityType.BAT));
					if(i == 0)
						g.setPassenger(batArray1.get(i));
					else
						batArray1.get(i-1).setPassenger(batArray1.get(i));
				}
			}
		}
		if(this.mobStringExists(2)) {
			
					if(mobOfChoice2.equalsIgnoreCase("sheep")) {
						for(int i = 0; i < numberMobs2; i++) {
							sheepArray2.add((Sheep)p.getWorld().spawnEntity(loc, EntityType.SHEEP));
							if(i == 0) {
								if(mobOfChoice1.equalsIgnoreCase("sheep")) {
									this.getFinalSheepObject(1).setPassenger(sheepArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("wolf")) {
									this.getFinalWolfObject(1).setPassenger(sheepArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("witch")) {
									this.getFinalWitchObject(1).setPassenger(sheepArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
									this.getFinalOcelotObject(1).setPassenger(sheepArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("pig")) {
									this.getFinalPigObject(1).setPassenger(sheepArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("cow")) {
									this.getFinalCowObject(1).setPassenger(sheepArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
									this.getFinalSkeletonObject(1).setPassenger(sheepArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("bat")) {
									this.getFinalBatObject(1).setPassenger(sheepArray2.get(i));
								}
							}
							else
								sheepArray2.get(i-1).setPassenger(sheepArray2.get(i));
						}
					}
					else if(mobOfChoice2.equalsIgnoreCase("wolf")) {
						for(int i = 0; i < numberMobs2; i++) {
							wolfArray2.add((Wolf)p.getWorld().spawnEntity(loc, EntityType.WOLF));
							if(i == 0) {
								if(mobOfChoice1.equalsIgnoreCase("sheep")) {
									this.getFinalSheepObject(1).setPassenger(wolfArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("wolf")) {
									this.getFinalWolfObject(1).setPassenger(wolfArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("witch")) {
									this.getFinalWitchObject(1).setPassenger(wolfArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
									this.getFinalOcelotObject(1).setPassenger(wolfArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("pig")) {
									this.getFinalPigObject(1).setPassenger(wolfArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("cow")) {
									this.getFinalCowObject(1).setPassenger(wolfArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
									this.getFinalSkeletonObject(1).setPassenger(wolfArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("bat")) {
									this.getFinalBatObject(1).setPassenger(wolfArray2.get(i));
								}
							}
							else
								wolfArray2.get(i-1).setPassenger(wolfArray2.get(i));
						}
					}
					else if(mobOfChoice2.equalsIgnoreCase("witch")) {
						for(int i = 0; i < numberMobs2; i++) {
							witchArray2.add((Witch)p.getWorld().spawnEntity(loc, EntityType.WITCH));
							if(i == 0) {
								if(mobOfChoice1.equalsIgnoreCase("sheep")) {
									this.getFinalSheepObject(1).setPassenger(witchArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("wolf")) {
									this.getFinalWolfObject(1).setPassenger(witchArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("witch")) {
									this.getFinalWitchObject(1).setPassenger(witchArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
									this.getFinalOcelotObject(1).setPassenger(witchArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("pig")) {
									this.getFinalPigObject(1).setPassenger(witchArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("cow")) {
									this.getFinalCowObject(1).setPassenger(witchArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
									this.getFinalSkeletonObject(1).setPassenger(witchArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("bat")) {
									this.getFinalBatObject(1).setPassenger(witchArray2.get(i));
								}
							}
							else
								witchArray2.get(i-1).setPassenger(witchArray2.get(i));
						}
					}
					else if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
						for(int i = 0; i < numberMobs2; i++) {
							ocelotArray2.add((Ocelot)p.getWorld().spawnEntity(loc, EntityType.OCELOT));
							if(i == 0) {
								if(mobOfChoice1.equalsIgnoreCase("sheep")) {
									this.getFinalSheepObject(1).setPassenger(ocelotArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("wolf")) {
									this.getFinalWolfObject(1).setPassenger(ocelotArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("witch")) {
									this.getFinalWitchObject(1).setPassenger(ocelotArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
									this.getFinalOcelotObject(1).setPassenger(ocelotArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("pig")) {
									this.getFinalPigObject(1).setPassenger(ocelotArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("cow")) {
									this.getFinalCowObject(1).setPassenger(ocelotArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
									this.getFinalSkeletonObject(1).setPassenger(ocelotArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("bat")) {
									this.getFinalBatObject(1).setPassenger(ocelotArray2.get(i));
								}
							}
							else
								ocelotArray2.get(i-1).setPassenger(ocelotArray2.get(i));
						}
					}
					else if(mobOfChoice2.equalsIgnoreCase("pig")) {
						for(int i = 0; i < numberMobs2; i++) {
							pigArray2.add((Pig)p.getWorld().spawnEntity(loc, EntityType.PIG));
							if(i == 0) {
								if(mobOfChoice1.equalsIgnoreCase("sheep")) {
									this.getFinalSheepObject(1).setPassenger(pigArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("wolf")) {
									this.getFinalWolfObject(1).setPassenger(pigArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("witch")) {
									this.getFinalWitchObject(1).setPassenger(pigArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
									this.getFinalOcelotObject(1).setPassenger(pigArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("pig")) {
									this.getFinalPigObject(1).setPassenger(pigArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("cow")) {
									this.getFinalCowObject(1).setPassenger(pigArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
									this.getFinalSkeletonObject(1).setPassenger(pigArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("bat")) {
									this.getFinalBatObject(1).setPassenger(pigArray2.get(i));
								}
							}
							else
								pigArray2.get(i-1).setPassenger(pigArray2.get(i));
						}
					}
					else if(mobOfChoice2.equalsIgnoreCase("cow")) {
						for(int i = 0; i < numberMobs2; i++) {
							cowArray2.add((Cow)p.getWorld().spawnEntity(loc, EntityType.COW));
							if(i == 0) {
								if(mobOfChoice1.equalsIgnoreCase("sheep")) {
									this.getFinalSheepObject(1).setPassenger(cowArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("wolf")) {
									this.getFinalWolfObject(1).setPassenger(cowArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("witch")) {
									this.getFinalWitchObject(1).setPassenger(cowArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
									this.getFinalOcelotObject(1).setPassenger(cowArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("pig")) {
									this.getFinalPigObject(1).setPassenger(cowArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("cow")) {
									this.getFinalCowObject(1).setPassenger(cowArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
									this.getFinalSkeletonObject(1).setPassenger(cowArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("bat")) {
									this.getFinalBatObject(1).setPassenger(cowArray2.get(i));
								}
							}
							else
								cowArray2.get(i-1).setPassenger(cowArray2.get(i));
						}
					}
					else if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
						for(int i = 0; i < numberMobs2; i++) {
							skellyArray2.add((Skeleton)p.getWorld().spawnEntity(loc, EntityType.SKELETON));
							if(i == 0) {
								if(mobOfChoice1.equalsIgnoreCase("sheep")) {
									this.getFinalSheepObject(1).setPassenger(skellyArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("wolf")) {
									this.getFinalWolfObject(1).setPassenger(skellyArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("witch")) {
									this.getFinalWitchObject(1).setPassenger(skellyArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
									this.getFinalOcelotObject(1).setPassenger(skellyArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("pig")) {
									this.getFinalPigObject(1).setPassenger(skellyArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("cow")) {
									this.getFinalCowObject(1).setPassenger(skellyArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
									this.getFinalSkeletonObject(1).setPassenger(skellyArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("bat")) {
									this.getFinalBatObject(1).setPassenger(skellyArray2.get(i));
								}
							}
							else
								skellyArray2.get(i-1).setPassenger(skellyArray2.get(i));
						}
					}
					else if(mobOfChoice2.equalsIgnoreCase("bat")) {
						for(int i = 0; i < numberMobs2; i++) {
							batArray2.add((Bat)p.getWorld().spawnEntity(loc, EntityType.BAT));
							if(i == 0) {
								if(mobOfChoice1.equalsIgnoreCase("sheep")) {
									this.getFinalSheepObject(1).setPassenger(batArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("wolf")) {
									this.getFinalWolfObject(1).setPassenger(batArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("witch")) {
									this.getFinalWitchObject(1).setPassenger(batArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
									this.getFinalOcelotObject(1).setPassenger(batArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("pig")) {
									this.getFinalPigObject(1).setPassenger(batArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("cow")) {
									this.getFinalCowObject(1).setPassenger(batArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
									this.getFinalSkeletonObject(1).setPassenger(batArray2.get(i));
								}
								if(mobOfChoice1.equalsIgnoreCase("bat")) {
									this.getFinalBatObject(1).setPassenger(batArray2.get(i));
								}
							}
							else
								batArray2.get(i-1).setPassenger(batArray2.get(i));
						}
					}
			}
		
		
		if(this.mobStringExists(3)) {
			if(mobOfChoice3.equalsIgnoreCase("sheep")) {
				for(int i = 0; i < numberMobs3; i++) {
					sheepArray3.add((Sheep)p.getWorld().spawnEntity(loc, EntityType.SHEEP));
					if(i == 0) {
						if(mobOfChoice2.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(2).setPassenger(sheepArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(2).setPassenger(sheepArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(2).setPassenger(sheepArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(2).setPassenger(sheepArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(2).setPassenger(sheepArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(2).setPassenger(sheepArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(2).setPassenger(sheepArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(2).setPassenger(sheepArray3.get(i));
						}
					}
					else
						sheepArray3.get(i-1).setPassenger(sheepArray3.get(i));
				}
			}
			else if(mobOfChoice3.equalsIgnoreCase("wolf")) {
				for(int i = 0; i < numberMobs3; i++) {
					wolfArray3.add((Wolf)p.getWorld().spawnEntity(loc, EntityType.WOLF));
					if(i == 0) {
						if(mobOfChoice2.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(2).setPassenger(wolfArray2.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(2).setPassenger(wolfArray2.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(2).setPassenger(wolfArray2.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(2).setPassenger(wolfArray2.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(2).setPassenger(wolfArray2.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(2).setPassenger(wolfArray2.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(2).setPassenger(wolfArray2.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(2).setPassenger(wolfArray2.get(i));
						}
					}
					else
						wolfArray3.get(i-1).setPassenger(wolfArray3.get(i));
				}
			}
			else if(mobOfChoice3.equalsIgnoreCase("witch")) {
				for(int i = 0; i < numberMobs3; i++) {
					witchArray3.add((Witch)p.getWorld().spawnEntity(loc, EntityType.WITCH));
					if(i == 0) {
						if(mobOfChoice2.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(2).setPassenger(witchArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(2).setPassenger(witchArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(2).setPassenger(witchArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(2).setPassenger(witchArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(2).setPassenger(witchArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(2).setPassenger(witchArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(2).setPassenger(witchArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(2).setPassenger(witchArray3.get(i));
						}
					}
					else
						witchArray3.get(i-1).setPassenger(witchArray3.get(i));
				}
			}
			else if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
				for(int i = 0; i < numberMobs3; i++) {
					ocelotArray3.add((Ocelot)p.getWorld().spawnEntity(loc, EntityType.OCELOT));
					if(i == 0) {
						if(mobOfChoice2.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(2).setPassenger(ocelotArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(2).setPassenger(ocelotArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(2).setPassenger(ocelotArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(2).setPassenger(ocelotArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(2).setPassenger(ocelotArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(2).setPassenger(ocelotArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(2).setPassenger(ocelotArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(2).setPassenger(ocelotArray3.get(i));
						}
					}
					else
						ocelotArray3.get(i-1).setPassenger(ocelotArray3.get(i));
				}
			}
			else if(mobOfChoice3.equalsIgnoreCase("pig")) {
				for(int i = 0; i < numberMobs3; i++) {
					pigArray3.add((Pig)p.getWorld().spawnEntity(loc, EntityType.PIG));
					if(i == 0) {
						if(mobOfChoice2.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(2).setPassenger(pigArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(2).setPassenger(pigArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(2).setPassenger(pigArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(2).setPassenger(pigArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(2).setPassenger(pigArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(2).setPassenger(pigArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(2).setPassenger(pigArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(2).setPassenger(pigArray3.get(i));
						}
					}
					else
						pigArray3.get(i-1).setPassenger(pigArray3.get(i));
				}
			}
			else if(mobOfChoice3.equalsIgnoreCase("cow")) {
				for(int i = 0; i < numberMobs3; i++) {
					cowArray3.add((Cow)p.getWorld().spawnEntity(loc, EntityType.COW));
					if(i == 0) {
						if(mobOfChoice2.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(2).setPassenger(cowArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(2).setPassenger(cowArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(2).setPassenger(cowArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(2).setPassenger(cowArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(2).setPassenger(cowArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(2).setPassenger(cowArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(2).setPassenger(cowArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(2).setPassenger(cowArray3.get(i));
						}
					}
					else
						cowArray3.get(i-1).setPassenger(cowArray3.get(i));
				}
			}
			else if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
				for(int i = 0; i < numberMobs3; i++) {
					skellyArray3.add((Skeleton)p.getWorld().spawnEntity(loc, EntityType.SKELETON));
					if(i == 0) {
						if(mobOfChoice2.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(2).setPassenger(skellyArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(2).setPassenger(skellyArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(2).setPassenger(skellyArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(2).setPassenger(skellyArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(2).setPassenger(skellyArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(2).setPassenger(skellyArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(2).setPassenger(skellyArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(2).setPassenger(skellyArray3.get(i));
						}
					}
					else
						skellyArray3.get(i-1).setPassenger(skellyArray3.get(i));
				}
			}
			else if(mobOfChoice3.equalsIgnoreCase("bat")) {
				for(int i = 0; i < numberMobs3; i++) {
					batArray3.add((Bat)p.getWorld().spawnEntity(loc, EntityType.BAT));
					if(i == 0) {
						if(mobOfChoice2.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(2).setPassenger(batArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(2).setPassenger(batArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(2).setPassenger(batArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(2).setPassenger(batArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(2).setPassenger(batArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(2).setPassenger(batArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(2).setPassenger(batArray3.get(i));
						}
						if(mobOfChoice2.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(2).setPassenger(batArray3.get(i));
						}
					}
					else
						batArray3.get(i-1).setPassenger(batArray3.get(i));
				}
			}
	}
		
		if(this.mobStringExists(4)) {
			if(mobOfChoice4.equalsIgnoreCase("sheep")) {
				for(int i = 0; i < numberMobs4; i++) {
					sheepArray4.add((Sheep)p.getWorld().spawnEntity(loc, EntityType.SHEEP));
					if(i == 0) {
						if(mobOfChoice3.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(3).setPassenger(sheepArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(3).setPassenger(sheepArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(3).setPassenger(sheepArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(3).setPassenger(sheepArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(3).setPassenger(sheepArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(3).setPassenger(sheepArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(3).setPassenger(sheepArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(3).setPassenger(sheepArray4.get(i));
						}
					}
					else
						sheepArray4.get(i-1).setPassenger(sheepArray4.get(i));
				}
			}
			else if(mobOfChoice4.equalsIgnoreCase("wolf")) {
				for(int i = 0; i < numberMobs4; i++) {
					wolfArray4.add((Wolf)p.getWorld().spawnEntity(loc, EntityType.WOLF));
					if(i == 0) {
						if(mobOfChoice3.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(3).setPassenger(wolfArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(3).setPassenger(wolfArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(3).setPassenger(wolfArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(3).setPassenger(wolfArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(3).setPassenger(wolfArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(3).setPassenger(wolfArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(3).setPassenger(wolfArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(3).setPassenger(wolfArray4.get(i));
						}
					}
					else
						wolfArray4.get(i-1).setPassenger(wolfArray4.get(i));
				}
			}
			else if(mobOfChoice4.equalsIgnoreCase("witch")) {
				for(int i = 0; i < numberMobs4; i++) {
					witchArray4.add((Witch)p.getWorld().spawnEntity(loc, EntityType.WITCH));
					if(i == 0) {
						if(mobOfChoice3.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(3).setPassenger(witchArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(3).setPassenger(witchArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(3).setPassenger(witchArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(3).setPassenger(witchArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(3).setPassenger(witchArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(3).setPassenger(witchArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(3).setPassenger(witchArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(3).setPassenger(witchArray4.get(i));
						}
					}
					else
						witchArray4.get(i-1).setPassenger(witchArray4.get(i));
				}
			}
			else if(mobOfChoice4.equalsIgnoreCase("ocelot")) {
				for(int i = 0; i < numberMobs4; i++) {
					ocelotArray4.add((Ocelot)p.getWorld().spawnEntity(loc, EntityType.OCELOT));
					if(i == 0) {
						if(mobOfChoice3.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(3).setPassenger(ocelotArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(3).setPassenger(ocelotArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(3).setPassenger(ocelotArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(3).setPassenger(ocelotArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(3).setPassenger(ocelotArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(3).setPassenger(ocelotArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(3).setPassenger(ocelotArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(3).setPassenger(ocelotArray4.get(i));
						}
					}
					else
						ocelotArray4.get(i-1).setPassenger(ocelotArray4.get(i));
				}
			}
			else if(mobOfChoice4.equalsIgnoreCase("pig")) {
				for(int i = 0; i < numberMobs4; i++) {
					pigArray4.add((Pig)p.getWorld().spawnEntity(loc, EntityType.PIG));
					if(i == 0) {
						if(mobOfChoice3.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(3).setPassenger(pigArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(3).setPassenger(pigArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(3).setPassenger(pigArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(3).setPassenger(pigArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(3).setPassenger(pigArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(3).setPassenger(pigArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(3).setPassenger(pigArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(3).setPassenger(pigArray4.get(i));
						}
					}
					else
						pigArray4.get(i-1).setPassenger(pigArray4.get(i));
				}
			}
			else if(mobOfChoice4.equalsIgnoreCase("cow")) {
				for(int i = 0; i < numberMobs4; i++) {
					cowArray4.add((Cow)p.getWorld().spawnEntity(loc, EntityType.COW));
					if(i == 0) {
						if(mobOfChoice3.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(3).setPassenger(cowArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(3).setPassenger(cowArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(3).setPassenger(cowArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(3).setPassenger(cowArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(3).setPassenger(cowArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(3).setPassenger(cowArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(3).setPassenger(cowArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(3).setPassenger(cowArray4.get(i));
						}
					}
					else
						cowArray4.get(i-1).setPassenger(cowArray4.get(i));
				}
			}
			else if(mobOfChoice4.equalsIgnoreCase("skeleton")) {
				for(int i = 0; i < numberMobs4; i++) {
					skellyArray4.add((Skeleton)p.getWorld().spawnEntity(loc, EntityType.SKELETON));
					if(i == 0) {
						if(mobOfChoice3.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(3).setPassenger(skellyArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(3).setPassenger(skellyArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(3).setPassenger(skellyArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(3).setPassenger(skellyArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(3).setPassenger(skellyArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(3).setPassenger(skellyArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(3).setPassenger(skellyArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(3).setPassenger(skellyArray4.get(i));
						}
					}
					else
						skellyArray4.get(i-1).setPassenger(skellyArray4.get(i));
				}
			}
			else if(mobOfChoice4.equalsIgnoreCase("bat")) {
				for(int i = 0; i < numberMobs4; i++) {
					batArray4.add((Bat)p.getWorld().spawnEntity(loc, EntityType.BAT));
					if(i == 0) {
						if(mobOfChoice3.equalsIgnoreCase("sheep")) {
							this.getFinalSheepObject(3).setPassenger(batArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("wolf")) {
							this.getFinalWolfObject(3).setPassenger(batArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("witch")) {
							this.getFinalWitchObject(3).setPassenger(batArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
							this.getFinalOcelotObject(3).setPassenger(batArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("pig")) {
							this.getFinalPigObject(3).setPassenger(batArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("cow")) {
							this.getFinalCowObject(3).setPassenger(batArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
							this.getFinalSkeletonObject(3).setPassenger(batArray4.get(i));
						}
						if(mobOfChoice3.equalsIgnoreCase("bat")) {
							this.getFinalBatObject(3).setPassenger(batArray4.get(i));
						}
					}
					else
						batArray4.get(i-1).setPassenger(batArray4.get(i));
				}
			}
		}
		//finally.. we set the player as the passenger.
		if(numberMobs1 == 0) {
			g.setPassenger(p);
		}
		else if(numberMobs2 == 0) {
			if(mobOfChoice1.equalsIgnoreCase("sheep")) {
				this.getFinalSheepObject(1).setPassenger(p);
			}
			if(mobOfChoice1.equalsIgnoreCase("wolf")) {
				this.getFinalWolfObject(1).setPassenger(p);
			}
			if(mobOfChoice1.equalsIgnoreCase("witch")) {
				this.getFinalWitchObject(1).setPassenger(p);
			}
			if(mobOfChoice1.equalsIgnoreCase("ocelot")) {
				this.getFinalOcelotObject(1).setPassenger(p);
			}
			if(mobOfChoice1.equalsIgnoreCase("pig")) {
				this.getFinalPigObject(1).setPassenger(p);
			}
			if(mobOfChoice1.equalsIgnoreCase("cow")) {
				this.getFinalCowObject(1).setPassenger(p);
			}
			if(mobOfChoice1.equalsIgnoreCase("skeleton")) {
				this.getFinalSkeletonObject(1).setPassenger(p);
			}
			if(mobOfChoice1.equalsIgnoreCase("bat")) {
				this.getFinalBatObject(1).setPassenger(p);
			}
		}
		else if(numberMobs3 == 0) {
			if(mobOfChoice2.equalsIgnoreCase("sheep")) {
				this.getFinalSheepObject(2).setPassenger(p);
			}
			if(mobOfChoice2.equalsIgnoreCase("wolf")) {
				this.getFinalWolfObject(2).setPassenger(p);
			}
			if(mobOfChoice2.equalsIgnoreCase("witch")) {
				this.getFinalWitchObject(2).setPassenger(p);
			}
			if(mobOfChoice2.equalsIgnoreCase("ocelot")) {
				this.getFinalOcelotObject(2).setPassenger(p);
			}
			if(mobOfChoice2.equalsIgnoreCase("pig")) {
				this.getFinalPigObject(2).setPassenger(p);
			}
			if(mobOfChoice2.equalsIgnoreCase("cow")) {
				this.getFinalCowObject(2).setPassenger(p);
			}
			if(mobOfChoice2.equalsIgnoreCase("skeleton")) {
				this.getFinalSkeletonObject(2).setPassenger(p);
			}
			if(mobOfChoice2.equalsIgnoreCase("bat")) {
				this.getFinalBatObject(2).setPassenger(p);
			}
		}
		else if(numberMobs4 == 0) {
			if(mobOfChoice3.equalsIgnoreCase("sheep")) {
				this.getFinalSheepObject(3).setPassenger(p);
			}
			if(mobOfChoice3.equalsIgnoreCase("wolf")) {
				this.getFinalWolfObject(3).setPassenger(p);
			}
			if(mobOfChoice3.equalsIgnoreCase("witch")) {
				this.getFinalWitchObject(3).setPassenger(p);
			}
			if(mobOfChoice3.equalsIgnoreCase("ocelot")) {
				this.getFinalOcelotObject(3).setPassenger(p);
			}
			if(mobOfChoice3.equalsIgnoreCase("pig")) {
				this.getFinalPigObject(3).setPassenger(p);
			}
			if(mobOfChoice3.equalsIgnoreCase("cow")) {
				this.getFinalCowObject(3).setPassenger(p);
			}
			if(mobOfChoice3.equalsIgnoreCase("skeleton")) {
				this.getFinalSkeletonObject(3).setPassenger(p);
			}
			if(mobOfChoice3.equalsIgnoreCase("bat")) {
				this.getFinalBatObject(3).setPassenger(p);
			}
		}
		else {
		
			if(mobOfChoice4.equalsIgnoreCase("sheep")) {
				this.getFinalSheepObject(4).setPassenger(p);
			}
			if(mobOfChoice4.equalsIgnoreCase("wolf")) {
				this.getFinalWolfObject(4).setPassenger(p);
			}
			if(mobOfChoice4.equalsIgnoreCase("witch")) {
				this.getFinalWitchObject(4).setPassenger(p);
			}
			if(mobOfChoice4.equalsIgnoreCase("ocelot")) {
				this.getFinalOcelotObject(4).setPassenger(p);
			}
			if(mobOfChoice4.equalsIgnoreCase("pig")) {
				this.getFinalPigObject(4).setPassenger(p);
			}
			if(mobOfChoice4.equalsIgnoreCase("cow")) {
				this.getFinalCowObject(4).setPassenger(p);
			}
			if(mobOfChoice4.equalsIgnoreCase("skeleton")) {
				this.getFinalSkeletonObject(4).setPassenger(p);
			}
			if(mobOfChoice4.equalsIgnoreCase("bat")) {
				this.getFinalBatObject(4).setPassenger(p);
			}
		}
	}
	private void emptyAllArrays() {
		sheepArray1 = new ArrayList<Sheep>();
		wolfArray1 = new ArrayList<Wolf>();
		witchArray1 = new ArrayList<Witch>();
		ocelotArray1 = new ArrayList<Ocelot>();
		pigArray1 = new ArrayList<Pig>();
		cowArray1 = new ArrayList<Cow>();
		skellyArray1 = new ArrayList<Skeleton>();
		batArray1 = new ArrayList<Bat>();
		
		sheepArray2 = new ArrayList<Sheep>();
		wolfArray2 = new ArrayList<Wolf>();
		witchArray2 = new ArrayList<Witch>();
		ocelotArray2 = new ArrayList<Ocelot>();
		pigArray2 = new ArrayList<Pig>();
		cowArray2 = new ArrayList<Cow>();
		skellyArray2 = new ArrayList<Skeleton>();
		batArray2 = new ArrayList<Bat>();
		
		sheepArray3 = new ArrayList<Sheep>();
		wolfArray3 = new ArrayList<Wolf>();
		witchArray3 = new ArrayList<Witch>();
		ocelotArray3 = new ArrayList<Ocelot>();
		pigArray3 = new ArrayList<Pig>();
		cowArray3 = new ArrayList<Cow>();
		skellyArray3 = new ArrayList<Skeleton>();
		batArray3 = new ArrayList<Bat>();
		
		sheepArray4 = new ArrayList<Sheep>();
		wolfArray4 = new ArrayList<Wolf>();
		witchArray4 = new ArrayList<Witch>();
		ocelotArray4 = new ArrayList<Ocelot>();
		pigArray4 = new ArrayList<Pig>();
		cowArray4 = new ArrayList<Cow>();
		skellyArray4 = new ArrayList<Skeleton>();
		batArray3 = new ArrayList<Bat>();
	}
	private Sheep getFinalSheepObject(int whichTier) {
		switch(whichTier) {
		case 1:
			return sheepArray1.get(sheepArray1.size()-1);
		case 2:
			return sheepArray2.get(sheepArray2.size()-1);
		case 3:
			return sheepArray3.get(sheepArray3.size()-1);
		default: //case = 4
			return sheepArray4.get(sheepArray4.size()-1);
		}
	}
	private Wolf getFinalWolfObject(int whichTier) {
		switch(whichTier) {
		case 1:
			return wolfArray1.get(wolfArray1.size()-1);
		case 2:
			return wolfArray2.get(wolfArray2.size()-1);
		case 3:
			return wolfArray3.get(wolfArray3.size()-1);
		default: //case = 4
			return wolfArray4.get(wolfArray4.size()-1);
		}
	}
	private Witch getFinalWitchObject(int whichTier) {
		switch(whichTier) {
		case 1:
			return witchArray1.get(witchArray1.size()-1);
		case 2:
			return witchArray2.get(witchArray2.size()-1);
		case 3:
			return witchArray3.get(witchArray3.size()-1);
		default: //case = 4
			return witchArray4.get(witchArray4.size()-1);
		}
	}
	private Ocelot getFinalOcelotObject(int whichTier) {
		switch(whichTier) {
		case 1:
			return ocelotArray1.get(ocelotArray1.size()-1);
		case 2:
			return ocelotArray2.get(ocelotArray2.size()-1);
		case 3:
			return ocelotArray3.get(ocelotArray3.size()-1);
		default: //case = 4
			return ocelotArray4.get(ocelotArray4.size()-1);
		}
	}
	private Pig getFinalPigObject(int whichTier) {
		switch(whichTier) {
		case 1:
			return pigArray1.get(pigArray1.size()-1);
		case 2:
			return pigArray2.get(pigArray2.size()-1);
		case 3:
			return pigArray3.get(pigArray3.size()-1);
		default: //case = 4
			return pigArray4.get(pigArray4.size()-1);
		}
	}
	private Cow getFinalCowObject(int whichTier) {
		switch(whichTier) {
		case 1:
			return cowArray1.get(cowArray1.size()-1);
		case 2:
			return cowArray2.get(cowArray2.size()-1);
		case 3:
			return cowArray3.get(cowArray3.size()-1);
		default: //case = 4
			return cowArray4.get(cowArray4.size()-1);
		}
	}
	private Skeleton getFinalSkeletonObject(int whichTier) {
		switch(whichTier) {
		case 1:
			return skellyArray1.get(skellyArray1.size()-1);
		case 2:
			return skellyArray2.get(skellyArray2.size()-1);
		case 3:
			return skellyArray3.get(skellyArray3.size()-1);
		default: //case = 4
			return skellyArray4.get(skellyArray4.size()-1);
		}
	}
	private Bat getFinalBatObject(int whichTier) {
		switch(whichTier) {
		case 1:
			return batArray1.get(batArray1.size()-1);
		case 2:
			return batArray2.get(batArray2.size()-1);
		case 3:
			return batArray3.get(batArray3.size()-1);
		default: //case = 4
			return batArray4.get(batArray4.size()-1);
		}
	}
}
