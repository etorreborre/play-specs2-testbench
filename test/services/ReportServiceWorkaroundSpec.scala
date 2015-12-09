package services

import org.specs2.mutable.Specification

/**
 * Workaround, using the Guice injector
 */
class ReportServiceWorkaroundSpec extends Specification with Inject {

  lazy val service = inject[ReportService]

  "ReportService" should {
    "Work" in {
      service.foobar mustEqual "foobar"
    }
  }

}


import play.api.inject.guice.GuiceApplicationBuilder
import scala.reflect.ClassTag    

trait Inject {
  lazy val injector = (new GuiceApplicationBuilder).injector

  def inject[T : ClassTag]: T = 
    injector.instanceOf[T]
}
