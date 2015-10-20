<tiles:insert template="/WEB-INF/view/common-2cols/layout.jsp" flush="true">

<tiles:put name="title" value="User manage" />

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
    <h1>User manage</h1>

    <h2>Register User</h2>

    <!-- 新規登録フォーム -->
    <div class="panel panel-default">
        <div class="panel-body">
            <html:errors property="mailAddr" />
            <s:form action="/mnt/userManage/addUserConfirm" styleClass="form-horizontal" method="POST">
                <fieldset>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">mail address</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputEmail" name="mailAddr" placeholder="Email" autocomplete="off" value="${mailAddr }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-lg-2 control-label">password</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputPassword" name="password" placeholder="Password" autocomplete="off" value="${password }">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <s:submit styleClass="btn btn-default">確認する</s:submit>
                        </div>
                    </div>
                </fieldset>
            </s:form>
        </div>
    </div>

    <hr>

    <h2>User List</h2>

    <table data-toggle="table">
        <thead>
        <tr>
            <th>id</th>
            <th>メールアドレス</th>
            <th>削除</th>
            <th>ロール</th>
            <th>最終ログイン日時</th>
            <th>ログイン失敗回数</th>
            <th>編集</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${userAuthList }" var="userAuth">
            <tr>
                <td data-sortable="true">${userAuth.userId }</td>
                <td data-sortable="true">${f:h( userAuth.mailAddr )}</td>
                <td data-sortable="true">${f:h( userAuth.delFlag )}</td>
                <td data-sortable="true">
                    <c:forEach items="${userAuth.userRoleList }" var="userRole">
                        ${f:h( userRole.role )}<br>
                    </c:forEach>
                </td>
                <td data-sortable="true">${f:h( userAuth.userAuthSec.lastLoginDate )}</td>
                <td data-sortable="true">${f:h( userAuth.userAuthSec.loginFailureCount )}</td>
                <td>
                    <button class="btn btn-xs btn-default edit_${userAuth.userId }">編集</button>
                    <button class="btn btn-xs btn-default del_${userAuth.userId }">削除</button>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</tiles:put>

</tiles:insert>
