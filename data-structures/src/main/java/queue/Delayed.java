package queue;

import java.util.concurrent.TimeUnit;
/**
 * @description: 一个混合样式界面，用于标记在给定延迟后应该执行的对象。
 * 该接口的实现必须定义一个compareTo方法，提供与其getDelay方法一致的排序。
 * @author: Created by yijq
 * @date: 2023/8/13 22:53
 */
public interface Delayed extends Comparable<Delayed>{

    /**
     * 在给定的时间单位中返回与此对象相关联的剩余延迟。
     * @param unit - 时间单位
     * @return 剩余的延迟;零或负值表示延迟已经过去
     */
    long getDelay(TimeUnit unit);
}
