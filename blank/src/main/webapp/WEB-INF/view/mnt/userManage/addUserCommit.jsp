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
password : *****<br>
<br>
登録完了しました。

<hr>

<ol>
    <li><a href="<%= request.getContextPath() %>/">Top</a></li>
    <li><a href="<%= request.getContextPath() %>/mnt/userManage">ユーザ一覧へ</a></li>
</ol>

<s:form action="/logout" method="POST">
    <s:submit>logout</s:submit>
</s:form>
</body>
</html>
