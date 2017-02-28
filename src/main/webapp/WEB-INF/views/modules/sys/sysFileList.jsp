<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>文件管理</title>
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
		<li class="active"><a href="${ctx}/sys/sysFile/">文件列表</a></li>
		<shiro:hasPermission name="sys:sysFile:edit"><li><a href="${ctx}/sys/sysFile/form">文件添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sysFile" action="${ctx}/sys/sysFile/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>附件名称：</label>
				<form:input path="filename" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>附件后缀：</label>
				<form:input path="extension" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>附件类型：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sys_file_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>附件名称</th>
				<th>附件后缀</th>
				<th>附件类型</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sys:sysFile:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysFile">
			<tr>
				<td><a href="${ctx}/sys/sysFile/form?id=${sysFile.id}">
					${sysFile.filename}
				</a></td>
				<td>
					${sysFile.extension}
				</td>
				<td>
					${fns:getDictLabel(sysFile.type, 'sys_file_type', '')}
				</td>
				<td>
					<fmt:formatDate value="${sysFile.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sysFile.remarks}
				</td>
				<shiro:hasPermission name="sys:sysFile:edit"><td>
    				<a href="${ctx}/sys/sysFile/form?id=${sysFile.id}">修改</a>
					<a href="${ctx}/sys/sysFile/delete?id=${sysFile.id}" onclick="return confirmx('确认要删除该文件吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>