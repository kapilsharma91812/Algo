package com.kapil.random;

import java.util.HashMap;

/**
 * Created by kapilsharma on 25/06/17.
 */
public class LRU {
    class Node {
        private Node pre;
        private Node next;
        private int pageNumber;

        public Node(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }
    }
    class DLL {
        private final int size;
        private int currentSize;
        private Node head;
        private Node tail;

        public DLL(int size) {
            this.size = size;
            this.currentSize = 0;
        }

        public int getSize() {
            return size;
        }

        public int getCurrentSize() {
            return currentSize;
        }

        public void setCurrentSize(int currentSize) {
            this.currentSize = currentSize;
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public Node addPageToList(int pageNo) {
            Node newNode = new Node(pageNo);
            if (head == null) {
                head = newNode;
                tail = newNode;
                currentSize = 1;
                return newNode;
            } else if (currentSize < size) {
                currentSize++;
            } else {
                tail = tail.getPre();
                tail.setNext(null);
            }
            newNode.setNext(head);
            head.setPre(newNode);
            head = newNode;
            return newNode;
        }

        public void movePageToHead(Node pageNode) {
            if (pageNode == null || pageNode == head) {
                return;
            }

            if(pageNode == tail) {
                tail = tail.getPre();
                tail.setNext(null);
            } else {
                pageNode.getPre().setNext(pageNode.getNext());
                pageNode.getNext().setPre(pageNode.getPre());
            }
            pageNode.setNext(head);
            pageNode.setPre(null);
            head = pageNode;
        }

        public void printList() {
            if (head == null) {
                return;
            }
            Node tmp = head;
            while (tmp != null) {
                System.out.println(tmp.getPageNumber());
                tmp = tmp.getNext();
            }
        }


    }

    private final int cacheSize;
    private final DLL pageList;
    private final HashMap<Integer, Node> pageMap;

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
        this.pageList = new DLL(cacheSize);
        this.pageMap = new HashMap<Integer, Node>();

    }

    public void accessPage(int pageNumber) {
        Node pageNode = null;
        if (pageMap.containsKey(pageNumber)) {
            pageNode = pageMap.get(pageNumber);
            pageList.movePageToHead(pageNode);
        } else {
            if (pageList.getCurrentSize() == pageList.getSize()) {
                pageMap.remove(pageList.getTail().getPageNumber());
            }
            pageNode = pageList.addPageToList(pageNumber);
            pageMap.put(pageNumber, pageNode);
        }
    }

    public void cacheState() {
        pageList.printList();
    }

    public static void main(String[] args) {
        int cacheSize = 4;
        LRU lru = new LRU(cacheSize);
        lru.accessPage(4);
        lru.cacheState();
        lru.accessPage(2);
    }

}
