// This does not compile because not all code paths return a value:
// function fn(a: string | number): boolean {
//     if (typeof a === "string") {
//         return true;
//     } else if (typeof a === "number") {
//         return false;
//     }
// }

// Solution:
function fn(a: string | number): boolean {
    if (typeof a === "string") {
        return true;
    } else if (typeof a === "number") {
        return false;
    }
    neverOccur();
}

function neverOccur(): never {
    throw new Error("Never!");
}

console.log(fn("test"));
console.log(fn(42));
console.log(fn(42));
