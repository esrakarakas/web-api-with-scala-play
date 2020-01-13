application using:

* scala (2.13.1)
* play (2.4)
* play-json
* slick (3.1)
* specs2

### Try it!

* Install mysql
* configure mysql connection in conf/application.conf
* create mysql database 'Persons'
* `./activator run`
* open `http://localhost:9000` in your browser
* click `Apply this script now!` to execute SQL script

... and you would see an empty json list.

### Test
* open terminal and execute this comment 
  * curl   http://localhost:9000/contacts   --header "Content-type: application/json"   --request POST   --data '{"name": "example", "lastName": "example", "phone1": "example"}' 
  * curl   http://localhost:9000/
  * or open `http://localhost:9000` in your browser and you would see json list.

* for select a person and view their inforation
  * curl   http://localhost:9000/contacts/name




