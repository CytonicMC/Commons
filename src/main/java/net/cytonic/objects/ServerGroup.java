package net.cytonic.objects;

import com.google.gson.Gson;
import net.cytonic.containers.ServerStatusContainer;

public record ServerGroup (String id, boolean canFallback) {

    public static ServerGroup deserialize(String json) {
        return new Gson().fromJson(json, ServerGroup.class);
    }

    public String serialize() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return serialize();
    }

}
