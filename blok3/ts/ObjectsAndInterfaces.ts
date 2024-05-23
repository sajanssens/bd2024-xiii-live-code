class Person {

    // fields and constructor: ---------------
    private _name: String = ""
    private _age: Number = 0

    constructor(n: String, a: Number) {
        this._name = n;
        this._age = a;
    }

    // or shorter:
    // constructor(private _name: String, private _age: Number) {}

    // ------------------------

    // Static properties --------------------
    static origin = new Person("Adam", 42)

    // Methods:
    upperCaseName(): String {
        return this._name.toUpperCase()
    }

    // Getters/setters --------------------
    get name(): String {
        if (this._name.length < 3) {
            throw new Error("kaboutertje")
        }
        return this._name;
    }

    set name(value: String) {
        this._name = value;
    }

    get age(): Number {
        return this._age;
    }

    set age(value: Number) {
        this._age = value;
    }
}

let p: Person = new Person("Bram", 44)
p.name = "BramToo"
p.age = 45
console.log(typeof p);

function printName(p: Human) {
    console.log(p.name)
}

let inputFromBackend = '{"name": "Bram", "age": 44}'
let p2: Human = JSON.parse(inputFromBackend)

interface Human {
    name: String
    age: Number

    // Method shapes
    speak(message: string): string;
}

// Declaration merging:
// You can add fields to an existing interface.
interface Human {
    sabre: boolean
}

console.log(p2.age);
printName(p2)
