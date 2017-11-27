<link href="/cms/css/bootstrap.css" rel="stylesheet"/>

<section class="col-lg-12">
<div class="box box-primary">
    <div class="box-header with-border">
        <h3 class="box-title">
            报告列表
            &nbsp;
            <button type="button" id="addReport" class=" btn btn-xs btn-warning">
                <span class="fa fa-plus-circle"></span> 添加
            </button>
        </h3>
    </div>
    <div class="box-body">
        <div class="form-group">
            <table id="reportList" class="table table-striped ">
            </table>
        </div>
    </div>
</div>
</section>
<script src="/bower_components/bootstrap-table/src/bootstrap-table.js"></script>
<script src="/bower_components/bootstrap-table/src/locale/bootstrap-table-zh-CN.js"></script>
<script src="/manage/report/js/reportList.js"></script>