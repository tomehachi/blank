<tiles:insert template="/WEB-INF/view/common-1col/layout.jsp" flush="true">

<tiles:put name="title" value="パスワードリセット - 認証" />

<tiles:put name="css" type="string">
</tiles:put>

<tiles:put name="js" type="string">
</tiles:put>

<tiles:put name="content" type="string">


<div class="row">
    <div class="col-md-6 col-lg-offset-3">
        <div class="panel panel-primary">
            <div class="panel-body">
                <s:form action="/resetPassword/auth" method="POST" styleClass="form-horizontal">
                    <fieldset>
                        <legend>パスワードリセット - 認証</legend>

                        <div class="alert alert-dismissible alert-danger">
                            <button type="button" class="close" data-dismiss="alert">×</button>
                            <p>
                                お送りしたメールに記載されていた認証キーを以下に入力し、「パスワードリセット」ボタンを押下して下さい。
                            </p>
                            <p><strong>パスワードリセットは1日に1回しかできませんので、ご注意下さい。</strong></p>
                        </div>

                        <div class="form-group">
                            <label for="authKey" class="col-lg-4 control-label">認証キー</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" name="authKey" id="authKey" placeholder="認証キーを入力" autocomplete="off">
                                <html:errors property="authKey" />
                                <html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-4">
                            </div>
                            <div class="col-lg-8">
                                <s:submit styleClass="btn btn-primary">パスワードリセット</s:submit>
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
