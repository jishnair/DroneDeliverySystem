import org.scalatest.FlatSpec
import parser.JsonParser
import util.DroneRouter


class DDSSpec extends FlatSpec {

    val customer = JsonParser.parseCustomers("src/main/resources/customers.json").head
    val drones = JsonParser.parseDrones("src/main/resources/drones.json")
    val stores = JsonParser.parseStores("src/main/resources/stores.json")
    val shortestRoute = DroneRouter.getShortestRoute(drones, stores, customer)

    "Shortest route" should "select drone D2" in {
        assert(shortestRoute.drone === drones(1))
    }

    "Shortest route" should "select Store1" in {
        assert(shortestRoute.store === stores(0))
    }

}
