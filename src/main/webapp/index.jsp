<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style>
<title>Parameters that need Encoding!!</title>
</head>
<body bgcolor="#E6E6FA">


<form action="api" method="post">
<h1 style="color:blue">Parameters that need Encoding!!</h1>
<table>
<tr><td></>HTML Data</td><td><input type="text" name="htmlData"></td></tr>
<tr><td>JavaScript Data</td><td><input type="text" name="javascriptData"></td></tr>
<tr><td>XML Data</td><td><input type="text" name="xmlData"></td></tr>
<!-- <tr><td>SQL Data</td><td><input type="text" name="sqlData"></td></tr> -->
<!-- <tr><td>CSS Data</td><td><input type="text" name="CSSData"></td></tr> -->
<!-- <tr><td>URL Data</td><td><input type="text" name="URLData"></td></tr> -->
<tr><td><input type="submit" name="submit"></td></tr>

</table>
</form>

</body>
</html>