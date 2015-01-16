package models

import play.api._
import play.api.Play.current
import play.api.db._
import scala.slick.driver.H2Driver.simple._

case class Task(id: Long, name: String, description: String, priority: Int)
case class Project(id: Long, name: String, description: String)


object Task extends Table[(Long, String, String, Int)]("tasks") {
	def id = column[Long]("id", O.PrimaryKey)
	def name = column[String]("name")
	def description = column[String]("description")
	def priority = column[Int]("priority")
	def * = id ~ name ~ description ~ priority
}


