
object HelloScala {
  def sayHello(name: String): Unit = {
    println(s"Hi ${name},Hello Scala,I am in Java Code.")
  }

  case class User(name: String, age: Int = 20)

  def testMe(test:String):String = {
    test + " Test Me"
  }

  def main(args: Array[String]): Unit = {
    val rao = User("rao")
    val Clark = User("Clark", 23)
    val ck = User("ck", 19)

    println("----------------------------")

    val users = List(rao, Clark, ck)

    users.filter(u => u.age >= 20).sortBy(u => (u.name, u.age)).foreach(u => println(u))

    val User(ckName, ckAge) = ck
    println(ckName, ckAge)

    ck match {
      case User(name,_) if name.equals("Clark") => println(s"Clark match")
      case other => println(s"${other.name} match")
    }

    for (i <- 0 to 10) {
      println(i)
    }
  }
}
