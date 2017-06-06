<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目管理</title>
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
		<li><a href="${ctx}/erp/erpProject/">项目列表</a></li>
		<li class="active"><a href="${ctx}/erp/erpProject/form?id=${erpProject.id}">项目<shiro:hasPermission name="erp:erpProject:edit">${not empty erpProject.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="erp:erpProject:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="erpProject" action="${ctx}/erp/erpProject/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">负责人编号：</label>
			<div class="controls">
				<form:input path="sysUser.id" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目合同：</label>
			<div class="controls">
				<form:input path="crmContract.id" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">级别：</label>
			<div class="controls">
				<form:select path="vip" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_customer_vip')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">来源：</label>
			<div class="controls">
				<form:select path="source" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_customer_source')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
				<form:select path="status" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('crm_customer_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地址：</label>
			<div class="controls">
				<form:input path="place" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标记位置经度：</label>
			<div class="controls">
				<form:input path="longitude" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标记位置纬度：</label>
			<div class="controls">
				<form:input path="latitude" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片：</label>
			<div class="controls">
				<form:hidden id="pictures" path="pictures" htmlEscape="false" maxlength="200" class="input-xlarge"/>
				<sys:ckfinder input="pictures" type="files" uploadPath="/erp/erpProject" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附件：</label>
			<div class="controls">
				<form:hidden id="files" path="files" htmlEscape="false" maxlength="200" class="input-xlarge"/>
				<sys:ckfinder input="files" type="files" uploadPath="/erp/erpProject" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">项目相关人：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>名称</th>
								<th>负责人编号</th>
								<th>参与客户</th>
								<th>参与类型</th>
								<th>参与内容</th>
								<th>图片</th>
								<th>附件</th>
								<th>备注信息</th>
								<shiro:hasPermission name="erp:erpProject:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="erpProjectFollowerList">
						</tbody>
						<shiro:hasPermission name="erp:erpProject:edit"><tfoot>
							<tr><td colspan="10"><a href="javascript:" onclick="addRow('#erpProjectFollowerList', erpProjectFollowerRowIdx, erpProjectFollowerTpl);erpProjectFollowerRowIdx = erpProjectFollowerRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="erpProjectFollowerTpl">//<!--
						<tr id="erpProjectFollowerList{{idx}}">
							<td class="hide">
								<input id="erpProjectFollowerList{{idx}}_id" name="erpProjectFollowerList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="erpProjectFollowerList{{idx}}_delFlag" name="erpProjectFollowerList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="erpProjectFollowerList{{idx}}_name" name="erpProjectFollowerList[{{idx}}].name" type="text" value="{{row.name}}" maxlength="200" class="input-small required"/>
							</td>
							<td>
								<input id="erpProjectFollowerList{{idx}}_sysUser" name="erpProjectFollowerList[{{idx}}].sysUser.id" type="text" value="{{row.sysUser.id}}" maxlength="64" class="input-small "/>
							</td>
							<td>
								<input id="erpProjectFollowerList{{idx}}_crmCustomer" name="erpProjectFollowerList[{{idx}}].crmCustomer.id" type="text" value="{{row.crmCustomer.id}}" maxlength="64" class="input-small "/>
							</td>
							<td>
								<select id="erpProjectFollowerList{{idx}}_classify" name="erpProjectFollowerList[{{idx}}].classify" data-value="{{row.classify}}" class="input-small ">
									<option value=""></option>
									<c:forEach items="${fns:getDictList('erp_project_follwer_classify')}" var="dict">
										<option value="${dict.value}">${dict.label}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<textarea id="erpProjectFollowerList{{idx}}_content" name="erpProjectFollowerList[{{idx}}].content" rows="4" maxlength="200" class="input-small ">{{row.content}}</textarea>
							</td>
							<td>
								<input id="erpProjectFollowerList{{idx}}_pictures" name="erpProjectFollowerList[{{idx}}].pictures" type="text" value="{{row.pictures}}" maxlength="200" class="input-small "/>
							</td>
							<td>
								<input id="erpProjectFollowerList{{idx}}_files" name="erpProjectFollowerList[{{idx}}].files" type="text" value="{{row.files}}" maxlength="200" class="input-small "/>
							</td>
							<td>
								<textarea id="erpProjectFollowerList{{idx}}_remarks" name="erpProjectFollowerList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="erp:erpProject:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#erpProjectFollowerList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var erpProjectFollowerRowIdx = 0, erpProjectFollowerTpl = $("#erpProjectFollowerTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(erpProject.erpProjectFollowerList)};
							for (var i=0; i<data.length; i++){
								addRow('#erpProjectFollowerList', erpProjectFollowerRowIdx, erpProjectFollowerTpl, data[i]);
								erpProjectFollowerRowIdx = erpProjectFollowerRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="erp:erpProject:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>