package queue;
/**
 * @description: 单端队列接口
 * Java泛型中的标记符含义：
 * E - Element （元素，在集合中使用）
 * T - Type （Java类）
 * K - Key （键）
 * V - Value （值）
 * N - Number （数值类型）
 * ? - 表示不确定的Java类型
 * @author: Created by yijq
 * @date: 2023/8/13 22:33
 */
public interface Queue<E> {

    boolean add(E e);

    /**
     * 如果在不违反容量限制的情况下立即执行，则将指定的元素插入到此队列中。
     * @param e
     * @return
     */
    boolean offer(E e);

    /**
     * 删除并返回队列的头：检索并删除此队列的头，如果此队列为空，则返回 null 。
     * remove()和poll()方法在队列为空时的行为不同： remove()方法抛出异常，而poll()方法返回null 。
     * @return
     */
    E poll();

    /**
     * 返回队列的头
     * @return
     */
    E peek();
}
