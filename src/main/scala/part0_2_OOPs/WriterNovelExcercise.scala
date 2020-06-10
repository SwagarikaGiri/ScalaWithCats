package part0_2_OOPs

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object WriterNovelExcercise extends App{
  val writer1=new Writer("Swagarika","Giri","09-06-1995")
  writer1.displayFullName()
  val writer2=new Writer("Shakespear","Abc","12-11-1994")
  writer2.displayFullName()
  val writer3=new Writer("Nicollas","Spark","28-06-1995")
  writer3.displayFullName()
  val aapbiti = new Novel("Aapbiti","01-07-2020",writer1)
  aapbiti.getAuthorsAgeAtTimeOfRelease()



}


class Writer(val firstName:String,val surname:String, val dateOfBirth:String)
{
  def displayFullName():Unit={
    //this is called s-interpolation where ${} is used
    println(s"My name is $firstName $surname")
  }
}

class Novel(val nameOfBook:String,val yearOfRelease:String,val authorName:Writer)
{
  val authorDOB=authorName.dateOfBirth
  def getAuthorsAgeAtTimeOfRelease():Unit={
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val oldDate = LocalDate.parse(authorDOB, formatter)
    val newDate = LocalDate.parse(yearOfRelease, formatter)
    val ageDifference = newDate.toEpochDay() - oldDate.toEpochDay()

    val localDate = LocalDate.ofEpochDay(ageDifference)
    println(localDate)
    println(ageDifference)
    val abc:String="abc"


  }
}