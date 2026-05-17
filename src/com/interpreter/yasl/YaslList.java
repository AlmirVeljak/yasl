package com.interpreter.yasl;

import java.util.ArrayList;
import java.util.List;

public class YaslList {
    final List<Object> elements = new ArrayList<>();

    @Override
    public String toString() {
        return elements.toString();
    }

    public Object getMethod(Token name) {
        switch (name.lexeme) {
            case "length": return new YaslCallable() {
                @Override
                public int arity() {
                    return 0;
                }

                @Override
                public Object call(Interpreter interpreter, List<Object> arguments) {
                    return (double)elements.size();
                }

                @Override
                public String toString() {return "<native function>";}
            };
        }
        throw new RuntimeError(name, "Undefined method '" + name.lexeme + "' on list.");
    }
}
