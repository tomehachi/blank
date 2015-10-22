<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">

        <title><tiles:getAsString name="title" /></title>

        <!-- bootstrap css -->
        <link href="<%= request.getContextPath() %>/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- custom style sheet -->
        <tiles:insert attribute="css" />

        <!-- common css -->
        <link href="<%= request.getContextPath() %>/assets/default/css/common.css" rel="stylesheet">
        <link href="<%= request.getContextPath() %>/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="container">

            <div class="row">
                <!-- ヘッダ部 -->
                <div class="col-sm-12">
                    <tiles:insert page="/WEB-INF/view/common-1col/header.jsp" />
                </div>
            </div>

            <div class="row">
                <!-- メインコンテンツ -->
                <div class="col-sm-12" style="margin-bottom: 15px;">
                    <tiles:insert attribute="content" />
                </div>
            </div>

            <div class="row">
                <!-- フッタ部 -->
                <div class="col-sm-12" style="background-color: #eee;">
                    <tiles:insert page="/WEB-INF/view/common-1col/footer.jsp" />
                </div>
            </div>

        </div>

        <script src="<%= request.getContextPath() %>/assets/jquery/jquery-2.1.4.min.js"></script>
        <script src="<%= request.getContextPath() %>/assets/bootstrap/js/bootstrap.min.js"></script>
        <tiles:insert attribute="js" />
    </body>
</html>
