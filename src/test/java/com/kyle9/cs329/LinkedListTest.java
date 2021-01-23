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

  @Test
  @Tag("find")
  @DisplayName("find should return object in list at location")
  void testFind_ReturnNull_WhenListIsPopulated() {
    list.insertNode(556);
    list.insertNode(44);

    Object o = list.findNodeAt(4);
    assertNull(o);
  }

  @Test
  @Disabled
  @DisplayName("A disabled test")
  void testNotRun() {
    System.out.println("This test will not run.");
  }

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

    @Test
    @Tag("remove")
    @DisplayName("remove 2 nodes from linked list should return true")
    void testRemoveTwoNodes() {
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