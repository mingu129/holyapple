package dataStructure.LinkedList; 


import java.util.ArrayList;
import java.util.Iterator;


public class LinkedList {
	private Node head;

	public LinkedList(){
		head = null;
	}
	public boolean isEmpty(){
		return head == null;
	}
	public Node get(int index) {
	    Node node = head;
	    for (int i = 0; i < index; i++)
	        node = node.next;
	    return node;
	}
	public void addFirst(int value){
		Node link = new Node(value);
		link.next = head;		//	���� �߰��ϴ� ����� next�� �� ���� ����
		head = link;				//	���� �߰��ϴ� ��带 first�� ����
	}
	public void addLast(int value){
		Node link = new Node(value);

		//	���������� ������ ����
		Node tmpLink = head;
		Node lastLink = null;
		while(tmpLink != null) {
			lastLink = tmpLink;
			tmpLink = tmpLink.next;
		}
		if(lastLink == null) head = link;
		else lastLink.next = link;				//	���� �߰��ϴ� ��带 first�� ����
	}
	public void add(int index, int value){
		// index�� 0�̸� ù��° ��忡 �߰�
		if(index == 0){
			addFirst(value);
		} else {
			Node previosNode = get(index-1);	//	�߰��� �ε��� �� ���(�������)
			Node nextNode = previosNode.next;	//	��������� ��ũ ���� ���ο� ����� ��ũ�� �Ǿ�� ��
			Node newNode = new Node(value);
			previosNode.next = newNode;		//	��������� ��ũ ���� ���ο� ���
			newNode.next = nextNode;		//	���ο� ����� ��ũ�� ������尡 �����״� ���
		}
	}
	public int size(){
		int count = 0;
		while(!isEmpty()) {
			deleteFirst();
			count++;
		}
		return count;
	}
	public Iterator<Integer> listIterator(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!isEmpty()) {
			Node delLink = deleteFirst();
			list.add(delLink.data);
		}
		return list.iterator();
	}
	public Node deleteFirst(){
		Node link = head;	//	���� ���� first���� ���� ����
		if(head == null){
			return null;
		}
		head = head.next;
		return link;
	}
	public Object delete(int index){
	    if(index == 0)
	        return deleteFirst();
	    Node previosNode = get(index-1);				//	������ �ε��� �� ���(�������)
	    Node deleteNode = previosNode.next;				//	��������� ��ũ ���� ������ ���, ���� �����ϸ� ��带 ������ �� ����. 
	    previosNode.next = deleteNode.next;				//	������ ����� ��ũ��尡 ��������� ��ũ��尡 �Ǿ�� ������ ������ ������ ��������.
	    Object returnValue = deleteNode.data; 			//	������ ����� ���� �����ϱ� ���� ����
	    return returnValue;
	}
	public void print() {
		Node link = head;
		while(link != null) {
			link.print();
			link = link.next;
		}
		System.out.println();
	}
}