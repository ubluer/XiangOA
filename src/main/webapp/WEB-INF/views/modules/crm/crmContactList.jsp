<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>联系人管理</title>
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
		<li class="active"><a href="${ctx}/crm/crmContact/">联系人列表</a></li>
		<shiro:hasPermission name="crm:crmContact:edit"><li><a href="${ctx}/crm/crmContact/form">联系人添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmContact" action="${ctx}/crm/crmContact/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>负责人编号：</label>
				<sys:treeselect id="sysUser" name="sysUser.id" value="${crmContact.sysUser.id}" labelName="sysUser.name" labelValue="${crmContact.sysUser.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>客户：</label>
				<sys:treeselect id="crmCustomer" name="crmCustomer.id" value="${crmContact.crmCustomer.id}" labelName="crmCustomer.name" labelValue="${crmContact.crmCustomer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>部门：</label>
				<form:input path="department" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>职位：</label>
				<form:input path="position" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>邮箱：</label>
				<form:input path="email" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>地址：</label>
				<form:input path="place" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>负责人编号</th>
				<th>客户</th>
				<th>部门</th>
				<th>职位</th>
				<th>邮箱</th>
				<th>地址</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmContact:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmContact">
			<tr>
				<td><a href="${ctx}/crm/crmContact/form?id=${crmContact.id}">
					${crmContact.name}
				</a></td>
				<td>
					${crmContact.sysUser.name}
				</td>
				<td>
					${crmContact.crmCustomer.name}
				</td>
				<td>
					${crmContact.department}
				</td>
				<td>
					${crmContact.position}
				</td>
				<td>
					${crmContact.email}
				</td>
				<td>
					${crmContact.place}
				</td>
				<td>
					<fmt:formatDate value="${crmContact.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmContact.remarks}
				</td>
				<shiro:hasPermission name="crm:crmContact:edit"><td>
    				<a href="${ctx}/crm/crmContact/form?id=${crmContact.id}">修改</a>
					<a href="${ctx}/crm/crmContact/delete?id=${crmContact.id}" onclick="return confirmx('确认要删除该联系人吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>