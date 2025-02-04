package ho.artisan.valles.api.cardinal;

import org.ladysnake.cca.api.v3.component.Component;

public interface IEnergy extends Component {

    /**
     * Add or minus energy to the player
     */
    void useEnergy(long energy);

    /**
     * Set the energy of the player
     */
    void setEnergy(long energy);

    /**
     * Set the max energy of the player
     */
    void setMaxEnergy(long energy);

    /**
     * Get the energy of the player
     */
    long getEnergy();

    /**
     * Get the max energy of the player
     */
    long getMaxEnergy();
}
