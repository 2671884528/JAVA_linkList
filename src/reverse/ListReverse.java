package reverse;

/**
 * @auther 郭永钢
 * @data 2020/9/8 18:50
 * @desc: 单向链表的反转
 */

public class ListReverse {

    static class LNode {

        //1.存储值
        Object value = null;
        //2.指向的下一个节点
        LNode next = null;

        public LNode(Object value, LNode next) {
            this.value = value;
            this.next = next;
        }

        public LNode() {
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public LNode getNext() {
            return next;
        }

        public void setNext(LNode next) {
            this.next = next;
        }

        @Override
        protected LNode clone() throws CloneNotSupportedException {
            return new LNode(value, next);
        }
    }

    public static void main(String[] args) {
        LNode first = new LNode();
        LNode current = null;
        for (int i = 0; i < 10; i++) {
            if (current == null)
                current = first;
            LNode node = new LNode();
            node.setValue("********" + i + "*********");
            current.setNext(node);
            current = node;
        }
        traverse(first);
        try {
            traverse(reverse(first));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /*正向遍历*/
    public static void traverse(LNode first) {
        while (first != null) {
            if (first.value != null)
                System.out.print(first.getValue().toString() + "\t");
            first = first.next;
        }
        System.out.println();
    }

    /*反转*/
    public static LNode reverse(LNode first) throws CloneNotSupportedException {
        //采用头插法实现，采用深拷贝
        //1.深拷贝first
        //2.深拷贝每一个current，修改它的下一个节点，指定之前的newF
        LNode current = first;
        LNode newF = null;
        LNode temp = first.clone();
        //注意：这里需要清空掉next，防止反向指引3-2-1-0-1-2-3
        //如果不注意，会导致上述情况
        temp.next=null;
        while (current != null && current.next != null) {
            newF = current.next.clone();
            newF.next = temp;
            current = current.next;
            temp = newF;
        }

        return newF;

    }

}
