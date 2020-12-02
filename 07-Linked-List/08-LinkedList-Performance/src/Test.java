import java.util.Random;

public class Test {

    // Array 的尾部添加元素与 LinkedList 头部添加元素性能对比
    public static void main(String[] args) {

        int count = 2_000_000;

        // 时间复杂度:
        // addLast: O(1)
        Array<Integer> array = new Array<>();
        long arrayTime = testArray(array, count);
        System.out.println("Array time: " + arrayTime + "ms");

        // 时间复杂度:
        // addFirst: O(1)
        LinkedList<Integer> linkedList = new LinkedList<>();
        long linkedListTime = testLinkedList(linkedList, count);
        System.out.println("LinkedList time: " + linkedListTime + "ms");

        // 虽然猛地看上去, 如果我们只在链表头添加元素, 时间复杂度是 O(1) 的. 同时, 因为使用链表不需要 resize, 所以, 凭直觉, 链表的性能应该更好. 但实际上, 当数据量达到一定程度, 链表的性能是更差的.

        // 为什么即使有 resize, 对于大规模数据, 动态数组还是会快于链表?
        // 1. 链表每添加一个元素, 都需要重新创建一个 Node 类的对象, 也就是都需要进行一次 new 的内存操作. 而对内存的操作, 是非常慢的.
        // 2. 动态数组, 每次 resize 容量增倍, 这将使得, 对于大规模数据, 实际上触发 resize 的次数是非常少的.
        //    动态数组 resize 的过程, 是一次申请一大片内存空间. 比如, 申请一次 10 万的空间, 是远远快于申请 10 万次 1 的空间的.
        //    而相较于堆内存空间的操作, 动态数组的 resize 过程虽然还需要赋值, 把旧数组的元素拷贝给新数组. 但是这个拷贝过程, 是远远快于对内存的操作的.
    }

    private static long testArray(Array<Integer> array, int count) {

        Random random = new Random();

        // 记录开始时间 (单位: 毫秒)
        long start = System.currentTimeMillis();
        // 记录开始时间 (单位: 纳秒)
        // long start = System.nanoTime();

        // 循环 count 次入队操作
        for (int i = 0; i < count; i++) {
            array.addLast(random.nextInt(Integer.MAX_VALUE));
        }

        // 记录结束时间 (单位: 毫秒)
        long end = System.currentTimeMillis();
        // 记录结束时间 (单位: 纳秒)
        // long end = System.nanoTime();

        // 返回间隔时间 (单位: 毫秒)
        return end - start;
        // 返回间隔时间 (单位: 秒)
        // return (end - start) / 1_000_000_000.0;
    }

    private static long testLinkedList(LinkedList<Integer> linkedList, int count) {

        Random random = new Random();

        // 记录开始时间 (单位: 毫秒)
        long start = System.currentTimeMillis();
        // 记录开始时间 (单位: 纳秒)
        // long start = System.nanoTime();

        // 循环 count 次入队操作
        for (int i = 0; i < count; i++) {
            linkedList.addFirst(random.nextInt(Integer.MAX_VALUE));
        }

        // 记录结束时间 (单位: 毫秒)
        long end = System.currentTimeMillis();
        // 记录结束时间 (单位: 纳秒)
        // long end = System.nanoTime();

        // 返回间隔时间 (单位: 毫秒)
        return end - start;
        // 返回间隔时间 (单位: 秒)
        // return (end - start) / 1_000_000_000.0;
    }

}
