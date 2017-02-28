<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>成交记录管理</title>
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
		<li class="active"><a href="${ctx}/crm/crmContractApprove/">成交记录列表</a></li>
		<shiro:hasPermission name="crm:crmContractApprove:edit"><li><a href="${ctx}/crm/crmContractApprove/form">成交记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="crmContractApprove" action="${ctx}/crm/crmContractApprove/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>合同id：</label>
				<sys:treeselect id="crmContract" name="crmContract.id" value="${crmContractApprove.crmContract.id}" labelName="crmContract.name" labelValue="${crmContractApprove.crmContract.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>客户id：</label>
				<sys:treeselect id="crmCustomer" name="crmCustomer.id" value="${crmContractApprove.crmCustomer.id}" labelName="crmCustomer.name" labelValue="${crmContractApprove.crmCustomer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>创建人id：</label>
				<sys:treeselect id="submitter" name="submitter.id" value="${crmContractApprove.submitter.id}" labelName="submitter.name" labelValue="${crmContractApprove.submitter.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>提交日期：</label>
				<input name="beginSubmitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmContractApprove.beginSubmitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endSubmitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmContractApprove.endSubmitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>审批人：</label>
				<sys:treeselect id="approver" name="approver.id" value="${crmContractApprove.approver.id}" labelName="approver.name" labelValue="${crmContractApprove.approver.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>审批日期：</label>
				<input name="beginApproveDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmContractApprove.beginApproveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endApproveDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${crmContractApprove.endApproveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>审批状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_approve_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>合同id</th>
				<th>客户id</th>
				<th>创建人id</th>
				<th>提交日期</th>
				<th>审批人</th>
				<th>审批日期</th>
				<th>审批状态</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="crm:crmContractApprove:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmContractApprove">
			<tr>
				<td><a href="${ctx}/crm/crmContractApprove/form?id=${crmContractApprove.id}">
					${crmContractApprove.crmContract.name}
				</a></td>
				<td>
					${crmContractApprove.crmCustomer.name}
				</td>
				<td>
					${crmContractApprove.submitter.name}
				</td>
				<td>
					<fmt:formatDate value="${crmContractApprove.submitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmContractApprove.approver.name}
				</td>
				<td>
					<fmt:formatDate value="${crmContractApprove.approveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(crmContractApprove.status, 'crm_approve_status', '')}
				</td>
				<td>
					<fmt:formatDate value="${crmContractApprove.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${crmContractApprove.remarks}
				</td>
				<shiro:hasPermission name="crm:crmContractApprove:edit"><td>
    				<a href="${ctx}/crm/crmContractApprove/form?id=${crmContractApprove.id}">修改</a>
					<a href="${ctx}/crm/crmContractApprove/delete?id=${crmContractApprove.id}" onclick="return confirmx('确认要删除该成交记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>