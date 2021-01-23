package com.kyle9.cs329;

/**
 * LinkedList.java.
 * 
 **/
public class LinkedList {
  private int size;
  private Node head;

  public LinkedList() {
    this.size = 0;
    this.head = null;
  }

  /**
   * Inserting new node at the end of the linked list.
   * 
   * @param item - represent the node item to be added to the linked list.
   */
  public void insertNode(int item) {
    Node node = new Node();
    node.item = item;
    Node current = this.head;

    if (this.head == null) {
      this.head = node;
      this.head.next = null;
      this.size = 1;
    } else {

      while (current.next != null) {
        current = current.next;
      }
      current.next = node;
      node.next = null;
      this.size += 1;
    }
  }
  
  /**
   * Adding node at the first location of the linked list.
   * 
   * @param item - represent item of the node to be added to LL.
   */
  public void insertFirst(int item) {
    Node node = new Node();
    node.item = item;
    node.next = this.head;
    this.head = node;
    this.size++;
  }
  
  /**
   * Adding node at the nth location of the linked list.
   * 
   * @param item - represent the item of the node to be added to the list.
   * @param position - position at which the node is to be added.
   */
  public boolean insertNth(int item, int position) {
    Node node = new Node();
    node.item = item;
    Node current = this.head;
    if (this.head != null && position <= this.size) {
      for (int i = 1; i < position; i++) {
        current = current.next;
      }
      node.next = current.next;
      current.next = node;
      this.size += 1;
      return true;
    }
    
    return false;
    
  }

  /**
   * Deleting the first node from the list.
   */
  public boolean deleteFirstNode() {
    if (head != null) {
      this.head = this.head.next;
      this.size--;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Deleting the last node from the list.
   */
  public void deleteLastNode() {
    Node currentNode = this.head;
    if (size == 1) {
      head = null;
      size = 0;
    } else {
      Node prevNode = null;
      while (currentNode.next != null) {
        prevNode = currentNode;
        currentNode = currentNode.next;
      }
      prevNode.next = null;
      this.size--;
    }
  }

  /**
   * Deleting the node from the nth location in the list.
   * 
   * @param position - location of the node to be deleted.
   */
  public boolean deleteNthNode(int position) {
    if (position <= this.size && this.head != null) {
      Node currentNode = this.head;
      Node prevNode = null;
      for (int i = 0; i < position; i++) {
        prevNode = currentNode;
        currentNode = currentNode.next;
      }
      prevNode.next = currentNode.next;
      this.size--;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Find if the node exist in the list.
   * 
   * @param item - item to be found in the list.
   * 
   */
  public boolean findNode(int item) {
    Node node = this.head;
    for (int i = 0; i < size; i++) {
      if (node.item == (item)) {
        return true;
      }
      node = node.next;
    }

    return false;
  }

  /**
   * Find the node item located at a specific location.
   * 
   * @param location - Find item at location.
   * 
   */
  public Object findNodeAt(int location) {
    Node node = this.head;
    if (head != null && location <= size) {
      for (int i = 0; i < location; i++) {
        node = node.next;
      }
      return (node.item);
    } else {
      return null;
    }
  }

  /**
   * Find the item at the last location.
   * 
   */
  public Object findLastNode() {
    Node node = this.head;
    if (head != null) {
      for (int i = 0; i < size - 1; i++) {
        node = node.next;
      }
      return (node.item);
    } else {
      return null;
    }
  }


  /**
   * Printing all the items in the list.
   */
  public String printNodes() {
    String retStr = "";
    if (this.size < 1) {
      return ("There are no nodes in the linked list");
    } else {
      Node current = this.head;
      for (int i = 0; i < this.size; i++) {
        retStr += ("Node " + current.item + " is at location " + i);
        current = current.next;
      }
      return retStr;
    }
  }
  
  /**
   * Obtain the current size of the list.
   * @return
   */
  public int getListSize() {
    return size;
  }

}
  
