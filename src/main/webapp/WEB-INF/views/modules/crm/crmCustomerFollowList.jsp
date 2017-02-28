<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>跟进记录管理</title>
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
		<li class="active"><a href="${ctx}/crm/crmCustomerFollow/">跟进记录列表</a></li>
		<shiro:hasPermission name="crm:crmCustomerFollow:edit"><li><a href="${ctx}/crm/crmCustomerFollow/form">跟进记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmCustomerFollow" action="${ctx}/crm/crmCustomerFollow/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>客户id：</label>
				<sys:treeselect id="crmCustomer" name="crmCustomer.id" value="${crmCustomerFollow.crmCustomer.id}" labelName="crmCustomer.name" labelValue="${crmCustomerFollow.crmCustomer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>机会id：</label>
				<sys:treeselect id="crmChance" name="crmChance.id" value="${crmCustomerFollow.crmChance.id}" labelName="crmChance.name" labelValue="${crmCustomerFollow.crmChance.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>合同id：</label>
				<sys:treeselect id="crmContract" name="crmContract.id" value="${crmCustomerFollow.crmContract.id}" labelName="crmContract.name" labelValue="${crmCustomerFollow.crmContract.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>发布人编号：</label>
				<sys:treeselect id="sysUser" name="sysUser.id" value="${crmCustomerFollow.sysUser.id}" labelName="sysUser.name" labelValue="${crmCustomerFollow.sysUser.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
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
				<th>机会id</th>
				<th>合同id</th>
				<th>发布人编号</th>
				<th>发布内容</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmCustomerFollow:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmCustomerFollow">
			<tr>
				<td><a href="${ctx}/crm/crmCustomerFollow/form?id=${crmCustomerFollow.id}">
					${crmCustomerFollow.crmCustomer.name}
				</a></td>
				<td>
					${crmCustomerFollow.crmChance.name}
				</td>
				<td>
					${crmCustomerFollow.crmContract.name}
				</td>
				<td>
					${crmCustomerFollow.sysUser.name}
				</td>
				<td>
					${crmCustomerFollow.content}
				</td>
				<td>
					<fmt:formatDate value="${crmCustomerFollow.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmCustomerFollow.remarks}
				</td>
				<shiro:hasPermission name="crm:crmCustomerFollow:edit"><td>
    				<a href="${ctx}/crm/crmCustomerFollow/form?id=${crmCustomerFollow.id}">修改</a>
					<a href="${ctx}/crm/crmCustomerFollow/delete?id=${crmCustomerFollow.id}" onclick="return confirmx('确认要删除该跟进记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>