<template>
  <div class="dashboard">
    <aside class="menu">
      <router-link to="/home">首页</router-link>
      <router-link to="/courses">课程列表</router-link>
      <router-link to="/homework">作业</router-link>
      <router-link :to="`/chat/${userId}`">答疑</router-link>
      <router-link to="/orders">订单</router-link>
      <router-link to="/notifications">通知</router-link>
      <a @click="logout">登出</a>
    </aside>
    <main class="content">
      <router-view/>
    </main>
  </div>
</template>

<script>
export default {
  computed: {
    userId() { return this.$store.getters.userId }
  },
  methods: {
    logout() {
      this.$store.commit('clearUser')
      this.$router.push('/login')
    }
  }
}
</script>

<style>
.dashboard { display: flex; }
.menu { width: 200px; }
.content { flex: 1; padding: 20px; }
</style>
