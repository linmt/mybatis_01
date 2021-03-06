<%--
  Created by IntelliJ IDEA.
  User: 张洲徽
  Date: 2018/9/21
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>达内－NetCTOSS</title>
    <!--
        路径问题二
        当前路径是web/cost/list.form  图片的路径是：web/images/logo.png
    -->
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        //排序按钮的点击事件
        function sort(btnObj) {
            if (btnObj.className == "sort_desc")
                btnObj.className = "sort_asc";
            else
                btnObj.className = "sort_desc";
        }

        //启用
        function startFee() {
            var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
            document.getElementById("operate_result_info").style.display = "block";
        }

        //删除
        function deleteFee(cost_id) {
            var r = window.confirm("确定要删除此资费吗？");
            if(r) {
                // http://localhost:8080/NETCTOSS/cost
                window.location.href = "deleteCost.do?cost_id="+cost_id;
            }
            //document.getElementById("operate_result_info").style.display = "block";
        }

        //跳转框回车事件
        //与网页自带的回车事件冲突
        function keyDown(e) {
            var ev= window.event||e;
            if (ev.keyCode == 13) {
                alert("回车");
                window.location.href="findCost.do?page=${page+1}";
            }
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <c:import url="../public/logo.jsp"></c:import>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <c:import url="../public/header.jsp"></c:import>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="list2.form" method="get">
        <!--排序-->
        <div class="search_add">
            <div>
                <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
            </div>
            <!--
                当前：/netctoss/findCost.do
                目标：/netctoss/toAddCost.do
            -->
            <input type="button" value="增加" class="btn_add" onclick="location.href='toAddCost.do';" />
        </div>
        <!--启用操作的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <%--路径问题三--%>
            <img src="images/close.png" onclick="this.parentNode.style.display='none';" />
            删除成功！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>资费ID</th>
                    <th class="width100">资费名称</th>
                    <th>基本时长</th>
                    <th>基本费用</th>
                    <th>单位费用</th>
                    <th>创建时间</th>
                    <th>开通时间</th>
                    <th class="width100">状态</th>
                    <th class="width200"><br /></th>
                </tr>
                <c:forEach items="${costs}" var="c" varStatus="s">
                    <tr>
                        <td>${c.cost_id}</td>
                        <td>${c.name}</td>
                        <td>${c.base_duration}</td>
                        <td>${c.base_cost}</td>
                        <td>${c.unit_cost}</td>
                        <td><fmt:formatDate value="${c.creat_time}" type="both"/></td>
                        <td><fmt:formatDate value="${c.start_time}" type="both"/></td>
                        <td>
                            <c:choose>
                                <c:when test="status==0">开通</c:when>
                                <c:otherwise>暂停</c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <input type="button" value="启用" class="btn_start" onclick="startFee();" />
                            <!--只传id，一是传的数据量少，二是防止多人修改产生意外-->
                            <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateCost.do?cost_id=${c.cost_id}';" />
                            <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${c.cost_id});" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>业务说明：<br />
                1、创建资费时，状态为暂停，记载创建时间；<br />
                2、暂停状态下，可修改，可删除；<br />
                3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
            </p>
        </div>
        <!--分页-->
        <div id="pages">
            <c:if test="${page==1}"><a href="#">上一页</a></c:if>
            <c:if test="${page>1}">
                <a href="list2.form?page=${page-1}">上一页</a>
            </c:if>
            <!--不能所有页数都显示出来-->
            <c:forEach var="p" begin="${page-1}" end="${page+1}">
                <c:if test="${p!=0&&p<=totalPage}">
                    <c:if test="${p==page}">
                        <a href="list2.form?page=${p}" class="current_page">${p}</a>
                    </c:if>
                    <c:if test="${p!=page}">
                        <a href="list2.form?page=${p}">${p}</a>
                    </c:if>
                </c:if>
            </c:forEach>
            <c:if test="${page==totalPage}"><a href="#">下一页</a></c:if>
            <c:if test="${page<totalPage}">
                <a href="list2.form?page=${page+1}">下一页</a>
            </c:if>
            共${totalPage}页
            跳转到 <input type="text" id="skip_to_page" name="page" style="width:25px"/> 页
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <c:import url="../public/footer.jsp"></c:import>
</div>
</body>
</html>