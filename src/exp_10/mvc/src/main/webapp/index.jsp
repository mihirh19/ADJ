<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<center>
  <div>
    <form action="display.jsp">
      Display: <input type="submit" value="display">
    </form>
  </div>
  <br>
  <div>
    <form action="update.jsp">
      ID: <input type="text" name="ID"><!-- comment --><br>
      New Name: <input type="text" name="newName"><!-- comment --><br>
      Update: <input type="submit" value="update">
    </form>
  </div>
  <br>
  <div>
    <form action="delete.jsp">
      Delete ID: <input type="text" name="ID"><!-- comment --><br>
      Delete: <input type="submit" value="Delete">
    </form>
  </div>
  <br>
  <div>
    <form action="create.jsp">
      New ID: <input type="text" name="ID"><!-- comment --><br>
      New Name: <input type="text" name="newName"><!-- comment --><br>
      Create: <input type="submit" value="create">
    </form>
  </div>
</center>

</body>
</html>