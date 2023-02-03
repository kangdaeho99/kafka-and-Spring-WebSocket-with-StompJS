/**
 * 
 */
var ws = null;

function setConnected(connected){
	document.getElementById('connect').disabled = connected;
	document.getElementById('disconnect').disabled = !connected;
	document.getElementById('echo').disabled = !connected;
}

function connect(){
	var sock = new SockJS("/websocket-chat");
	ws = Stomp.over(sock);
	alert("ws connected button clicked");
	ws.connect({},function(){
		setConnected(true);
		ws.subscribe('/topic/echo', onMessageReceived);
	});
}

function disconnect(){
	if(ws != null){
		ws.disconnect();
		ws = null;
	}
	setConnected(false);
}

function echo(){
	if(ws){
		var message = document.getElementById('message').value;
		console.log("echo message: "+message);
		ws.send('/echo', {}, JSON.stringify({message:message}));
	}else{
		ws.send(message);
		alert('connection not established, please connect.');
	}
}

function onMessageReceived(payload){
	var message = JSON.parse(payload.body);
	var console = document.getElementById('logging');
	var p = document.createElement('p');
	p.appendChild(document.createTextNode(message.message));
	console.appendChild(p);
	while(console.childNodes.length > 12){
		console.removeChild(console.firstChild);
	}
	console.scrollTop = console.scrollHeight; 
}