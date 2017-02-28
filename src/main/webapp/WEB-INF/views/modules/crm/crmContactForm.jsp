<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>联系人管理</title>
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
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/crm/crmContact/">联系人列表</a></li>
		<li class="active"><a href="${ctx}/crm/crmContact/form?id=${crmContact.id}">联系人<shiro:hasPermission name="crm:crmContact:edit">${not empty crmContact.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="crm:crmContact:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="crmContact" action="${ctx}/crm/crmContact/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">负责人：</label>
			<div class="controls">
				<sys:treeselect id="sysUser" name="sysUser.id" value="${crmContact.sysUser.id}" labelName="sysUser.name" labelValue="${crmContact.sysUser.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户：</label>
			<div class="controls">
				<sys:treeselect id="crmCustomer" name="crmCustomer.id" value="${crmContact.crmCustomer.id}" labelName="crmCustomer.name" labelValue="${crmContact.crmCustomer.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门：</label>
			<div class="controls">
				<form:input path="department" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">职位：</label>
			<div class="controls">
				<form:input path="position" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱：</label>
			<div class="controls">
				<form:input path="mail" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地址：</label>
			<div class="controls">
				<form:input path="place" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<form:hidden id="pitures" path="pitures" htmlEscape="false" maxlength="200" class="input-xlarge"/>
				<sys:ckfinder input="pitures" type="files" uploadPath="/crm/crmContact" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附件：</label>
			<div class="controls">
				<form:hidden id="files" path="files" htmlEscape="false" maxlength="200" class="input-xlarge"/>
				<sys:ckfinder input="files" type="files" uploadPath="/crm/crmContact" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">联系人电话：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>电话</th>
								<th>备注信息</th>
								<shiro:hasPermission name="crm:crmContact:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="crmContactPhoneList">
						</tbody>
						<shiro:hasPermission name="crm:crmContact:edit"><tfoot>
							<tr><td colspan="4"><a href="javascript:" onclick="addRow('#crmContactPhoneList', crmContactPhoneRowIdx, crmContactPhoneTpl);crmContactPhoneRowIdx = crmContactPhoneRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="crmContactPhoneTpl">//<!--
						<tr id="crmContactPhoneList{{idx}}">
							<td class="hide">
								<input id="crmContactPhoneList{{idx}}_id" name="crmContactPhoneList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="crmContactPhoneList{{idx}}_delFlag" name="crmContactPhoneList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="crmContactPhoneList{{idx}}_phone" name="crmContactPhoneList[{{idx}}].phone" type="text" value="{{row.phone}}" maxlength="64" class="input-small "/>
							</td>
							<td>
								<textarea id="crmContactPhoneList{{idx}}_remarks" name="crmContactPhoneList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="crm:crmContact:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#crmContactPhoneList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var crmContactPhoneRowIdx = 0, crmContactPhoneTpl = $("#crmContactPhoneTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(crmContact.crmContactPhoneList)};
							for (var i=0; i<data.length; i++){
								addRow('#crmContactPhoneList', crmContactPhoneRowIdx, crmContactPhoneTpl, data[i]);
								crmContactPhoneRowIdx = crmContactPhoneRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="crm:crmContact:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>