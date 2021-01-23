package com.kyle9.cs329;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.*;


public class LinkedListTest {
  public static LinkedList list;

  @BeforeEach
  void init() {
    list = new LinkedList();
  } 

  /**
   * This is a Find Test. It looks through an empty Linked List
   * and shows whether the Linked List is empty or if there are
   * any nodes in the Linked List. When the Linked List is empty,
   * it should be null.
   */
  @Test
  @Tag("find")
  @DisplayName("find should return null when list is empty")
  void testFind_ReturnNull_WhenListEmpty() {
    Object o = list.findLastNode();
    assertNull(o);
    boolean b = list.findNode(9);
    assertFalse(b);
    o = list.findNodeAt(99);
    assertNull(o);
  }

  /**
   * This is a Find Test. It looks through a Linked List and
   * finds the object's value that is located at that location
   * while the Linked List is populated. This test uses 2 nodes
   * in the Linked List.
   */
  @Test
  @Tag("find")
  @DisplayName("find should return object in list at location")
  void testFind_ReturnObject_WhenListIsPopulated() {
    list.insertNode(22);
    list.insertNode(1);

    Object o = list.findNodeAt(1);
    assumeTrue(o != null);
    int i = (int)o;

    assertEquals(1, i);
  }

  /**
   * This is a Find Test. It returns the object at a
   * location in the Linked List and makes sure that that
   * object is not null.
   */
  @Test
  @Tag("find")
  @DisplayName("find should return object in list at location")
  void testFind_ReturnNull_WhenListIsPopulated() {
    list.insertNode(556);
    list.insertNode(44);

    Object o = list.findNodeAt(4);
    assertNull(o);
  }

  /**
   * This is a Disabled Test. It should not run becuase
   * it is disabled.
   */
  @Test
  @Disabled
  @DisplayName("A disabled test")
  void testNotRun() {
    System.out.println("This test will not run.");
  }

  /**
   * This is a Nested Test. It tests the Remove Method in
   * multiple ways. Before each test, it inserts a list of
   * objects in the Linked List and then removes specific
   * nodes that are given.
   */
  @Nested
  @DisplayName("Testing functionality of removing nodes")
  class removeNodesTest {
    private LinkedList list;

    @BeforeEach
    void init() {
      list = new LinkedList();
      list.insertNode(12);
      list.insertNode(33);
      list.insertNode(2);
      list.insertNode(3);
      list.insertNode(4);
      list.insertNode(9);
    }

    /**
     * This is a Remove Test. It first assumes that the Linked
     * List is not null. It then asserts two true statements to
     * ensure that the remove methods function and return true
     * after completeing their operation. 
     */
    @Test
    @Tag("remove")
    @DisplayName("remove 2 nodes from linked list should return true")
    void testRemoveTwoNodes_ReturnTrue_WhenNodesAreInList() {
      assumeTrue(list != null);  

      assertAll(
        () -> {
          boolean b = list.deleteFirstNode();
          assertTrue(b);
        },
        () -> {
          assumeTrue(list.getListSize() == 5);
          boolean b = list.deleteNthNode(4);
          assertTrue(b);
        }
      );
    }

  }

  /**
   * This is a Size Test. It first assumes that the Linked
   * List is empty. If the Linked List is empty, then the
   * test inserts objects into the Linked List and checks its
   * size, then removes an object and checks its size again.
   */
  @Test
  @Tag("size")
  @DisplayName("testing size should be accurate while list changes size")
  void testSize_ShouldReturnCorrectSize_WhenListChangesSize() {
    assumingThat(list.getListSize() == 0, 
      () -> {
        list.insertNode(12);
        list.insertNode(33);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(9);

        assertEquals(6, list.getListSize());

        list.deleteLastNode();
        assertEquals(5, list.getListSize());
      }
    );
  }

  @AfterAll
  public static void done() {
    System.out.println("\n\n...Your testing is complete!\n");
  }



}