function printName(firstName: string, lastName?: string, x?: string, y?: string) {
    if (lastName) {
        console.log(`${firstName} ${lastName} ${x}`);
    } else {
        console.log(firstName);
    }
}

printName("", undefined, "")

const oneTwoThree = [1, 2, 3];
const copy = [...oneTwoThree];

const han = {
    firstName: 'Han',
    lastName: 'Han',
    age: 42,
    lightSabre: true,
}

const {firstName: f, lightSabre: ls} = han; // Object destructuring
//
// let firstName1 = han.firstName;
// let lightSabre = han.lightSabre;

console.log(f);
console.log(ls);

let arr;
console.log(arr?.[0] ?? "n/a");

arr = [1, 2, 3]
console.log(arr?.[0] ?? "n/a");

let add = (x: number) => x + x;
let i = add(42);

function add2(x: number) {
    return x + x;
}

function higherOrderFunction(xyz: any){

}

higherOrderFunction(add2);
