package org.example;

import lombok.Getter;

public interface Operation {
    OperationType getType();

    static Operation from(String operation) {
        if (operation.startsWith("push")) {
            return new Push(Integer.parseInt(operation.substring(5)));
        }

        if (operation.startsWith("pop")) {
            return new Pop();
        }

        if (operation.startsWith("inc")) {
            String[] splitted = operation.split("\\s+");
            return new Inc(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
        }

        throw new IllegalArgumentException();
    }

    @Getter
    class Push implements Operation {
        private final int value;

        public Push(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public OperationType getType() {
            return OperationType.PUSH;
        }
    }

    class Pop implements Operation {
        @Override
        public OperationType getType() {
            return OperationType.POP;
        }
    }

    @Getter
    class Inc implements Operation {
        private final int items;
        private final int value;

        public Inc(int items, int value) {
            this.items = items;
            this.value = value;
        }

        @Override
        public OperationType getType() {
            return OperationType.INC;
        }
    }
}
