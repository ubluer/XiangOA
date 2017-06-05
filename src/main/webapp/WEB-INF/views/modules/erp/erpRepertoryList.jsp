<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目库存管理</title>
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
		<li class="active"><a href="${ctx}/erp/erpRepertory/">项目库存列表</a></li>
		<shiro:hasPermission name="erp:erpRepertory:edit"><li><a href="${ctx}/erp/erpRepertory/form">项目库存添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="erpRepertory" action="${ctx}/erp/erpRepertory/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>类型：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('erp_repertory_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>名称</th>
				<th>类型</th>
				<th>规格</th>
				<th>库存数量</th>
				<th>单位</th>
				<th>花费</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="erp:erpRepertory:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="erpRepertory">
			<tr>
				<td><a href="${ctx}/erp/erpRepertory/form?id=${erpRepertory.id}">
					${erpRepertory.erpProject.id}
				</a></td>
				<td>
					${erpRepertory.name}
				</td>
				<td>
					${fns:getDictLabel(erpRepertory.type, 'erp_repertory_type', '')}
				</td>
				<td>
					${erpRepertory.edition}
				</td>
				<td>
					${erpRepertory.count}
				</td>
				<td>
					${fns:getDictLabel(erpRepertory.unit, 'erp_repertory_unit', '')}
				</td>
				<td>
					${erpRepertory.cost}
				</td>
				<td>
					<fmt:formatDate value="${erpRepertory.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${erpRepertory.remarks}
				</td>
				<shiro:hasPermission name="erp:erpRepertory:edit"><td>
    				<a href="${ctx}/erp/erpRepertory/form?id=${erpRepertory.id}">修改</a>
					<a href="${ctx}/erp/erpRepertory/delete?id=${erpRepertory.id}" onclick="return confirmx('确认要删除该项目库存吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>