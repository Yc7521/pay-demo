<script setup>
import VueQr from 'vue-qr'
import {Message} from "element-ui";
import {getTradingCode} from "@/api/pay/tradingCode";
import {genReceiptCode, me} from "@/api/pay/info";
import {login} from "@/api/pay/login";
import {addGoods, delGoods, getGoods, listGoods, updateGoods} from "@/api/goods/goods";


// onMounted(async () => {
//   /**
//    * @type {LoginRes[]}
//    */
//   const token = await Promise.all([
//     login({
//       key: "6327269b245ab286f863e2411f37384b3e23",
//     }),
//     login({
//       key: "0baafdf94a54a89bab21954506ea7e45e62c",
//     }),
//   ]);
//   /**
//    * @type {UserInfo[]}
//    */
//   const users = await Promise.all([
//     me({
//       headers: {
//         isToken: false,
//         Authorization: "Bearer " + token[0].idToken,
//       },
//     }),
//     me({
//       headers: {
//         isToken: false,
//         Authorization: "Bearer " + token[1].idToken,
//       },
//     }),
//   ]);
//   for (let i = 0; i < 2; i++) {
//     data.data.push({
//       ...template_data[i],
//       token: token[i].idToken,
//       shopName: users[i].nickname,
//     });
//   }
//   data.users = token;
// });

export default {
  name: "Goods",
  components: {
    VueQr
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 总条数
      total: 0,
      // 商品表格数据
      goodsList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 9,
        name: null,
        price: null,
        description: null,
        picture: null,
        stock: null,
        tag: null,
        userId: null
      },
      showGood: false,
      code: {
        id: 0,
        userInfoId: undefined,
        tradingType: undefined,
        money: 0,
      },
      task: 0,
      message: "",
      name: "",
      price: 0,
      token: "",
      info: {},
    };
  },
  watch: {
    showGood(val) {
      if (!val) {
        this.cancel();
      }
    },
  },
  created() {
    this.getList();
  },
  destroyed() {
    if (this.task !== 0) {
      this.cancel();
    }
  },
  methods: {
    /** 查询商品列表 */
    getList() {
      this.loading = true;
      listGoods(this.queryParams).then(response => {
        this.goodsList = response.rows;
        console.log(this.goodsList);
        this.total = response.total;
        this.loading = false;
      });
    },
    cancel() {
      clearInterval(this.task);
      this.task = 0;
      this.show = false;
    },
    async getToken(key) {
      return await login({
        key: key,
      });
    },
    async getInfo(token) {
      return await me({
        headers: {
          isToken: false,
          Authorization: "Bearer " + token.idToken,
        },
      });
    },
    async genCode(item) {
      this.message = "";
      if (item.keys.length < 1) {
        Message.info({
          message: "该商家未设置支付密钥",
          type: "info",
        });
        return;
      }
      this.token = await this.getToken(item.keys[0]);
      this.info = await this.getInfo(this.token);
      this.code = await genReceiptCode(item.price, {
        headers: {
          isToken: false,
          Authorization: "Bearer " + this.token.idToken,
        },
      });
      this.task = setInterval(this.loop, 3000);
    },
    async doPay(item) {
      await this.genCode(item);
      this.name = item.name;
      this.price = item.price;
      this.showGood = true;
    },
    async loop() {
      try {
        let code = await getTradingCode(this.code.id, {
          headers: {
            isToken: false,
            Authorization: "Bearer " + this.token.idToken,
          },
        });
        switch (code.state) {
          case "Created":
            this.message = "用户已扫码，请点击支付。";
            break;
          case "Finished":
            this.cancel();
            Message.info({
              message: "用户成功支付",
              type: "success",
            });
            break;
          case "Canceled":
            this.cancel();
            Message.info({
              message: "用户取消支付",
              type: "info",
            });
            break;
        }
      } catch (e) {
        this.showGood = false;
        console.log("error");
      }
    },
  }
};
</script>
<template>
  <div>
    <el-row justify="center">
      <el-col
        v-for="(i, index) in goodsList"
        :key="i.id"
        :span="7"
        :offset="1"
        style="margin-top: 0.75rem"
      >
        <el-card style="width: 240px">
          <template #header>
            <image-preview :src="i.picture" :width="200" :height="200"/>
          </template>
          <el-row class="mt-3">{{ i.user.nickName }}</el-row>
          <el-row class="mt-3">商品：{{ i.name }}</el-row>
          <el-row class="mt-3">价格：{{ i.price }}元</el-row>
          <el-row class="mt-3" justify="start">
            <el-button type="primary" @click="doPay(i)">Pay</el-button>
          </el-row>
        </el-card>
      </el-col>
    </el-row>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      :pageSizes="[9, 12]"
      @pagination="getList"
    />

    <el-dialog :visible.sync="showGood" center title="付款码">
      <el-row justify="center" :gutter="20">
        <el-col :span="14">
          <el-row justify="end">
            <vue-qr :text="JSON.stringify(code)" :size="200"></vue-qr>
          </el-row>
        </el-col>
        <el-col :span="10" style="margin-top: 1em">
          <el-row class="mt-3">商品：{{ name }}</el-row>
          <el-row class="mt-3">价格：{{ price }}元</el-row>
          <el-row class="mt-3" v-if="message">{{ message }}</el-row>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>

<style scoped></style>
