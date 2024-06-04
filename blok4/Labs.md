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

2. REST\
	a. Maak een nieuwe rest-app met een simpele `HelloWorldResource`:
	- maak nieuw leeg maven project
	- voeg jakarta ee 10 toe
	- maak één class en annoteer deze met `@ApplicationPath`
	- maak sub-packages:
		- domain
		- repositories
		- resources
	- maak je eerste resource op een uniek `@Path` met een `@GET` endpoint die "Hello World" teruggeeft.
	b. 
