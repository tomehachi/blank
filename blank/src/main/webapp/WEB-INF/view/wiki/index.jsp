<tiles:insert template="/WEB-INF/view/common-2cols/layout.jsp" flush="true">

<tiles:put name="title" value="User manage" />

<tiles:put name="css" type="string">
    <!-- テーブル関連ライブラリ -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/bootstrap-table/bootstrap-table.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/default/css/wiki.css">
    <style>
        .wiki-menu {
            display: none;
        }
        .panel-body {
            padding: 10px;
        }
        .wiki-menu-head {
            margin-bottom: 5px;
        }
    </style>
</tiles:put>

<tiles:put name="js" type="string">
    <!-- テーブル関連ライブラリ -->
    <script src="<%= request.getContextPath() %>/assets/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="<%= request.getContextPath() %>/assets/bootstrap-table/locale/bootstrap-table-ja-JP.min.js"></script>
    <script src="<%= request.getContextPath() %>/assets/markedjs/marked.js"></script>
    <script>
    $(function() {
        $("#wiki").html(marked($("#wiki").text()));

        $("#wiki > table").addClass("table");
    });
    </script>
</tiles:put>

<tiles:put name="content" type="string">
<div class="panel panel-primary">
    <div class="panel-body">
        <p class="wiki-menu-head"><i class="fa fa-sign-in fa-lg"></i> Wiki menu</p>
        <div class="wiki-menu">

        </div>
    </div>
</div>

<div id="wiki">
${result }
</div>
</tiles:put>

</tiles:insert>
