package com.airesnor.wuxiacraft.cultivation;

import com.airesnor.wuxiacraft.WuxiaCraft;

public class Cultivation implements ICultivation {
	private float progress;
	private CultivationLevel level;
	private int subLevel;
	private float energy;

	public Cultivation() {
		this.subLevel = 0;
		this.progress = 0;
		this.level = CultivationLevel.BODY_REFINEMENT;
		this.energy = 0;
	}

	@Override
	public boolean addProgress(float amount) {
		boolean leveled = false;
		this.progress += amount;
		while(this.progress >= this.level.getProgressBySubLevel(this.subLevel)) {
			leveled = true;
			this.progress -= this.level.getProgressBySubLevel(this.subLevel);
			this.subLevel++;
			if(this.subLevel >= this.level.subLevels) {
				this.subLevel = 0;
				this.level = this.level.getNextLevel();
			}
		}
		return leveled;
	}

	@Override
	public CultivationLevel getCurrentLevel() {
		return this.level;
	}

	@Override
	public int getCurrentSubLevel() {
		return this.subLevel;
	}

	@Override
	public float getCurrentProgress() {
		return this.progress;
	}

	@Override
	public void setCurrentLevel(CultivationLevel level) {
		this.level = level;
	}

	@Override
	public void setCurrentSubLevel(int subLevel) {
		this.subLevel = subLevel;
	}

	@Override
	public float getEnergy() {
		return this.energy;
	}

	@Override
	public void setEnergy(float amount) {
		this.energy = Math.min(Math.max(0, amount), this.level.getMaxEnergyByLevel(this.subLevel));
	}

	@Override
	public void addEnergy(float amount) {
		this.energy = Math.min(this.energy + amount, this.level.getMaxEnergyByLevel(this.subLevel));
	}

	@Override
	public void remEnergy(float amount) {
		this.energy = Math.max(this.energy - amount, 0);
	}

	@Override
	public void setProgress(float amount) {
		this.progress = Math.min(Math.max(0,amount), this.level.getProgressBySubLevel(this.subLevel));
	}
}
