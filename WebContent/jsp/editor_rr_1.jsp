<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>待审核</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="index.html" method="get">
    软文名称
    <input type="text" name="RRname" id="RRname"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary" id="search">搜索</button>&nbsp;&nbsp; <button type="button" class="btn btn-success" id="addnew">新增软文</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>软文标题</th>
        <th>图片</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:if test="${RRLIST!=null}">
    <c:forEach items="${RRLIST}" var="rr">
        <tr>
                <td>${rr.name}</td>   <%-- TODO--%>
                <td><img src="${rr.picUrl}"/></td>
                <td><a href="/editing/getNews?newsId=${rr.id}">编辑</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="if(window.confirm('确定删除该项吗？')) this.href='/editing/delNews?newsId=${rr.id}'">删除</a></td>
            </tr>
    </c:forEach>
</c:if>
        </table>

</body>
</html>
<script>
    $(function () {
        $('#addnew').click(function(){

                window.location.href="editor_rr_add.jsp";
         });
    });

    $(function(){
        $('#search').click(function(){
            window.location.href="/editing/getUnreviewedByNewsName?newsName=${RRname}";
        });
    });
    
</script>