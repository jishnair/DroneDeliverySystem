import models.{Customer, Route}
import parser.JsonParser
import util.DroneRouter

object Main extends App {

    val dronesDataPath = DataPath.DRONES
    val storesDataPath = DataPath.STORES
    val customersDataPath = DataPath.CUSTOMERS

    val dronesList = JsonParser.parseDrones(dronesDataPath)
    val storesList = JsonParser.parseStores(storesDataPath)
    val customersList = JsonParser.parseCustomers(customersDataPath)

    do {
        val maybeCustomer = getCustomer()
        maybeCustomer match {
            case Some(customer) =>
                val shortestRoute = DroneRouter.getShortestRoute(dronesList, storesList, customer)
                printResult(shortestRoute)

            case None =>
                println("\n*****************\n")
                println("Could not find customer with Id ")
                println("\n*****************\n")
        }

    } while (true)

    private def getCustomer(): Option[Customer] = {

        println("Please enter the customer Id for delivery")
        customersList.map { c =>
            println("Id=" + c.Id + " Address=" + c.address)
        }
        val userInput = scala.io.StdIn.readLine().toUpperCase()

        customersList.find(c => c.Id == userInput)
    }

    private def printResult(route: Route): Unit = {

        println("\n*****************\n")

        println("Shortest route to customer: " + route.customer.Id + ", " + route.customer.address)
        println("Distance = %.2f km".format(route.distance))

        println("Nearest Drone = " + route.drone.Id + ", " + route.drone.location)
        println("Nearest Store = " + route.store.Id + ", " + route.store.address)

        val time = 60 * route.distance / route.drone.speed
        val timeInMinutes = time.toInt
        val timeInSeconds = ((time - timeInMinutes) * 60).toInt
        println("Time required= " + timeInMinutes + " minutes " + timeInSeconds + " seconds")

        println("Google maps route: https://www.google.de/maps/dir/" +
          route.drone.location.replaceAll("\\s", "+") + "/" +
          route.store.address.replaceAll("\\s", "+") + "/" +
          route.customer.address.replaceAll("\\s", "+"))

        println("\n*****************\n")

    }


}

object DataPath {
    val DRONES = "src/main/resources/drones.json"
    val STORES = "src/main/resources/stores.json"
    val CUSTOMERS = "src/main/resources/customers.json"
}