<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>修改记录管理</title>
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
		<li class="active"><a href="${ctx}/crm/crmModified/">修改记录列表</a></li>
		<shiro:hasPermission name="crm:crmModified:edit"><li><a href="${ctx}/crm/crmModified/form">修改记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmModified" action="${ctx}/crm/crmModified/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>客户id：</label>
				<sys:treeselect id="crmCustomer" name="crmCustomer.id" value="${crmModified.crmCustomer.id}" labelName="crmCustomer.name" labelValue="${crmModified.crmCustomer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>修改人id：</label>
				<sys:treeselect id="sysUser" name="sysUser.id" value="${crmModified.sysUser.id}" labelName="sysUser.name" labelValue="${crmModified.sysUser.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>修改表名：</label>
				<form:input path="modifiedTable" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>修改字段：</label>
				<form:input path="modifiedField" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>客户id</th>
				<th>修改人id</th>
				<th>修改表名</th>
				<th>修改字段</th>
				<th>修改前内容</th>
				<th>修改后内容</th>
				<th>修改实体</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmModified:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmModified">
			<tr>
				<td><a href="${ctx}/crm/crmModified/form?id=${crmModified.id}">
					${crmModified.crmCustomer.name}
				</a></td>
				<td>
					${crmModified.sysUser.name}
				</td>
				<td>
					${crmModified.modifiedTable}
				</td>
				<td>
					${crmModified.modifiedField}
				</td>
				<td>
					${crmModified.beforeModified}
				</td>
				<td>
					${crmModified.afterModified}
				</td>
				<td>
					${crmModified.modifiedClass}
				</td>
				<td>
					<fmt:formatDate value="${crmModified.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmModified.remarks}
				</td>
				<shiro:hasPermission name="crm:crmModified:edit"><td>
    				<a href="${ctx}/crm/crmModified/form?id=${crmModified.id}">修改</a>
					<a href="${ctx}/crm/crmModified/delete?id=${crmModified.id}" onclick="return confirmx('确认要删除该修改记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>