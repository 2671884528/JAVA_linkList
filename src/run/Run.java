package run;

import linkList.LinkList;

public class Run {

    public static void main(String[] args){
        LinkList link = new LinkList();
        link.add("余惠是猪");
        link.add(19971015);
        link.add(1925078307);
        link.add("我在写作业");

        //link.change(0,"我爱你小鱼儿");
        link.traverse();
        System.out.println(link.getSize());
        System.out.println("#######################");

        link.remove(3);
        link.traverse();
//        link.search(1);
        System.out.println(link.getSize());
        System.out.println("#################################");

        link.remove(2);
        link.traverse();
        System.out.println(link.getSize());
        System.out.println("#################################");

        link.remove(1);
        link.traverse();
        System.out.println(link.getSize());
        System.out.println("#################################");

        link.remove(0);
        link.traverse();
        System.out.println(link.getSize());
        System.out.println("#################################");

    }
}
