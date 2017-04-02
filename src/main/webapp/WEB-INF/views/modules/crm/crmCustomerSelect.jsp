<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>选择客户</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("input[name=id]").each(function(){
				var customerSelect = null;
				if (top.mainFrame.cmsMainFrame){
					customerSelect = top.mainFrame.cmsMainFrame.articleSelect;
				}else{
					customerSelect = top.mainFrame.articleSelect;
				}
				for (var i=0; i<customerSelect.length; i++){
					if (customerSelect[i][0]==$(this).val()){
						this.checked = true;
					}
				}
				$(this).click(function(){
					var id = $(this).val(), title = $(this).attr("title");
					if (top.mainFrame.cmsMainFrame){
						top.mainFrame.cmsMainFrame.articleSelectAddOrDel(id, title);
					}else{
						top.mainFrame.articleSelectAddOrDel(id, title);
					}
				});
			});
		});
		function view(href){
			top.$.jBox.open('iframe:'+href,'查看客户',$(top.document).width()-220,$(top.document).height()-120,{
				buttons:{"关闭":true},
				loaded:function(h){
					$(".jbox-content", top.document).css("overflow-y","hidden");
					$(".nav,.form-actions,[class=btn]", h.find("iframe").contents()).hide();
				}
			});
			return false;
		}
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<div style="margin:10px;">
	<form:form id="searchForm" modelAttribute="crmCustomer" action="${ctx}/crm/crmCustomer/select" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<li><label>名称：</label>
			<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
		</li>
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
	</form:form>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
		<tr>
			<th>名称</th>
			<th>负责人编号</th>
			<th>客户级别</th>
			<th>客户来源</th>
			<th>客户分类</th>
			<th>客户状态</th>
			<th>电话</th>
			<th>网址</th>
			<th>更新时间</th>
			<th>备注信息</th>
			<shiro:hasPermission name="crm:crmCustomer:edit"><th>操作</th></shiro:hasPermission>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="crmCustomer">
			<tr>
				<td><a href="${ctx}/crm/crmCustomer/form?id=${crmCustomer.id}">
						${crmCustomer.name}
				</a></td>
				<td>
						${crmCustomer.sysUser.name}
				</td>
				<td>
						${fns:getDictLabel(crmCustomer.vip, 'crm_customer_vip', '')}
				</td>
				<td>
						${fns:getDictLabel(crmCustomer.source, 'crm_customer_source', '')}
				</td>
				<td>
						${fns:getDictLabel(crmCustomer.classify, 'crm_customer_classify', '')}
				</td>
				<td>
						${fns:getDictLabel(crmCustomer.status, 'crm_customer_status', '')}
				</td>
				<td>
						${crmCustomer.phone}
				</td>
				<td>
						${crmCustomer.website}
				</td>
				<td>
					<fmt:formatDate value="${crmCustomer.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
						${crmCustomer.remarks}
				</td>
				<shiro:hasPermission name="crm:crmCustomer:edit"><td>
					<a href="${ctx}/crm/crmCustomer/form?id=${crmCustomer.id}">修改</a>
					<a href="${ctx}/crm/crmCustomer/delete?id=${crmCustomer.id}" onclick="return confirmx('确认要删除该客户吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	</div>
</body>
</html>