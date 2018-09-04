import sbt._

object Dependencies {
  def scalafixVersion: String = sys.env.get("TRAVIS_TAG") match {
    case Some(v) if v.nonEmpty => v.stripPrefix("v")
    case _ => "0.6.0-M18"
  }
  val all = List(
    "org.eclipse.jgit" % "org.eclipse.jgit" % "4.5.4.201711221230-r",
    "ch.epfl.scala" % "scalafix-interfaces" % scalafixVersion,
    // coursier-small provides a binary stable API around Coursier making sure that
    // sbt-scalafix doesn't conflict with the user's installed version of sbt-coursier.
    // Details: https://github.com/olafurpg/coursier-small
    "com.geirsson" %% "coursier-small" % "1.0.0-M4"
  )
}
