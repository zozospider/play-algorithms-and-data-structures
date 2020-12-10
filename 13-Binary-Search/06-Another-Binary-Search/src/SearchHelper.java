// 查找帮助类
public class SearchHelper {

    private SearchHelper() {
    }

    enum SEARCH {
        LINEAR_SEARCH,
        BINARY_SEARCH,
        BINARY_SEARCH_NOT_RECURSION,
        BINARY_SEARCH_NOT_RECURSION_2
    }

    // 测试查找耗时
    public static <E extends Comparable<E>> long search(E[] data, E target, SEARCH search) {
        // 记录开始时间 (单位: 毫秒)
        long start = System.currentTimeMillis();

        if (search == SEARCH.LINEAR_SEARCH) {
            int index = LinearSearch.search(data, target);
        } else if (search == SEARCH.BINARY_SEARCH) {
            int index = BinarySearch.search(data, target);
        } else if (search == SEARCH.BINARY_SEARCH_NOT_RECURSION) {
            int index = BinarySearch.searchNotRecursion(data, target);
        } else if (search == SEARCH.BINARY_SEARCH_NOT_RECURSION_2) {
            int index = BinarySearch.searchNotRecursion2(data, target);
        }

        // 记录结束时间 (单位: 毫秒)
        long end = System.currentTimeMillis();
        // 返回时间间隔 (单位: 毫秒)
        return end - start;
    }

}
