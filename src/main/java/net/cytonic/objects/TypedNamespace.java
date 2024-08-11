package net.cytonic.objects;

import net.minestom.server.utils.NamespaceID;


/**
 * A record class holding a namespace and a type, to keep type safety
 *
 * @param namespaceID the namespace
 * @param type        the type of the preference
 * @param <T>         the type of the preference
 */
public record TypedNamespace<T>(NamespaceID namespaceID, Class<T> type) {
    // records are cool
}
