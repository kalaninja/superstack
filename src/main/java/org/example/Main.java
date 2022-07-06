package org.example;

import lombok.val;

public class Main {
    private static final String EMPTY = "EMPTY";

    public static void main(String[] args) {
        run(new String[]{
            "push 4",
            "push 5",
            "inc 2 1",
            "pop",
            "pop"
        });
    }

    static void run(String[] operations) {

        val stack = new SuperStack(operations.length);

        for (val operation : operations) {
            val op = Operation.from(operation);
            switch (op.getType()) {
                case PUSH:
                    stack.push(((Operation.Push) op).getValue());
                    break;
                case POP:
                    stack.pop();
                    break;
                case INC:
                    val inc = (Operation.Inc) op;
                    stack.inc(inc.getItems(), inc.getValue());
                    break;
            }

            System.out.println(stack.isEmpty() ? EMPTY : stack.peek());
        }
    }
}