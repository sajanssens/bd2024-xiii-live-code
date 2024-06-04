## Labs Jakarta EE

1. **Jakarta EE Container**
	- download OpenLiberty, bekijk de install dir	
		kies voor de kale kernel versie en bekijk de README.
		doe dan `server create`
	- maak een HelloWorld in maven (bijv. uit JavaWEB) en deploy en run op WLP
		- bewerk de server.xml van defaultServer
		- voer uit `featureUtility installServerFeatures defaultServer`
		- zet je war in de `dropins` folder
		- voer uit `server run`
	- gebruik nu de `liberty-maven-plugin` met `mvn liberty:dev`

2. **REST**
	1. Maak een nieuwe rest-app met een simpele `HelloWorldResource`:
       - maak nieuw leeg maven project
       - voeg jakarta ee 10 toe aan je pom.
       - maak één class en annoteer deze met `@ApplicationPath`
       - maak sub-packages:
           - domain
           - repositories
           - resources
       - maak je eerste resource op een uniek `@Path` met een `@GET` endpoint die `Hello World` teruggeeft.
   1. Breid je GET endpoint uit met een query parameter id: als deze negatief is, geef dan een http 400 terug.
   1. Maak je tweede resource met een GET endpoint die een List van objecten teruggeeft als JSON.
   1. Breid die resource uit met: GET met queryparam, GET met pathparam, POST, PUT en DELETE.
      - test met bijv. de Http client in IDEA of met Postman.
   1. Maak gebruik van sub resources: acties op één entity moeten in een aparte resource.
   1. Bouw een CORS filter.
   1. Bouw ondersteuning in voor XML-responses.
   1. Bouw in dat je JSON-array ook echt valide JSON is: 
      - van unnamed `[ {..}, .. ]` naar named `{ "arraynaam": [ {..}, .. ] }`
   1. Sluit je frontend op je backend aan.
   1. Maak een Dao voor je objecten.
   1. Handling errors implementeren m.b.v. exceptions en foutmeldingen.
   1. OpenApi/Swagger toevoegen.
   1. Connectedness implementeren.
   1. Bouw JPA in.
   1. JWT implementeren.
   1. Integratietest maken met behulp van `test-containers`.

3.  verder vanaf Lab 2 (pdf) (TODO...)
