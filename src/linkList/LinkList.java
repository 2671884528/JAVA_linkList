package linkList;
/**
 * 删除操作调试bug
 * 花了四小时
 */

import node.Node;

public class LinkList {

    private Node fist;
    private Node last;
    private int size;

    /*
    增加数据
     */
    public void add(Object value) {
        Node node = new Node();
        if (fist == null) {
            node.setPervious(null);
            node.setObj(value);
            node.setNext(null);

            fist = node;
            last = node;

        } else {
            node.setObj(value);
            node.setPervious(last);
            last.setNext(node);
            node.setNext(null);

            last = node;
        }
        size++;
    }

    /*
    记录链表的长度
     */
    public int getSize() {
        return size;
    }

    /*
    查询链表的内容
     */
    public void search(int index) {
        Node temp = new Node();
        if (index >= size || index < 0) {
            System.out.println("输入的检索超出范围");
        } else {
            temp = fist;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }
        System.out.println(temp.getObj());
    }

    /*
    删除链表的数据
     */
    public void remove(int index) {

        Node temp = null;
        Node up = null;
        Node down = null;
        if (index >= size || index < 0) {
            System.out.println("输入的检索超出范围");
        } else {
            temp = fist;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            up = temp.getPervious();
            down = temp.getNext();
            if (up != null && down != null) {
                System.out.println("错误1");
                up.setNext(down);
                down.setPervious(up);
                size--;
            }else if(up == null && down != null){
                System.out.println("错误2");
                fist = down;
                fist.setPervious(null);
                size--;
            }else if(down == null && up != null){
                System.out.println("错误3");
                last = up;
                last.setNext(null);
                size--;
            }else if(up ==null && down ==null){

                size--;
            }
        }
    }

    /*
    改动数据
     */
    public Node change(int index, Object value) {
        Node temp = new Node();
        if (index >= size || index < 0) {
            System.out.println("输入的检索超出范围");
        } else {
            temp = fist;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            temp.setObj(value);
        }
        return temp;
    }

    /*
    遍历链表的数据
     */
    public void traverse() {
        if (size == 0) {
            System.out.print("这是一个空链表");
        } else {
            Node temp;
            temp = fist;
            for (int i = 0; i < size; i++) {
                System.out.print(temp.getObj() + " ");
                if (temp.getNext() != null) {
                    temp = temp.getNext();
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }
}
