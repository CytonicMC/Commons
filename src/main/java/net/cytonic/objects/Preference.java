package net.cytonic.objects;

/**
 * A record class holding a preference object
 * @param type The type of this prefernce, only here to prevent gson doing the type cohersion its oh so fond of >:P
 * @param value The value of the preference
 * @param <T> the type of the preference
 */
public record Preference<T>(Class<T> type, T value) {
}
