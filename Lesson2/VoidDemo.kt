package lesson2

/* The Unit type in Kotlin fulfills the same function as void in Java. It can be used as a
return type of a function that has nothing interesting to return:*/
fun main(){
    f()
    f1()
}
fun f(): Unit {
    println("Nothing return can use Unit similar like Void")
}
// If there is no return type mentioned work as void
fun f1() {
    println("No return type similar like Void")
}