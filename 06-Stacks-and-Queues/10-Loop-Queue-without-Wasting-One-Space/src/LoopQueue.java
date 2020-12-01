// 该 LoopQueue 的实现不浪费那 1 个空间
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        // 由于不浪费空间, 所以 data 静态数组的大小是 capacity, 而不是 capacity + 1
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        // 注意, 我们不再使用 front 和 tail 之间的关系来判断队列是否为空, 而直接使用 size
        return size == 0;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from an empty queue.");
        }
        return data[front];
    }

    @Override
    public void enqueue(E e) {

        // 注意, 我们不再使用 front 和 tail 之间的关系来判断队列是否为满, 而直接使用 size
        // if (tail % data.length == front && size != 0) {
        if (size == getCapacity()) {
            resize(2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from an empty queue.");
        }
        E e = data[front];

        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return e;
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("LoopQueue: {size = %d, capacity = %d, front = %d, tail = %d, ", size, getCapacity(), front, tail));

        builder.append("front [");
        // 注意, 我们的循环遍历打印队列的逻辑也有相应的更改
        for (int i = 0; i < size; i++) {
            builder.append(data[(front + i) % data.length]);
            if ((front + i + 1) % data.length != tail) {
                builder.append(", ");
            }
        }
        builder.append("] tail");

        return builder.toString();

        /*return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';*/
    }

}
