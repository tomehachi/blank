<tiles:insert template="/WEB-INF/view/common-1col/layout.jsp" flush="true">

<tiles:put name="title" value="パスワードリマインダ" />

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
                        <legend>パスワードリセット</legend>

                        <div class="alert alert-dismissible alert-danger">
                            <button type="button" class="close" data-dismiss="alert">×</button>
                            <p>
                            パスワードを忘れてしまった方は、以下のテキストボックスに、ご登録のメールアドレスを入力の上、「パスワードをリセットする」ボタンを押下してください。<br>
                            ご案内をご登録メールアドレスに送信いたします。<br>
                            </p>
                            <p><strong>パスワードリセットは1日に1回しかできませんので、ご注意下さい。</strong></p>
                        </div>

                        <div class="form-group">
                            <label for="mailAddr" class="col-lg-4 control-label">メールアドレス</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" name="mailAddr" id="mailAddr" placeholder="メールアドレスを入力" autocomplete="off">
                                <html:errors property="mailAddr" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-4">
                            </div>
                            <div class="col-lg-8">
                                <s:submit styleClass="btn btn-primary">パスワードをリセットする</s:submit>
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
