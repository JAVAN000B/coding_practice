import java.util.HashMap;

/**
 * @Classname CopyComplexList
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class CopyComplexList {
    static class linkNode {
        int data;
        linkNode next;
        linkNode sibling;
        linkNode(int data){
            this.data = data;
        }
    }

    public linkNode copy(linkNode head){
        if (head == null) return null;
        HashMap<linkNode,linkNode> map = new HashMap();
        linkNode newhead = new linkNode(head.data);
        map.put(head,newhead);
        linkNode Head = head;
        while (Head.next!=null){
            newhead.next = new linkNode(Head.next.data);
            map.put(Head.next,newhead.next);
            Head = Head.next;
            newhead = newhead.next;
        }
        Head = head;
        linkNode Newhead = map.get(head);
        while (Head!= null) {
            Newhead.sibling = map.get(Head.sibling);
            Head = Head.next;
            Newhead = Newhead.next;
        }
        return map.get(head);
    }

    public linkNode copyWithoutHashMap(linkNode head){
        linkNode Head = head;
        while (Head!=null){
            linkNode newNode = new linkNode(Head.data);
            linkNode originNext = Head.next;
            Head.next = newNode;
            newNode.next = originNext;
            Head= Head.next.next;
        }
        Head = head;
        linkNode newhead = Head.next;
        while (Head!=null){
            linkNode copyNode = Head.next;
            linkNode originNext = Head.next.next;
            linkNode originSibling = Head.sibling.next;
            copyNode.next= originNext.next;
            copyNode.sibling = originSibling.next;
            Head.next = originNext;
            Head = Head.next;
        }
        return newhead;
    }

    public static void main(String[] args) {
        CopyComplexList machine = new CopyComplexList();
        linkNode[] list = new linkNode[5];
        for (int i = 0; i < list.length; i++) {
            list[i] = new linkNode(i);
        }
        for (int i = 0; i < 4; i++) {
            list[i].next = list[i+1];
            list[i].sibling = list[i+1];
        }
        list[4].sibling = list[0];
        linkNode copy =  machine.copy(list[0]);
        System.out.println("finish!!");
    }
}
