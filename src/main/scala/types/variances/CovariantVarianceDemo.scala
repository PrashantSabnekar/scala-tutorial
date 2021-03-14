package types.variances

abstract class Shape {
  def draw: Unit
}

class Square extends Shape{
  override def draw: Unit = {
    println("draw square")
  }
}

class Triangle extends Shape {
  override def draw: Unit = {
    println("draw Triangle")
  }
}

class Circle extends Shape {
  override def draw: Unit = {
    println("draw Circle")
  }
}

//covariant
//abstract class Painter[+A]{
//  def paint(): Unit
//}

//invariant
//abstract class Painter[A]{
//    def paint(): Unit
//}

//contravariant
abstract class Painter[-A]{
  def paint(): Unit
}


class ShapePainter extends Painter[Shape]{
  override def paint(): Unit = {
    println("Shape painter")
  }
}

class SquarePainter extends Painter[Square] {
  override def paint(): Unit = {
    println("Square painter")
  }
}

class TrianglePainter extends Painter[Triangle] {
  override def paint(): Unit = {
    println("Triangle Painter")
  }
}

class CirclePainter extends Painter[Square]{
  override def paint(): Unit = {
    println("Circle painter")
  }
}

object CovariantVarianceDemo extends App{

  def paintingDemoA(a: Painter[Shape]): Unit = {
    a.paint()
  }

  def paintingDemoB(b: Painter[Square]) ={
    b.paint()
  }

  def demo(): Unit ={
    val shapePainter = new ShapePainter
    val squarePainter = new SquarePainter
    paintingDemoA(shapePainter)
    //paintingDemoA(squarePainter)
    paintingDemoB(squarePainter)
    paintingDemoB(shapePainter)

  }

  demo()

}
