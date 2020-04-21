/**
 * @Classname linkListProblem
 * @Description TODO
 * @Author Minghui Sun,
 * @Version 1.0
 */
public class linkListProblem {
    static class Node {
        int data;
        Node nodeNext;
        public Node(int data){
            this.data = data;
        }
    }

    linkListProblem(){}

    public Node findLastKth(Node head, int k){
        if (k<1) return null;
        if (head == null) return null;
        Node kth =head; int count = 0;
        while (head.nodeNext!=null){
            head = head.nodeNext;
            count++;
            if (count > k-1){
                kth = kth.nodeNext;
            }
        }
        if (count< k-1) return null;
        return kth;
    }

    public Node FindLoopEntrance(Node head){
        if (head == null) return null;
        boolean isLoop = false;
        Node quick = head; Node slow = head;
        while (slow.nodeNext!=null && quick.nodeNext!= null){
            slow = slow.nodeNext;
            quick = quick.nodeNext;
            if (quick.nodeNext!= null) quick = quick.nodeNext;
            if (slow == quick){
                isLoop = true;
                break;
            }
        }
        if (!isLoop) return null;
        int count = 0;
        while (true){
            slow = slow.nodeNext;
            count++;
            if (slow ==quick) break;
        }
        slow = quick = head;
        while (count > 0){
            quick = quick.nodeNext;
            count--;
        }
        while (slow!=quick){
            slow = slow.nodeNext;
            quick = quick.nodeNext;
        }
        return slow;
    }

    public void reverseList(Node head){
        Node next = head.nodeNext;
        if (next!=null){
            reverseList(next);
            next.nodeNext = head;
            head.nodeNext = null;
        }
    }

    public Node merge2list(Node head1, Node head2){
        if (head1 == null)return head2;
        if (head2 == null) return head1;
        int data1 = head1.data;
        int data2 = head2.data;
       Node newHead;
       if (data1<= data2){
           newHead =head1;
           head1 = head1.nodeNext;
       }else{
           newHead = head2;
           head2 = head2.nodeNext;
       }
       Node node = newHead;
       while (head1!= null && head2!=null){
           if (head1.data<=head2.data){
               node.nodeNext = head1;
               head1 = head1.nodeNext;
               node = node.nodeNext;
           }else {
               node.nodeNext = head2;
               head2 = head2.nodeNext;
               node = node.nodeNext;
           }
       }
       if(head1 != null){
           node.nodeNext = head1;
       }
       if (head2 != null){
           node.nodeNext = head2;
       }
       return newHead;
    }


    public static void main(String[] args) {
        linkListProblem linkListProblem = new linkListProblem();
        Node[] list = new Node[5];
        for (int i = 0; i < 5; i++) {
            list[i] = new Node(0);
        }
        for(int i = 0; i < 4; i++){
            list[i].data = 2*i+1;
            list[i].nodeNext = list[i+1];
        }
        list[4].data = 9;
        Node[] list2 = new Node[5];
        for (int i = 0; i < 5; i++) {
            list2[i] = new Node(0);
        }
        for(int i = 0; i < 4; i++){
            list2[i].data = 2*i;
            list2[i].nodeNext = list2[i+1];
        }
        list2[4].data = 8;

        //list[9].nodeNext = list[0];
        //Node k = linkListProblem.findLastKth(list[0],10);
        //Node entrance = linkListProblem.FindLoopEntrance(list[7]);
        //linkListProblem.reverseList(list[0]);
        Node newStart = linkListProblem.merge2list(list[0], list2[0]);
        System.out.println("Finish!!!");
    }


}
