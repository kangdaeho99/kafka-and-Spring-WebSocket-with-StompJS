<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.min.css" />
    <script type="text/javascript" src="../../resources/1.5.2.sockjs.min.js"></script>
    <script type="text/javascript" src="../../resources/2.3.3.stomp.min.js"></script>
    <script type="text/javascript" src="../../resources/app.js"></script>
</head>
<body>
    <div id="connect-container" class="ui centered grid">
        <div class="row">
            <button id="connect" onclick="connect();" class="ui green button">Connect</button>
            <button id="disconnect" disabled="disabled" onclick="disconnect();" class="ui red button">Disconnect</button>
        </div>
        <div class="row">
            <textArea id="message" style="width: 350px" class="ui input" placeholder="Message to Echo"></textArea>
        </div>
        <div class="row">
            <button id="echo" onclick="echo();" disabled="disabled" class="ui button">Echo message</button>
        </div>
        <div id="console-container">
            <h3>Logging</h3>
            <div id="logging"></div>
        </div>
    </div>
</body>
</html>