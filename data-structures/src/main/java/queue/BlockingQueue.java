package queue;
/**
 * @description: 阻塞队列接口
 * @author: Created by yijq
 * @date: 2023/8/13 22:51
 */
public interface BlockingQueue<E> extends Queue<E> {

    boolean add(E e);

    /**
     * 将指定的元素插入到此队列中，如果可以立即执行此操作，而不会违反容量限制， true在成功时 false如果当前没有可用空间，则返回false。
     * @param e
     * @return
     */
    boolean offer(E e);
}
