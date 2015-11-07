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

                        <div class="alert alert-dismissible alert-info">
                            <p>
                            パスワードを忘れてしまった方は、以下のテキストボックスに、ご登録のメールアドレスを入力の上、「パスワードリセットの案内を送信」ボタンを押下してください。<br>
                            パスワードリセットに関するご案内をご登録メールアドレスに送信いたします。<br>
                            </p>
                            <p><strong>送信後、24時間は再送できませんので、ご了承下さい。</strong></p>
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
                                <s:submit styleClass="btn btn-primary">パスワードリセットの案内を送信</s:submit>
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
