<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同管理</title>
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
		<li class="active"><a href="${ctx}/crm/crmContract/">合同列表</a></li>
		<shiro:hasPermission name="crm:crmContract:edit"><li><a href="${ctx}/crm/crmContract/form">合同添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmContract" action="${ctx}/crm/crmContract/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>付款方式：</label>
				<form:select path="paymentMethod" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_contract_payment_method')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>标题</th>
				<th>客户id</th>
				<th>机会id</th>
				<th>合同金额</th>
				<th>折扣后金额</th>
				<th>签约日期</th>
				<th>付款方式</th>
				<th>我方签约人</th>
				<th>客户签约人</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmContract:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmContract">
			<tr>
				<td><a href="${ctx}/crm/crmContract/form?id=${crmContract.id}">
					${crmContract.name}
				</a></td>
				<td>
					${crmContract.crmCustomer.name}
				</td>
				<td>
					${crmContract.crmChance.name}
				</td>
				<td>
					${crmContract.amount}
				</td>
				<td>
					${crmContract.discount}
				</td>
				<td>
					<fmt:formatDate value="${crmContract.contarctDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(crmContract.paymentMethod, 'crm_contract_payment_method', '')}
				</td>
				<td>
					${crmContract.sysUser.name}
				</td>
				<td>
					${crmContract.parties}
				</td>
				<td>
					<fmt:formatDate value="${crmContract.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmContract.remarks}
				</td>
				<shiro:hasPermission name="crm:crmContract:edit"><td>
    				<a href="${ctx}/crm/crmContract/form?id=${crmContract.id}">修改</a>
					<a href="${ctx}/crm/crmContract/delete?id=${crmContract.id}" onclick="return confirmx('确认要删除该合同吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>