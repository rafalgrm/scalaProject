package controllers

import play.api._
import play.api.mvc._

import play.api.data.Form
import play.api.data._
import play.api.data.Forms._
import scala.slick.driver.H2Driver.simple._
import play.api.libs.json._
import models._
import play.api.db._
import play.api.Play.current



object Application extends Controller {
	

  	def index = Action {
	  	val tasks:TableQuery[Task] = TableQuery[Task]

		val db = Database.forURL("jdbc:h2:mem:play", driver="org.h2.Driver", user="sa")
		db.withSession {implicit session => 
			//tasks.ddl.create
			tasks += (4, "cofasdstam", "fada")
			val list = tasks.list
			Ok(views.html.index("Hello", list))
		}

  	}

}
