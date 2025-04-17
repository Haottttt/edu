<template>
  <div>
    <h2>课程{{ courseId }} 实时答疑</h2>
    <div class="msgs">
      <div v-for="m in msgs" :key="m.id">
        [{{ m.sentAt }}] 学生{{ m.senderId }}：{{ m.content }}
      </div>
    </div>
    <input v-model="content" @keyup.enter="send" placeholder="输入消息..." />
  </div>
</template>

<script>
import api from '@/services/api'
export default {
  props: ['courseId'],
  data() { return { msgs: [], content: '' } },
  async created() { this.load() },
  methods: {
    async load() {
      // 假设用 courseId 当 chatId
      const res = await api.fetchHistory(this.courseId)
      this.msgs = res.data
    },
    async send() {
      const sid = this.$store.getters.userId
      await api.sendMessage({
        chatId: +this.courseId,
        senderId: sid,
        content: this.content
      })
      this.content = ''
      this.load()
    }
  }
}
</script>

<style>
.msgs { max-height:300px; overflow:auto; margin-bottom:10px; }
</style>
