class DynamicArray {

    private int size;
    private int capacity;
    private Integer array[];

    public DynamicArray(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            this.size = 0;
            this.array = new Integer[capacity];
        }
    }

    public Integer get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity)
            resize();

        for (int i = 0; i < capacity; ++i) {
            if (array[i] == null) {
                array[i] = n;
                ++size;

                break;
            }
        }
    }

    public Integer popback() {
        for (int i = this.capacity - 1; this.capacity >= 0; --i)
            if (this.array[i] != null) {
                int returnedValue = array[i];
                array[i] = null;
                --size;
                return returnedValue;
            }

        return null;
    }

    private void resize() {
        this.capacity *= 2;
        Integer[] newArr = new Integer[this.capacity];
        for (int i = 0; i < size; ++i)
            newArr[i] = array[i];
        this.array = newArr;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
