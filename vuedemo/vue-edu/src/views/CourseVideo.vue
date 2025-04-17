<template>
  <div>
    <h2>视频列表</h2>
    <ul>
      <li v-for="v in videos" :key="v.id">
        <h3>{{ v.title }}</h3>
        <video :src="v.videoUrl" controls style="max-width:600px;"></video>
      </li>
    </ul>
  </div>
</template>

<script>
import api from '@/services/api'
export default {
  props: ['id'],
  data() { return { videos: [] } },
  async created() {
    const res = await api.getVideos(this.id)
    this.videos = res.data
  }
}
</script>
