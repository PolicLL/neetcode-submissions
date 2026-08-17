class DynamicArray {

    private int size;
    private int array[];

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        
        this.size = 0;
        this.array = new int[capacity];
    }

    public int get(int i) {
        checkIndex(i);
        return array[i];
    }

    public void set(int i, int n) {
        checkIndex(i);
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == getCapacity())
            resize();

        array[size++] = n;
    }

    public int popback() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        return array[--size];
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return array.length;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
