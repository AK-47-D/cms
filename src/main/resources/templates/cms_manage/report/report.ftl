<link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<section class="col-lg-12">
    <div class="box box-info">
    <div class="box-header">
        <i class="fa fa-envelope"></i>

        <h3 class="box-title"><#if report??>编辑<#else>新增</#if></h3>
        <#if report??>
            <#list manageStatus as reportStatus>
                <#if report?? && reportStatus.code == report.status><font color="red">${(reportStatus.detail)!}</font></#if>
            </#list>
        </#if>
    </div>
    <div class="box-body">
        <form id="reportForm" class="form-horizontal">
            <div style="position: absolute;float: right;left: 80%;"><img style="width:200px;" id="reportImage" src=""></div>
            <#if (report.id)?? >
                <input type="hidden" name="id" value="${(report.id?c)!}" />
            </#if>
            <div class="form-group">
                <label class="col-sm-2 control-label">标题</label>
                <div class="col-sm-7">
                    <input class="form-control" maxlength="30" name="title" value="${(report.title)!}" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">pdf链接</label>
                <div class="col-sm-7">
                    <input class="form-control" name="pdf" value="${(report.pdf)!?html}" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">发生时间</label>
                <div class="col-sm-7">
                    <input class="form-control" name="happenDate"
                           value="${(report.happenDate?string('yyyy/MM/dd hh:mm:ss'))!}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">状态</label>
                <div class="col-sm-7">
                    <select name="status" class="form-control">
                    <#list manageStatus as reportStatus>
                        <option value="${(reportStatus.code)!}"<#if report?? &&reportStatus.code == report.status>selected</#if>>${(reportStatus.detail)!}</option>
                    </#list>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">报告来源</label>
                <div class="col-sm-7">
                    <select name="source" class="form-control">
                    <#list manageFrom as reportFrom>
                        <option value="${(reportFrom.code)!}" <#if report?? && reportFrom.code == report.source>selected</#if>>${(reportFrom.cb)!}</option>
                    </#list>
                    </select>
                </div>
            </div>
        </form>
    </div>
    <div class="box-footer clearfix">
        <button type="button" class="pull-right btn btn-default" id="saveReport">保存
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
<script src="/manage/report/js/report.js"></script>