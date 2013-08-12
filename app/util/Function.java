package util;

/**
 * Represents a function from objects of type {@link A} to objects of type {@link B}.
 */
public interface Function<A,B> {

    B apply(A a);
}
