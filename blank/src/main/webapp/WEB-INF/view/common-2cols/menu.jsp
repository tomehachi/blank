<h2>Menu</h2>

<div class="list-group">
    <a href="<%= request.getContextPath() %>/" class="list-group-item">Top</a>
    <a href="<%= request.getContextPath() %>/mnt/userManage" class="list-group-item">ユーザ管理</a>
    <a href="<%= request.getContextPath() %>/wiki/view/index" class="list-group-item">Wiki</a>
</div>

<s:form action="/logout" method="POST">
    <s:submit>logout</s:submit>
</s:form>
