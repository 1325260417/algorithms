package linked_list;
/**
 * @description: 链表
 * 时间复杂度：
 *      访问、查找：O(n)
 *      插入、删除：O(1)
 *
 * @author: Created by yijq
 * @date: 2023/8/13 19:34
 */
public class LinkedList<E> implements List<E> {

    transient int size = 0;

    transient  Node<E> first;

    transient Node<E> last;

    public LinkedList() {
    }

    /**
     * 头插节点
     * @param e
     */
    void linkFirst(E e) {
        final Node<E> f = first;
        // 新建一个空节点，next为first节点
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        // 当前无节点，则newNode为尾节点，有则将first节点指向新的首节点newNode
        if (f == null) {
            last = newNode;
        }else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * 尾插节点
     * @param e
     */
    void linkLast(E e) {
        final Node<E> l = last;
        // 新建一个空节点，prev为last节点
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        // 当前无节点，则newNode为头节点，有则将last节点指向新的尾节点newNode
        if (l == null) {
            first = newNode;
        }else {
            l.next = newNode;
        }
        size++;
    }
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean addFist(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        }else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 拆链
     * unlink 是一种拆链操作，只要你给定一个元素，它就可以把当前这个元素的上一个节点和一个节点进行相连，之后把自己拆除。
     * 这个方法常用于 remove 移除元素操作，因为整个操作过程不需要遍历，拆除元素后也不需要复制新的空间，所以时间复杂读为 O(1)
     * @param x
     * @return
     */
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;
        if (prev == null) {
            first = next;
        }else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        }else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public void printLinkList() {
        if (this.size == 0) {
            System.out.println("链表为空");
        } else {
            Node<E> temp = first;
            System.out.print("目前的列表，头节点：" + first.item + " 尾节点：" + last.item + " 整体：");
            while (temp != null) {
                System.out.println(temp.item + "，");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    /**
     * 查找O(n)
     * @param index
     * @return
     */
    Node<E> node(int index) {
        // size >> 1 为一半 8 =》 1000 4 =》 100
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        }else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    /**
     * ？表示不确定的 java 类型
     * T (type) 表示具体的一个java类型
     * K V (key value) 分别代表java键值中的Key Value
     * E (element) 代表Element
     */
    private static class Node<E> {

        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
