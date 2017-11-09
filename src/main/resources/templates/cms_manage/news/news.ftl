<link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<section class="col-lg-12">
    <div class="box box-info">
    <div class="box-header">
        <i class="fa fa-envelope"></i>

        <h3 class="box-title">编辑</h3>
    </div>
    <div class="box-body">
        <form id="newsForm" class="form-horizontal">
            <input type="hidden" name="id" value="${(newsId)!}" />
            <div class="form-group">
                <label class="col-sm-2 control-label">标题</label>
                <div class="col-sm-7">
                    <input class="form-control" name="title"  />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">类型</label>
                <div class="col-sm-7">
                    <select name="type" class="form-control">
                    <#list manageNewsType as newsType>
                        <option value="${newsType.code}">${newsType.detail}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">状态</label>
                <div class="col-sm-7">
                    <select name="status" class="form-control">
                    <#list manageNewsStatus as newsStatus>
                        <option value="${newsStatus.code}">${newsStatus.detail}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">来源</label>
                <div class="col-sm-7">
                    <select name="source" class="form-control">
                    <#list manageNewsFrom as manageNews>
                        <option value="${manageNews.code}">${manageNews.cb}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">来源url</label>
                <div class="col-sm-7">
                    <input class="form-control" name="url"  />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">内容</label>
                <div class="col-sm-7">
                  <textarea class="textarea" placeholder="content" name="html"
                            style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                </div>
            </div>
        </form>
    </div>
    <div class="box-footer clearfix">
        <button type="button" class="pull-right btn btn-default" id="saveNews">保存
            <i class="fa fa-arrow-circle-right"></i></button>
    </div>
</div>
</section>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/manage/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/manage/dist/js/pages/dashboard.js"></script>
<script src="/manage/news/js/news.js"></script>