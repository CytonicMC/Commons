package net.cytonic.containers;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.cytonic.objects.CytonicServer;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("preview")
public class SendPlayerToServerContainer implements Container {
    private final String id = "SEND_PLAYER";
    private UUID player = null;
    private CytonicServer server = null;

    @Nullable
    private UUID instance = null;

    /**
     * Creates an instance of this container
     *
     * @param player the player's uuid
     * @param server the server to send the player to
     * @param instance the uuid of the instance to send the player tor
     * @return the created object instance
     */
    public static SendPlayerToServerContainer create(UUID player, CytonicServer server, UUID instance) {
        return new SendPlayerToServerContainer(player, server, instance);
    }

    static SendPlayerToServerContainer create() {
        return new SendPlayerToServerContainer();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String serialize() {
        return STR."\{id}-\{new Gson().toJson(this)}";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String id() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SendPlayerToServerContainer parse(String json) {
        return new Gson().fromJson(json, SendPlayerToServerContainer.class);
    }
}
