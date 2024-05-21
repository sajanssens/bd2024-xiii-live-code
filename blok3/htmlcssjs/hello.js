function hello() {
    let x = 10;
    console.log(x); // 10

    x += 15;
    console.log(x); // 25

    if (x > 13) {
        console.log('x is larger than 13');
    }
}

function helloToo(){
    console.log(x);
}

function getBook(){
    let book = {
        title: 'E = mc²',
        author: 'Einstein',
        languages: ['Dutch', 'English'],
        printIsbn() {
            console.log('978-3-16-148410-0');
        }
    };
    return book;
}

function fillBook() {
    let b = getBook();
    let bookP = document.querySelector('#myBook');
    bookP.innerHTML = b.title;
}
