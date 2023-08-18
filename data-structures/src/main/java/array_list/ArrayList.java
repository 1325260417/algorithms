package array_list;

import java.util.Arrays;

/**
 * @description: 数组
 * @author: Created by yijq
 * @date: 2023/8/13 22:29
 */
public class ArrayList<E> implements List<E> {

    /**
     * 默认初始化空间
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 空元素
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * ArrayList 元素数组缓存区
     */
    transient  Object[] elementData;

    /**
     * List 集合元素数量
     */
    private int size;

    public ArrayList() {
        // 默认给个空的元素，当开始添加元素的时候再初始化长度
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public boolean add(E e) {
        // 确保内部容量
        int minCapacity = size + 1;
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // 判断扩容操作
        //数组容量要扩展1.5倍（原长度加上原长度右移一位即0.5倍），
        //若扩展1.5倍后还不够数组增加的内容，则数组容量就为数组增加的内容长度，
        //若扩展长度大于int类型最大值，则扩展容量为hugeCapacity(minCapacity)
        //然后新建一个数组，数组容量为扩增后的容量，将原数组内容拷贝到新数组，
        //空位补默认值 注意：所以每次都会新建一个新数组，并不是在原数组上做修改
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        // [0,1,2,3,4] index = 3
        E oldValue = (E) elementData[index]; // 3
        int numMoved = size - index - 1; // 5 - 3 -1 = 1
        if (numMoved > 0) {
            // 将后一个元素复制到前一个元素再删除最后一个元素，最后返回删除的元素
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public String toString() {
        return "ArrayList{" +
            "elementData=" + Arrays.toString(elementData) +
            ", size=" + size +
            '}';
    }
}
