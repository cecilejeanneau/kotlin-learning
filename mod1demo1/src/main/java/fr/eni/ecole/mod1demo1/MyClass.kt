package fr.eni.ecole.mod1demo1

//fun main() {
//    print("Hello world");
//
//    //variable declaration
//    var name : String = "Michel";
//    var name2 : String? = null;
//
//    //constant
//    val COFFEE : String;
//    COFFEE = "Café ?";
//
//    //COFFEE = "Thé" // impossible
////    ctrl alt L -> indentation auto
//ctrl d copier une ligne
//}

//fun main() {
//    var null1 : String? = null;
//    var null2 = null;
//
//    println(null1?.length ?: "No size");
//    println(null1!!.length);
//    println(null2);
//}

//fun main() {
//    var world = "world";
//    val message by lazy {"Hello $world"};
////    let a predicate initialize our constant callback return auto what's got in it
//    println(message);
////    retrieve value of world and do it just once so the next update not taken
//    world = "man";
//    println(message);
//}

//fun main() {
//    //conditions
//    val AGE = 18;
//    val message = if(AGE >=18){
//        "Majeur";
//    } else {
//        "Mineur";
//    }
//    val message2 = if(AGE >=18) "Majeur" else "Mineur";
//
//    println(message);
//
////    switch
//    when(AGE){
//        0,1,2 -> println("baby");
//        in 1..18 -> println("mineur");
//        is Int -> println("is integer");
//        else -> println("something else");
//    }
//}

//fun main() {
//    //loops
//    val powers = listOf("Fly", "Invisibility", "Pyrokinesis", "Strength");
////    list = object and more methods like push than an array
////    powers.add impossible because it's immutable ! -> mutableListOf
////    loop over elements
//    for(p in powers) {
//        println(p);
//    }
//
//    for(i in 0..<powers.size) {
//        println(powers[i]); //powers.get(i);
//    }
//
////    by default step("pas") is 1
//    for(j in 10 downTo 1){
////    for(j in 10 downTo 1 step 2){
//        println(j);
//    }
//}

fun main() {
    //functions
    val articles = List(30)
//    {id -> turn it into id
    {//this lambda function/predicate, callback, expression, is the second and last parameter of List method
//        it = index
        "Article $it";
    }

//    val colors = mutableListOf("");
    val colors = mutableListOf<String>();
    colors.add("darkblue");
    colors += "sand";
    colors += "sand";

    var nbColor = colors.filter {
//        predicate (take parameter String) -> Boolean(return)
        it == "sand";
    }.count()

    println(nbColor);

//    extensions
    fun String.sayHello(){
        println("Hello $this");
    }
    "Michel".sayHello();
}
