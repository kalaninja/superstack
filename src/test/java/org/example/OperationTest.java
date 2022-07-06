package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.val;
import org.junit.jupiter.api.Test;

class OperationTest {

    @Test
    void fromPush() {
        val result = Operation.from("push -1");

        assertTrue(result instanceof Operation.Push);
        assertEquals(-1, ((Operation.Push) result).getValue());
    }

    @Test
    void fromPop() {
        val result = Operation.from("pop");

        assertTrue(result instanceof Operation.Pop);
    }

    @Test
    void fromInc() {
        val result = Operation.from("inc 2 3");

        assertTrue(result instanceof Operation.Inc);
        assertEquals(2, ((Operation.Inc) result).getItems());
        assertEquals(3, ((Operation.Inc) result).getValue());
    }

    @Test
    void fromUnknown() {
        assertThrows(IllegalArgumentException.class, () -> Operation.from("unknown"));
    }
}