This is the demo backend app for Jakarta EE. 

Just run ```mvn liberty:dev``` and surf to `http://localhost:9080/baseball-quiz/api/<someresource>`.

You can also use the Angular-app to demonstrate this backend.

- to get JWT working you need to create a `public-key.pem` and `private-key.pem` as follows:
    - private key: `openssl genpkey -algorithm RSA -out private-key.pem -pkeyopt rsa_keygen_bits:2048`
    - public key: `openssl rsa -pubout -in private-key.pem -out public-key.pem`
    - on windows, you can use Git Bash for this
