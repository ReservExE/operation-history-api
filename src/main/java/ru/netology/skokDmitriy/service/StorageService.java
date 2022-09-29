package ru.netology.skokDmitriy.service;

import ru.netology.skokDmitriy.domain.Customer;
import ru.netology.skokDmitriy.domain.operation.Operation;

import java.util.Arrays;

public class StorageService<T> {
    private T[] storage;

    public StorageService(int capacity) {
        this.storage = (T[]) new Object[capacity];
    }

    public void setElement(T element, int position){
        storage[position] = element;
    }

    public T getElement(int position){
        return storage[position];
    }

    public int getLength(){
        return storage.length;
    }

    public String toString(){
        return Arrays.toString(storage);
    }

}
