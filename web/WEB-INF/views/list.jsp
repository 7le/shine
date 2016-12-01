<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title> 你好</title>
</head>
<body>
<form action="/res/info" method="post">
  <input type="text" name="pid"/>
  <input type="text" name="pname"/>
  <input type="submit"/>
</form>
<script>
  console.log(${res.records});
  console.log(${infoBean});
</script>
</body>
</html>