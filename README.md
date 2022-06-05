# DeliveryAPI

##Models:
1. Address - Contain street,city,country and zip.
2. Delivery - contain Status,Timeslotid and User
3. Timeslot- contain start time, end time and supported addresses(List of Addresses)
4. User - Contain name and address

##API Methods:

1.POST /timeslots - retrieve all available timeslots for a formatted/structured address 
      request format:  {"address": {"street":"streetName","city":"cityName","country":"countryName","zip":"zipCode"}}
2.POST /resolve-address - resolves a single line non-structured address into a structured one
 one line address format : "street, city, country, zip"
3.POST /deliveries - try to book a delivery (will be checked by mechanism of handling concurrent requests)
  delvery format : {user : {" name" :"Example", address:{"street":"streetName","city":"cityName","country":"countryName","zip":"zipCode"}},
                            "timeslotid" ":timeslotid"
                                                }
4.POST /deliveries/{DELIVERY_ID}/complete - mark delivery as completed
5.DELETE /deliveries/{DELIVERY_ID} - cancel a delivery
6.GET /deliveries/daily - retrieve a list of all today’s deliveries
7.GET /deliveries/weekly - retrieve a list of all deliveries for current week

