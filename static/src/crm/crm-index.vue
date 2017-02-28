<style>
    .bg-purple-dark {
        background: #99a9bf;
    }
    .text {
        font-size: 14px;
    }
    .item {
        padding: 18px 0;
    }
    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }
    .box-card {
        width: 480px;
    }
</style>
<template>
    <div>
        <!--导航栏-->
        <div class="navigation">
            <el-row type="flex" justify="around">
                <el-col :span="2">
                    <i class="el-icon-arrow-left"></i>
                </el-col>
                <el-col :span="20">
                    <div>Customer Manager</div>
                </el-col>
                <el-col :span="2">
                    <i class="el-icon-setting"></i>
                </el-col>
            </el-row>
        </div>
        <!--按钮区-->
        <div class="buttons">
            <el-row>
                <el-col :span="6">
                    <el-button>Customer</el-button>
                </el-col>
                <el-col :span="6">
                    <el-button>Contact</el-button>
                </el-col>
                <el-col :span="6">
                    <el-button>Contract</el-button>
                </el-col>
                <el-col :span="6">
                    <el-button>Chance</el-button>
                </el-col>
            </el-row>
        </div>
        <!--选择查看人-->
        <div class="content">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span style="line-height: 36px;">选择查看人</span>
                    <el-button style="float: right;" type="primary">操作按钮</el-button>
                </div>
            </el-card>
        </div>
        <!--客户概况-->
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span style="line-height: 36px;">客户概况</span>
                <el-button style="float: right;" type="primary">操作按钮</el-button>
            </div>
            <div class="text item">
                '列表内容 ' + o
            </div>
        </el-card>
        <!--销售简报-->
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span style="line-height: 36px;">销售简报</span>
                <el-button style="float: right;" type="primary">操作按钮</el-button>
            </div>
            <div class="text item">
                '销售简报 ' + o
            </div>
        </el-card>
        <!--最新跟进-->
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span style="line-height: 36px;">最新跟进</span>
                <el-button style="float: right;" type="primary">操作按钮</el-button>
            </div>
            <div class="text item">
                '最新跟进 ' + o
            </div>
        </el-card>
        <!--待跟进客户-->
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span style="line-height: 36px;">待跟进客户</span>
                <el-button style="float: right;" type="primary">操作按钮</el-button>
            </div>
            <div class="text item">
                '待跟进客户 ' + o
            </div>
        </el-card>
        <!--回款计划-->
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span style="line-height: 36px;">回款计划</span>
                <el-button style="float: right;" type="primary">操作按钮</el-button>
            </div>
            <div class="text item">
                '回款计划 ' + o
            </div>
        </el-card>
    </div>
</template>
<script>
    import HeaderComponent from '../common/header.vue'
    export default{
        data(){
            return {
                msg: 'hello vue'
            }
        },
        components: {
            HeaderComponent,
        }
    }
</script>
