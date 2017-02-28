<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>跟进记录管理</title>
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
		<li><a href="${ctx}/crm/crmCustomerFollow/">跟进记录列表</a></li>
		<li class="active"><a href="${ctx}/crm/crmCustomerFollow/form?id=${crmCustomerFollow.id}">跟进记录<shiro:hasPermission name="crm:crmCustomerFollow:edit">${not empty crmCustomerFollow.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="crm:crmCustomerFollow:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="crmCustomerFollow" action="${ctx}/crm/crmCustomerFollow/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">客户id：</label>
			<div class="controls">
				<sys:treeselect id="crmCustomer" name="crmCustomer.id" value="${crmCustomerFollow.crmCustomer.id}" labelName="crmCustomer.name" labelValue="${crmCustomerFollow.crmCustomer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">机会id：</label>
			<div class="controls">
				<sys:treeselect id="crmChance" name="crmChance.id" value="${crmCustomerFollow.crmChance.id}" labelName="crmChance.name" labelValue="${crmCustomerFollow.crmChance.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">合同id：</label>
			<div class="controls">
				<sys:treeselect id="crmContract" name="crmContract.id" value="${crmCustomerFollow.crmContract.id}" labelName="crmContract.name" labelValue="${crmCustomerFollow.crmContract.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发布人编号：</label>
			<div class="controls">
				<sys:treeselect id="sysUser" name="sysUser.id" value="${crmCustomerFollow.sysUser.id}" labelName="sysUser.name" labelValue="${crmCustomerFollow.sysUser.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发布内容：</label>
			<div class="controls">
				<form:textarea path="content" htmlEscape="false" rows="4" maxlength="500" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<form:hidden id="pictures" path="pictures" htmlEscape="false" maxlength="200" class="input-xlarge"/>
				<sys:ckfinder input="pictures" type="files" uploadPath="/crm/crmCustomerFollow" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附件：</label>
			<div class="controls">
				<form:hidden id="files" path="files" htmlEscape="false" maxlength="200" class="input-xlarge"/>
				<sys:ckfinder input="files" type="files" uploadPath="/crm/crmCustomerFollow" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="crm:crmCustomerFollow:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>