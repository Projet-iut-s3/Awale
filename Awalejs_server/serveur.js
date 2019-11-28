const JoueurHumain = require('./JoueurHumain');
const Jeu = require('./Jeu');

var j1;
var j2;
var jeu;
var fini;

var express = require('express');
var app = express();
var http = require('http').Server(app);
var io = require('socket.io')(http);

http.listen(8080);

app.use(express.static(__dirname));

app.get('/', function (req, res) {
    res.sendFile(__dirname + '/index.html');
});
/*var http = require('http');
var fs = require('fs');*/
/*
var server = http.createServer(function(req, res) {
    fs.readFile('./index.html', 'utf-8', function(error, content) {
        res.writeHead(200, {"Content-Type": "text/html"});
        res.end(content);
    });
});

var io = require('socket.io').listen(server);*/

io.on('connection', function (socket) {
    console.log('Un client s\'est connecté');
    socket.emit('log', 'Login success');
    socket.on('con', function (pseudo) {
        socket.pseudo = pseudo;
        if(typeof j1 === 'undefined')
            j1 = new JoueurHumain(pseudo, 1);
        else {
            j2 = new JoueurHumain(pseudo, 2);
            jeu = new Jeu(j1, j2, 0);
            fini = false;
            socket.broadcast.emit('list_joueur', {j1:j1.pseudo, j2:j2.pseudo});
            socket.emit('list_joueur', {j1:j1.pseudo, j2:j2.pseudo});
        }
    });
    socket.on('click', function (i) { // Quand le joueur click
        console.log('click sur', i);
        if(typeof j1 !== 'undefined' && typeof j2 !== 'undefined') {
            console.log(jeu.getPlateau().getPlateauList());
            if(!fini) {
                let cote = Math.floor(i / 5);
                console.log("cote", cote);
                let res = jeu.jouer(i % 5, cote);
                if (res !== -1)
                    fini = true;
            }
            socket.broadcast.emit('click_resultat', {j1: j1.score, j2:j2.score, tour: jeu.getTour(), cases: jeu.getPlateau().getPlateauList()});
            socket.emit('click_resultat', {j1: j1.score, j2:j2.score, tour: jeu.getTour(), cases: jeu.getPlateau().getPlateauList()});
            console.log(jeu);
            console.log(jeu.getPlateau().getPlateauList());
        }
    });
});

