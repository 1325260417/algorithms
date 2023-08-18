package linked_list;

public interface List<E> {

    boolean add(E e);

    boolean addFist(E e);

    boolean addLast(E e);

    boolean remove(Object o);

    E get(int index);

    void printLinkList();
}
