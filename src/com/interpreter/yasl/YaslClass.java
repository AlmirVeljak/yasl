package com.interpreter.yasl;

import java.util.List;
import java.util.Map;

public class YaslClass implements YaslCallable {
    final String name;
    final YaslClass superclass;
    private final Map<String, YaslFunction> methods;

    YaslClass(String name, YaslClass superclass, Map<String, YaslFunction> methods) {
        this.name = name;
        this.superclass = superclass;
        this.methods = methods;
    }

    YaslFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        if (superclass != null) {
            return superclass.findMethod(name);
        }

        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int arity() {
       YaslFunction initializer = findMethod("init");
       if (initializer == null) return 0;
       return initializer.arity();
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        YaslInstance instance = new YaslInstance(this);
        YaslFunction initializer = findMethod("init");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return instance;
    }
}
