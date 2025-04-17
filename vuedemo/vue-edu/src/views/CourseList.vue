<template>
  <div>
    <h2>课程列表</h2>
    <ul>
      <li v-for="c in courses" :key="c.id">
        <router-link :to="`/courses/${c.id}`">{{ c.title }}（¥{{ c.price }}）</router-link>
        <button @click="enroll(c.id)">选课</button>
      </li>
    </ul>
  </div>
</template>

<script>
import api from '@/services/api'
export default {
  data() { return { courses: [] } },
  async created() {
    const res = await api.getCourses()
    this.courses = res.data
  },
  methods: {
    async enroll(courseId) {
      const sid = this.$store.getters.userId
      await api.enrollCourse(sid, courseId)
      alert('已选课')
    }
  }
}
</script>
