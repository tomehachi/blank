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
               <div class="alert alert-dismissible alert-info">
                    <p>
                        サイトにご登録のメールアドレスが正しく入力されていた場合に限り、パスワードリセットのご案内が送信されます。<br>
                    </p>
                    <p><strong>パスワードリセットのご案内は、24時間前の間に既に送信されていた場合は送信されませんので、ご注意頂けます様お願い申し上げます。</strong></p>
                </div>
            </div>
        </div>
    </div>
</div>
</tiles:put>

</tiles:insert>
