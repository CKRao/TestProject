package mystruct.array;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/16 23:36
 * @Description: 自定义数组类
 */
@Slf4j
@Data
public class Array {

    /**
     * 装载数据的数组
     */
    private int[] data;

    /**
     * 数组大小
     */
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造器，默认Array的容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个元素
     *
     * @param e
     */
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 将元素添加到第一位
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在index位置插入新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            log.error("AddLast failed. Array is full.");
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }

        if (index < 0 || index > size) {
            log.error("AddLast failed. Array is full.");
            throw new IllegalArgumentException("AddLast failed. Require index < 0 || index > size.");
        }
        //循环向后移元素
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        //将元素e放置到index位置
        data[index] = e;

        size++;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public int get(int index) {
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index, int e) {
        if (index < 0 || index > size) {
            log.error("AddLast failed. Array is full.");
            throw new IllegalArgumentException("AddLast failed. Require index < 0 || index > size.");
        }

        data[index] = e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d，Capacity = %d，", size, data.length));
        res.append("[");

        for (int i = 0; i < size; i++) {
            res.append(data[i]);

            if (i != size - 1) {
                res.append(",");
            }
        };

        res.append("]");
        return res.toString();
    }
}
