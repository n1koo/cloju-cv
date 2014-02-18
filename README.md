# cloju-cv

Simple CV template thingie. 

* Clojure
* Stencil
* HTTP-kit
* Ring
* twitter-api
* Cheshire

Running example can be found at [n1ko.salaliitto.com][1]

## Prerequisites

You will need [Leiningen][2] 1.7.0 or above installed.

Your cv should be in the same directory as where you are running the app from (and named cv.json).
Repository contains mine for reference.

For the twitter-integration to work you need to also have a twitter_cred.json file
in the same directory.

Example twitter_cred.json:

{
	"api-key": "xxx",
	"api-secret": "yyy",
	"user-access-token" : "zzz",
	"user-access-token-secret" : "vvv"
}

## Running

To start a web server for the application, run:

    lein ring server

## TODO

 - Parameter the twitter and cv files
 - Don't hard code the twitter user, read from json
 - Hobbies
 - Better technologies listing
 - Styling
 - Editing and persisting data
 - Linkedin API integration?

## License

This project is licensed under the [MIT license](http://opensource.org/licenses/MIT).

[1]: http://n1ko.salaliitto.com
[2]: https://github.com/technomancy/leiningen