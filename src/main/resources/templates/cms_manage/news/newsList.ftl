<link href="/cms/css/bootstrap.css" rel="stylesheet"/>
<section class="col-lg-12">
    <div class="box box-primary">
        <!-- 复盘项目列表 -->
        <div class="box-header with-border">
            <h3 class="box-title">
                新闻列表
                &nbsp;
                <button type="button" id="addNews" class=" btn btn-xs btn-warning btn-lg">
                    <span class="fa fa-search"></span>添加
                </button>
            </h3>
        </div>
        <div class="box-body">
            <div class="form-group">
                <table id="newsList" class="table table-striped ">
                </table>
            </div>
        </div>
    </div>
</section>
<script src="/bower_components/bootstrap-table/src/bootstrap-table.js"></script>
<script src="/bower_components/bootstrap-table/src/locale/bootstrap-table-zh-CN.js"></script>
<script src="/manage/news/js/newsList.js"></script>