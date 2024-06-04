package com.infosupport;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

// http(s)://serveraddress:serverport/context-root/application-path/...
// http(s)://localhost:9080/baseballquiz/api/...
@ApplicationPath("api")
public class App extends Application {

    // dit is onze "main"
}
