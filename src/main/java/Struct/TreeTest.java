package Struct;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/14 22:26
 * @Description:
 */
public class TreeTest {


    private static Node initTree() {
        //设置节点值
        Node node = new Node();
        node.val = 1;
        Node node1 = new Node();
        node1.val = 2;
        Node node2 = new Node();
        node2.val = 3;
        Node node3 = new Node();
        node3.val = 4;
        Node node4 = new Node();
        node4.val = 5;
        Node node5 = new Node();
        node5.val = 6;
        Node node6 = new Node();
        node6.val = 7;
        Node node7 = new Node();
        node7.val = 8;
        Node node8 = new Node();
        node8.val = 9;
        Node node9 = new Node();
        node9.val = 10;
        Node node10 = new Node();
        node10.val = 11;
        Node node11 = new Node();
        node11.val = 12;

        //设置节点关系
        node.leftNode = node1;
        node.rightNode = node2;
        node1.leftNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        node4.leftNode = node6;
        node4.rightNode = node7;
        node7.leftNode = node8;
        node7.rightNode = node9;
        node9.leftNode = node10;
        node10.rightNode = node11;

        //返回根节点
        return node;
    }


    public static void main(String[] args) throws InterruptedException {
        //1.获得根节点
        Node root = initTree();
        //2.设置last 和 nextLast
        Node last = root;
        Node nextLast = null;

        //3.设置队列来存储节点
        ArrayBlockingQueue<Node> queue = new ArrayBlockingQueue<Node>(100);

        //4.先将根节点放置于队列中
        queue.put(root);
        //5.循环将下一行节点放进队列
        while (true) {
            //如果当前弹出元素已经为空则代表打印结束
            if (queue.isEmpty()) {
                System.out.println("-----END-----");
                break;
            }
            //6.将自己的子节点放进队列并弹出自己同时打印
            Node take = queue.take();
            System.out.print("-" + take.val);
            //如果子节点不为空则将其放进队列
            if (take.leftNode != null) {
                queue.put(take.leftNode);
                nextLast = take.leftNode;
            }
            if (take.rightNode != null) {
                queue.put(take.rightNode);
                nextLast = take.rightNode;
            }

            if (last == take) {
                last = nextLast;
                //打印换行符
                System.out.println("--");
            }
        }
    }
}
