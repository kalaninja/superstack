package org.example;

import com.google.common.base.Preconditions;
import lombok.Getter;

public class SuperStack {
    private final int[] buffer;

    @Getter
    private int size = 0;

    public SuperStack(int maxSize) {
        buffer = new int[maxSize];
    }

    public void push(int value) {
        buffer[size++] = value;
    }

    public int pop() {
        Preconditions.checkState(size > 0);

        return buffer[--size];
    }

    public void inc(int n, int value) {
        for (int i = 0; i < n; i++) {
            buffer[i] += value;
        }
    }

    public int peek() {
        Preconditions.checkState(size > 0);

        return buffer[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
