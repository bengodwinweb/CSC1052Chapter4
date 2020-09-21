/*
Benjamin Godwin 2020
CSC1052 - TodoList Project
LinkNode.java

Info: Generic node used by LinkedList
 */

public class LinkNode<T>{
    private T m_data;
    private LinkNode<T> m_next;

    public LinkNode(T data) {
        m_data = data;
    }

    /**
     * @return the node's Data object
     */
    public T getData() {
        return m_data;
    }

    /**
     * Set the node's Data object
     */
    public void setData(T data) {
        m_data = data;
    }

    /**
     * @return the reference to the next node
     */
    public LinkNode<T> getNext() {
        return m_next;
    }

    /**
     * Set the reference to the next node returned by getNext()
     */
    public void setNext(LinkNode<T> next) {
        m_next = next;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LinkNode) {
            LinkNode other = (LinkNode) obj;
            if (m_data != null) {
                boolean dataEqual = m_data.equals(other.getData());
                boolean otherEqual = m_next == other.getNext();
                return m_data.equals(other.getData()) && m_next == other.getNext();
            } else {
                return other.getData() == null && m_next == other.getNext();
            }
        }
        return false;
    }
}
