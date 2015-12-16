package services

import org.specs2.mutable.Specification

/**
 * Specification using the Guice injector
 */
class ReportServiceSpec extends Specification with Inject {

  lazy val service = inject[ReportService]

  "ReportService" should {
    "Work" in {
      service.foobar mustEqual "testbar"
    }
  }

}


import play.api.inject.guice._
import scala.reflect.ClassTag

trait Inject {
  lazy val builder =
    new GuiceApplicationBuilder

  lazy val injector = builder.load(testModule).injector

  lazy val testModule: GuiceableModule =
    new TestModule

  def inject[T : ClassTag]: T =
    injector.instanceOf[T]
}

import com.google.inject.AbstractModule

class TestModule extends AbstractModule {
  def configure() = {

    bind(classOf[UserService])
      .to(classOf[TestUserService])

  }
}

class TestUserService extends UserService {
  def foo = "test"
}
