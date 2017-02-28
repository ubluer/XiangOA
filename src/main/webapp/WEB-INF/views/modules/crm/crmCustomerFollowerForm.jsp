<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>跟进人管理</title>
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
		<li><a href="${ctx}/crm/crmCustomerFollower/">跟进人列表</a></li>
		<li class="active"><a href="${ctx}/crm/crmCustomerFollower/form?id=${crmCustomerFollower.id}">跟进人<shiro:hasPermission name="crm:crmCustomerFollower:edit">${not empty crmCustomerFollower.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="crm:crmCustomerFollower:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="crmCustomerFollower" action="${ctx}/crm/crmCustomerFollower/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">客户id：</label>
			<div class="controls">
				<sys:treeselect id="crmCustomer" name="crmCustomer.id" value="${crmCustomerFollower.crmCustomer.id}" labelName="crmCustomer.name" labelValue="${crmCustomerFollower.crmCustomer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">跟进人编号：</label>
			<div class="controls">
				<sys:treeselect id="sysUser" name="sysUser.id" value="${crmCustomerFollower.sysUser.id}" labelName="sysUser.name" labelValue="${crmCustomerFollower.sysUser.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="crm:crmCustomerFollower:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>