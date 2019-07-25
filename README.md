# Drone Delivery System

Find the shortest route to a customer from a Drone location via a Store.

## Problem statement

A supermarket chain is looking into express shipping with unmanned aerial vehicles ("drones").

There is a fleet of drones in two locations available:  
Metrostrasse 12, 40235 Düsseldorf  
Am Albertussee 1, 40549 Düsseldorf  

Currently four test customers participate  
C1 : Kronprinzenstraße 88, 40217 Düsseldorf    
C2 : Kaiserstraße 2, 40479 Düsseldorf  
C3 : Wildenbruchstraße 2, 40545 Düsseldorf  
C4 : Schlesische Straße 5, 40231 Düsseldorf

The supermarket locations are:   

Schiessstraße 31, 40549 Düsseldorf  
Friedrichstraße 152, 40217 Düsseldorf  
Breslauer Str. 2, 41460 Neuss  
Bataverstraße 93, 41462 Neuss  
Am Sandbach 30, 40878 Ratingen  

The process of delivery works like this:  
- The orders are pre-picked and can be picked up without delay from the stores above
- The drone will always begin from one of the two drone depots mentioned above
- After picking up the goods the drone will fly to the customers in the shortest distance

The software should tell which depot and store shall be chosen for a given customer and calculate the total delivery time in minutes and seconds.

Assumptions: You can pre- calculate the GPS coordinates and use these in your software.
The drone has a velocity of 60 km/h. No time for pick-up and hand-over is required.

## Solution
The resources directory contains the Json data of Customers, Drones and Stores.
This will help reusing the program with different set of data or can extend the program with 
rest endpoints as data sources.

The util class DroneRouter calculates the optimal route from Drone location -> Store -> Customer.
The algorithm uses a Brute force approach since the requirement is to calculate the shortest path. 

Libraries used:   
    Circe - For Json parsing  
    ScalaTest - For testing



## Running

To run the file copy the jar file in an appropriate directory and run

`java -jar dds-assembly-1.0.jar   
`
The program will list the customer details. Enter the customer Id to calculate 
the route:  
Eg: c1  

The program will print the shortest route details:  
Clicking on the link will redirect to you to the Google Maps link of the optimal route.




