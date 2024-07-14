package net.cytonic.objects;

import net.minestom.server.utils.NamespaceID;

/**
 * A record class holding a preference with a namespace
 * @param namespaceID The namespace
 * @param value The default value
 * @param <T> the type of the preference
 */
public record NamespacedPreference<T>(NamespaceID namespaceID, T value) {
}
