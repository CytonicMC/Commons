package net.cytonic.objects;

/**
 * A record class holding a preference object
 * @param value The value of the preference
 * @param <T> the type of the preference
 */
public record Preference<T>(T value) {
}
