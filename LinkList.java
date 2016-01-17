public class LinkList{
	private Node head=null;
	private int length=0;

	private void insert_at_beginning(int val){
		Node n=new Node(val,head);
		head=n;
		length++;
	}

	private Node insert_at_end(int val,Node h){
		if(h!=null){
			Node next_node=h.getnextnode();
			Node q= insert_at_end(val,next_node);
			if (q==null){
				Node n=new Node(val,null);
				h.next_pointer=n;
				return h;
			}
			else 
				return h;
		}
		
		return null;
		

	}
	private void insert_at_end_nonrecursive(int val){
		Node p,q;
		p=head;
		q=head;
		while(p!=null){
			p=p.getnextnode();
			if(p!=null){
				q=p;
			}
		}
		Node n=new Node(val,null);
		q.next_pointer=n;

	}
	public void enqueue(int val){
		if(head==null){
			Node n=new Node(val,head);
			head=n;
			
		}
		else{
			//Node n=insert_at_end(val,head);
			insert_at_end_nonrecursive(val);
		}
		length++;
	}
	public void push(int val){
		insert_at_beginning(val);
	}

	public  int remove_from_front(){
		int value=head.val;
		head=head.next_pointer;
		return value;

	}

	public int pop(){
		int value=-10000;
		if (head!=null){
			value=remove_from_front();
		}
		return value;
	}

	public static void main(String[] args) {
		LinkList l=new LinkList();
//		l.push(5);	
//		l.push(10);	
		l.enqueue(5);
		l.enqueue(10);

		System.out.println(l.pop());
		System.out.println(l.pop());
	}

}

class Node{
	int val;
	Node next_pointer=null;

	public Node(int val, Node head){
		this.val=val;
		next_pointer=head;
	}
	public Node getnextnode(){
			return this.next_pointer;
	}
}


