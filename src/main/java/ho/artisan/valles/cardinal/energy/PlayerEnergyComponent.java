package ho.artisan.valles.cardinal.energy;

import ho.artisan.valles.api.cardinal.IEnergy;
import ho.artisan.valles.cardinal.VallesCardinalComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class PlayerEnergyComponent implements IEnergy, AutoSyncedComponent {

    public final PlayerEntity player;

    private long maxEnergy = 270;
    private long energy = 270;

    public PlayerEnergyComponent(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public void useEnergy(long energy) {
        this.energy += energy;
        if (this.energy < 0) player.sendMessage(Text.translatable("message.valles.over_exertion"), true);
        VallesCardinalComponent.ENERGY.sync(this.player);
    }

    @Override
    public void setEnergy(long energy) {
        this.energy = energy;
        VallesCardinalComponent.ENERGY.sync(this.player);
    }

    @Override
    public long getEnergy() {
        return this.energy;
    }

    @Override
    public void setMaxEnergy(long energy) {
        this.maxEnergy = energy;
        VallesCardinalComponent.ENERGY.sync(this.player);
    }

    @Override
    public long getMaxEnergy() {
        return this.maxEnergy;
    }

    @Override
    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.energy = nbtCompound.getLong("energy");
        this.maxEnergy = nbtCompound.getLong("maxEnergy");
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbtCompound.putLong("energy", this.energy);
        nbtCompound.putLong("maxEnergy", this.maxEnergy);
    }
}
