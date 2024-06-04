## Labs Jakarta EE

1. OpenLiberty
	- download OpenLiberty, bekijk de install dir	
		kies voor de kernel versie en zie de readme.
		doe dan `server create`
	- maak een HelloWorld in maven (bijv. uit JavaWEB) en deploy en run op WLP
		bewerk de server.xml van defaultServer
		doe dan `featureUtility installServerFeatures`
		dan je war in dropins zetten
		dan server run
	- gebruik nu de liberty-maven-plugin met mvn liberty:dev

2. REST
	1. Maak een nieuwe rest-app met een simpele `HelloWorldResource`:
       - maak nieuw leeg maven project
       - voeg jakarta ee 10 toe
       - maak één class en annoteer deze met `@ApplicationPath`
       - maak sub-packages:
           - domain
           - repositories
           - resources
       - maak je eerste resource op een uniek `@Path` met een `@GET` endpoint die "Hello World" teruggeeft.\
	1. breid je GET endpoint uit met een query parameter id: als deze negatief is, geef dan een 403 terug.
	1. maak je tweede resource met een GET endpoint die een List van objecten teruggeeft als JSON.
	1. breid die resource uit met: GET met queryparam, GET met pathparam, POST, PUT DELETE
       - test met bijv. de Http client in IDEA of met Postman.
	1. sluit je frontend op je backend aan
	1. bouw ondersteuning in voor XML-responses
	1. bouw in dat je json array valide is
	1. maak een Dao voor je objecten
	1. Handling errors implementeren m.b.v. exceptions
	1. Sub resources implementeren
