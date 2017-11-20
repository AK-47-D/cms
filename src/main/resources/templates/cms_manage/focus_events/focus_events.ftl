<link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<section class="col-lg-12">
    <div class="box box-info">
        <div class="box-header">
            <i class="fa fa-envelope"></i>

            <h3 class="box-title"><#if focusEvents??>编辑<#else>新增</#if></h3>
        </div>
        <div class="box-body">
            <form id="focusForm" class="form-horizontal">
            <#if (focusEvents.id)?? >
                <input type="hidden" name="id" value="${(focusEvents.id?c)!}"/>
            </#if>
                <div class="form-group">
                    <label class="col-sm-2 control-label">标题</label>
                    <div class="col-sm-7">
                        <input class="form-control" name="title" value="${(focusEvents.title)!}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">发生时间</label>
                    <div class="col-sm-7">
                        <input class="form-control" name="happenDate"
                               value="${(focusEvents.happenDate?string('yyyy/MM/dd hh:mm:ss'))!}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">来源</label>
                    <div class="col-sm-7">
                        <select name="source" class="form-control">
                        <#list manageFrom as focusFrom>
                            <option value="${(focusFrom.code)!}"
                                    <#if focusEvents?? && focusFrom.code == focusEvents.source>selected</#if>>${(focusFrom.cb)!}</option>
                        </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">地区</label>
                    <div class="col-sm-7">
                        <select name="country" class="form-control">
                        <#list manageCountry as focusCountry>
                            <option value="${(focusCountry.code)!}" <#if focusEvents?? && focusCountry.code == focusEvents.country>selected</#if>>${(focusCountry.detail)!}</option>
                        </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">状态</label>
                    <div class="col-sm-7">
                        <select name="status" class="form-control">
                        <#list manageStatus as focusStatus>
                            <option value="${(focusStatus.code)!}"<#if focusEvents?? &&focusStatus.code == focusEvents.status>selected</#if>>${(focusStatus.detail)!}</option>
                        </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">严重性</label>
                    <div class="col-sm-7">
                        <select name="level" class="form-control">
                        <#list manageLevel as focusLevel>
                            <option value="${(focusLevel.code)!}"<#if focusEvents?? &&focusLevel.code == focusEvents.level>selected</#if>>${(focusLevel.detail)!}</option>
                        </#list>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">内容</label>
                    <div class="col-sm-7">
                      <textarea class="textarea" placeholder="content" id="content"
                                style="width: 100%; height: 500px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">${(focusEvents.content)!}</textarea>
                        <input hidden name="content">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">gdp</label>
                    <div class="col-sm-7">
                        <input type="number" class="form-control" name="gdp" value="${(focusEvents.gdp)!}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">cpi</label>
                    <div class="col-sm-7">
                        <input type="number" class="form-control" name="cpi" value="${(focusEvents.cpi)!}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">nu</label>
                    <div class="col-sm-7">
                        <input type="number" class="form-control" name="nu" value="${(focusEvents.nu)!}"/>
                    </div>
                </div>
            </form>
        </div>
        <div class="box-footer clearfix">
            <button type="button" class="pull-right btn btn-default" id="saveFocus">保存
                <i class="fa fa-arrow-circle-right"></i></button>
        </div>
    </div>
</section>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="/manage/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/manage/bower_components/ckeditor/ckeditor.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/manage/dist/js/pages/dashboard.js"></script>
<script src="/manage/focus_events/js/focus_events.js"></script>