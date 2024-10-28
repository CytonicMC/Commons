package net.cytonic.containers;

import com.google.gson.Gson;
import net.cytonic.objects.CytonicServer;
import net.cytonic.objects.ServerGroup;

/**
 * The container for when a server starts or stops
 * @param serverName the name of the server
 * @param mode whether the server is starting or stopping
 * @param ip the ip of the server
 * @param port the port of the server
 * @param group the {@link ServerGroup} of the server
 */
public record ServerStatusContainer(String serverName, net.cytonic.containers.ServerStatusContainer.Mode mode,
                                    String ip, int port, ServerGroup group) {

    /**
     * Converts a serialized string into a {@link ServerStatusContainer}
     *
     * @param json The serialized string
     * @return the container object
     */
    public static ServerStatusContainer deserialize(String json) {
        return new Gson().fromJson(json, ServerStatusContainer.class);
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

    /**
     * Creates a new {@link CytonicServer} object using the server's IP, name, and port.
     *
     * @return A new {@link CytonicServer} object representing the server.
     *
     * @see CytonicServer
     */
    public CytonicServer server() {
        return new CytonicServer(ip, serverName, port);
    }

    /**
     * Whether the server is starting or stopping
     */
    public enum Mode {
        /**
         * When the server starts
         */
        START,
        /**
         * When the server stops
         */
        STOP
    }
}
