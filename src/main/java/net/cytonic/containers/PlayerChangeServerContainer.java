package net.cytonic.containers;

import com.google.gson.Gson;

import java.util.UUID;

/**
 * The container for when a player changes server
 * @param uuid the uuid of the player
 * @param serverName the server name that the player is now connected to
 */
public record PlayerChangeServerContainer(UUID uuid, String serverName) {

    /**
     * Converts a serialized string into a {@link PlayerChangeServerContainer}
     *
     * @param json The serialized string
     * @return the container object
     */
    public static PlayerChangeServerContainer deserialize(String json) {
        return new Gson().fromJson(json, PlayerChangeServerContainer.class);
    }

    /**
     * Serializes the container into a string
     *
     * @return the serialized string
     */
    public String serialize() {
        return new Gson().toJson(this);
    }

    /**
     * Serializes the container into a string
     *
     * @return the serialized string
     */
    @Override
    public String toString() {
        return serialize();
    }
}