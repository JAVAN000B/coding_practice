import java.util.Stack;

/**
 * @Classname publicNode
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class publicNode {
    static class listNode{
        int data;
        listNode next;
    }

    public listNode findPublicNode(listNode head1, listNode head2){
        if (head2 == null||head1==null) return null;

        listNode publicNode = null;
        Stack<listNode> stack1 = new Stack<> ();
        Stack<listNode> stack2 = new Stack<> ();

        while (head1!=null){
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2!= null){
            stack2.push(head2);
            head2 = head2.next;
        }

        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            listNode node1 = stack1.pop();
            listNode node2 = stack2.pop();
            if (node1.equals(node2))
                publicNode = node1;
            else break;
        }
        return publicNode;
    }

    //有问题，故意留着纠错！！！！！下次不要在犯错！！！！
    public listNode findPublicNode2(listNode head1,listNode head2){
        if (head2 == null||head1==null) return null;

        listNode publicNode = null;
        int list1Length = 0;
        int list2Length = 0;

        while (head1!=null){
            list1Length++;
            head1 = head1.next;
        }
        while (head2!=null){
            list2Length++;
            head2 = head2.next;
        }

        if (list1Length>list2Length){
            for (int i = 0; i <list1Length-list2Length;i++){
                head1 = head1.next;
            }
            while (head1!=null&&head2!=null){
                if (head1.equals(head2)) {
                    publicNode = head1;
                    break;
                }else {
                    head1 = head1.next;
                    head2 = head2.next;
                }
            }
        }else {
            for (int i = 0; i < list2Length-list1Length;i++){
                head2 = head2.next;
            }
            while (head1!=null&&head2!=null){
                if (head1.equals(head2)) {
                    publicNode = head1;
                    break;
                }else {
                    head1 = head1.next;
                    head2 = head2.next;
                }
            }
        }

        return publicNode;
    }


}
