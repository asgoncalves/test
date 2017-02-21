import scala.concurrent.Future


class HelloWorldImplementation extends HelloWorldTrait {

  override def greetSomeOne(name: String): Future[String] = Future.successful(s"Hello $name!")
  override def greetSergio(): Future[String] = greetSomeOne("Sergio")
  override def greetBoris(): Future[String] = greetSomeOne("Boris")
  override def greetBorisAndSergio(): Future[String] = ???

}
