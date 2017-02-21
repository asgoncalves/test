import scala.concurrent.Future

trait HelloWorldTrait {

  def greetSomeOne(name: String): Future[String]
  def greetSergio(): Future[String]
  def greetBoris(): Future[String]
  def greetBorisAndSergio(): Future[String]

}
