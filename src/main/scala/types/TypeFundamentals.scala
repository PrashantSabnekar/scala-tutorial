package types

class Demo{
  def greet()={
    println("Hello types")
  }
}
case class Car(company: String, brand: String)


object TypeFundamentals extends App {

  types1


  def types1: Unit ={
    val c = new Demo
    println(s"getClass: $c.getClass")
    println(s"classOf[Demo]: ${classOf[Demo]}")
    println(s"getClass.getMethods: ${c.getClass.getMethods}")
    println(s"superclass of Demo ${c.getClass.getSuperclass}")
    println(s"Type parameters of Demo ${c.getClass.getTypeParameters.foreach(t => println(t.getName)) }, ")
    println("All methods of class Demo")
    c.getClass.getMethods.foreach(m => print(s"${m.getName}, "))
    println("\nAll interfaces of class Demo")
    c.getClass.getInterfaces.foreach(i => print(s"${i.getName} "))

  }

}
