import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

class HelloWorldRunner(implementation: HelloWorldImplementation) {

  def doItForSomeone(): Future[String] = implementation.greetSomeOne("Someone")
  def doItForSergio(): Future[String] = implementation.greetSergio()
  def doItForBoris(): Future[String] = implementation.greetBoris()
  def doItForBorisAndSergio(): Future[String] = {
    implementation.greetBoris() map(println)
    implementation.greetSergio() map(println)
    Future("Hello Sergio and Boris!")
  }

}
