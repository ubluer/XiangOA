<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>日报管理</title>
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
		<li class="active"><a href="${ctx}/erp/erpDaily/">日报列表</a></li>
		<shiro:hasPermission name="erp:erpDaily:edit"><li><a href="${ctx}/erp/erpDaily/form">日报添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="erpDaily" action="${ctx}/erp/erpDaily/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>工程id：</label>
				<form:input path="erpProject.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>记录人编号：</label>
				<form:input path="sysUser.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>类型：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('erp_daily_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>工程id</th>
				<th>记录人编号</th>
				<th>类型</th>
				<th>天气</th>
				<th>花费</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="erp:erpDaily:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="erpDaily">
			<tr>
				<td><a href="${ctx}/erp/erpDaily/form?id=${erpDaily.id}">
					${erpDaily.erpProject.id}
				</a></td>
				<td>
					${erpDaily.sysUser.id}
				</td>
				<td>
					${fns:getDictLabel(erpDaily.type, 'erp_daily_type', '')}
				</td>
				<td>
					${fns:getDictLabel(erpDaily.weather, 'weather', '')}
				</td>
				<td>
					${erpDaily.cost}
				</td>
				<td>
					<fmt:formatDate value="${erpDaily.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${erpDaily.remarks}
				</td>
				<shiro:hasPermission name="erp:erpDaily:edit"><td>
    				<a href="${ctx}/erp/erpDaily/form?id=${erpDaily.id}">修改</a>
					<a href="${ctx}/erp/erpDaily/delete?id=${erpDaily.id}" onclick="return confirmx('确认要删除该日报吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>