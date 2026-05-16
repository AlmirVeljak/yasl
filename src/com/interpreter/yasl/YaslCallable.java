package com.interpreter.yasl;

import java.util.List;

interface YaslCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}
