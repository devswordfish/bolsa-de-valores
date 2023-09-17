package estruturadados;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class StaticArray<T> {
    private int size = 0;
    private int capacity;
    private Object[] elements;

    public StaticArray(int capacity) {
        this.setCapacity(capacity);
        this.elements = new Object[capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) this.elements[index];
    }

    public void add(T element) {
        if (this.isFull()) throw new RuntimeException("Static Array is full");
        this.elements[this.size++] = element;
    }

    public void add(int index, T element) {
        if (this.isFull()) throw new RuntimeException("Static Array is full");
        for (int i = this.size - 1; i >= index; i--) this.elements[i + 1] = this.elements[i];
        this.elements[index] = element;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (this.isEmpty()) throw new RuntimeException("Static Array is empty");
        for (int i = index; i < this.size - 1; i++) this.elements[i] = this.elements[i + 1];
        this.size--;
        return (T) this.elements;
    }

    @SuppressWarnings("unchecked")
    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.size; i++) consumer.accept((T) this.elements[i]);
    }

    @SuppressWarnings("unchecked")
    public StaticArray<T> filter(Predicate<T> predicate) {
        StaticArray<T> filteredElements = new StaticArray<>(this.size);
        for (int i = 0; i < this.size; i++) {
            T element = (T) this.elements[i];
            if (predicate.test(element)) filteredElements.add(element);
        }
        filteredElements.setCapacity(filteredElements.getSize());
        return filteredElements;
    }

    @SuppressWarnings("unchecked")
    public <E> StaticArray<E> map(Function<T, E> function) {
        StaticArray<E> mappedElements = new StaticArray<>(this.size);
        for (int i = 0; i < this.size; i++) mappedElements.add(function.apply((T) this.elements[i]));
        return mappedElements;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) throw new RuntimeException("Capaciy must be a non-negative number");
        this.capacity = capacity;
    }
}
