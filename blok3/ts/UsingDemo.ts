function createLogger(name: string) {
    return {
        log(message: string) {
            console.log(`[${name}] ${message}`);
        },
        // [Symbol.dispose]() {
        //     console.log(`${name} disposed`);
        // },
    };
}


function demo() {
    using logger = createLogger('demo');
    logger.log('Hello world');
}



demo();
