<template>
  <div class="login-page">
    <h2>登录</h2>
    <form @submit.prevent="doLogin">
      <input v-model="username" placeholder="用户名" />
      <input v-model="password" type="password" placeholder="密码" />
      <button>登录</button>
    </form>
    <p>
      没有账号？<router-link to="/register">注册</router-link>
    </p>
  </div>
</template>

<script>
import api from '@/services/api'
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    async doLogin() {
      try {
        const res = await api.login(this.username, this.password)
        this.$store.commit('setUser', res.data)
        this.$router.push('/')
      } catch (err) {
        alert(err.response?.data || err.message)
      }
    }
  }
}
</script>
