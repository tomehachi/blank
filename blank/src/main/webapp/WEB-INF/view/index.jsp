<tiles:insert template="/WEB-INF/view/common-2cols/layout.jsp" flush="true">

<tiles:put name="title" value="" />

<tiles:put name="css" type="string">
    <!-- テーブル関連ライブラリ -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/bootstrap-table/bootstrap-table.min.css">
</tiles:put>

<tiles:put name="js" type="string">
    <!-- テーブル関連ライブラリ -->
    <script src="<%= request.getContextPath() %>/assets/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="<%= request.getContextPath() %>/assets/bootstrap-table/locale/bootstrap-table-ja-JP.min.js"></script>
</tiles:put>

<tiles:put name="content" type="string">
    <h1>Top page</h1>

    <h2>your profile</h2>

    userId = ${f:h( userDto.userId )}<br>
    requestUri = ${f:h( userDto.requestUrl )}<br>
    role = ${f:h( userDto.role )}<br>
    loggedInAt = <fmt:formatDate value="${userDto.loggedInAt }" pattern="yyyy/MM/dd HH:mm:ss.SSS" /><br>

</tiles:put>

</tiles:insert>
