package util

import models._

object DroneRouter {

    def getShortestRoute(drones: Seq[Drone], stores: Seq[Store], customer: Customer): Route = {

        val customerCord = customer.coordinates
        //calculate shortest route lazily
        val shortestRoute = (for {
            d <- drones.toStream
            s <- stores
        } yield (calcDistFromDroneToStoreToCustomer(d.coordinates, s.coordinates, customerCord), d, s)).sortBy(_._1).head

        Route(shortestRoute._1, shortestRoute._2, shortestRoute._3, customer)

    }

    private def calcDistFromDroneToStoreToCustomer(coDrone: Coordinate, coStore: Coordinate, coCustomer: Coordinate) = {
        calculateDistanceInKilometer(coDrone, coStore) + calculateDistanceInKilometer(coStore, coCustomer)
    }

    //calculate distance between two gps cordinates in km
    private def calculateDistanceInKilometer(coordinate1: Coordinate, coordinate2: Coordinate): Double = {
        val AVERAGE_RADIUS_OF_EARTH_KM = 6371.0

        val latDistance = Math.toRadians(coordinate1.latitude - coordinate2.latitude)
        val lngDistance = Math.toRadians(coordinate1.longitude - coordinate2.longitude)
        val sinLat = Math.sin(latDistance / 2.0)
        val sinLng = Math.sin(lngDistance / 2.0)
        val a = sinLat * sinLat +
          (Math.cos(Math.toRadians(coordinate1.latitude))
            * Math.cos(Math.toRadians(coordinate2.latitude))
            * sinLng * sinLng)
        val c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a))
        (AVERAGE_RADIUS_OF_EARTH_KM * c)
    }
}
