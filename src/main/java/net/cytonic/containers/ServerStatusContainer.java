package net.cytonic.containers;

import com.google.gson.Gson;
import net.cytonic.objects.CytonicServer;
import net.cytonic.objects.ServerGroup;

public record ServerStatusContainer(String serverName, net.cytonic.containers.ServerStatusContainer.Mode mode,
                                    String ip, int port, ServerGroup group) {


    public static ServerStatusContainer deserialize(String json) {
        return new Gson().fromJson(json, ServerStatusContainer.class);
    }

    public String serialize() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return serialize();
    }

    public CytonicServer server() {
        return new CytonicServer(ip, serverName, port);
    }

    public enum Mode {
        START,
        STOP
    }
}
