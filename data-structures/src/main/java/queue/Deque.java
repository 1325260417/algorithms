package queue;
/**
 * @description: 双端队列接口
 * @author: Created by yijq
 * @date: 2023/8/13 22:48
 */
public interface Deque<E> extends Queue<E> {
    void addFirst(E e);

    void addLast(E e);
}
