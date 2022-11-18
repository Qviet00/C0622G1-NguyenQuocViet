// happy coding 👻
console.log("hello world");
function totalFibonacci(count: number) {
    let num1 = 0;
    let num2 = 1;
    let total;
    let fibonacci :Array<number> = [];
    for(let i = 0; i < count; i++){
        fibonacci.push(num1);
        total = num1 + num2;
        num1 = num2;
        num2 = total;
    }
    console.log('fibonacci: '+ fibonacci );
    console.log('total: ' + total);
    return total;
}
totalFibonacci(5);