<template>
  <div>
    <h2>{{ course.title }}</h2>
    <p>{{ course.description }}</p>
    <p>价格：¥{{ course.price }}</p>
    <router-link :to="`/courses/${course.id}/video`">去看视频</router-link>
  </div>
</template>

<script>
import api from '@/services/api'
export default {
  props: ['id'],
  data() { return { course: {} } },
  async created() {
    this.course = await api.getCourseDetail(this.id)
  }
}
</script>
