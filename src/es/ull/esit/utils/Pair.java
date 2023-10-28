package es.ull.esit.utils;
import java.util.Objects;

public class Pair<F, S> {
    public final F first;
    public final S second;
    /**
     * @brief Constructor de la clase
     * @param first : primer valor del pair
     * @param second : segundo valor del pair
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * @brief devuelve si un pair es igual al otro
     * @return booleano
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }
    /**
     * @brief si los valores no son nulos, devuelve el hascode de cada parte del pair
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }
    /**
     * @brief Crea un Pair <A, B>
     * @param <A>
     * @param <B>
     * @param a
     * @param b
     * @return devuelve el Pair creado
     */
    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }
}
