package com.syn.builtinfunctions.predicate;

import java.util.function.Predicate;

public class CheckForNull implements Predicate {

    @Override
    public boolean test(Object o) {
        return o != null;
    }
}
