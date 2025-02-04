package ho.artisan.valles.cardinal;

import ho.artisan.valles.Valles;
import ho.artisan.valles.cardinal.energy.PlayerEnergyComponent;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class VallesCardinalComponent implements EntityComponentInitializer {

    public static final ComponentKey<PlayerEnergyComponent> ENERGY =
            ComponentRegistry.getOrCreate(Valles.of("energy"), PlayerEnergyComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(ENERGY, PlayerEnergyComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
    }
}
