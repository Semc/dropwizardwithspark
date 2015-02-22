package com.example.spark.actors

import akka.actor.Actor
import org.apache.spark.streaming.receiver.ActorHelper
import java.io.File
import akka.actor.Props
import akka.routing.RoundRobinRouter
import akka.actor.Status

/**
 * @author marcinsemczuk
 */

object TopActor{
  case class LineProcessed(line:String)
  case class ProcessFile(file:File)
}

class TopActor extends Actor with ActorHelper{
  import TopActor._
  
  val processor = context.actorOf(Props(new LineProcessor).withRouter(RoundRobinRouter(10)))
  var eof = false
  
  override def receive = {
    case ProcessFile(file) => {
      val src = scala.io.Source.fromFile(file)
      src.getLines().foreach { line => processor ! line }
      eof = true
      context.become(processing)
    }
  }
  
  def processing: Receive = {
    case ProcessFile(file) => { 
      while(!eof){
        val startTime = System.currentTimeMillis();
        logDebug("Still processing file, waiting in queue for: " + (System.currentTimeMillis() - startTime) + " ms")
        Thread.sleep(200)
    }
    }
    case LineProcessed(line) => store(line)
  }
  
}