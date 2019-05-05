package mystruct.array;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.StringJoiner;

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
     *
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
            throw new IllegalArgumentException("AddLast failed. Require index > 0 && index < size.");
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
     *
     * @param index
     * @return
     */
    public int get(int index) {
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, int e) {
        if (index < 0 || index > size) {
            log.error("AddLast failed. Array is full.");
            throw new IllegalArgumentException("AddLast failed. Require index > 0 && index < size.");
        }

        data[index] = e;
    }

    @Override
    public String toString() {
//        原toString方法采用StringBuilder实现
//        StringBuilder res = new StringBuilder();
//        res.append(String.format("Array:size = %d，Capacity = %d，", size, data.length));
//        res.append("[");
//
//        for (int i = 0; i < size; i++) {
//            res.append(data[i]);
//
//            if (i != size - 1) {
//                res.append(",");
//            }
//        }
//
//        res.append("]");
//        return res.toString();

        //采用StringJoiner重写toString
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            sj.add(data[i] + "");
        }
        return sj.toString();
    }

    /**
     * 查找数组中是否含有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找数组中元素e所在的所有索引，如果不存在元素e，则返回空数组
     *
     * @param e
     * @return
     */
    public Array findAll(int e) {
        Array indexArr = new Array();
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                indexArr.addLast(i);
            }
        }
        return indexArr;
    }

    /**
     * 从数组中删除index位置的元素，并返回删除的元素
     *
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            log.error("Remove failed. Index is illegal.");
            throw new IllegalArgumentException("Remove failed. Require index < 0 || index > size.");

        }

        int ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        return ret;
    }

    /**
     * 删除第一个元素，并返回删除的元素
     *
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素，并返回删除的元素
     *
     * @return
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param e
     */
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 从数组中删除元素e，并返回一个删除标记
     *
     * @param e
     */
    public boolean removeEleAndGetFlag(int e) {
        boolean isRemove = false;
        int index = find(e);
        if (index != -1) {
            remove(index);
            isRemove = true;
        }

        return isRemove;
    }

    /**
     * 从数组中删除所有的元素e
     *
     * @param e
     */
    public void removeAllElements(int e) {
        for (int i = 0; i < size; i++) {
            if (!removeEleAndGetFlag(e)) {
                break;
            }
        }
    }
}
