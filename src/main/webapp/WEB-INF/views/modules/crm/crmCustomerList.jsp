<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>客户管理</title>
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
		<li class="active"><a href="${ctx}/crm/crmCustomer/">客户列表</a></li>
		<shiro:hasPermission name="crm:crmCustomer:edit"><li><a href="${ctx}/crm/crmCustomer/form">客户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmCustomer" action="${ctx}/crm/crmCustomer/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>负责人编号：</label>
				<sys:treeselect id="sysUser" name="sysUser.id" value="${crmCustomer.sysUser.id}" labelName="sysUser.name" labelValue="${crmCustomer.sysUser.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>客户级别：</label>
				<form:select path="vip" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_customer_vip')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>客户来源：</label>
				<form:select path="source" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_customer_source')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>客户分类：</label>
				<form:select path="classify" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_customer_classify')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>客户状态：</label>
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
				<th>负责人编号</th>
				<th>客户级别</th>
				<th>客户来源</th>
				<th>客户分类</th>
				<th>客户状态</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmCustomer:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmCustomer">
			<tr>
				<td><a href="${ctx}/crm/crmCustomer/form?id=${crmCustomer.id}">
					${crmCustomer.name}
				</a></td>
				<td>
					${crmCustomer.sysUser.name}
				</td>
				<td>
					${fns:getDictLabel(crmCustomer.vip, 'crm_customer_vip', '')}
				</td>
				<td>
					${fns:getDictLabel(crmCustomer.source, 'crm_customer_source', '')}
				</td>
				<td>
					${fns:getDictLabel(crmCustomer.classify, 'crm_customer_classify', '')}
				</td>
				<td>
					${fns:getDictLabel(crmCustomer.status, 'crm_customer_status', '')}
				</td>
				<td>
					<fmt:formatDate value="${crmCustomer.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmCustomer.remarks}
				</td>
				<shiro:hasPermission name="crm:crmCustomer:edit"><td>
    				<a href="${ctx}/crm/crmCustomer/form?id=${crmCustomer.id}">修改</a>
					<a href="${ctx}/crm/crmCustomer/delete?id=${crmCustomer.id}" onclick="return confirmx('确认要删除该客户吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>