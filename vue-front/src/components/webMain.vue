<template>
  <el-container>
    <el-row class="top-bar" :gutter="20">
      <el-col :span="20">
        <div class="pointer" @click="backToMain">
          <h2>欢迎你来到求职招聘网</h2>
        </div>
      </el-col>
      <el-col :span="2">
        <div v-if="!name" class="grid-content bg-purple">
          <a>
            <router-link to="/auth">登录</router-link>
          </a>
        </div>
        <div v-if="name" class="grid-content bg-purple">
          <a @click="gotoInfo">欢迎你@{{name}}</a>
        </div>
      </el-col>
      <el-col :span="2">
        <div v-if="!name" class="grid-content bg-purple">
          <a>
            <router-link to="/auth">注册</router-link>
          </a>
        </div>
        <div v-if="name" class="grid-content bg-purple">
          <a @click="quit">退出</a>
        </div>
      </el-col>
    </el-row>
    <!-- 上方需要保留 -->

    <el-row class="search" type="flex" justify="center">
      <el-col :span="8">
        <el-input v-model="seachinput" placeholder="搜索一下"></el-input>
      </el-col>
      <el-col :span="6">
        <el-select v-model="value" filterable placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          ></el-option>
        </el-select>
        <el-button type="info" @click="search">search</el-button>
      </el-col>
    </el-row>
    <!-- 头部导航和bannner分割线-----don't know why~ -->
    <div class="header-wrapper">
      <div>
        <el-row :gutter="20">
          <el-col :span="16">
            <div class="homebanner">
              <el-carousel :interval="5000" arrow="always">
                <el-carousel-item v-for=" pic in bannerimgurls" :key="pic">
                  <img :src="pic">
                </el-carousel-item>
              </el-carousel>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="homesiderbar">
              <el-tabs tab-position="right">
                <el-tab-pane label="技术">
                  <el-card class="box-card" style="height: 300px;">
                    <div slot="header" class="clearfix">
                      <span>技术</span>
                    </div>
<!--                        <div v-for="o in 4" :key="o" class="text item">{{'Java ' + o }}</div>-->
                    <div class="text item">Java</div>
                    <div class="text item">PHP</div>
                    <div class="text item">Python</div>
                    <div class="text item">数据挖掘</div>
                    <el-progress :percentage="100" status="success"></el-progress>
                  </el-card>
                </el-tab-pane>
                <el-tab-pane label="设计">设计</el-tab-pane>
                <el-tab-pane label="产品">产品</el-tab-pane>
                <el-tab-pane label="运营">运营</el-tab-pane>
                <el-tab-pane label="市场">市场</el-tab-pane>
                <el-tab-pane label="销售">销售</el-tab-pane>
                <el-tab-pane label="游戏">游戏</el-tab-pane>
              </el-tabs>
            </div>
          </el-col>
        </el-row>
      </div>
    </div>

    <el-main class="main-wrapper">
      <!--====热门公司开始===== -->
      <el-tabs class="panel-wrapper" v-model="activeName">
        <el-tab-pane label="热门公司" name="first">
          <el-row>
            <el-col :span="4" v-for="(item) in firmInfoListData" :key="item.cid" :offset=" 1 ">
              <el-card style="cursor:pointer" :body-style="{ padding: '0px' }">

                <img
                  @click="toMainFirm(item.cid)"
                  :src="item.logo"
                  class="image"
                >
                <div style="padding: 14px;">
                  <span>{{item.name }}</span>
                  <div class="bottom clearfix">
                    <time class="time">{{item.brief }}</time>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-tab-pane>
      </el-tabs>
      <!--====热门职位开始===== -->

      <el-tabs class="panel-wrapper" v-model="activeName">
        <el-tab-pane label="热门职位" name="first">
          <el-row>
            <el-col :span="4" v-for="(item) in JDlistData" :key="item.jid" :offset=" 1 ">
              <el-card class="padding-enable" style="cursor: pointer">
                <div @click="toMainJD(item.jid)" style="padding: 14px;">
                  <div class="inline">
                    <div>
                      <h2>{{item.opc}}</h2>
                    </div>
                    <div class="pay">{{item.pay}}</div>
                  </div>
                  <div class="inline">
                    <span style="color:#808080">[{{item.relDate}}]</span>
                  </div>
                  <div class="inline">
                    <span style="color:#808080">{{item.type}}/{{item.location}}/{{item.exp}}</span>
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-tab-pane>
      </el-tabs>
    </el-main>

    <el-header class="header-wrapper">© 2020 GitHub/kekee0724, Inc.</el-header>
  </el-container>
