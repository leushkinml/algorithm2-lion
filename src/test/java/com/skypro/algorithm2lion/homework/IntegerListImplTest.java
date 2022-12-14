package com.skypro.algorithm2lion.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private IntegerListImpl expected;
    //private Integer[] array;
    Integer integer1 = 101;
    Integer integer2 = 102;
    Integer integer3 = 103;
    Integer integer4 = 104;


    @BeforeEach
    public void setUp() throws SetIsFullException, NullException {
        expected = new IntegerListImpl(10);
        expected.addByItem(integer1);
        expected.addByItem(integer2);
        expected.addByItem(integer3);
        expected.addByItem(integer4);

//        array = new Integer[10];
//        array[0] = 101;
//        array[1] = 102;
//        array[2] = 103;
//        array[3] = 104;
    }

    @Test
        // addByItem
    void testAddItem() {
        var array = List.of(101,102,103,104).toArray();
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test // addByIndex
    void testAddItemByIndex() throws WrongIndexException, NullException {
        var array = List.of(101,111, 102,103,104).toArray();
        expected.addByIndex(1, 111);
        array[1] = 111;
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test   //  set
    void testSet() throws WrongIndexException, NullException {
        var array = List.of(101,111,103,104).toArray();
        expected.set(1, 111);
        array[1] = 111;
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test   // remove
    void testRemove() throws NullException, ItemNotFoundException {
        var array = List.of(101,103,104).toArray();
        expected.remove(102);
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test    // removeByIndex
    void testRemoveByIndex() throws WrongIndexException {
        var array = List.of(101,103,104).toArray();
        expected.removeByIndex(1);
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test
    void contains() {
        Assertions.assertTrue(expected.contains(102));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals((expected.indexOf(102)), 1);
    }

    @Test
    void lastIndexOf() {
        Assertions.assertEquals((expected.indexOf(102)), 1);
    }

    @Test
    void get() throws WrongIndexException {
        Integer getTest = expected.get(1);
        Integer actual = 102;
        Assertions.assertEquals(getTest, actual);
    }

    @Test
    void testEquals() throws SetIsFullException, NullException {
        IntegerListImpl actual = new IntegerListImpl(10);
        actual.addByItem(integer1);
        actual.addByItem(integer2);
        actual.addByItem(integer3);
        actual.addByItem(integer4);;
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    void size() {
        int sizeExpected = expected.size();
        int sizeActual = 4;
        Assertions.assertEquals(sizeExpected, sizeActual);
    }

    @Test
    void isEmpty() {
        IntegerListImpl isEmpty = new IntegerListImpl(10);
        int sizeExpected = isEmpty.size();
        int sizeActual = 0;
        Assertions.assertEquals(sizeExpected, sizeActual);
    }

    @Test
    void clear() {
        expected.clear();
        int sizeExpected = expected.size();
        int sizeActual = 0;
        Assertions.assertEquals(sizeExpected, sizeActual);
    }

    @Test // toArray
    void testToArray() {
        var array = List.of(101,102,103,104).toArray();
        Integer[] expectedCopy = expected.toArray();
        Assertions.assertArrayEquals(array, expectedCopy);
    }

    @Test
    public void shouldThrowWhenIndexIsWrong() {
        Assertions.assertThrows(WrongIndexException.class, () -> expected.set(11, 111));
    }

    @Test
    public void shouldThrowWhenItemIsNull() {
        Assertions.assertThrows(NullException.class, () -> expected.addByItem(null));
    }

    @Test
    public void shouldThrowWhenLengthIsFull() throws SetIsFullException, NullException {
        expected.addByItem(105);
        expected.addByItem(106);
        expected.addByItem(107);
        expected.addByItem(108);
        expected.addByItem(109);
        expected.addByItem(110);
        Assertions.assertThrows(SetIsFullException.class, () -> expected.addByItem(111));
    }

}