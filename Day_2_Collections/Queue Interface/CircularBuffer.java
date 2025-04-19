public class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            head = (head + 1) % capacity;
        } else {
            size++;
        }
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
    }

    public void displayBuffer() {
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer(3);
        
        circularBuffer.insert(1);
        circularBuffer.insert(2);
        circularBuffer.insert(3);
        circularBuffer.displayBuffer();  
        
        circularBuffer.insert(4);
        circularBuffer.displayBuffer();  
    }
}
