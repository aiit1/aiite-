var sys = require("util");
var fs = require("fs");
var ws = require("websocket-server");
var server = ws.createServer();

server.addListener("connection", function(connection){
        var client_id = connection.id;
        sys.log("Connected->"+client_id);
        readFile();

        fs.watchFile('./kabu.html',readFile);
});

function readFile(curr,prev) {
        fs.readFile('./kabu.html','UTF-8', function(err,data) {
                sys.log("news->"+data);
                server.broadcast(data);
        });
}

server.listen(10080);
