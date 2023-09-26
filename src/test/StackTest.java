//
//
//import java.io.*;
//import java.util.Arrays;
//import java.util.EmptyStackException;
//
//
//class Scratch {
//    public static void main(String[] args) throws FileNotFoundException {
//
//        class Stack {
//            private Object[] elements;
//            private int size = 0;
//            private static final int DEFAULT_CAPACITY = 16;
//
//            public Stack() {
//                elements = new Object[DEFAULT_CAPACITY];
//            }
//
//            public void push(Object e) {
//                ensureCapacity();
//                elements[size++] = e;
//            }
//
//            public Object pop() {
//                if (size == 0) {
//                    throw new EmptyStackException();
//                }
//                return elements[--size];
//            }
//
//            // 원소를 위한 공간을 적어도 하나 이상 여유를 두며, 늘려야하는 경우 두배 이상 늘린다.
//            private void ensureCapacity() {
//                System.out.println("push");
//                if (elements.length == size) {
//                    System.out.println("ensure");
////                    System.out.println(elements.length);
////                    System.out.println(size);
//                    elements = Arrays.copyOf(elements, 2 * size + 1);
//                }
//            }
//        }
//        Stack stack = new Stack();
//        System.out.println("stack intital: " + stack.size);
//        System.out.println("stack.elements intital: " + Arrays.toString(stack.elements));
//        System.out.println("stack elememt intital size  : " + stack.elements.length);
//        stack.push(3);
//        System.out.println("stack : " + Arrays.toString(stack.elements));
//        stack.push(3);
//        System.out.println("stack : " + Arrays.toString(stack.elements));
//        System.out.println("stack : " + stack.size);
//        System.out.println("stack : " + stack.elements.length);
//        for (int i= 1; i <= 18; i++){
//            stack.push(i);
//        }
//        System.out.println("stack size : " + stack.size);
//        System.out.println("stack elememt size  : " + stack.elements.length);
//        System.out.println("stack : " + Arrays.toString(stack.elements));
//
////        for (int i= 0; i <= stack.elements.length; i++){
////            stack.push(i);
////        }
////        System.out.println("stack : {}" + stack.elements.length);
////              System.out.println("stack : {}" + stack.size);
//
//
//
//    }}