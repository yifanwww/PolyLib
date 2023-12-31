package net.creeperhost.polylib.neoforge.inventory.energy;

import net.creeperhost.polylib.inventory.energy.PlatformEnergyManager;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
//import net.neoforged.neoforge.common.capabilities.CapabilityProvider;
import net.neoforged.neoforge.energy.IEnergyStorage;

public record NeoForgeEnergyManager(IEnergyStorage energy) implements PlatformEnergyManager
{
    public NeoForgeEnergyManager(BlockEntity energyItem, Direction direction)
    {
        this(energyItem.getLevel().getCapability(Capabilities.EnergyStorage.BLOCK, energyItem.getBlockPos(), direction));
    }

    @Override
    public long getStoredEnergy()
    {
        return energy.getEnergyStored();
    }

    @Override
    public long getCapacity()
    {
        return energy.getMaxEnergyStored();
    }

    @Override
    public long extract(long amount, boolean simulate)
    {
        return energy.extractEnergy((int) amount, simulate);
    }

    @Override
    public long insert(long amount, boolean simulate)
    {
        return energy.receiveEnergy((int) amount, simulate);
    }

    @Override
    public boolean supportsInsertion()
    {
        return energy.canReceive();
    }

    @Override
    public boolean supportsExtraction()
    {
        return energy.canExtract();
    }
}