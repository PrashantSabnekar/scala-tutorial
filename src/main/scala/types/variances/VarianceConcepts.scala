package types.variances

abstract class Animal{
  def name: String
}

case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

abstract class Registrar[-A] {
  def register() = {
    println("Registrar")
  }
}

class AnimalRegistrar extends Registrar[Animal] {
  override def register(): Unit = {
    println("Animal Registrar")
  }
}

class CatRegistrar extends Registrar[Cat] {
  override def register(): Unit = {
    println("Cat Registrar")
  }
}

class DogRegistrar extends Registrar[Dog] {
  override def register(): Unit = {
    println("Dog Registrar")
  }
}

object RegistrarOffice {
  def registrarAnimal(g: Registrar[Animal]): Unit = {
    g.register()
  }

  def registerCat(r: Registrar[Cat])= {
    r.register()
  }

  def registerDog(d: Registrar[Dog]): Unit ={
    d.register()
  }
}

object VarianceConcepts extends App {

  def printAnimalNames(animals: List[Animal]) = {
    animals.foreach(a => println(a.name))
  }

  val cats : List[Cat] = List(Cat("Catte"), Cat("cattiji"), Cat("pussy"))
  val dogs = List(Dog("Dobberman"), Dog("Kutta"), Dog("kamina"))

  printAnimalNames(cats)
  printAnimalNames(dogs)

  def registrationHelper(): Unit ={

    val ar = new AnimalRegistrar
    val cr = new CatRegistrar
    val dr = new DogRegistrar

//    RegistrarOffice.registrarAnimal(ar)
//    RegistrarOffice.registrarAnimal(cr)

    RegistrarOffice.registerCat(cr)
    RegistrarOffice.registerCat(ar)

  }

  registrationHelper()


}

/*

Covariant
Contravariant
Invariant

 */