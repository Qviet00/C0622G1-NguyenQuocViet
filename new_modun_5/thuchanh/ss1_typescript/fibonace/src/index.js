// happy coding 👻
console.log("hello world");
function totalFibonacci(count) {
    var num1 = 0;
    var num2 = 1;
    var total;
    var fibonacci = [];
    for (var i = 0; i < count; i++) {
        fibonacci.push(num1);
        total = num1 + num2;
        num1 = num2;
        num2 = total;
    }
    console.log('fibonacci: ' + fibonacci);
    console.log('total: ' + total);
    return total;
}
totalFibonacci(5);
