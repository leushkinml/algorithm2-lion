package com.skypro.algorithm2lion.homework;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private final Integer[] IntegerSet;

    private int size;

    public IntegerListImpl() {
        IntegerSet = new Integer[10];
    }

    public IntegerListImpl(int initialSize) {
        IntegerSet = new Integer[initialSize];
    }

    private void checkInteger(Integer item) throws NullException {
        if (item == null) {
            throw new NullException();
        }
    }

    private void checkSize() throws SetIsFullException {
        if (size == IntegerSet.length) {
            throw new SetIsFullException();
        }
    }

    private void checkIndex(int index) throws WrongIndexException {
        if (index < 0 || index > size) {
            throw new WrongIndexException();
        }
    }

    private void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--; // j-;
            }
            arr[j] = temp;
        }
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public Integer addByItem(Integer item) throws SetIsFullException, NullException {
        checkSize();
        checkInteger(item);
        IntegerSet[size++] = item;
        return null;
    }

    @Override
    public Integer addByIndex(int index, Integer item) throws NullException, WrongIndexException, SetIsFullException {
        checkSize();
        checkInteger(item);
        checkIndex(index);
        if (index == size) {
            IntegerSet[size++] = item;
            return item; // - добавили return, чтобы не писать блок else
        }
        System.arraycopy(IntegerSet, index, IntegerSet,index+1, size-index);
        IntegerSet[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) throws WrongIndexException, NullException {
        checkIndex(index);
        checkInteger(item);
        IntegerSet[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) throws NullException, ItemNotFoundException {
        checkInteger(item);
        int index = indexOf(item);

        if (index == -1) {
            throw new ItemNotFoundException();
        }

        if (index != size) {
            System.arraycopy(IntegerSet, index + 1, IntegerSet, index, size - index);
        }
        size--;
        return item;

        // цикл можно заменить на return remove(index);
    }

    @Override
    public Integer removeByIndex(int index) throws WrongIndexException {

        checkIndex(index);

        Integer item = IntegerSet[index];

        if (index != size) {
            System.arraycopy(IntegerSet, index + 1, IntegerSet, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] integerSetCopy = toArray();
        sort(integerSetCopy);
        return binarySearch(integerSetCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            Integer str = IntegerSet[i];
            if (str.equals(item)) {   //  можно написать if (IntegerSet[i].equals(item))
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            Integer str = IntegerSet[i];
            if (str.equals(item)) {   //  можно написать if (IntegerSet[i].equals(item))
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) throws WrongIndexException {
        checkIndex(index);
        return IntegerSet[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {

        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(IntegerSet, size);
    }

}
