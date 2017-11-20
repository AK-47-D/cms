<link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<section class="col-lg-12">
    <div class="box box-info">
    <div class="box-header">
        <i class="fa fa-envelope"></i>

        <h3 class="box-title"><#if news??>编辑<#else>新增</#if></h3>
        <#if news??>
            <#list manageNewsStatus as newsStatus>
                <#if news?? && newsStatus.code == news.status><font color="red">${(newsStatus.detail)!}</font></#if>
            </#list>
        </#if>
    </div>
    <div class="box-body">
        <form id="newsForm" class="form-horizontal">
            <div style="position: absolute;float: right;left: 80%;"><img style="width:200px;" id="newsImage" src=""></div>
            <#if (news.id)?? >
                <input type="hidden" name="id" value="${(news.id?c)!}" />
            </#if>
            <div class="form-group">
                <label class="col-sm-2 control-label">标题</label>
                <div class="col-sm-7">
                    <input class="form-control" maxlength="30" name="title" value="${(news.title)!}" />
                </div>
            </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">新闻图片</label>
                    <div class="col-sm-7">
                        <input class="form-control" name="image" value="${(news.image)!}" />
                    </div>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">发生时间</label>
                <div class="col-sm-7">
                    <div class="col-sm-2">
                        <input class="form-control" name="happenDate" value="${(news.happenDate?string('yyyy/MM/dd hh:mm:ss'))!}" />
                    </div>
                    <label class="col-sm-2 control-label">类型</label>
                    <div class="col-sm-2">
                        <select name="type" class="form-control">
                        <#list manageNewsType as newsType>
                            <option value="${(newsType.code)!}" <#if news?? && newsType.code == news.type>selected</#if>>${(newsType.detail)!}</option>
                        </#list>
                        </select>
                    </div>
                    <label class="col-sm-2 control-label">新闻来源</label>
                    <div class="col-sm-2">
                        <select name="source" class="form-control">
                        <#list manageNewsFrom as manageNews>
                            <option value="${(manageNews.code)!}" <#if news?? && manageNews.code == news.source>selected</#if>>${(manageNews.cb)!}</option>
                        </#list>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">新闻地区</label>
                <div class="col-sm-7">
                <div class="checkbox">
                    <#list manageNewsCountry as newsCountry>
                        <label>
                            <input type="checkbox" name="labels" <#if news??><#list news.newsLabels as newsLabel><#if newsCountry.code == newsLabel.label>checked</#if></#list></#if> value="${(newsCountry.code)!}">
                            ${(newsCountry.detail)!}
                        </label>
                    </#list>
                </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">新闻url</label>
                <div class="col-sm-7">
                    <input class="form-control" name="url" value="${(news.url)!}" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">内容</label>
                <div class="col-sm-7">
                  <textarea class="textarea" placeholder="content" id="html"
                            style="width: 100%; height: 500px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">${(news.html)!}</textarea>
                    <input hidden name="html">
                </div>
            </div>
        </form>
    </div>
    <div class="box-footer clearfix">
        <#if news??>
            <#list Session['manageUser'].manageRoleList as roleList>
                <#if roleList.roleName == 'manage'>
                    <button type="button" class="pull-right btn btn-warning" style="margin-left: 5px;" id="releaseNews">发布
                        <i class="fa fa-arrow-circle-right"></i></button>
                    <#break>
                </#if>
            </#list>
        </#if>
        <button type="button" class="pull-right btn btn-default" id="saveNews">保存
            <i class="fa fa-arrow-circle-right"></i></button>
    </div>
</div>
</section>
<script>
    debugger
</script>
<script src="/manage/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap ckeditor -->
<script src="/manage/bower_components/ckeditor/ckeditor.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/manage/dist/js/pages/dashboard.js"></script>
<script src="/manage/news/js/news.js"></script>