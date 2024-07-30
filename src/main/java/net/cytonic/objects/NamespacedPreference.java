package net.cytonic.objects;

import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.Nullable;

/**
 * A record class holding a preference with a namespace
 * @param namespaceID The namespace
 * @param value The default value
 * @param <T> the type of the preference
 */
public record NamespacedPreference<T>(NamespaceID namespaceID, T value) {

    public NamespacedPreference(NamespaceID namespaceID, Class<T> type, @Nullable T value) {
        this(namespaceID, type.cast(value));
    }

    public NamespacedPreference(NamespaceID namespaceID, T value) {
        this.namespaceID = namespaceID;
        this.value = value;
    }
}
