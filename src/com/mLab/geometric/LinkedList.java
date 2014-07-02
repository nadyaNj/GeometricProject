package com.mLab.geometric;


public class LinkedList<T> {
    private Node firstNode;
    private Node lastNode;
    private int length;

    public LinkedList() {
        length = 0;
    }

    public void add(T item) {
        Node newNode = new Node(item);
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }

        length++;
    }

    public void add(int index, T item) {
        if (index == length) {
            add(item);
            length++;
        } else if (index == 0) {
            Node newNode = new Node(item);
            newNode.next = firstNode;
            firstNode = newNode;
            length++;
        }

        Node temp = firstNode;

        for (int i = 0; i < index - 2; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(item);

        newNode.next = temp.next;
        temp.next = newNode;

        length++;
    }

    public void add(int index, LinkedList<T> newList) {
        if (index == length) {
            lastNode.next = newList.firstNode;
            lastNode = newList.lastNode;
        } else if (index == 0) {
            newList.lastNode.next = firstNode;
            firstNode = newList.firstNode;

        } else {

            Node temp = firstNode;

            for (int i = 0; i < index - 2; i++) {
                temp = temp.next;
            }

            newList.lastNode.next = temp.next;
            temp.next = newList.firstNode;

        }
        length += newList.length;



    }


    public T getItem(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        Node temp = firstNode;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        return temp.value;
    }


    public LinkedList<T> getItem(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || firstIndex >= length || secondIndex < 0 || secondIndex > length) {
            return null;
        }
        LinkedList<T> returnedLinkedList = new LinkedList<T>();
        Node temp = firstNode;
        if(firstIndex < secondIndex) {
            for (int i = 0; i < firstIndex - 1; i++) {
                temp = temp.next;
            }

            for(int i = 0; i < secondIndex-firstIndex; i ++) {
                temp = temp.next;
                returnedLinkedList.add(temp.value);
            }

        }

        return returnedLinkedList;
    }

    public void deleteItem(int index) {
        if (index < 0 || index >= length) {
            return;
        }

        if (length == 1) {
            firstNode = null;
            lastNode = null;
            return;
        }

        Node temp = firstNode;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        length--;

    }

    public int search(T str) {
        Node temp = firstNode;
        int index = 0;
        while (!temp.value.equals(str)) {
            index++;
            if (index == length) {
                return -1;
            }
            temp = temp.next;
        }
        return index;
    }

    private class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();
        Node temp = firstNode;
        do {
            builder.append(temp.value);
            builder.append(",");
            temp = temp.next;
        } while (temp != null);

        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }
}
