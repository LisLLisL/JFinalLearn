<#include "/WEB-INF/pages/admin/common/_layout.ftl"/>
<@layout page_tab="news">
<section class="content-header">
    <h1>
        资讯
        <small>列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${path!}/admin/index"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li><a href="${path!}/admin/news"><i class="fa fa-tag"></i> 资讯</a></li>
        <li class="active">列表</li>
    </ol>
</section>
<section class="content">
    <div class="box">
        <div class="box-header">
            <form class="form-inline" method="get" action="${path!}/admin/news">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" value="${name!}" placeholder="标题"/>
                </div>
                <button type="submit" class="btn btn-raised btn-default ">搜索</button>
                <@shiro.hasPermission name="news:add">
                    <a href="${path!}/admin/news/add" class="btn btn-raised btn-default  pull-right">添加</a>
                </@shiro.hasPermission>
            </form>
        </div>
        <div class="box-body">
            <div class="dataTables_wrapper form-inline dt-bootstrap">
                <table class="table table-hover table-bordered table-responsive">
                    <thead>
                    <th width="80">摘要图</th>
                    <th>标题</th>
                    <th width="60">作者</th>
                    <th width="80">分类</th>
                    <th width="80">浏览量</th>
                    <th>发布时间</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                        <#list page.getList() as new>
                        <tr id="news_${new.id!}">
                            <td>
                                <#if new.img ??>
                                    <img src="${imgPath!}${new.img!}" style="width:50px;height: 25px;" />
                                </#if>
                            </td>
                            <td>
                                <#if new.isExternalHref == 1>
                                    <span class="label label-success">外</span>
                                </#if>
                                <a href="${path!}/news/${new.id!}.html" target="_blank">
                                    ${new.title!}
                                </a>
                            </td>
                            <td>${new.author!}</td>
                            <td>${new.categoryName!}</td>
                            <td>
                                ${new.view!}
                            </td>
                            <td>${new.releaseTime!}</td>
                            <td>
                                <a href="javascript:;" data-toggle="modal" data-target="#news_detail_${new.id!}">
                                    <span class="glyphicon glyphicon-eye-open" title="查看详情"></span>
                                </a>
                                <@shiro.hasPermission name="news:edit">
                                    <a href="${path!}/admin/topic/edit/${new.id!}"><span
                                            class="glyphicon glyphicon-edit" title="编辑"></span></a>
                                </@shiro.hasPermission>
                                <@shiro.hasPermission name="news:delete">
                                    <a href="javascript:deleteNews('${new.id}')"><span
                                            class="glyphicon glyphicon-trash" title="删除"></span></a>
                                </@shiro.hasPermission>
                                <div class="modal fade" id="news_detail_${new.id!}" tabindex="-1" role="dialog"
                                     aria-labelledby="myModalLabel">
                                    <div class="modal-dialog modal-lg" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close"><span aria-hidden="true">&times;</span>
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">
                                                    <#if new.isExternalHref == 1>
                                                        <span class="label label-success">外</span>
                                                    </#if>
                                                    ${new.title!}
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <#if new.isExternalHref == 1>
                                                    <a href="${new.externalHref}" target="_blank">${new.externalHref}</a>
                                                <#else>
                                                    ${new.content!}
                                                </#if>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-raised btn-default"
                                                        data-dismiss="modal">关闭
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-sm-5">
                        <div class="dataTables_info" id="example2_info" role="status" aria-live="polite">
                            总资讯数：${page.getTotalRow()}</div>
                    </div>
                    <div class="col-sm-7">
                        <div class="dataTables_paginate paging_simple_numbers">
                            <#include "/WEB-INF/pages/admin/common/_paginate.ftl"/>
                            <@paginate currentPage=page.pageNumber totalPage=page.totalPage actionUrl="${path!}/admin/news/index" urlParas="" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</@layout>
<script type="text/javascript">
    function deleteNews(id) {
        if (confirm("确定 删除该资讯 吗？\n(注：这会删除该资讯下的所有相关内容！)")) {
            $.ajax({
                url: "${path!}/admin/news/delete",
                async: false,
                cache: false,
                type: 'post',
                dataType: "json",
                data: {
                    id: id
                },
                success: function (data) {
                    if (data.code == '200') {
                        $("#news_" + id).remove();
                    } else {
                        layer.msg(data.description, {time: 1000});
                    }
                }
            });
        }
    }
</script>
