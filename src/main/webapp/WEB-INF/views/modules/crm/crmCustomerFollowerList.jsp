<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>跟进人管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/crm/crmCustomerFollower/">跟进人列表</a></li>
		<shiro:hasPermission name="crm:crmCustomerFollower:edit"><li><a href="${ctx}/crm/crmCustomerFollower/form">跟进人添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmCustomerFollower" action="${ctx}/crm/crmCustomerFollower/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>客户id</th>
				<th>跟进人编号</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmCustomerFollower:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmCustomerFollower">
			<tr>
				<td><a href="${ctx}/crm/crmCustomerFollower/form?id=${crmCustomerFollower.id}">
					${crmCustomerFollower.crmCustomer.name}
				</a></td>
				<td>
					${crmCustomerFollower.sysUser.name}
				</td>
				<td>
					<fmt:formatDate value="${crmCustomerFollower.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmCustomerFollower.remarks}
				</td>
				<shiro:hasPermission name="crm:crmCustomerFollower:edit"><td>
    				<a href="${ctx}/crm/crmCustomerFollower/form?id=${crmCustomerFollower.id}">修改</a>
					<a href="${ctx}/crm/crmCustomerFollower/delete?id=${crmCustomerFollower.id}" onclick="return confirmx('确认要删除该跟进人吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>