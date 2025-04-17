// src/store/index.js
import { createStore } from 'vuex'
import api from '@/services/api'

export default createStore({
  state: {
    user: null,
    notifications: []
  },
  mutations: {
    setUser(state, u) {
      state.user = u
    },
    clearUser(state) {
      state.user = null
    },
    addNotification(state, note) {
      state.notifications.push(note)
    }
  },
  actions: {
    async login({ commit }, { username, password }) {
      const res = await api.login(username, password)
      commit('setUser', res.data)
    },
    logout({ commit }) {
      commit('clearUser')
    },
    async register({ dispatch }, payload) {
      await api.register(payload)
      await dispatch('login', { username: payload.username, password: payload.password })
    }
  },
  getters: {
    isAuthenticated: state => !!state.user,
    userId: state => state.user && state.user.id
  }
})
