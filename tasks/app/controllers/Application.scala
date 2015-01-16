package controllers

import play.api._
import play.api.mvc._

import play.api.data.Form
import play.api.data._
import play.api.data.Forms._
import scala.slick.driver.H2Driver.simple._
import scala.slick.session.Session
import play.api.libs.json._
import models._
import play.api.db._
import play.api.Play.current
import Database.threadLocalSession


object Application extends Controller {
	lazy val db = Database.forDataSource(DB.getDataSource())
	val todoForm = Form(
		mapping(
			"name" -> text
		)
			((name) => Task(1,name,"a",1))
			((task:Task) => Some(task.name))
		
	)

  	def index = Action {
    	Ok(views.html.index(todoForm))
  	}

}
