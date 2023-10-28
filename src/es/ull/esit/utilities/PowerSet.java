package es.ull.esit.utilities;

import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

/// Sirve para calcular todos los subconjuntos de un conjunto dado
public class PowerSet<E> implements Iterator<Set<E>>, Iterable<Set<E>> {

    private E[] arr = null;
    private BitSet bset = null;
    /**
     * @brief Constructor de la clase
     * @param set : es un Set<E>
     */
    @SuppressWarnings("unchecked")
    public PowerSet(Set<E> set) {
        this.arr = set.toArray((E[]) new Object[0]);
        this.bset = new BitSet(this.arr.length + 1);
    }
    /**
     * @brief devuelve si el set tiene siguiente
     * @return booleano
     */
    @Override
    public boolean hasNext() {
        return !this.bset.get(this.arr.length);
    }
    /**
     * @brief Devuelve el siguiente valor del set
     * @return Set<E>
     */
    @Override
    public Set<E> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Set<E> returnSet = new TreeSet<>();
        for (int i = 0; i < this.arr.length; i++) {
            if (this.bset.get(i)) {
                returnSet.add(this.arr[i]);
            }
        }
        for (int i = 0; i < this.bset.size(); i++) {
            if (!this.bset.get(i)) {
                this.bset.set(i);
                break;
            } else {
                this.bset.clear(i);
            }
        }
        return returnSet;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not Supported!");
    }
    /**
     * @brief devuelve el iterador del siguiente elemento
     * @return Iterator<Set<E>>
     */
    @Override
    public Iterator<Set<E>> iterator() {
        return new Iterator<Set<E>>() {
            public boolean hasNext() {
                return hasNext();
            }
            public Set<E> next() {
                return next();
            }
        };
    }
}