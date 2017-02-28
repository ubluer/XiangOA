<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>回款记录管理</title>
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
		<li class="active"><a href="${ctx}/crm/crmContractPayback/">回款记录列表</a></li>
		<shiro:hasPermission name="crm:crmContractPayback:edit"><li><a href="${ctx}/crm/crmContractPayback/form">回款记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmContractPayback" action="${ctx}/crm/crmContractPayback/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>期数：</label>
				<form:input path="period" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>实际日期：</label>
				<input name="beginExecutionTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmContractPayback.beginExecutionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endExecutionTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmContractPayback.endExecutionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>是否开票：</label>
				<form:radiobuttons path="billing" items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>期数</th>
				<th>合同id</th>
				<th>负责人id</th>
				<th>实收金额</th>
				<th>实际日期</th>
				<th>是否开票</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmContractPayback:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmContractPayback">
			<tr>
				<td><a href="${ctx}/crm/crmContractPayback/form?id=${crmContractPayback.id}">
					${crmContractPayback.period}
				</a></td>
				<td>
					${crmContractPayback.crmContract.name}
				</td>
				<td>
					${crmContractPayback.crmChance.name}
				</td>
				<td>
					${crmContractPayback.amount}
				</td>
				<td>
					<fmt:formatDate value="${crmContractPayback.executionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(crmContractPayback.billing, 'yes_no', '')}
				</td>
				<td>
					<fmt:formatDate value="${crmContractPayback.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmContractPayback.remarks}
				</td>
				<shiro:hasPermission name="crm:crmContractPayback:edit"><td>
    				<a href="${ctx}/crm/crmContractPayback/form?id=${crmContractPayback.id}">修改</a>
					<a href="${ctx}/crm/crmContractPayback/delete?id=${crmContractPayback.id}" onclick="return confirmx('确认要删除该回款记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>