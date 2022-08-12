package ss_11_DSA_Stack_Queue.ss_1_practice.Post1;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {

    public  static class myGenericStack<T> {
        private  LinkedList<T> stack;

        public myGenericStack() {
            stack = new LinkedList();
        }

        public void push(T element) {
            stack.addFirst(element);
        }

        public T pop() {
            if (stack.isEmpty()) {
                throw new EmptyStackException();

            }
            return stack.removeFirst();
        }

        public  int size() {
            return stack.size();
        }

        public boolean isEmpty() {
            if (stack.size() == 0) {
                return true;
            }
            return false;
        }
    }
}