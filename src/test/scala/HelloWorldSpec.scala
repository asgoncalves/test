import org.scalatest.{Matchers, FlatSpec}
import org.scalamock.scalatest.MockFactory

import scala.concurrent.Future
import org.scalatest.concurrent.ScalaFutures

class HelloWorldSpec extends FlatSpec with Matchers with MockFactory with ScalaFutures {

  "HelloWorld mock" should "greet me when asked to greet Boris" in {
    val mockedHelloWorldImpl = mock[HelloWorldImplementation]
    (mockedHelloWorldImpl.greetBoris _).expects().returning(Future.successful("Hello Sergio!"))

    val runner = new HelloWorldRunner(mockedHelloWorldImpl)
    runner.doItForBoris().futureValue shouldBe "Hello Sergio!"
  }

  "HelloWorld mock" should "greet Boris and I in the future" in {
    val mockedHelloWorldImpl = mock[HelloWorldImplementation]
    (mockedHelloWorldImpl.greetBoris _).expects().returning(Future.successful("Hello Sergio!"))
    (mockedHelloWorldImpl.greetSergio _).expects().returning(Future.successful("Hello Boris!"))

    val runner = new HelloWorldRunner(mockedHelloWorldImpl)
    runner.doItForBorisAndSergio().futureValue shouldBe "Hello Sergio and Boris!"
  }



}
