<tiles:insert template="/WEB-INF/view/common-1col/layout.jsp" flush="true">

<tiles:put name="title" value="パスワードリセット - 入力" />

<tiles:put name="css" type="string">
</tiles:put>

<tiles:put name="js" type="string">
</tiles:put>

<tiles:put name="content" type="string">

<html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" />
<div class="row">
    <div class="col-md-6 col-lg-offset-3">
        <div class="panel panel-primary">
            <div class="panel-body">
                <s:form action="/resetPassword/execute" method="POST" styleClass="form-horizontal">
                    <fieldset>
                        <legend>パスワードリセット - 入力</legend>

                        <div class="alert alert-dismissible alert-danger">
                            <p>
                                新しいパスワードを入力して下さい。
                            </p>
                        </div>

                        <div class="form-group">
                            <label for="password1" class="col-lg-4 control-label">パスワード</label>
                            <div class="col-lg-8">
                                <input type="password" class="form-control" name="password1" id="password1" placeholder="パスワードを入力" autocomplete="off">
                                <html:errors property="password1" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password2" class="col-lg-4 control-label">パスワード確認</label>
                            <div class="col-lg-8">
                                <input type="password" class="form-control" name="password2" id="password2" placeholder="パスワードを入力" autocomplete="off">
                                <html:errors property="password2" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-4">
                            </div>
                            <div class="col-lg-8">
                                <s:submit styleClass="btn btn-danger">設定する</s:submit>
                            </div>
                        </div>
                    </fieldset>
                </s:form>
            </div>
        </div>
    </div>
</div>
</tiles:put>

</tiles:insert>
