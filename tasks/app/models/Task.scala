package models

import play.api._
import play.api.Play.current
import play.api.db._
import scala.slick.driver.H2Driver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}


class Task(tag: Tag) extends Table[(Int, String, String)](tag, "Task"){
	def id: Column[Int] = column[Int]("TaskID", O.PrimaryKey)
	def name: Column[String] = column[String]("TaskName")
	def description: Column[String] = column[String]("Description")
	
	// projection
	def * : ProvenShape[(Int, String, String)] = (id, name, description)
}
