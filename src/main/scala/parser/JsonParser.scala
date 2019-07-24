package parser

import java.io.File
import io.circe.generic.semiauto.deriveDecoder
import io.circe.parser.decode
import scala.io.Source
import models._
import models.Decoders._

object JsonParser {

    def parseDrones(filePath: String): Seq[Drone] = {
        val dronesJsonString = Source.fromFile(new File(filePath)).getLines().mkString("\n")
        val maybeDrones = decode[Drones](dronesJsonString)(deriveDecoder[Drones])
        maybeDrones match {
            case Right(drones) =>
                drones.drones
            case Left(e) => println("error=" + e)
                Seq.empty[Drone]
        }
    }

    def parseStores(filePath: String): Seq[Store] = {
        val storesJsonString = Source.fromFile(new File(filePath)).getLines().mkString("\n")
        val maybeStores = decode[Stores](storesJsonString)(deriveDecoder[Stores])
        maybeStores match {
            case Right(stores) =>
                stores.stores
            case Left(e) => println("error=" + e)
                Seq.empty[Store]
        }
    }

    def parseCustomers(filePath: String): Seq[Customer] = {
        val customerJsonString = Source.fromFile(new File(filePath)).getLines().mkString("\n")
        val maybeCustomers = decode[Customers](customerJsonString)(deriveDecoder[Customers])
        maybeCustomers match {
            case Right(customers) =>
                customers.customers
            case Left(e) => println("error=" + e)
                Seq.empty[Customer]
        }
    }
}
