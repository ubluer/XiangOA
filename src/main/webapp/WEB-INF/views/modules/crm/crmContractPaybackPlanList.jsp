<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>回款计划管理</title>
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
		<li class="active"><a href="${ctx}/crm/crmContractPaybackPlan/">回款计划列表</a></li>
		<shiro:hasPermission name="crm:crmContractPaybackPlan:edit"><li><a href="${ctx}/crm/crmContractPaybackPlan/form">回款计划添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmContractPaybackPlan" action="${ctx}/crm/crmContractPaybackPlan/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>期数：</label>
				<form:input path="period" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>计划日期：</label>
				<input name="beginExecutionTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmContractPaybackPlan.beginExecutionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endExecutionTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmContractPaybackPlan.endExecutionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
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
				<th>计划日期</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmContractPaybackPlan:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmContractPaybackPlan">
			<tr>
				<td><a href="${ctx}/crm/crmContractPaybackPlan/form?id=${crmContractPaybackPlan.id}">
					${crmContractPaybackPlan.period}
				</a></td>
				<td>
					<fmt:formatDate value="${crmContractPaybackPlan.executionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${crmContractPaybackPlan.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmContractPaybackPlan.remarks}
				</td>
				<shiro:hasPermission name="crm:crmContractPaybackPlan:edit"><td>
    				<a href="${ctx}/crm/crmContractPaybackPlan/form?id=${crmContractPaybackPlan.id}">修改</a>
					<a href="${ctx}/crm/crmContractPaybackPlan/delete?id=${crmContractPaybackPlan.id}" onclick="return confirmx('确认要删除该回款计划吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>