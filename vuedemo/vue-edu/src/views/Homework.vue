<template>
  <div>
    <h2>我的作业</h2>
    <form @submit.prevent="submit">
      <textarea v-model="desc" placeholder="作业描述"></textarea>
      <button>提交作业</button>
    </form>
    <ul>
      <li v-for="hw in list" :key="hw.id">
        作业#{{ hw.id }} 状态：{{ hw.corrected ? hw.grade + '分' : '待批改' }}
      </li>
    </ul>
  </div>
</template>

<script>
import api from '@/services/api'
export default {
  data() { return { desc: '', list: [] } },
  async created() { await this.load() },
  methods: {
    async load() {
      const sid = this.$store.getters.userId
      const res = await api.getMyHomework(sid)
      this.list = res.data
    },
    async submit() {
      const sid = this.$store.getters.userId
      await api.submitHomework({ studentId: sid, courseId: 0, description: this.desc })
      this.desc = ''
      this.load()
    }
  }
}
</script>
