package models

import io.circe._
import io.circe.generic.semiauto._

case class Coordinate(latitude: Double, longitude: Double)

case class Drone(Id: String, location: String, coordinates: Coordinate, speed: Int)

case class Drones(drones: Seq[Drone])

case class Store(Id: String, address: String, coordinates: Coordinate)

case class Stores(stores: Seq[Store])

case class Customer(Id: String, address: String, coordinates: Coordinate)

case class Customers(customers: Seq[Customer])

case class Route(distance: Double, drone: Drone, store: Store, customer: Customer)

object Decoders {
    implicit val decodeCoordinates: Decoder[Coordinate] = deriveDecoder[Coordinate]

    implicit val decodeDrone: Decoder[Drone] = deriveDecoder[Drone]
    implicit val decodeDrones: Decoder[Drones] = deriveDecoder[Drones]

    implicit val decodeStore: Decoder[Store] = deriveDecoder[Store]
    implicit val decodeStores: Decoder[Stores] = deriveDecoder[Stores]

    implicit val decodeCustomer: Decoder[Customer] = deriveDecoder[Customer]
    implicit val decodeCustomers: Decoder[Customers] = deriveDecoder[Customers]
}

