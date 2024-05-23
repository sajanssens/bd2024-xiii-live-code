let x = 2;

function add(x, y) {
    return x + y;
}

let sum1 = add(x, 42);
let sum2 = add("23", "2")
let sum3 = add(23, '2')
let sum4 = add("23", 2)
let sum5 = add(false, true)

console.log(sum1);
console.log(sum2);
console.log(sum3);
console.log(sum4);
console.log(sum5);