</template>

<script>
  export default {
    name: "webMain",
    data() {
      return {
        options: [
          {
            value: "职位",
            label: "职位"
          },
          {
            value: "公司",
            label: "公司"
          }
        ],
        value: "职位",
        seachinput: "",
        currentDate: "xxx",
        activeName: "first",
        bannerimgurls: [
          "https://sxsimg.xiaoyuanzhao.com/1C/91/1C49B905FC50A45FCC41C53527CBB291.png",
          "https://sxsimg.xiaoyuanzhao.com/64/E8/64AC3A9EA68D67D0590E2BAF7BD485E8.png",
          "https://sxsimg.xiaoyuanzhao.com/73/DC/73A14E131C300E223BB5EEDE6D5AC7DC.png",
          "https://sxsimg.xiaoyuanzhao.com/7B/A2/7B3B8852D5C258D7AD364FE175CE56A2.png"
        ],
        firmInfoListData: null,
        JDlistData: null,
        name: "",
        msg: "Welcome to Your Vue.js App",
        input: "",
        auth: null
      };
    },
    created() {
      if (localStorage.getItem("auth") !== null) {
        this.auth = JSON.parse(localStorage.getItem("auth"));
        this.name = this.auth.name;
      }
    },
    methods: {
      //返回主页
      backToMain() {
        this.$router.push({path: "/"});
      },
      //点击搜索
      search() {
        if (this.value === "职位") {
          this.$router.push({path: "/search/" + this.seachinput});
        }
      },
      //---退出
      quit() {
        localStorage.clear();
        this.$message({
          message: "已退出...",
          type: "success"
        });
        setTimeout(() => {
          location.reload();
        }, 3000);
      },
      toMainFirm: function (id) {
        this.$router.push({path: "/mainFirm/" + id});
      },
      toMainJD: function (id) {
        this.$router.push({path: "/mainJD/" + id});
      },
      gotoInfo: function () {
        if (this.auth.auth === 1) {
          //企业
          this.$router.push({path: "/about"});
        }
        if (this.auth.auth === 0) {
          this.$router.push({path: "/detail"});
        }
      },
      getAllFirmInfo: function () {
        this.axios({
          method: "get",
          url: "/allFirmInfo"
        }).then(x => {
          this.firmInfoListData = x.data;
        });
      },
      getAllJD: function () {
        this.axios({
          method: "get",
          url: "/allJD"
        }).then(x => {
          this.JDlistData = x.data;
        });
      }
    },
    mounted() {
      setTimeout(() => {
        this.getAllFirmInfo();
        this.getAllJD();
      }, 0);
    }
  };
</script>


<style lang="scss" scoped>
  .inline {
    position: relative;
    height: 20px;
  }

  .pay {
    right: 0;
    position: absolute;
    font-size: 16px;
    color: #fa6041;
  }

  .padding-enable {
    padding: 0;
  }

  .main-wrapper {
    padding: 2% 4% 2% 4%;
  }

  .pointer {
    cursor: pointer;
  }

  a {
    cursor: pointer;
  }

  .panel-wrapper {
    padding-bottom: 5%;
  }

  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
  }

  img {
    width: 100%;
  }

  .header-wrapper {
    padding: 2% 4% 0 4%;
  }

  .top-bar {
    padding: 5px;
    background: black;
    color: white;

    a {
      color: white;
    }
  }

  .search {
    padding: 2%;
    background: gainsboro;
  }
</style>









