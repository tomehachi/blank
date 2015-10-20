<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add user Confirm</title>
</head>
<body>
<h1>User manage</h1>

<h2>Add user Confirm</h2>

<hr>

mail Addr : ${f:h(mailAddr) }<br>
password : *****

<s:form action="/mnt/userManage/addUserCommit" method="POST">
<html:errors property="mailAddr" />
<input type="hidden" name="mailAddr" value="${mailAddr }"><br>
<html:errors property="password" />
<input type="hidden" name="password" value="${password }"><br>
<s:submit>決定する</s:submit>
</s:form>

<hr>

<ol>
    <li><a href="<%= request.getContextPath() %>/">Top</a></li>
</ol>

<s:form action="/logout" method="POST">
    <s:submit>logout</s:submit>
</s:form>
</body>
</html>
