package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.val;
import org.junit.jupiter.api.Test;

class SuperStackTest {

    @Test
    void push() {
        val stack = new SuperStack(1);

        val expected = 10;
        stack.push(expected);

        assertEquals(1, stack.getSize());
        assertEquals(expected, stack.peek());
    }

    @Test
    void pop() {
        val stack = new SuperStack(1);

        val expected = 10;
        stack.push(expected);

        assertEquals(expected, stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    void inc() {
        val stack = new SuperStack(3);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        stack.inc(2, 3);

        assertEquals(7, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(8, stack.pop());
    }

    @Test
    void peek() {
        val stack = new SuperStack(3);
        stack.push(5);

        assertEquals(5, stack.peek());
    }

    @Test
    void isEmpty() {
        val stack = new SuperStack(0);

        assertTrue(stack.isEmpty());
    }

    @Test
    void getSize() {
        val stack = new SuperStack(6);

        stack.push(5);
        stack.push(5);
        stack.push(5);

        assertEquals(3, stack.getSize());
    }
}