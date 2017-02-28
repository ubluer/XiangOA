<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>成交记录管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/crm/crmContractApprove/">成交记录列表</a></li>
		<li class="active"><a href="${ctx}/crm/crmContractApprove/form?id=${crmContractApprove.id}">成交记录<shiro:hasPermission name="crm:crmContractApprove:edit">${not empty crmContractApprove.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="crm:crmContractApprove:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="crmContractApprove" action="${ctx}/crm/crmContractApprove/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">合同id：</label>
			<div class="controls">
				<sys:treeselect id="crmContract" name="crmContract.id" value="${crmContractApprove.crmContract.id}" labelName="crmContract.name" labelValue="${crmContractApprove.crmContract.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户id：</label>
			<div class="controls">
				<sys:treeselect id="crmCustomer" name="crmCustomer.id" value="${crmContractApprove.crmCustomer.id}" labelName="crmCustomer.name" labelValue="${crmContractApprove.crmCustomer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建人id：</label>
			<div class="controls">
				<sys:treeselect id="submitter" name="submitter.id" value="${crmContractApprove.submitter.id}" labelName="submitter.name" labelValue="${crmContractApprove.submitter.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">提交日期：</label>
			<div class="controls">
				<input name="submitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${crmContractApprove.submitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审批人：</label>
			<div class="controls">
				<sys:treeselect id="approver" name="approver.id" value="${crmContractApprove.approver.id}" labelName="approver.name" labelValue="${crmContractApprove.approver.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审批日期：</label>
			<div class="controls">
				<input name="approveDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${crmContractApprove.approveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审批状态：</label>
			<div class="controls">
				<form:select path="status" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_approve_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">驳回理由：</label>
			<div class="controls">
				<form:input path="reason" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<form:hidden id="pictures" path="pictures" htmlEscape="false" maxlength="200" class="input-xlarge"/>
				<sys:ckfinder input="pictures" type="files" uploadPath="/crm/crmContractApprove" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附件：</label>
			<div class="controls">
				<form:hidden id="files" path="files" htmlEscape="false" maxlength="200" class="input-xlarge"/>
				<sys:ckfinder input="files" type="files" uploadPath="/crm/crmContractApprove" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="crm:crmContractApprove:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>