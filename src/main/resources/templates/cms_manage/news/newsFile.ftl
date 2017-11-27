<section class="col-lg-12">
    <div class="box box-primary">
        <div class="box-header with-border">
            <h3 class="box-title">
                文件管理
            </h3>
        </div>
        <div class="box-body">
            <form id="fileForm" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">文件上传</label>
                    <div class="col-sm-4">
                        <input type="file" id="file" name="file">
                    </div>
                    <div class="col-sm-3">
                        <button type="button" id="upload" class=" btn btn-xs btn-primary">
                            <span class="fa fa-cloud-upload"></span> 上传
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <div class="form-group">
            <table id="fileList" class="table table-striped ">
            </table>
        </div>
    </div>
</section>
<script src="/bower_components/bootstrap-table/src/bootstrap-table.js"></script>
<script src="/bower_components/bootstrap-table/src/locale/bootstrap-table-zh-CN.js"></script>
<script src="/manage/news/js/newsFile.js"></script>
