this project is made using spring boot framework
H2 is used as internal database
you can pull this project from github https://github.com/sandip125/powerplant-proshore.git and run on your device

        API 1
    url    http://localhost:8080/batteries/add
    method :POST
    take array of batteries as list in request
    eg:{
    "batteryInfos":[
        {
            "name":"jug",
            "postCode":"1041110",
            "wattCapacity":812.2
        },
        {
            "name":"bfdbdfhsfsd",
            "postCode":"1019110",
            "wattCapacity":112.2
        }
    ]
}

        API 2

    url:     http://localhost:8080/batteries?startPostcode=1011110&endPostcode=1041110
    method:   GET


