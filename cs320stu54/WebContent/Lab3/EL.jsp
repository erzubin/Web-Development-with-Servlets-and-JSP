<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

</head>
<style>
td {
text-align : center;
}
</style>
<body>

<table class="table table-striped" width="400" border="1">
 <tr align="left">
<th width="200" colspan="2"><h3>Arithmetic Operators</h3></th>
<th width="200" colspan="2"><h3>Relational Operators</h3></th>
</tr>

<tr align="left">
<th><h3>Expression</h3></th>
<th><h3>Result</h3></th>
<th><h3>Expression</h3></th>
<th><h3>Result</h3></th>
</tr>

<tr>
<td><h3><span>$</span><span>{2+3-1}</span></h3></td>
<td><h3>${2+3-1}</h3></td>
<td><h3><span>$</span><span>{1<2}</span></h3></td>
<td><h3>${1<2}</h3></td>
</tr>

<tr>
<td><h3><span>$</span><span>{"1"+2}</span></h3></td>
<td><h3>${"1"+2}</h3></td>
<td><h3><span>$</span><span>{"a"<"b"}</span></h3></td>
<td><h3>${"a"<"b"}</h3></td>
</tr>

<tr>
<td><h3><span>$</span><span>{1+2*3+3/4}</span></h3></td>
<td><h3>${1+2*3+3/4}</h3></td>
<td><h3><span>$</span><span>{2/3>=3/2}</span></h3></td>
<td><h3>${2/3>=3/2}</h3></td>
</tr>

<tr>
<td><h3><span>$</span><span>{3%2}</span></h3></td>
<td><h3>${3%2}</h3></td>
<td><h3><span>$</span><span>{3/4==0.75}</span></h3></td>
<td><h3>${3/4==0.75}</h3></td>
</tr>

<tr>
<td><h3><span>$</span><span>{(8div2)mod3}</span></h3></td>
<td><h3>${(1/2)mod 3}</h3></td>
<td><h3><span>$</span><span>{null=="test"}</span></h3></td>
<td><h3>${null=="test"}</h3></td>
</tr>

<!-- <tr align="left">
<td><h3>Logical Operators</h3></td>
<td><h3>Operators</h3></td>
</tr> -->
<
<tr>
<th width="200" colspan="2"><h3>Logical Operators</h3></th>
<th width="200" colspan="2"><h3><span style="color:red">empty</span><span>   </span><span>Operators</span></h3></th>
</tr>

<tr align="left">
<th align="left"><h3>Expression</h3></th>
<th><h3>Result</h3></th>
<th><h3>Expression</h3></th>
<th><h3>Result</h3></th>
</tr>

<tr>
<td><h3><span>$</span><span>{(1<2)&&(4<3)}</span></h3></td>
<td><h3>${(1<2)&&(4<3)}}</h3></td>
<td><h3><span>$</span><span>{empty ""}</span></h3></td>
<td><h3>${empty ""}</h3></td>
</tr>

<tr>
<td><h3><span>$</span><span>{(1<2)||(4<3)}</span></h3></td>
<td><h3>${(1<2)||(4<3)}</h3></td>
<td><h3><span>$</span><span>{empty null}</span></h3></td>
<td><h3>${empty null}</h3></td>
</tr>
<tr>
<td><h3><span>$</span><span>{!(1<2)}</span></h3></td>
<td><h3>${!(1<2)}</h3></td>
<td><h3><span>$</span><span>{empty param.blah}</span></h3></td>
<td><h3>${empty param.blah}</h3></td>
</tr>

</table>


</body>
</html>