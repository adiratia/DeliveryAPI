# DeliveryAPI

## Models:
1. Address - Contain street,city,country and zip.
2. Delivery - contain Status,Timeslotid and User
3. Timeslot- contain start time, end time and supported addresses(List of Addresses)
4. User - Contain name and address

## API Methods:

1.POST /timeslots - retrieve all available timeslots for a formatted/structured address
<br />
      request format:  {"address": {"street":"streetName","city":"cityName","country":"countryName","zip":"zipCode"}}
   <br />
2.POST /resolve-address - resolves a single line non-structured address into a structured.
<br />
 one line address format : "street, city, country, zip"
 <br />
3.POST /deliveries - try to book a delivery (will be checked by mechanism of handling concurrent requests)
<br />
  delvery format : {user : {" name" :"Example", address:{"street":"streetName","city":"cityName","country":"countryName","zip":"zipCode"}},
                            "timeslotid" ":timeslotid"
                                                }
 <br />
4.POST /deliveries/{DELIVERY_ID}/complete - mark delivery as completed
<br />
5.DELETE /deliveries/{DELIVERY_ID} - cancel a delivery
<br />
6.GET /deliveries/daily - retrieve a list of all today’s deliveries
<br />
7.GET /deliveries/weekly - retrieve a list of all deliveries for current week
<br />

