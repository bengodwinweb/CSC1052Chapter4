/*
Benjamin Godwin 2020
CSC1052 - TodoList Project
LinkedList.java

Info: Generic LinkedList class implementing IList<T>
 */

public class LinkedList<T> {
    private LinkNode<T> m_front;
    private LinkNode<T> m_current;

    public LinkNode getFront() {
        return m_front;
    }

    public boolean find(T data) {
        m_current = m_front;

        /*
        Find the element in the list whose data matches the input
        If none exists, return false
        Do not iterate past the last element in the list, that way we can add a new
        element to the end of the list without another iteration, and without having
        to keep track of the tail
         */

        if (!isEmpty()) {
            while (true) {
                if (m_current.getData().equals(data)) {
                    return true;
                } else if (m_current.getNext() != null) {
                    m_current = m_current.getNext();
                } else {
                    break;
                }
            }
        }

        return false;
    }

    public void insert(T data) {
        LinkNode<T> newNode = new LinkNode<>(data);

        /*
        If the list is empty, set front and current equal to the new node
        Otherwise, insert just after current
         */

        if (isEmpty()) {
            m_front = m_current = newNode;
        } else if (!find(data)) {
            newNode.setNext(m_current.getNext());
            m_current.setNext(newNode);
            m_current = newNode;
        }
    }

    public LinkNode<T> get(T data) {
        if (find(data)) {
            return m_current;
        }

        return null;
    }

    public T remove() {
        T data = null;

        /*
        If the list is empty, do nothing

        If the current node is the front, update the front reference
        Otherwise, find the node before the current node, update its next reference to current.getNext(),
        update the current reference
         */

        if (!isEmpty() && m_current != null) {
            if (m_current == m_front) {
                data = m_current.getData();
                m_front = m_current.getNext();
                m_current = m_front;
            } else {
                LinkNode<T> node = m_front;

                while (!m_current.equals(node.getNext())) {
                    node = node.getNext();
                }

                node.setNext(m_current.getNext());
                data = m_current.getData();
                m_current = node;
            }
        }

        return data;
    }

    public T traverse() {
        /*
        Return the current node's data,
        update current to point to the next node
         */

        T data = null;
        if (m_current != null) {
            data = m_current.getData();
            m_current = m_current.getNext();
        }

        return data;
    }

    public void reset() {
        m_current = m_front;
    }

    public boolean isEmpty() {
        return m_front == null;
    }
}
