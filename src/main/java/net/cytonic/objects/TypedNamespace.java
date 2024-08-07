package net.cytonic.objects;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.minestom.server.utils.NamespaceID;

import java.io.IOException;


/**
 * A record class holding a namespace and a type, to keep type safety
 * @param namespaceID the namespace
 * @param type the type of the preference
 * @param <T> the type of the preference
 */
public record TypedNamespace<T>(NamespaceID namespaceID, Class<T> type) {
    // records are cool
}
