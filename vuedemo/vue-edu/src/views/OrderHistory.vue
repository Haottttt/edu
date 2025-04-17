<template>
  <div>
    <h2>我的订单</h2>
    <ul>
      <li v-for="o in orders" :key="o.id">
        订单#{{ o.id }} 课程{{ o.courseId }} ¥{{ o.amount }} 状态：{{ o.status }}
        <button v-if="o.status==='PENDING'" @click="pay(o.id)">去支付</button>
      </li>
    </ul>
  </div>
</template>

<script>
import api from '@/services/api'
export default {
  data() { return { orders: [] } },
  async created() { this.load() },
  methods: {
    async load() {
      const sid = this.$store.getters.userId
      this.orders = (await api.getOrdersByStudent(sid)).data
    },
    async pay(id) {
      await api.payOrder(id, 'WECHAT')
      this.load()
    }
  }
}
</script>
