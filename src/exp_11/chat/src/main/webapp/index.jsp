<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Java EE WebSocket Chat</h1>

<div style="text-align: center;">
  <form action="">

    <div id="messages" name="messages"  ></div><br/>
    <input type="text" id="messageField" placeholder="Type your message here"><br/>
    <input onclick="sendMessage()" value="Send Message" type="button">
  </form>
</div>


<script type="text/javascript" src="js/socket.js">

</script>

</body>
</html>