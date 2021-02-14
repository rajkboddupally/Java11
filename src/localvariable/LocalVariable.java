package localvariable;

import org.jetbrains.annotations.NotNull;

public class LocalVariable {
    public static void main(String[] args) {
        Hello h = (@NotNull var v1, var v2) -> {
            System.out.println(v1 + v2);
        };
        h.add(null, "Kumar");
        System.out.println();
    }
}

interface Hello {
    void add(String a, String b);
}
