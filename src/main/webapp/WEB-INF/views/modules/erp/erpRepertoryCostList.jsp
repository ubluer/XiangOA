<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>库存消费管理</title>
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
		<li class="active"><a href="${ctx}/erp/erpRepertoryCost/">库存消费列表</a></li>
		<shiro:hasPermission name="erp:erpRepertoryCost:edit"><li><a href="${ctx}/erp/erpRepertoryCost/form">库存消费添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="erpRepertoryCost" action="${ctx}/erp/erpRepertoryCost/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
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
				<th>材料id</th>
				<th>库存数量变化</th>
				<th>单位</th>
				<th>花费</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="erp:erpRepertoryCost:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="erpRepertoryCost">
			<tr>
				<td><a href="${ctx}/erp/erpRepertoryCost/form?id=${erpRepertoryCost.id}">
					${erpRepertoryCost.erpProject.id}
				</a></td>
				<td>
					${erpRepertoryCost.sysUser.id}
				</td>
				<td>
					${erpRepertoryCost.erpRepertory.id}
				</td>
				<td>
					${erpRepertoryCost.count}
				</td>
				<td>
					${fns:getDictLabel(erpRepertoryCost.unit, 'erp_repertory_unit', '')}
				</td>
				<td>
					${erpRepertoryCost.cost}
				</td>
				<td>
					<fmt:formatDate value="${erpRepertoryCost.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${erpRepertoryCost.remarks}
				</td>
				<shiro:hasPermission name="erp:erpRepertoryCost:edit"><td>
    				<a href="${ctx}/erp/erpRepertoryCost/form?id=${erpRepertoryCost.id}">修改</a>
					<a href="${ctx}/erp/erpRepertoryCost/delete?id=${erpRepertoryCost.id}" onclick="return confirmx('确认要删除该库存消费吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>