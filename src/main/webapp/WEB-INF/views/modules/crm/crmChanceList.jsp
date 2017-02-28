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
		<li class="active"><a href="${ctx}/crm/crmChance/">联系人列表</a></li>
		<shiro:hasPermission name="crm:crmChance:edit"><li><a href="${ctx}/crm/crmChance/form">联系人添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmChance" action="${ctx}/crm/crmChance/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>机会名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>客户：</label>
				<sys:treeselect id="crmCustomer" name="crmCustomer.id" value="${crmChance.crmCustomer.id}" labelName="crmCustomer.name" labelValue="${crmChance.crmCustomer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>预计成交金额：</label>
				<form:input path="amount" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>预计成交时间：</label>
				<input name="beginExecutionTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmChance.beginExecutionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endExecutionTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmChance.endExecutionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>销售进度：</label>
				<form:select path="progress" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_chance_progress')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>机会级别：</label>
				<form:select path="degree" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_chance_degree')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>机会名称</th>
				<th>客户</th>
				<th>预计成交金额</th>
				<th>预计成交时间</th>
				<th>销售进度</th>
				<th>机会级别</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmChance:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmChance">
			<tr>
				<td><a href="${ctx}/crm/crmChance/form?id=${crmChance.id}">
					${crmChance.name}
				</a></td>
				<td>
					${crmChance.crmCustomer.name}
				</td>
				<td>
					${crmChance.amount}
				</td>
				<td>
					<fmt:formatDate value="${crmChance.executionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(crmChance.progress, 'crm_chance_progress', '')}
				</td>
				<td>
					${fns:getDictLabel(crmChance.degree, 'crm_chance_degree', '')}
				</td>
				<td>
					<fmt:formatDate value="${crmChance.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmChance.remarks}
				</td>
				<shiro:hasPermission name="crm:crmChance:edit"><td>
    				<a href="${ctx}/crm/crmChance/form?id=${crmChance.id}">修改</a>
					<a href="${ctx}/crm/crmChance/delete?id=${crmChance.id}" onclick="return confirmx('确认要删除该联系人吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>