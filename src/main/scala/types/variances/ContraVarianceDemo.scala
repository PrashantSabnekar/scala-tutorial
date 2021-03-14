package types.variances

object ContraVarianceDemo extends App{

  abstract class Printer[-A] {
    def print(value: A): Unit
  }

  class AnimalPrinter extends Printer[Animal] {
    override def print(animal: Animal): Unit = {
      println("The animals name is: " + animal.name)
    }
  }

  class CatPrinter extends Printer[Cat] {
    override def print(cat: Cat): Unit = {
      println("Cats name is: " + cat.name)
    }
  }

  def printCat(printer: Printer[Cat], cat: Cat): Unit ={
    printer.print(cat)
  }

  val animalPrinter = new AnimalPrinter
  val catPrinter = new CatPrinter

  printCat(catPrinter, Cat("Pussy"))
  printCat(animalPrinter, Cat("Pussy"))

}
