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
	private ArrayList<Entity> array1, array2, array3, array4 = new ArrayList<Entity>();
	public String mobOfChoice1 = "wolf";
	public int numberMobs1 = 2;
	public String mobOfChoice2, mobOfChoice3, mobOfChoice4 = "no mob";
	public int numberMobs2, numberMobs3, numberMobs4 = 0;

	private String chooseMOC(int mobString) {
		switch(mobString) {
		case 1:
			if(this.mobStringExists(1))
				return mobOfChoice1;
			break;
		case 2:
			if(this.mobStringExists(2))
				return mobOfChoice2;
			break;
		case 3:
			if(this.mobStringExists(3))
				return mobOfChoice3;
			break;
		case 4:
			if(this.mobStringExists(4))
				return mobOfChoice4;
			break;
		default:
			return null;
		}
		return null;
	}
	private ArrayList<Entity> chooseArrayList(int input) {
		switch (input) {
		case 1:
			return array1;
		case 2:
			return array2;
		case 3:
			return array3;
		case 4:
			return array4;
		default:
			return null;
		}
	}
	private EntityType chooseAnimal(String mobS) {
		if(mobS.equalsIgnoreCase("sheep"))
			return EntityType.SHEEP;
		else if(mobS.equalsIgnoreCase("wolf"))
			return EntityType.WOLF;
		else if(mobS.equalsIgnoreCase("witch"))
			return EntityType.WITCH;
		else if(mobS.equalsIgnoreCase("ocelot"))
			return EntityType.OCELOT;
		else if(mobS.equalsIgnoreCase("pig"))
			return EntityType.PIG;
		else if(mobS.equalsIgnoreCase("bat"))
			return EntityType.BAT;
		else if(mobS.equalsIgnoreCase("cow"))
			return EntityType.COW;
		else if(mobS.equalsIgnoreCase("skeleton"))
			return EntityType.SKELETON;
		return null;
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
	private int chooseNOM(int numberMobs) {
		switch(numberMobs) {
		case 1:
			return numberMobs1;
		case 2:
			return numberMobs2;
		case 3:
			return numberMobs3;
		case 4:
			return numberMobs4;
		default:
			return 0;
		}
	}

	public MobString(WaterGunListener wgl) {
		//globalWgl = wgl;
	}
	public void cowboy(Player p, Ghast g, Location loc) {
		this.createMobs(p, g, loc);
		//TODO There was a list of if, and else if statements for mobString(1-4) to test whether they existed.
	}

	private void createMobs(Player p, Ghast g, Location loc) {
		this.emptyAllArrays();
		for (int L = 2; L < 5; L++) {
			if(mobStringExists(L)) {
				EntityType animal = chooseAnimal(chooseMOC(L));
				for(int i = 0; i < chooseNOM(L); i++) {
					chooseArrayList(L).add((Entity)p.getWorld().spawnEntity(loc, animal));
					if(i == 0) {
						if (L == 1) g.setPassenger((Entity) chooseArrayList(L).get(i));
						if (L >= 2 && L <= 4) getFinalEntity(L-1).setPassenger(chooseArrayList(L).get(i));
					} 
					else chooseArrayList(L).get(i-1).setPassenger(chooseArrayList(L).get(i));
				}
			}
		} 
		//finally.. we set the player as the passenger.
		if(chooseNOM(1) == 0) ((Ghast) g).setPassenger((Player) p);
		for (int R = 2; R < 6; R++) {
			if(chooseNOM(R) == 0) {//CHECKS AND GIVES 1st, 2nd and 3rd TIER RIDES
				int n = R-1;
				Entity q = getFinalEntity(n);
				if(chooseMOC(n).equalsIgnoreCase("sheep")) castSheep(q).setPassenger(p); 
				else if(chooseMOC(n).equalsIgnoreCase("wolf")) castWolf(q).setPassenger(p);
				else if(chooseMOC(n).equalsIgnoreCase("witch")) castWitch(q).setPassenger(p);
				else if(chooseMOC(n).equalsIgnoreCase("ocelot")) castOcelot(q).setPassenger(p);
				else if(chooseMOC(n).equalsIgnoreCase("pig")) castPig(q).setPassenger(p);
				else if(chooseMOC(n).equalsIgnoreCase("bat")) castBat(q).setPassenger(p);
				else if(chooseMOC(n).equalsIgnoreCase("cow")) castCow(q).setPassenger(p);
				else if(chooseMOC(n).equalsIgnoreCase("skeleton")) castSkelly(q).setPassenger(p);
			}
		}
	}

	private void emptyAllArrays() {
		array1 = new ArrayList<Entity>();
		array2 = new ArrayList<Entity>();
		array3 = new ArrayList<Entity>();
		array4 = new ArrayList<Entity>();
	}

	private Entity getFinalEntity(int whichTier) {
		switch(whichTier) {
		case 1: return array1.get(array1.size()-1);
		case 2: return array2.get(array2.size()-1);
		case 3:	return array3.get(array3.size()-1);
		case 4:	return array4.get(array4.size()-1);
		default:return null;
		}
	}

	private Sheep castSheep(Entity e) {return (Sheep) e;}
	private Wolf castWolf(Entity e) {return (Wolf) e;}
	private Witch castWitch(Entity e) {return (Witch) e;}
	private Ocelot castOcelot(Entity e) {return (Ocelot) e;}
	private Pig castPig(Entity e) {return (Pig)e;}
	private Cow castCow(Entity e) {return (Cow)e;}
	private Skeleton castSkelly(Entity e) {return (Skeleton)e;}
	private Bat castBat(Entity e) {return (Bat)e;}
}
