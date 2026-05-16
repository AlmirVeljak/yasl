# YASL — Yet Another Student Language

YASL is a dynamically typed, tree-walk interpreted programming language built in Java as a learning project based on the book [*Crafting Interpreters*](https://craftinginterpreters.com/) by Robert Nystrom. It supports variables, functions, closures, classes, inheritance, and basic file I/O.

---

## Features

- **Dynamic typing** — variables hold any value at runtime
- **First-class functions** — functions are values; closures work as expected
- **Classes and inheritance** — object-oriented programming with `class` and `super`
- **Lexical scoping** — variable resolution is determined at compile time
- **File I/O** — read, write, and append files with built-in native functions
- **User input** — prompt the user from the terminal
- **Arithmetic & logic** — standard operators, `and`/`or`, `!=`, `==`, etc.

---

## Language Tour

### Variables
```
let name = "YASL";
let version = 1;
print name;
```

### Control Flow
```
if (version >= 1) {
    print "Stable!";
} else {
    print "Not yet.";
}

let i = 0;
while (i < 5) {
    print i;
    i = i + 1;
}
```

### Functions
```
fun greet(name) {
    print "Hello, " + name + "!";
}

greet("world");
```

### Closures
```
fun makeCounter() {
    let count = 0;
    fun increment() {
        count = count + 1;
        return count;
    }
    return increment;
}

let counter = makeCounter();
print counter(); // 1
print counter(); // 2
```

### Classes
```
class Animal {
    init(name) {
        this.name = name;
    }

    speak() {
        print this.name + " makes a sound.";
    }
}

class Dog < Animal {
    speak() {
        print this.name + " barks.";
    }
}

let d = Dog("Rex");
d.speak(); // Rex barks.
```

### User Input
```
let name = input("What is your name? ");
print "Hello, " + name + "!";

let age = toNumber(input("Enter your age: "));
if (age >= 18) {
    print "Adult!";
}
```

### File I/O
```
writeFile("notes.txt", "Hello from YASL!\n");
appendFile("notes.txt", "A second line.\n");
var contents = readFile("notes.txt");
print contents;
```

---

## Built-in Functions

| Function | Arguments | Description |
|---|---|---|
| `print` | any | Print a value to stdout |
| `clock()` | none | Current time in seconds since epoch |
| `input(prompt)` | string | Read a line of user input |
| `toNumber(str)` | string | Convert a string to a number |
| `readFile(path)` | string | Read a file and return its contents as a string |
| `writeFile(path, content)` | string, string | Write a string to a file (overwrites) |
| `appendFile(path, content)` | string, string | Append a string to a file |

---

## Example Programs

See the [`data/`](./data) directory for:

- `hello.yasl` — Hello, World!
- `factorial.yasl` — Recursive factorial
- `fibonacci.yasl` — Fibonacci sequence
- `counter.yasl` — Closures demo
- `greet.yasl` — Basic user input
- `notes.yasl` — Simple note-taking app using file I/O

---

## Project Structure

```
src/
└── com/craftinginterpreters/lox/
    ├── Yasl.java          # Entry point
    ├── Scanner.java      # Lexer
    ├── Parser.java       # Parser
    ├── Resolver.java     # Variable resolution
    ├── Interpreter.java  # Tree-walk interpreter
    ├── Expr.java         # Expression AST nodes
    ├── Stmt.java         # Statement AST nodes
    ├── Environment.java  # Variable scoping
    ├── YaslCallable.java  # Callable interface
    ├── YaslFunction.java  # User-defined functions
    ├── YaslClass.java     # Class runtime representation
    └── YaslInstance.java  # Instance runtime representation
```

---

## Acknowledgements

Built by following [*Crafting Interpreters*](https://craftinginterpreters.com/) by Robert Nystrom. Highly recommended for anyone interested in how programming languages work.
