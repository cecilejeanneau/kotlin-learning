package fr.eni.ecole.mod1demo2poo

class Base {
//    useless but can exists
}

// by default it's final so no heritable and need to be opened to be heritable
open class Apero(
//    this is a default constructor
   private var _name: String, //attribut d'instance not parameter
   var degree: Int
//    so, public by default
) {

    //    var name : String;
//
//    constructor(name : String) {
//        this.name = name;
//    }


//    getter setter
    var name: String
        get() = this._name;
        set(value) {
            this._name = value;
        }

//    methods
    override fun toString(): String {
        return "Apero(name='$name', degree=$degree)";
    }

    open fun getCheers(cheers : String): String {
        return cheers;
    }
}

//in interface everything is open
interface Samu {
//    abstract method
    fun callPhone(): Int;
//    concrete method
    fun getSiren(): String {
        return "TululuTululu";
    }
}

//dataclass for a BO class

// extends Apero
// hover implement members to get declarations of interface methods
class HangOver(var headacheLvl: Int) : Apero("Happy hour", 35), Samu {
    override fun getCheers(cheers: String): String{
        return cheers + "to consume with prevention";
    }

    override fun callPhone(): Int {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return super.toString() + ", potential headache = ${this.headacheLvl}";
    }
//    polymorphism and object flexibility, take the more precise and define method so it will be this one witch will be called

//    static, no static word
    companion object{
        var glass = "verre à pied";
    }
}

//commun à toute instance = static

////singleton
//object HangOver : Apero("Happy hour", 35) {
//    override fun getCheers(cheers: String): String{
//        return cheers + "to consume with prevention";
//    }
//
//    override fun toString(): String {
//        return super.toString() + ", potential headache = ${this.headacheLvl}";
//    }
////    polymorphism and object flexibility, take the more precise and define method so it will be this one witch will be called
//}

fun main(){
//    no need new -> new Apero()
    var mojito = Apero("Mojito", 20);
    println(mojito.getCheers("momojito!"));
    println(mojito.getCheers(mojito.name));

    var ho = HangOver(8);
    println(ho);
//    println(ho.glass); don't work
    println(HangOver.glass);
}