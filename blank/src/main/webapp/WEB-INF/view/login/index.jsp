<tiles:insert template="/WEB-INF/view/common-1col/layout.jsp" flush="true">

<tiles:put name="title" value="ログイン" />

<tiles:put name="css" type="string">
</tiles:put>

<tiles:put name="js" type="string">
</tiles:put>

<tiles:put name="content" type="string">

<html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" />
<div class="row">
    <div class="col-md-4 col-lg-offset-8">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <i class="fa fa-sign-in fa-lg"></i> ログイン
            </div>
            <div class="panel-body">
                <s:form action="/login/execute" method="POST" styleClass="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <label for="mailAddr" class="col-lg-4 control-label">メールアドレス</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" name="mailAddr" id="mailAddr" placeholder="メールアドレスを入力" autocomplete="off">
                                <html:errors property="mailAddr" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-lg-4 control-label">パスワード</label>
                            <div class="col-lg-8">
                                <input type="password" class="form-control" name="password" id="password" placeholder="パスワードを入力" autocomplete="off">
                                <html:errors property="password" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-4">
                            </div>
                            <div class="col-lg-8">
                                <s:submit styleClass="btn btn-primary">ログイン</s:submit>
                            </div>
                        </div>
                    </fieldset>
                </s:form>
            </div>
        </div>

        <s:form action="/resetPassword" method="POST" styleClass="form-horizontal" style="display: inline-block;">
            <s:submit styleClass="btn btn-default btn-xs">パスワードを忘れた</s:submit>
        </s:form>

        <s:form action="/mailAuth" method="POST" styleClass="form-horizontal" style="display: inline-block;">
            <s:submit styleClass="btn btn-default btn-xs">アカウントを登録する</s:submit>
        </s:form>
    </div>
</div>
</tiles:put>

</tiles:insert>
