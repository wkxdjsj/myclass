const http = require('http')

http.createServer(function (request, response){
    console.log('request come into 8887', request.url)

    response.writeHead(200, {
        'Access-Control-Allow-Origin':'*'
    })


    let a = response.end('node js response from server2 8887')

}).listen(8887)
console.log('server --> 8887')