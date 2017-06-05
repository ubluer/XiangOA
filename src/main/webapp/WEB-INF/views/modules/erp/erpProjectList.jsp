<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目管理</title>
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
		<li class="active"><a href="${ctx}/erp/erpProject/">项目列表</a></li>
		<shiro:hasPermission name="erp:erpProject:edit"><li><a href="${ctx}/erp/erpProject/form">项目添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="erpProject" action="${ctx}/erp/erpProject/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>级别：</label>
				<form:select path="vip" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_customer_vip')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>来源：</label>
				<form:select path="source" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_customer_source')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_customer_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>级别</th>
				<th>来源</th>
				<th>状态</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="erp:erpProject:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="erpProject">
			<tr>
				<td><a href="${ctx}/erp/erpProject/form?id=${erpProject.id}">
					${erpProject.name}
				</a></td>
				<td>
					${fns:getDictLabel(erpProject.vip, 'crm_customer_vip', '')}
				</td>
				<td>
					${fns:getDictLabel(erpProject.source, 'crm_customer_source', '')}
				</td>
				<td>
					${fns:getDictLabel(erpProject.status, 'crm_customer_status', '')}
				</td>
				<td>
					<fmt:formatDate value="${erpProject.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${erpProject.remarks}
				</td>
				<shiro:hasPermission name="erp:erpProject:edit"><td>
    				<a href="${ctx}/erp/erpProject/form?id=${erpProject.id}">修改</a>
					<a href="${ctx}/erp/erpProject/delete?id=${erpProject.id}" onclick="return confirmx('确认要删除该项目吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>