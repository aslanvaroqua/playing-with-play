package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Body(
                 id: Option[Int],
                 userId: Int,
                 weight: Int,
                 height: Int,
                 age: Option[Int],
                 hairColor: String
               ) {
  require(List("Black").contains(hairColor))
}

object Body {
  implicit val messageReads: Reads[Body] = (
    (JsPath \ "id").readNullable[Int] and
      (JsPath \ "userId").read[Int] and
      (JsPath \ "weight").read[Int] and
      (JsPath \ "height").read[Int] and
      (JsPath \ "age").readNullable[Int] and
      (JsPath \ "hairColor").read[String]
    ) (Body.apply _)


  implicit val messageWrites: Writes[Body] = (
    (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "userId").write[Int] and
      (JsPath \ "weight").write[Int] and
      (JsPath \ "height").write[Int] and
      (JsPath \ "age").writeNullable[Int] and
      (JsPath \ "hairColor").write[String]
    ) (unlift(Body.unapply _))

}