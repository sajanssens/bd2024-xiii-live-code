class HelloWorld {
    static sayHello(name: String = "world") {
        console.log(`Hello ${name}`);
    }
}

HelloWorld.sayHello("Bram");
HelloWorld.sayHello();
