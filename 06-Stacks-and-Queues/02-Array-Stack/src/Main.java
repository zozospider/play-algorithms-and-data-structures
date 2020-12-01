public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        System.out.println("peek: " + stack.peek());
        System.out.println(stack);

        System.out.println("pop: " + stack.pop());
        System.out.println(stack);
    }

}
